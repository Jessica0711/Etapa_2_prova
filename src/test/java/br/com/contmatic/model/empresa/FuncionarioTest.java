package br.com.contmatic.model.empresa;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.either;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
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
import org.joda.time.DateTime;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;

import br.com.contmatic.model.endereco.Endereco;
import br.com.contmatic.model.telefone.DDD;
import br.com.contmatic.model.telefone.Telefone;
import br.com.contmatic.model.telefone.TipoTelefone;
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
	 * Deve retornar vardadeiro para um nome nao nulo.
	 */
	@Test
	public void deve_retornar_vardadeiro_para_um_nome_nao_nulo() {
		assertNotNull(funcionario.getNome());
	}

	/**
	 * Deve retornar vardadeiro para um salario nao nulo.
	 */
	@Test
	public void deve_retornar_vardadeiro_para_um_salario_nao_nulo() {
		assertNotNull(funcionario.getSalario());
	}

	/**
	 * Deve retornar vardadeiro para um cargo nao nulo.
	 */
	@Test
	public void deve_retornar_vardadeiro_para_um_cargo_nao_nulo() {
		assertNotNull(funcionario.getCargo());
	}

	/**
	 * Deve retornar vardadeiro para um cpf nao nulo.
	 */
	@Test
	public void deve_retornar_vardadeiro_para_um_cpf_nao_nulo() {
		assertNotNull(funcionario.getCpf());
	}

	/**
	 * Deve retornar vardadeiro para nascimento nao nulo.
	 */
	@Test
	public void deve_retornar_vardadeiro_para_nascimento_nao_nulo() {
		assertNotNull(funcionario.getNascimento());
	}

	/**
	 * Deve retornar vardadeiro para idade nula.
	 */
	@Test
	public void deve_retornar_vardadeiro_para_idade_nula() {
		assertNull(funcionario.getIdade());
	}

	/**
	 * Deve retornar vardadeiro para contratacao nao nulo.
	 */
	@Test
	public void deve_retornar_vardadeiro_para_contratacao_nao_nulo() {
		assertNotNull(funcionario.getContratacao());
	}

	/**
	 * Deve retornar vardadeiro para um telefone nao nulo.
	 */
	@Test
	public void deve_retornar_vardadeiro_para_um_telefone_nao_nulo() {
		assertNotNull(funcionario.getTelefones());
	}

	/**
	 * Deve retornar vardadeiro para um endereco nao nulo.
	 */
	@Test
	public void deve_retornar_vardadeiro_para_um_endereco_nao_nulo() {
		assertNotNull(funcionario.getEnderecos());
	}

	/**
	 * Deve retornar verdadeiro na comparacao do get com nome igual do enviado no
	 * set.
	 */
	@Test
	public void deve_retornar_verdadeiro_na_comparacao_do_get_com_nome_igual_do_enviado_no_set() {
		String nome = funcionario.getNome();
		assertThat(funcionario.getNome(), is(nome));
	}

	/**
	 * Deve retornar falso na comparacao do get com nome diferente do enviado no
	 * set.
	 */
	@Test
	public void deve_retornar_falso_na_comparacao_do_get_com_nome_diferente_do_enviado_no_set() {
		assertThat(funcionario.getNome(), not("Maria Santos"));
	}

	/**
	 * Deve retornar verdadeiro na comparacao do get com salario igual do enviado no
	 * set.
	 */
	@Test
	public void deve_retornar_verdadeiro_na_comparacao_do_get_com_salario_igual_do_enviado_no_set() {
		BigDecimal salario = new BigDecimal(1500);
		funcionario.setSalario(salario);
		assertTrue(funcionario.getSalario().compareTo(salario) == 0);
	}

	/**
	 * Deve retornar falso na comparacao do get com salario diferente do enviado no
	 * set.
	 */
	@Test
	public void deve_retornar_falso_na_comparacao_do_get_com_salario_diferente_do_enviado_no_set() {
		assertFalse(funcionario.getSalario().compareTo(BigDecimal.valueOf(1550.00)) == 0);
	}

	/**
	 * Deve retornar verdadeiro na comparacao do get com cargo igual do enviado no
	 * set.
	 */
	@Test
	public void deve_retornar_verdadeiro_na_comparacao_do_get_com_cargo_igual_do_enviado_no_set() {
		assertThat(funcionario.getCargo(), either(containsString("Vendedor")).or(containsString("Gerente"))
				.or(containsString("Caixa")).or(containsString("Diretor(a)")));
	}

	/**
	 * Deve retornar falso na comparacao do get com cargo diferente do enviado no
	 * set.
	 */
	@Test
	public void deve_retornar_falso_na_comparacao_do_get_com_cargo_diferente_do_enviado_no_set() {
		assertThat(funcionario.getCargo(), not("Estoquista"));
	}

	/**
	 * Deve retornar verdadeiro na comparacao do get com cpf igual do enviado no
	 * set.
	 */
	@Test
	public void deve_retornar_verdadeiro_na_comparacao_do_get_com_cpf_igual_do_enviado_no_set() {
		assertThat(funcionario.getCpf(), either(containsString("432.678.378-80")).or(containsString("820.314.100-59")));
	}

	/**
	 * Deve retornar verdadeiro na comparacao do get com nascimento igual do enviado
	 * no set.
	 */
	@Test
	public void deve_retornar_verdadeiro_na_comparacao_do_get_com_nascimento_igual_do_enviado_no_set() {
		DateTime dataNascimento = DateTime.parse("1993-06-07");
		funcionario.setNascimento(dataNascimento);
		assertThat(funcionario.getNascimento(), is(dataNascimento));
	}

	/**
	 * Deve retornar falso na comparacao do get com nascimento diferente do enviado
	 * no set.
	 */
	@Test
	public void deve_retornar_falso_na_comparacao_do_get_com_nascimento_diferente_do_enviado_no_set() {
		DateTime dataNascimento = DateTime.now();
		assertThat(funcionario.getNascimento(), is(not(dataNascimento)));
	}

	/**
	 * Deve retornar verdadeiro na comparacao do get com contratacao igual do
	 * enviado no set.
	 */
	@Test
	public void deve_retornar_verdadeiro_na_comparacao_do_get_com_contratacao_igual_do_enviado_no_set() {
		DateTime dataContratacao = DateTime.parse("2018-09-11");
		funcionario.setContratacao(dataContratacao);
		assertThat(funcionario.getContratacao(), is(dataContratacao));
	}

	/**
	 * Deve retornar falso na comparacao do get com contratacao diferente do enviado
	 * no set.
	 */
	@Test
	public void deve_retornar_falso_na_comparacao_do_get_com_contratacao_diferente_do_enviado_no_set() {
		DateTime dataContratacao = DateTime.now();
		assertThat(funcionario.getContratacao(), is(not(dataContratacao)));
	}

	/**
	 * Deve retornar verdadeiro na comparacao do get com telefone igual do enviado
	 * no set.
	 */
	@Test
	public void deve_retornar_verdadeiro_na_comparacao_do_get_com_telefone_igual_do_enviado_no_set() {
		Set<Telefone> telefone = new HashSet<>();
		telefone.add(Fixture.from(Telefone.class).gimme("valid"));
		funcionario.setTelefones(telefone);
		assertThat(funcionario.getTelefones(), is(telefone));
	}

	/**
	 * Deve retornar falso na comparacao do get com telefone diferente do enviado no
	 * set.
	 */
	@Test
	public void deve_retornar_falso_na_comparacao_do_get_com_telefone_diferente_do_enviado_no_set() {
		Set<Telefone> telefone = new HashSet<>();
		telefone.add(new Telefone("999999999", TipoTelefone.CELULAR, DDD.DDD15));
		assertThat(funcionario.getTelefones(), not(telefone));
	}

	/**
	 * Deve retornar verdadeiro na comparacao do get com endereco igual do enviado
	 * no set.
	 */
	@Test
	public void deve_retornar_verdadeiro_na_comparacao_do_get_com_endereco_igual_do_enviado_no_set() {
		Set<Endereco> endereco = new HashSet<>();
		endereco.add(Fixture.from(Endereco.class).gimme("valid"));
		funcionario.setEnderecos(endereco);
		assertThat(funcionario.getEnderecos(), is(endereco));
	}

	/**
	 * Deve retornar falso na comparacao do get com endereco diferente do enviado no
	 * set.
	 */
	@Test
	public void deve_retornar_falso_na_comparacao_do_get_com_endereco_diferente_do_enviado_no_set() {
		Set<Endereco> endereco = new HashSet<>();
		endereco.add(Fixture.from(Endereco.class).gimme("valid"));
		assertThat(funcionario.getEnderecos(), not(endereco));
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
		assertEquals("Nome não pode ser vazio", constraintViolations.iterator().next().getMessage());
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
		assertEquals("Salário com valor fora do permitido", constraintViolations.iterator().next().getMessage());
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
		assertEquals("Salário com valor fora do permitido", constraintViolations.iterator().next().getMessage());
	}

	/**
	 * Deve retornar verdadeiro na captura de erro quando o cargo for vazio.
	 */
	@Test
	public void deve_retornar_verdadeiro_na_captura_de_erro_quando_o_cargo_for_vazio() {
		funcionario.setCargo(null);
		Set<ConstraintViolation<Funcionario>> constraintViolations = validator.validate(funcionario);
		assertEquals(1, constraintViolations.size());
		assertEquals("Cargo não pode ser vazio", constraintViolations.iterator().next().getMessage());
	}

	/**
	 * Deve retornar verdadeiro na captura de erro quando tiver numero no cargo.
	 */
	@Test
	public void deve_retornar_verdadeiro_na_captura_de_erro_quando_tiver_numero_no_cargo() {
		funcionario.setCargo("5261bhv15rf");
		Set<ConstraintViolation<Funcionario>> constraintViolations = validator.validate(funcionario);
		assertEquals(1, constraintViolations.size());
		assertEquals("Caractere inválido em cargo", constraintViolations.iterator().next().getMessage());
	}

	/**
	 * Deve retornar verdadeiro na captura de erro quando o cpf possui letras.
	 */
	@Test
	public void deve_retornar_verdadeiro_na_captura_de_erro_quando_o_cpf_possui_letras() {
		funcionario.setCpf("hdjkfh");
		Set<ConstraintViolation<Funcionario>> constraintViolations = validator.validate(funcionario);
		assertEquals(1, constraintViolations.size());
		assertEquals("CPF inválido", constraintViolations.iterator().next().getMessage());
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
		assertEquals("CPF inválido", constraintViolations.iterator().next().getMessage());
	}

	/**
	 * Deve retornar verdadeiro na captura de erro quando cpf for nulo.
	 */
	@Test
	public void deve_retornar_verdadeiro_na_captura_de_erro_quando_cpf_for_nulo() {
		funcionario.setCpf(null);
		Set<ConstraintViolation<Funcionario>> constraintViolations = validator.validate(funcionario);
		assertEquals(1, constraintViolations.size());
		assertEquals("CPF deve ser preenchido", constraintViolations.iterator().next().getMessage());
	}

	/**
	 * Deve retornar verdadeiro na captura de erro quando idade nao for nula.
	 */
	@Test
	public void deve_retornar_verdadeiro_na_captura_de_erro_quando_idade_nao_for_nula() {
		funcionario.setIdade("15");
		Set<ConstraintViolation<Funcionario>> constraintViolations = validator.validate(funcionario);
		assertEquals(1, constraintViolations.size());
		assertEquals("idade não deve ser preenchida", constraintViolations.iterator().next().getMessage());
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
		assertEquals(1, constraintViolations.size());
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
		assertEquals("Somente é permitido um telefone", constraintViolations.iterator().next().getMessage());
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
		assertEquals(3, constraintViolations.size());
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
		assertEquals("Somente pode possuir um endereco", constraintViolations.iterator().next().getMessage());
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
