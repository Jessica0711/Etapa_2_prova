package br.com.contmatic.model.empresa;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.either;
import static org.hamcrest.CoreMatchers.is;
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
import br.com.contmatic.model.telefone.Telefone;
import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.loader.FixtureFactoryLoader;

@FixMethodOrder(NAME_ASCENDING)
public class ClienteTest {

	private Cliente cliente;

	private static Validator validator;

	@BeforeClass
	public static void setUpBeforeClass() {
		FixtureFactoryLoader.loadTemplates("br.com.contmatic.model.template");
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
	}

	@AfterClass
	public static void tearDownAfterClass() {
		System.out.println("Fim dos testes para a classe cliente");
	}

	@Before
	public void setUp() {
		cliente = Fixture.from(Cliente.class).gimme("valid");
	}

	@After
	public void tearDown() {
		cliente = null;
	}

	@Test
	public void deve_retornar_vardadeiro_para_uma_empresa_nao_nulo() {
		assertNotNull(cliente.getNome());
		assertNotNull(cliente.getCpf());
		assertNotNull(cliente.getEnderecos());
		assertNotNull(cliente.getEmail());
		assertNotNull(cliente.getTelefones());
	}

	@Test
	public void deve_retornar_verdadeiro_na_comparacao_do_get_com_o_enviado_no_set() {
		assertThat(cliente.getCpf(), either(containsString("820.314.100-59")).or(containsString("432.678.378-80")));
		Set<Endereco> endereco = new HashSet<>();
		endereco.add(Fixture.from(Endereco.class).gimme("valid"));
		cliente.setEnderecos(endereco);
		assertThat(cliente.getEnderecos(), is(endereco));
		assertThat(cliente.getEmail(),
				either(containsString("exemplo@teste.com")).or(containsString("testando@test.com")));
		Set<Telefone> telefone = new HashSet<>();
		telefone.add(Fixture.from(Telefone.class).gimme("valid"));
		cliente.setTelefones(telefone);
		assertThat(cliente.getTelefones(), is(telefone));

	}

	@Test
	public void deve_retornar_verdadeiro_na_comparacao_do_hashcode_de_dois_objetos_iguais() {
		Cliente outroCliente = cliente;
		assertEquals(cliente.hashCode(), outroCliente.hashCode());
	}

	@Test
	public void deve_retornar_falso_na_comparacao_do_hashcode_de_dois_objetos_diferentes() {
		Cliente outroCliente = Fixture.from(Cliente.class).gimme("valid");
		assertFalse(cliente.hashCode() == outroCliente.hashCode());
	}

	@Test
	public void deve_retornar_verdadeiro_quando_comparado_dois_objetos_iguais_atraves_do_equals() {
		Cliente outroCliente = cliente;
		assertTrue(cliente.equals(outroCliente));
	}

	@Test
	public void deve_retornar_falso_quando_comparado_dois_objetos_diferentes_da_mesma_classe_atraves_do_equals() {
		Cliente outroCliente = new Cliente("Maria", "02358301000");
		assertFalse(cliente.equals(outroCliente));
	}

	@Test
	public void deve_retornar_falso_quando_comparado_cliente_a_um_objeto_nulo_atraves_do_equals() {
		Cliente outroCliente = null;
		assertFalse(cliente.equals(outroCliente));
	}

	@Test
	public void deve_retornar_falso_quando_comparado_dois_objetos_de_classes_diferentes_atraves_do_equals() {
		assertFalse(cliente.equals(new Object()));
	}

	@Test
	public void deve_retornar_verdadeiro_quando_comparado_um_objeto_a_ele_mesmo_atraves_do_equals() {
		assertTrue(cliente.equals(cliente));
	}

	@Test
	public void deve_retornar_verdadeiro_na_captura_de_erro_quando_tiver_numero_no_nome() {
		cliente.setNome("5261bhv15rf");
		Set<ConstraintViolation<Cliente>> constraintViolations = validator.validate(cliente);
		assertEquals(1, constraintViolations.size());
		assertEquals("Caractere inválido no nome do cliente", constraintViolations.iterator().next().getMessage());
	}

