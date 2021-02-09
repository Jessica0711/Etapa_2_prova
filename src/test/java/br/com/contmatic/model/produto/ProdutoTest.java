package br.com.contmatic.model.produto;

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
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.joda.time.DateTime;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.loader.FixtureFactoryLoader;

/**
 * The Class ProdutoTest.
 */
public class ProdutoTest {

	/** The validator. */
	private static Validator validator;

	/** The produto. */
	private Produto produto;

	/**
	 * Set up before class.
	 */
	@BeforeClass
	public static void setUp_before_class() {
		FixtureFactoryLoader.loadTemplates("br.com.contmatic.model.template");
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
	}

	/**
	 * Set up.
	 */
	@Before
	public void setUp() {
		produto = Fixture.from(Produto.class).gimme("valid");
	}

	/**
	 * Deve retornar verdadeiro para um produto nao nulo.
	 */
	@Test
	public void deve_retornar_verdadeiro_para_um_produto_nao_nulo() {
		assertNotNull(produto.getNome());
		assertNotNull(produto.getMarca());
		assertNotNull(produto.getPreco());
		assertNotNull(produto.getCodigo());
		assertNotNull(produto.getFimProducao());
	}

	/**
	 * Deve retornar verdadeiro na comparacao do get com o enviado no set.
	 */
	@Test
	public void deve_retornar_verdadeiro_na_comparacao_do_get_com_o_enviado_no_set() {
		assertThat(produto.getNome(), either(containsString("Shorts")).or(containsString("Calça"))
				.or(containsString("Camisa")).or(containsString("Vestido")));
		assertThat(produto.getMarca(),
				either(containsString("Camaleon")).or(containsString("Addidas")).or(containsString("Nike")));
		assertThat(produto.getFimProducao(), is(parse("2030-03-11")));
	}

	/**
	 * Deve retornar verdadeiro na comparacao do hashcode de dois objetos iguais.
	 */
	@Test
	public void deve_retornar_verdadeiro_na_comparacao_do_hashcode_de_dois_objetos_iguais() {
		Produto outroProduto = produto;
		assertEquals(produto.hashCode(), outroProduto.hashCode());
	}

	/**
	 * Deve retornar falso na comparacao do hashcode de dois objetos diferentes.
	 */
	@Test
	public void deve_retornar_falso_na_comparacao_do_hashcode_de_dois_objetos_diferentes() {
		Produto outroProduto = new Produto("Camisa", "Adidas", BigDecimal.valueOf(50.46), (long) 1489);
		assertFalse(produto.hashCode() == outroProduto.hashCode());
	}

	/**
	 * Deve retornar verdadeiro quando comparado dois objetos iguais atraves do
	 * equals.
	 */
	@Test
	public void deve_retornar_verdadeiro_quando_comparado_dois_objetos_iguais_atraves_do_equals() {
		Produto outroProduto = produto;
		assertTrue(produto.equals(outroProduto));
	}

	/**
	 * Deve retornar falso quando comparado dois objetos diferentes da mesma classe
	 * atraves do equals.
	 */
	@Test
	public void deve_retornar_falso_quando_comparado_dois_objetos_diferentes_da_mesma_classe_atraves_do_equals() {
		Produto outroProduto = Fixture.from(Produto.class).gimme("valid");
		outroProduto.setCodigo(15);
		assertFalse(produto.equals(outroProduto));
	}

	/**
	 * Deve retornar falso quando comparado produto a um objeto nulo atraves do
	 * equals.
	 */
	@Test
	public void deve_retornar_falso_quando_comparado_produto_a_um_objeto_nulo_atraves_do_equals() {
		Produto outroProduto = null;
		assertFalse(produto.equals(outroProduto));
	}

	/**
	 * Deve retornar verdadeiro quando comparado um objeto a ele mesmo atraves do
	 * equals.
	 */
	@Test
	public void deve_retornar_verdadeiro_quando_comparado_um_objeto_a_ele_mesmo_atraves_do_equals() {
		assertTrue(produto.equals(produto));
	}

	/**
	 * Deve retornar falso quando comparado dois objetos de classes diferentes
	 * atraves do equals.
	 */
	@Test
	public void deve_retornar_falso_quando_comparado_dois_objetos_de_classes_diferentes_atraves_do_equals() {
		assertFalse(produto.equals(new Object()));
	}

