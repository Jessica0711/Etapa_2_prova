package br.com.contmatic.model.empresa;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.either;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.junit.runners.MethodSorters.NAME_ASCENDING;

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
import br.com.contmatic.model.telefone.DDD;
import br.com.contmatic.model.telefone.Telefone;
import br.com.contmatic.model.telefone.TipoTelefone;
import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.loader.FixtureFactoryLoader;

/**
 * The Class ClienteTest.
 */
@FixMethodOrder(NAME_ASCENDING)
public class ClienteTest {

	/** The cliente. */
	private Cliente cliente;

	/** The validator. */
	private static Validator validator;

	/**
	 * Set up before class.
	 */
	@BeforeClass
	public static void setUpBeforeClass() {
		FixtureFactoryLoader.loadTemplates("br.com.contmatic.model.template");
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
	}

	/**
	 * Tear down after class.
	 */
	@AfterClass
	public static void tearDownAfterClass() {
		System.out.println("Fim dos testes para a classe cliente");
	}

	/**
	 * Set up.
	 */
	@Before
	public void setUp() {
		cliente = Fixture.from(Cliente.class).gimme("valid");
	}

	/**
	 * Tear down.
	 */
	@After
	public void tearDown() {
		cliente = null;
	}

	/**
	 * Deve retornar vardadeiro para um nome nao nulo.
	 */
	@Test
	public void deve_retornar_vardadeiro_para_um_nome_nao_nulo() {
		assertNotNull(cliente.getNome());
	}

	/**
	 * Deve retornar vardadeiro para um cpf nao nulo.
	 */
	@Test
	public void deve_retornar_vardadeiro_para_um_cpf_nao_nulo() {
		assertNotNull(cliente.getCpf());
	}

	/**
	 * Deve retornar vardadeiro para um endereco nao nulo.
	 */
	@Test
	public void deve_retornar_vardadeiro_para_um_endereco_nao_nulo() {
		assertNotNull(cliente.getEnderecos());
	}

	/**
	 * Deve retornar vardadeiro para um email nao nulo.
	 */
	@Test
	public void deve_retornar_vardadeiro_para_um_email_nao_nulo() {
		assertNotNull(cliente.getEmail());
	}

	/**
	 * Deve retornarverdadeiro para um telefone não nulo.
	 */
	@Test
	public void deve_retornarverdadeiro_para_um_telefone_não_nulo() {
		assertNotNull(cliente.getTelefones());
	}

	/**
	 * Deve retornar verdadeiro na comparacao do get com nome igual do enviado no
	 * set.
	 */
	@Test
	public void deve_retornar_verdadeiro_na_comparacao_do_get_com_nome_igual_do_enviado_no_set() {
		String nome = cliente.getNome();
		assertThat(cliente.getNome(), is(nome));
	}

	/**
	 * Deve retornar falso na comparacao do get com nome diferente do enviado no
	 * set.
	 */
	@Test
	public void deve_retornar_falso_na_comparacao_do_get_com_nome_diferente_do_enviado_no_set() {
		assertThat(cliente.getNome(), not("João Silva"));
	}

	/**
	 * Deve retornar verdadeiro na comparacao do get com cpf igual do enviado no
	 * set.
	 */
	@Test
	public void deve_retornar_verdadeiro_na_comparacao_do_get_com_cpf_igual_do_enviado_no_set() {
		assertThat(cliente.getCpf(), either(containsString("820.314.100-59")).or(containsString("432.678.378-80")));
	}

	/**
	 * Deve retornar falso na comparacao do get com cpf diferente do enviado no set.
	 */
	@Test
	public void deve_retornar_falso_na_comparacao_do_get_com_cpf_diferente_do_enviado_no_set() {
		assertThat(cliente.getCpf(), not("555.614.488-80"));
	}

	/**
	 * Deve retornar verdadeiro na comparacao do get com endereco igual do enviado
	 * no set.
	 */
	@Test
	public void deve_retornar_verdadeiro_na_comparacao_do_get_com_endereco_igual_do_enviado_no_set() {
		Set<Endereco> endereco = new HashSet<>();
		endereco.add(Fixture.from(Endereco.class).gimme("valid"));
		cliente.setEnderecos(endereco);
		assertThat(cliente.getEnderecos(), is(endereco));
	}