	@Test
	public void deve_retornar_verdadeiro_na_captura_de_erro_quando_o_nome_for_vazio() {
		cliente.setNome(null);
		Set<ConstraintViolation<Cliente>> constraintViolations = validator.validate(cliente);
		assertEquals(1, constraintViolations.size());
		assertEquals("Nome do cliente não pode ser vazio", constraintViolations.iterator().next().getMessage());
	}

	@Test
	public void deve_retornar_verdadeiro_na_captura_de_erro_quando_tiver_letra_no_cpf() {
		cliente.setCpf("45f1egf1es54d");
		Set<ConstraintViolation<Cliente>> constraintViolations = validator.validate(cliente);
		assertEquals(1, constraintViolations.size());
		assertEquals("CPF do cliente inválido", constraintViolations.iterator().next().getMessage());
	}

	@Test
	public void deve_retornar_verdadeiro_na_captura_de_erro_quando_cpf_for_maior_que_o_permitido() {
		cliente.setCpf(RandomStringUtils.randomNumeric(12));
		Set<ConstraintViolation<Cliente>> constraintViolations = validator.validate(cliente);
		assertEquals(1, constraintViolations.size());
		assertEquals("CPF do cliente inválido", constraintViolations.iterator().next().getMessage());
	}

	@Test
	public void deve_retornar_verdadeiro_na_captura_de_erro_quando_email_for_nulo() {
		cliente.setEmail(null);
		Set<ConstraintViolation<Cliente>> constraintViolations = validator.validate(cliente);
		assertEquals(1, constraintViolations.size());
		assertEquals("Email do cliente não pode ser nulo", constraintViolations.iterator().next().getMessage());
	}

	@Test
	public void deve_retornar_verdadeiro_na_captura_de_erros_quando_telefone_for_vazio() {
		Set<Telefone> telefone = new HashSet<>();
		telefone.add(new Telefone());
		cliente.setTelefones(telefone);
		Set<ConstraintViolation<Cliente>> constraintViolations = validator.validate(cliente);
		assertEquals(9, constraintViolations.size());
	}

	@Test
	public void deve_retornar_verdadeiro_na_captura_de_erros_quando_inserido_mais_de_um_telefone() {
		Set<Telefone> telefone = new HashSet<>();
		telefone.add(Fixture.from(Telefone.class).gimme("valid"));
		telefone.add(Fixture.from(Telefone.class).gimme("valid"));
		telefone.add(Fixture.from(Telefone.class).gimme("valid"));
		cliente.setTelefones(telefone);
		Set<ConstraintViolation<Cliente>> constraintViolations = validator.validate(cliente);
		assertEquals(1, constraintViolations.size());
		assertEquals("Somente pode possuir um telefone no cliente", constraintViolations.iterator().next().getMessage());
	}

	@Test
	public void deve_retornar_verdadeiro_na_captura_de_erros_quando_endereco_for_vazio() {
		Set<Endereco> endereco = new HashSet<>();
		endereco.add(new Endereco());
		cliente.setEnderecos(endereco);
		Set<ConstraintViolation<Cliente>> constraintViolations = validator.validate(cliente);
		assertEquals(10, constraintViolations.size());
	}

	@Test
	public void deve_retornar_verdadeiro_na_captura_de_erros_quando_inserido_mais_de_um_endereco() {
		Set<Endereco> endereco = new HashSet<>();
		endereco.add(Fixture.from(Endereco.class).gimme("valid"));
		endereco.add(Fixture.from(Endereco.class).gimme("valid"));
		endereco.add(Fixture.from(Endereco.class).gimme("valid"));
		cliente.setEnderecos(endereco);
		Set<ConstraintViolation<Cliente>> constraintViolations = validator.validate(cliente);
		assertEquals(1, constraintViolations.size());
		assertEquals("Somente pode possuir um endereco no cliente", constraintViolations.iterator().next().getMessage());
	}
}
