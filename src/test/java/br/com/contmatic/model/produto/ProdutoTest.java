package br.com.contmatic.model.produto;

import static br.com.six2six.fixturefactory.Fixture.from;
import static javax.validation.Validation.buildDefaultValidatorFactory;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.either;
import static org.hamcrest.CoreMatchers.is;
import static org.joda.time.DateTime.parse;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.loader.FixtureFactoryLoader;

public class ProdutoTest {

	private static Validator validator;

	private Produto produto;

	@BeforeClass
	public static void setUp_before_class() {
		FixtureFactoryLoader.loadTemplates("br.com.contmatic.model.template");
		ValidatorFactory factory = buildDefaultValidatorFactory();
		validator = factory.getValidator();
	}

	@Before
	public void setUp() {
		produto = from(Produto.class).gimme("valid");
	}

	@Test
	public void deve_retornar_verdadeiro_para_um_produto_nao_nulo() {
		assertNotNull(produto.getNome());
		assertNotNull(produto.getMarca());
		assertNotNull(produto.getPreco());
		assertNotNull(produto.getCodigo());
		assertNotNull(produto.getFimProducao());
	}

	@Test
	public void deve_retornar_verdadeiro_na_comparacao_do_get_com_o_enviado_no_set() {
		assertThat(produto.getNome(), either(containsString("Shorts")).or(containsString("Calça"))
				.or(containsString("Camisa")).or(containsString("Vestido")));
		assertThat(produto.getMarca(),
				either(containsString("Camaleon")).or(containsString("Addidas")).or(containsString("Nike")));
		assertThat(produto.getFimProducao(), is(parse("2030-03-11")));
	}

	@Test
	public void deve_retornar_verdadeiro_na_comparacao_do_hashcode_de_dois_objetos_iguais() {
		Produto outroProduto = produto;
		assertEquals(produto.hashCode(), outroProduto.hashCode());
	}

	@Test
	public void deve_retornar_falso_na_comparacao_do_hashcode_de_dois_objetos_diferentes() {
		Produto outroProduto = new Produto("Camisa", "Adidas", BigDecimal.valueOf(50.46), (long) 1489);
		assertFalse(produto.hashCode() == outroProduto.hashCode());
	}

	@Test
	public void deve_retornar_verdadeiro_quando_comparado_dois_objetos_iguais_atraves_do_equals() {
		Produto outroProduto = produto;
		assertTrue(produto.equals(outroProduto));
	}

	@Test
	public void deve_retornar_falso_quando_comparado_dois_objetos_diferentes_da_mesma_classe_atraves_do_equals() {
		Produto outroProduto = Fixture.from(Produto.class).gimme("valid");
		outroProduto.setCodigo(15L);
		assertFalse(produto.equals(outroProduto));
	}

	@Test
	public void deve_retornar_falso_quando_comparado_produto_a_um_objeto_nulo_atraves_do_equals() {
		Produto outroProduto = null;
		assertFalse(produto.equals(outroProduto));
	}

	@Test
	public void deve_retornar_verdadeiro_quando_comparado_um_objeto_a_ele_mesmo_atraves_do_equals() {
		assertTrue(produto.equals(produto));
	}

	@Test
	public void deve_retornar_falso_quando_comparado_dois_objetos_de_classes_diferentes_atraves_do_equals() {
		assertFalse(produto.equals(new Object()));
	}

	@Test
	public void deve_retornar_falso_quando_comparado_produto_a_nulo_atraves_do_equals() {
		assertFalse(produto.equals(null));
	}

	@Test
	public void deve_retornar_verdadeiro_na_captura_de_erro_quando_nome_for_nulo() {
		produto.setNome(null);
		Set<ConstraintViolation<Produto>> constraintViolations = validator.validate(produto);
		assertEquals(1, constraintViolations.size());
		assertEquals("Nome do produto não pode estar vazio", constraintViolations.iterator().next().getMessage());
	}

	@Test
	public void deve_retornar_verdadeiro_na_captura_de_erro_quando_nome_possuir_caracteres_invalidos() {
		produto.setNome("!@#$%¨&*()_+");
		Set<ConstraintViolation<Produto>> constraintViolations = validator.validate(produto);
		assertEquals(1, constraintViolations.size());
		assertEquals("Caractere inválido no nome do produto", constraintViolations.iterator().next().getMessage());
	}

	@Test
	public void deve_retornar_verdadeiro_na_captura_de_erro_quando_marca_for_nulo() {
		produto.setMarca(null);
		Set<ConstraintViolation<Produto>> constraintViolations = validator.validate(produto);
		assertEquals(1, constraintViolations.size());
		assertEquals("Marca do produto não pode estar vazia", constraintViolations.iterator().next().getMessage());
	}

	@Test
	public void deve_retornar_verdadeiro_na_captura_de_erro_quando_marca_possuir_caracteres_invalidos() {
		produto.setMarca("!@#$%¨&*()_+");
		Set<ConstraintViolation<Produto>> constraintViolations = validator.validate(produto);
		assertEquals(1, constraintViolations.size());
		assertEquals("Caractere inválido na marca do produto", constraintViolations.iterator().next().getMessage());
	}

	@Test
	public void deve_retornar_verdadeiro_na_captura_de_erro_quando_preco_for_nulo() {
		produto.setPreco(null);
		Set<ConstraintViolation<Produto>> constraintViolations = validator.validate(produto);
		assertEquals(1, constraintViolations.size());
		assertEquals("Preço do produto não pode ser nulo", constraintViolations.iterator().next().getMessage());
	}

	@Test
	public void deve_retornar_verdadeiro_na_captura_de_erro_quando_preco_for_menor_que_o_permitido() {
		produto.setPreco(BigDecimal.valueOf(0));
		Set<ConstraintViolation<Produto>> constraintViolations = validator.validate(produto);
		assertEquals(1, constraintViolations.size());
		assertEquals("Preço do produto minimo é 1", constraintViolations.iterator().next().getMessage());
	}

	@Test
	public void deve_retornar_verdadeiro_na_captura_de_erro_quando_fim_de_producao_for_uma_data_do_passado() {
		produto.setFimProducao(parse("2010-06-07"));
		Set<ConstraintViolation<Produto>> constraintViolations = validator.validate(produto);
		assertEquals(1, constraintViolations.size());
		assertEquals("Fim da produção do produto deve ser uma data futura",
				constraintViolations.iterator().next().getMessage());
	}

	@After
	public void tearDown() {
		produto = null;
	}

	@AfterClass
	public static void tearDownAfterClass() {
		System.out.println("Fim dos teste para a classe Produto");
	}
}
