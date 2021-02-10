package br.com.contmatic.model.auditoria;

import static br.com.six2six.fixturefactory.Fixture.from;
import static br.com.six2six.fixturefactory.loader.FixtureFactoryLoader.loadTemplates;
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

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * The Class AuditoriaTest.
 */
public class AuditoriaTest {

	/** The auditoria. */
	private Auditoria auditoria;

	/** The validator. */
	private static Validator validator;

	/**
	 * Sets the up before class.
	 */
	@BeforeClass
	public static void setUpBeforeClass() {
		loadTemplates("br.com.contmatic.model.template");
		ValidatorFactory factory = buildDefaultValidatorFactory();
		validator = factory.getValidator();
	}

	/**
	 * Tear down after class.
	 */
	@AfterClass
	public static void tearDownAfterClass() {
		System.out.println("Finalizado os teste para a classe Auditoria");
	}

	/**
	 * Sets the up.
	 */
	@Before
	public void setUp() {
		auditoria = from(Auditoria.class).gimme("valid");
	}

	/**
	 * Tear down.
	 */
	@After
	public void tearDown() {
		auditoria = null;
	}

	/**
	 * Should return true to auditoria is not null.
	 */
	@Test
	public void should_return_true_to_auditoria_is_not_null() {
		assertNotNull(auditoria.getDataAlteracao());
		assertNotNull(auditoria.getDataCadastro());
		assertNotNull(auditoria.getCriadoPor());
		assertNotNull(auditoria.getUltimaModificacao());
		assertNotNull(auditoria.getIpCriadoPor());
		assertNotNull(auditoria.getIpUltimaModificacao());
	}

	/**
	 * Should return true to correct inputs.
	 */
	@Test
	public void should_return_true_to_correct_inputs() {
		assertThat(auditoria.getDataAlteracao(), is(parse("2021-03-02")));
		assertThat(auditoria.getDataCadastro(), is(parse("2021-03-02")));
		assertThat(auditoria.getCriadoPor(), either(containsString("admim")).or(containsString("user")));
		assertThat(auditoria.getIpCriadoPor(),
				either(containsString("1111111")).or(containsString("2222222")).or(containsString("3333333")));
		assertThat(auditoria.getUltimaModificacao(), either(containsString("admim")).or(containsString("user")));
		assertThat(auditoria.getIpUltimaModificacao(),
				either(containsString("1111111")).or(containsString("2222222")).or(containsString("3333333")));
	}
	
	/**
	 * Deve retornar verdadeiro quando todos os campos de auditoria sao validos.
	 */
	@Test
	public void deve_retornar_verdadeiro_quando_todos_os_campos_de_auditoria_sao_validos() {
		Set<ConstraintViolation<Auditoria>> constraintViolations = validator.validate(this.auditoria);
		assertEquals(0, constraintViolations.size());
	}
	
	/**
	 * Deve retornar verdadeiro na captura de erro quando criado por for vazio.
	 */
	@Test
	public void deve_retornar_verdadeiro_na_captura_de_erro_quando_criado_por_for_vazio() {
		this.auditoria.setCriadoPor(null);;
		Set<ConstraintViolation<Auditoria>> constraintViolations = validator.validate(this.auditoria);
		assertEquals(1, constraintViolations.size());
		assertEquals("Criado por não pode ser vazia", constraintViolations.iterator().next().getMessage());
	}
	
	/**
	 * Deve retornar verdadeiro na captura de erro quando data alteracao for vazio.
	 */
	@Test
	public void deve_retornar_verdadeiro_na_captura_de_erro_quando_data_alteracao_for_vazio() {
		this.auditoria.setDataAlteracao(null);
		Set<ConstraintViolation<Auditoria>> constraintViolations = validator.validate(this.auditoria);
		assertEquals(1, constraintViolations.size());
		assertEquals("Data de alteração não pode ser vazia", constraintViolations.iterator().next().getMessage());
	}
	
	/**
	 * Deve retornar verdadeiro na captura de erro quando data cadastro for vazio.
	 */
	@Test
	public void deve_retornar_verdadeiro_na_captura_de_erro_quando_data_cadastro_for_vazio() {
		this.auditoria.setDataCadastro(null);
		Set<ConstraintViolation<Auditoria>> constraintViolations = validator.validate(this.auditoria);
		assertEquals(1, constraintViolations.size());
		assertEquals("Data de cadastro não pode ser vazia", constraintViolations.iterator().next().getMessage());
	}
	