	/**
	 * Deve retornar verdadeiro na comparacao do get com email igual do enviado no
	 * set.
	 */
	@Test
	public void deve_retornar_verdadeiro_na_comparacao_do_get_com_email_igual_do_enviado_no_set() {
		assertThat(cliente.getEmail(),
				either(containsString("exemplo@teste.com")).or(containsString("testando@test.com")));
	}

	/**
	 * Deve retornar falso na comparacao do get com email diferente do enviado no
	 * set.
	 */
	@Test
	public void deve_retornar_falso_na_comparacao_do_get_com_email_diferente_do_enviado_no_set() {
		assertThat(cliente.getEmail(), not("qualquer@email.com.br"));
	}

	/**
	 * Deve retornar verdadeiro na comparacao do get com telefone igual do enviado
	 * no set.
	 */
	@Test
	public void deve_retornar_verdadeiro_na_comparacao_do_get_com_telefone_igual_do_enviado_no_set() {
		Set<Telefone> telefone = new HashSet<>();
		telefone.add(Fixture.from(Telefone.class).gimme("valid"));
		cliente.setTelefones(telefone);
		assertThat(cliente.getTelefones(), is(telefone));
	}

	/**
	 * Deve retornar falso na comparacao do get com telefone diferente do enviado no
	 * set.
	 */
	@Test
	public void deve_retornar_falso_na_comparacao_do_get_com_telefone_diferente_do_enviado_no_set() {
		Set<Telefone> telefone = new HashSet<>();
		telefone.add(new Telefone("999999999", TipoTelefone.CELULAR, DDD.DDD15));
		assertThat(cliente.getTelefones(), not(telefone));
	}

	/**
	 * Deve retornar verdadeiro na comparacao do hashcode de dois objetos iguais.
	 */
	@Test
	public void deve_retornar_verdadeiro_na_comparacao_do_hashcode_de_dois_objetos_iguais() {
		Cliente outroCliente = cliente;
		assertEquals(cliente.hashCode(), outroCliente.hashCode());
	}

	/**
	 * Deve retornar falso na comparacao do hashcode de dois objetos diferentes.
	 */
	@Test
	public void deve_retornar_falso_na_comparacao_do_hashcode_de_dois_objetos_diferentes() {
		Cliente outroCliente = Fixture.from(Cliente.class).gimme("valid");
		assertFalse(cliente.hashCode() == outroCliente.hashCode());
	}

	/**
	 * Deve retornar verdadeiro quando comparado dois objetos iguais atraves do
	 * equals.
	 */
	@Test
	public void deve_retornar_verdadeiro_quando_comparado_dois_objetos_iguais_atraves_do_equals() {
		Cliente outroCliente = cliente;
		assertTrue(cliente.equals(outroCliente));
	}

	/**
	 * Deve retornar falso quando comparado dois objetos diferentes da mesma classe
	 * atraves do equals.
	 */
	@Test
	public void deve_retornar_falso_quando_comparado_dois_objetos_diferentes_da_mesma_classe_atraves_do_equals() {
		Cliente outroCliente = new Cliente("Maria", "02358301000");
		assertFalse(cliente.equals(outroCliente));
	}

	/**
	 * Deve retornar falso quando comparado cliente a um objeto nulo atraves do
	 * equals.
	 */
	@Test
	public void deve_retornar_falso_quando_comparado_cliente_a_um_objeto_nulo_atraves_do_equals() {
		Cliente outroCliente = null;
		assertFalse(cliente.equals(outroCliente));
	}

	/**
	 * Deve retornar falso quando comparado dois objetos de classes diferentes
	 * atraves do equals.
	 */
	@Test
	public void deve_retornar_falso_quando_comparado_dois_objetos_de_classes_diferentes_atraves_do_equals() {
		assertFalse(cliente.equals(new Object()));
	}

	/**
	 * Deve retornar verdadeiro quando comparado um objeto a ele mesmo atraves do
	 * equals.
	 */
	@Test
	public void deve_retornar_verdadeiro_quando_comparado_um_objeto_a_ele_mesmo_atraves_do_equals() {
		assertTrue(cliente.equals(cliente));
	}