	/**
	 * Deve retornar falso quando comparado produto a nulo atraves do equals.
	 */
	@Test
	public void deve_retornar_falso_quando_comparado_produto_a_nulo_atraves_do_equals() {
		assertFalse(produto.equals(null));
	}

	/**
	 * Deve retornar verdadeiro na captura de erro quando nome for nulo.
	 */
	@Test
	public void deve_retornar_verdadeiro_na_captura_de_erro_quando_nome_for_nulo() {
		produto.setNome(null);
		Set<ConstraintViolation<Produto>> constraintViolations = validator.validate(produto);
		assertEquals(1, constraintViolations.size());
		assertEquals("Nome do produto não pode estar vazio", constraintViolations.iterator().next().getMessage());
	}

	/**
	 * Deve retornar verdadeiro na captura de erro quando nome possuir caracteres
	 * invalidos.
	 */
	@Test
	public void deve_retornar_verdadeiro_na_captura_de_erro_quando_nome_possuir_caracteres_invalidos() {
		produto.setNome("!@#$%¨&*()_+");
		Set<ConstraintViolation<Produto>> constraintViolations = validator.validate(produto);
		assertEquals(1, constraintViolations.size());
		assertEquals("Caractere inválido no nome do produto", constraintViolations.iterator().next().getMessage());
	}

	/**
	 * Deve retornar verdadeiro na captura de erro quando marca for nulo.
	 */
	@Test
	public void deve_retornar_verdadeiro_na_captura_de_erro_quando_marca_for_nulo() {
		produto.setMarca(null);
		Set<ConstraintViolation<Produto>> constraintViolations = validator.validate(produto);
		assertEquals(1, constraintViolations.size());
		assertEquals("Marca do produto não pode estar vazia", constraintViolations.iterator().next().getMessage());
	}

	/**
	 * Deve retornar verdadeiro na captura de erro quando marca possuir caracteres
	 * invalidos.
	 */
	@Test
	public void deve_retornar_verdadeiro_na_captura_de_erro_quando_marca_possuir_caracteres_invalidos() {
		produto.setMarca("!@#$%¨&*()_+");
		Set<ConstraintViolation<Produto>> constraintViolations = validator.validate(produto);
		assertEquals(1, constraintViolations.size());
		assertEquals("Caractere inválido na marca do produto", constraintViolations.iterator().next().getMessage());
	}

	/**
	 * Deve retornar verdadeiro na captura de erro quando preco for nulo.
	 */
	@Test
	public void deve_retornar_verdadeiro_na_captura_de_erro_quando_preco_for_nulo() {
		produto.setPreco(null);
		Set<ConstraintViolation<Produto>> constraintViolations = validator.validate(produto);
		assertEquals(1, constraintViolations.size());
		assertEquals("Preço do produto não pode ser nulo", constraintViolations.iterator().next().getMessage());
	}

	/**
	 * Deve retornar verdadeiro na captura de erro quando preco for menor que o
	 * permitido.
	 */
	@Test
	public void deve_retornar_verdadeiro_na_captura_de_erro_quando_preco_for_menor_que_o_permitido() {
		produto.setPreco(BigDecimal.valueOf(0));
		Set<ConstraintViolation<Produto>> constraintViolations = validator.validate(produto);
		assertEquals(1, constraintViolations.size());
		assertEquals("Preço do produto minimo é 1", constraintViolations.iterator().next().getMessage());
	}

	/**
	 * Deve retornar verdadeiro na captura de erro quando fim de produção for uma
	 * data do passado
	 */
	@Test
	public void deve_retornar_verdadeiro_na_captura_de_erro_quando_fim_de_producao_for_uma_data_do_passado() {
		produto.setFimProducao(DateTime.parse("2010-06-07"));
		Set<ConstraintViolation<Produto>> constraintViolations = validator.validate(produto);
		assertEquals(1, constraintViolations.size());
		assertEquals("Fim da produção do produto deve ser uma data futura",
				constraintViolations.iterator().next().getMessage());
	}

	/**
	 * Tear down.
	 */
	@After
	public void tearDown() {
		produto = null;
	}

	/**
	 * Tear down after class.
	 */
	@AfterClass
	public static void tearDownAfterClass() {
		System.out.println("Fim dos teste para a classe Produto");
	}
}
