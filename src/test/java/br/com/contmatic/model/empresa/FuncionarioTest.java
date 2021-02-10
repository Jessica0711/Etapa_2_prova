package br.com.contmatic.model.empresa;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.either;
import static org.hamcrest.CoreMatchers.is;
import static org.joda.time.DateTime.parse;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.junit.runners.MethodSorters.NAME_ASCENDING;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.apache.commons.lang.RandomStringUtils;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;

import br.com.contmatic.model.endereco.Endereco;
import br.com.contmatic.model.telefone.Telefone;
import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.loader.FixtureFactoryLoader;

/**
 * The Class FuncionarioTest.
 */
@FixMethodOrder(NAME_ASCENDING)
public class FuncionarioTest {

	/** The funcionario. */
	private Funcionario funcionario;

	/** The validator. */
	private static Validator validator;

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
		funcionario = Fixture.from(Funcionario.class).gimme("valid");
	}

	/**
	 * Deve retornar vardadeiro para um funcionário nao nulo.
	 */
	@Test
	public void deve_retornar_vardadeiro_para_um_funcionario_nao_nulo() {
		assertNotNull(funcionario.getNome());
		assertNotNull(funcionario.getSalario());
		assertNotNull(funcionario.getCargo());
		assertNotNull(funcionario.getCpf());
		assertNotNull(funcionario.getNascimento());
		assertNull(funcionario.getIdade());
		assertNotNull(funcionario.getContratacao());
		assertNotNull(funcionario.getTelefones());
		assertNotNull(funcionario.getEnderecos());
	}

	/**
	 * Deve retornar verdadeiro na comparacao do get com o enviado no set.
	 */
	@Test
	public void deve_retornar_verdadeiro_na_comparacao_do_get_com_o_enviado_no_set() {
		BigDecimal salario = new BigDecimal(1500);
		funcionario.setSalario(salario);
		assertTrue(funcionario.getSalario().compareTo(salario) == 0);
		assertThat(funcionario.getCargo(), either(containsString("Vendedor")).or(containsString("Gerente"))
				.or(containsString("Caixa")).or(containsString("Diretor(a)")));
		assertThat(funcionario.getCpf(), either(containsString("432.678.378-80")).or(containsString("820.314.100-59")));
		assertThat(funcionario.getNascimento(), is(parse("1995-06-07")));
		assertThat(funcionario.getContratacao(), is(parse("2019-09-11")));
		Set<Telefone> telefone = new HashSet<>();
		telefone.add(Fixture.from(Telefone.class).gimme("valid"));
		funcionario.setTelefones(telefone);
		assertThat(funcionario.getTelefones(), is(telefone));
		Set<Endereco> endereco = new HashSet<>();
		endereco.add(Fixture.from(Endereco.class).gimme("valid"));
		funcionario.setEnderecos(endereco);
		assertThat(funcionario.getEnderecos(), is(endereco));

	}

	/**
	 * Deve retornar verdadeiro na comparacao do hashcode de dois objetos iguais.
	 */
	@Test
	public void deve_retornar_verdadeiro_na_comparacao_do_hashcode_de_dois_objetos_iguais() {
		Funcionario outroFuncionario = funcionario;
		assertEquals(funcionario.hashCode(), outroFuncionario.hashCode());
	}

	/**
	 * Deve retornar falso na comparacao do hashcode de dois objetos diferentes.
	 */
	@Test
	public void deve_retornar_falso_na_comparacao_do_hashcode_de_dois_objetos_diferentes() {
		Funcionario outroFuncionario = Fixture.from(Funcionario.class).gimme("valid");
		assertFalse(funcionario.hashCode() == outroFuncionario.hashCode());
	}

	/**
	 * Deve retornar verdadeiro quando comparado dois objetos iguais atraves do
	 * equals.
	 */
	@Test
	public void deve_retornar_verdadeiro_quando_comparado_dois_objetos_iguais_atraves_do_equals() {
		Funcionario outroFuncionario = funcionario;
		assertTrue(funcionario.equals(outroFuncionario));
	}

	/**
	 * Deve retornar falso quando comparado dois objetos diferentes da mesma classe
	 * atraves do equals.
	 */
	@Test
	public void deve_retornar_falso_quando_comparado_dois_objetos_diferentes_da_mesma_classe_atraves_do_equals() {
		Funcionario outroFuncionario = new Funcionario("José", BigDecimal.valueOf(5000.00), "Gerente", "02358301000");
		assertFalse(funcionario.equals(outroFuncionario));
	}

	/**
	 * Deve retornar falso quando comparado funcionario a um objeto nulo atraves do
	 * equals.
	 */
	@Test
	public void deve_retornar_falso_quando_comparado_funcionario_a_um_objeto_nulo_atraves_do_equals() {
		Funcionario outroFuncionario = null;
		assertFalse(funcionario.equals(outroFuncionario));
	}

	/**
	 * Deve retornar verdadeiro quando comparado um objeto a ele mesmo atraves do
	 * equals.
	 */
	@Test
	public void deve_retornar_verdadeiro_quando_comparado_um_objeto_a_ele_mesmo_atraves_do_equals() {
		assertTrue(funcionario.equals(funcionario));
	}

	/**
	 * Deve retornar falso quando comparado dois objetos de classes diferentes
	 * atraves do equals.
	 */
	@Test
	public void deve_retornar_falso_quando_comparado_dois_objetos_de_classes_diferentes_atraves_do_equals() {
		assertFalse(funcionario.equals(new Object()));
	}

	/**
	 * Deve retornar falso quando comparado funci 0 onario a nulo atraves do equals.
	 */
	@Test
	public void deve_retornar_falso_quando_comparado_funci0onario_a_nulo_atraves_do_equals() {
		assertFalse(funcionario.equals(null));
	}

	/**
	 * Deve retornar verdadeiro na captura de erro quando o nome for vazio.
	 */
	@Test
	public void deve_retornar_verdadeiro_na_captura_de_erro_quando_o_nome_for_vazio() {
		funcionario.setNome(null);
		Set<ConstraintViolation<Funcionario>> constraintViolations = validator.validate(funcionario);
		assertEquals(1, constraintViolations.size());
		assertEquals("Nome do funcionário não pode ser vazio", constraintViolations.iterator().next().getMessage());
	}

	/**
	 * Deve retornar verdadeiro na captura de erro quando tiver numero no nome.
	 */
	@Test
	public void deve_retornar_verdadeiro_na_captura_de_erro_quando_tiver_numero_no_nome() {
		funcionario.setNome("5261bhv15rf");
		Set<ConstraintViolation<Funcionario>> constraintViolations = validator.validate(funcionario);
		assertEquals(1, constraintViolations.size());
		assertEquals("Caractere inválido no nome do funcionário", constraintViolations.iterator().next().getMessage());
	}

	/**
	 * Deve retornar verdadeiro na captura de erro quando salario for menor que o
	 * permitido.
	 */
	@Test
	public void deve_retornar_verdadeiro_na_captura_de_erro_quando_salario_for_menor_que_o_permitido() {
		funcionario.setSalario(BigDecimal.valueOf(1.0));
		Set<ConstraintViolation<Funcionario>> constraintViolations = validator.validate(funcionario);
		assertEquals(1, constraintViolations.size());
		assertEquals("Salário do funcionário com valor fora do permitido",
				constraintViolations.iterator().next().getMessage());
	}

	/**
	 * Deve retornar verdadeiro na captura de erro quando salario for maior que o
	 * permitido.
	 */
	@Test
	public void deve_retornar_verdadeiro_na_captura_de_erro_quando_salario_for_maior_que_o_permitido() {
		funcionario.setSalario(BigDecimal.valueOf(100000.0));
		Set<ConstraintViolation<Funcionario>> constraintViolations = validator.validate(funcionario);
		assertEquals(1, constraintViolations.size());
		assertEquals("Salário do funcionário com valor fora do permitido",
				constraintViolations.iterator().next().getMessage());
	}

	/**
	 * Deve retornar verdadeiro na captura de erro quando o cargo for vazio.
	 */
	@Test
	public void deve_retornar_verdadeiro_na_captura_de_erro_quando_o_cargo_for_vazio() {
		funcionario.setCargo(null);
		Set<ConstraintViolation<Funcionario>> constraintViolations = validator.validate(funcionario);
		assertEquals(1, constraintViolations.size());
		assertEquals("Cargo do funcionário não pode ser vazio", constraintViolations.iterator().next().getMessage());
	}

	/**
	 * Deve retornar verdadeiro na captura de erro quando tiver numero no cargo.
	 */
	@Test
	public void deve_retornar_verdadeiro_na_captura_de_erro_quando_tiver_numero_no_cargo() {
		funcionario.setCargo("5261bhv15rf");
		Set<ConstraintViolation<Funcionario>> constraintViolations = validator.validate(funcionario);
		assertEquals(1, constraintViolations.size());
		assertEquals("Caractere inválido em cargo do funcionário", constraintViolations.iterator().next().getMessage());
	}

	/**
	 * Deve retornar verdadeiro na captura de erro quando o cpf possui letras.
	 */
	@Test
	public void deve_retornar_verdadeiro_na_captura_de_erro_quando_o_cpf_possui_letras() {
		funcionario.setCpf("hdjkfh");
		Set<ConstraintViolation<Funcionario>> constraintViolations = validator.validate(funcionario);
		assertEquals(1, constraintViolations.size());
		assertEquals("CPF do funcionário inválido", constraintViolations.iterator().next().getMessage());
	}

	/**
	 * Deve retornar verdadeiro na captura de erro quando cpf for maior que o
	 * permitido.
	 */
	@Test
	public void deve_retornar_verdadeiro_na_captura_de_erro_quando_cpf_for_maior_que_o_permitido() {
		funcionario.setCpf(RandomStringUtils.randomNumeric(12));
		Set<ConstraintViolation<Funcionario>> constraintViolations = validator.validate(funcionario);
		assertEquals(1, constraintViolations.size());
		assertEquals("CPF do funcionário inválido", constraintViolations.iterator().next().getMessage());
	}

	/**
	 * Deve retornar verdadeiro na captura de erro quando cpf for nulo.
	 */
	@Test
	public void deve_retornar_verdadeiro_na_captura_de_erro_quando_cpf_for_nulo() {
		funcionario.setCpf(null);
		Set<ConstraintViolation<Funcionario>> constraintViolations = validator.validate(funcionario);
		assertEquals(1, constraintViolations.size());
		assertEquals("CPF do funcionário deve ser preenchido", constraintViolations.iterator().next().getMessage());
	}

	/**
	 * Deve retornar verdadeiro na captura de erro quando contratacao for nulo.
	 */
	@Test
	public void deve_retornar_verdadeiro_na_captura_de_erro_quando_contratacao_for_nulo() {
		funcionario.setContratacao(null);
		Set<ConstraintViolation<Funcionario>> constraintViolations = validator.validate(funcionario);
		assertEquals(1, constraintViolations.size());
		assertEquals("Contratação do funcionário não pode ser nula",
				constraintViolations.iterator().next().getMessage());
	}

	/**
	 * Deve retornar verdadeiro na captura de erro quando idade nao for nula.
	 */
	@Test
	public void deve_retornar_verdadeiro_na_captura_de_erro_quando_idade_nao_for_nula() {
		funcionario.setIdade("15");
		Set<ConstraintViolation<Funcionario>> constraintViolations = validator.validate(funcionario);
		assertEquals(1, constraintViolations.size());
		assertEquals("idade do funcionário não deve ser preenchida",
				constraintViolations.iterator().next().getMessage());
	}

	/**
	 * Dev retornar verdadeiro na captura de erros quando telefone for vazio.
	 */
	@Test
	public void dev_retornar_verdadeiro_na_captura_de_erros_quando_telefone_for_vazio() {
		Set<Telefone> telefone = new HashSet<>();
		telefone.add(new Telefone());
		funcionario.setTelefones(telefone);
		Set<ConstraintViolation<Funcionario>> constraintViolations = validator.validate(funcionario);
		assertEquals(9, constraintViolations.size());
	}

	/**
	 * Deve retornar verdadeiro na captura de erros quando inserido mais de um
	 * telefone.
	 */
	@Test
	public void deve_retornar_verdadeiro_na_captura_de_erros_quando_inserido_mais_de_um_telefone() {
		Set<Telefone> telefone = new HashSet<>();
		telefone.add(Fixture.from(Telefone.class).gimme("valid"));
		telefone.add(Fixture.from(Telefone.class).gimme("valid"));
		telefone.add(Fixture.from(Telefone.class).gimme("valid"));
		funcionario.setTelefones(telefone);
		Set<ConstraintViolation<Funcionario>> constraintViolations = validator.validate(funcionario);
		assertEquals(1, constraintViolations.size());
		assertEquals("Somente é permitido um telefone do funcionário",
				constraintViolations.iterator().next().getMessage());
	}

	/**
	 * Deve retornar verdadeiro na captura de erros quando endereco for vazio.
	 */
	@Test
	public void deve_retornar_verdadeiro_na_captura_de_erros_quando_endereco_for_vazio() {
		Set<Endereco> endereco = new HashSet<>();
		endereco.add(new Endereco());
		funcionario.setEnderecos(endereco);
		Set<ConstraintViolation<Funcionario>> constraintViolations = validator.validate(funcionario);
		assertEquals(10, constraintViolations.size());
	}

	/**
	 * Deve retornar verdadeiro na captura de erros quando inserido mais de um
	 * endereco.
	 */
	@Test
	public void deve_retornar_verdadeiro_na_captura_de_erros_quando_inserido_mais_de_um_endereco() {
		Set<Endereco> endereco = new HashSet<>();
		endereco.add(Fixture.from(Endereco.class).gimme("valid"));
		endereco.add(Fixture.from(Endereco.class).gimme("valid"));
		endereco.add(Fixture.from(Endereco.class).gimme("valid"));
		funcionario.setEnderecos(endereco);
		Set<ConstraintViolation<Funcionario>> constraintViolations = validator.validate(funcionario);
		assertEquals(1, constraintViolations.size());
		assertEquals("Somente pode possuir um endereco do funcionário",
				constraintViolations.iterator().next().getMessage());
	}

	/**
	 * Tear down.
	 */
	@After
	public void tearDown() {
		funcionario = null;
	}

	/**
	 * Tear down after class.
	 */
	@AfterClass
	public static void tearDownAfterClass() {
		System.out.println("Finalizado os teste para a classe Funcionario");
	}
}