	/**
	 * Deve retornar verdadeiro na captura de erro quando tiver numero no nome.
	 */
	@Test
	public void deve_retornar_verdadeiro_na_captura_de_erro_quando_tiver_numero_no_nome() {
		cliente.setNome("5261bhv15rf");
		Set<ConstraintViolation<Cliente>> constraintViolations = validator.validate(cliente);
		assertEquals(1, constraintViolations.size());
		assertEquals("Caractere inválido no Nome", constraintViolations.iterator().next().getMessage());
	}

	/**
	 * Deve retornar verdadeiro na captura de erro quando o nome for vazio.
	 */
	@Test
	public void deve_retornar_verdadeiro_na_captura_de_erro_quando_o_nome_for_vazio() {
		cliente.setNome(null);
		Set<ConstraintViolation<Cliente>> constraintViolations = validator.validate(cliente);
		assertEquals(1, constraintViolations.size());
		assertEquals("Nome não pode ser vazio", constraintViolations.iterator().next().getMessage());
	}

	/**
	 * Deve retornar verdadeiro na captura de erro quando tiver letra no cpf.
	 */
	@Test
	public void deve_retornar_verdadeiro_na_captura_de_erro_quando_tiver_letra_no_cpf() {
		cliente.setCpf("45f1egf1es54d");
		Set<ConstraintViolation<Cliente>> constraintViolations = validator.validate(cliente);
		assertEquals(1, constraintViolations.size());
		assertEquals("CPF inválido", constraintViolations.iterator().next().getMessage());
	}

	/**
	 * Deve retornar verdadeiro na captura de erro quando cpf for maior que o
	 * permitido.
	 */
	@Test
	public void deve_retornar_verdadeiro_na_captura_de_erro_quando_cpf_for_maior_que_o_permitido() {
		cliente.setCpf(RandomStringUtils.randomNumeric(12));
		Set<ConstraintViolation<Cliente>> constraintViolations = validator.validate(cliente);
		assertEquals(1, constraintViolations.size());
		assertEquals("CPF inválido", constraintViolations.iterator().next().getMessage());
	}

	/**
	 * Deve retornar verdadeiro na captura de erro quando email for nulo.
	 */
	@Test
	public void deve_retornar_verdadeiro_na_captura_de_erro_quando_email_for_nulo() {
		cliente.setEmail(null);
		Set<ConstraintViolation<Cliente>> constraintViolations = validator.validate(cliente);
		assertEquals(1, constraintViolations.size());
		assertEquals("Email não pode ser nulo", constraintViolations.iterator().next().getMessage());
	}

	/**
	 * Deve retornar verdadeiro na captura de erros quando telefone for vazio.
	 */
	@Test
	public void deve_retornar_verdadeiro_na_captura_de_erros_quando_telefone_for_vazio() {
		Set<Telefone> telefone = new HashSet<>();
		telefone.add(new Telefone());
		cliente.setTelefones(telefone);
		Set<ConstraintViolation<Cliente>> constraintViolations = validator.validate(cliente);
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
		cliente.setTelefones(telefone);
		Set<ConstraintViolation<Cliente>> constraintViolations = validator.validate(cliente);
		assertEquals(1, constraintViolations.size());
		assertEquals("Somente pode possuir um telefone", constraintViolations.iterator().next().getMessage());
	}

	/**
	 * Deve retornar verdadeiro na captura de erros quando endereco for vazio.
	 */
	@Test
	public void deve_retornar_verdadeiro_na_captura_de_erros_quando_endereco_for_vazio() {
		Set<Endereco> endereco = new HashSet<>();
		endereco.add(new Endereco());
		cliente.setEnderecos(endereco);
		Set<ConstraintViolation<Cliente>> constraintViolations = validator.validate(cliente);
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
		cliente.setEnderecos(endereco);
		Set<ConstraintViolation<Cliente>> constraintViolations = validator.validate(cliente);
		assertEquals(1, constraintViolations.size());
		assertEquals("Somente pode possuir um endereco", constraintViolations.iterator().next().getMessage());
	}
}