	/**
	 * Deve retornar verdadeiro na captura de erro quando ip criado por for vazio.
	 */
	@Test
	public void deve_retornar_verdadeiro_na_captura_de_erro_quando_ip_criado_por_for_vazio() {
		this.auditoria.setIpCriadoPor(null);
		Set<ConstraintViolation<Auditoria>> constraintViolations = validator.validate(this.auditoria);
		assertEquals(1, constraintViolations.size());
		assertEquals("IP criado por não pode ser vazia", constraintViolations.iterator().next().getMessage());
	}
	
	/**
	 * Deve retornar verdadeiro na captura de erro quando ip ultima modificacao for vazio.
	 */
	@Test
	public void deve_retornar_verdadeiro_na_captura_de_erro_quando_ip_ultima_modificacao_for_vazio() {
		this.auditoria.setIpUltimaModificacao(null);
		Set<ConstraintViolation<Auditoria>> constraintViolations = validator.validate(this.auditoria);
		assertEquals(1, constraintViolations.size());
		assertEquals("IP última modificação não pode ser vazia", constraintViolations.iterator().next().getMessage());
	}
	
	/**
	 * Deve retornar verdadeiro na captura de erro quando ultima modificacao for vazio.
	 */
	@Test
	public void deve_retornar_verdadeiro_na_captura_de_erro_quando_ultima_modificacao_for_vazio() {
		this.auditoria.setUltimaModificacao(null);
		Set<ConstraintViolation<Auditoria>> constraintViolations = validator.validate(this.auditoria);
		assertEquals(1, constraintViolations.size());
		assertEquals("Última modificação não pode ser vazia", constraintViolations.iterator().next().getMessage());
	}
	
	/**
	 * Deve retornar verdadeiro na comparacao do hashcode de dois objetos iguais.
	 */
	@Test
	public void deve_retornar_verdadeiro_na_comparacao_do_hashcode_de_dois_objetos_iguais() {
		Auditoria outraAuditoria = this.auditoria;
		assertEquals(this.auditoria.hashCode(), outraAuditoria.hashCode());
	}

	/**
	 * Deve retornar falso na comparacao do hashcode de dois objetos diferentes.
	 */
	@Test
	public void deve_retornar_falso_na_comparacao_do_hashcode_de_dois_objetos_diferentes() {
		Auditoria outraAuditoria = from(Auditoria.class).gimme("valid");
		assertFalse(this.auditoria.hashCode() == outraAuditoria.hashCode());
	}

	/**
	 * Deve retornar verdadeiro quando comparado dois objetos iguais atraves do
	 * equals.
	 */
	@Test
	public void deve_retornar_verdadeiro_quando_comparado_dois_objetos_iguais_atraves_do_equals() {
		Auditoria outraAuditoria = this.auditoria;
		assertTrue(this.auditoria.equals(outraAuditoria));
	}

	/**
	 * Deve retornar falso quando comparado dois objetos diferentes da mesma classe
	 * atraves do equals.
	 */
	@Test
	public void deve_retornar_falso_quando_comparado_dois_objetos_diferentes_da_mesma_classe_atraves_do_equals() {
		Auditoria outraAuditoria = from(Auditoria.class).gimme("valid");
		assertFalse(this.auditoria.equals(outraAuditoria));
	}

	/**
	 * Deve retornar falso quando comparado endereço a um objeto nulo atraves do
	 * equals.
	 */
	@Test
	public void deve_retornar_falso_quando_comparado_auditoria_a_um_objeto_nulo_atraves_do_equals() {
		Auditoria outraAuditoria = null;
		assertFalse(this.auditoria.equals(outraAuditoria));
	}

	/**
	 * Deve retornar falso quando comparado dois objetos de classes diferentes
	 * atraves do equals.
	 */
	@Test
	public void deve_retornar_falso_quando_comparado_dois_objetos_de_classes_diferentes_atraves_do_equals() {
		assertFalse(this.auditoria.equals(new Object()));
	}

	/**
	 * Deve retornar falso quando comparado endereço a nulo atraves do equals.
	 */
	@Test
	public void deve_retornar_falso_quando_comparado_auditoria_a_nulo_atraves_do_equals() {
		assertFalse(this.auditoria.equals(null));
	}

	/**
	 * Deve retornar verdadeiro quando comparado um objeto a ele mesmo atraves do
	 * equals.
	 */
	@Test
	public void deve_retornar_verdadeiro_quando_comparado_um_objeto_a_ele_mesmo_atraves_do_equals() {
		assertTrue(this.auditoria.equals(this.auditoria));
	}

}
