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

public class AuditoriaTest {

	private Auditoria auditoria;

	private static Validator validator;

	@BeforeClass
	public static void setUpBeforeClass() {
		loadTemplates("br.com.contmatic.model.template");
		ValidatorFactory factory = buildDefaultValidatorFactory();
		validator = factory.getValidator();
	}

	@AfterClass
	public static void tearDownAfterClass() {
		System.out.println("Finalizado os teste para a classe Auditoria");
	}

	@Before
	public void setUp() {
		auditoria = from(Auditoria.class).gimme("valid");
	}

	@After
	public void tearDown() {
		auditoria = null;
	}

	@Test
	public void should_return_true_to_auditoria_is_not_null() {
		assertNotNull(auditoria.getDataAlteracao());
		assertNotNull(auditoria.getDataCadastro());
		assertNotNull(auditoria.getCriadoPor());
		assertNotNull(auditoria.getUltimaModificacao());
		assertNotNull(auditoria.getIpCriadoPor());
		assertNotNull(auditoria.getIpUltimaModificacao());
	}

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
	
	@Test
	public void deve_retornar_verdadeiro_quando_todos_os_campos_de_auditoria_sao_validos() {
		Set<ConstraintViolation<Auditoria>> constraintViolations = validator.validate(this.auditoria);
		assertEquals(0, constraintViolations.size());
	}
	
	@Test
	public void deve_retornar_verdadeiro_na_captura_de_erro_quando_criado_por_for_vazio() {
		this.auditoria.setCriadoPor(null);;
		Set<ConstraintViolation<Auditoria>> constraintViolations = validator.validate(this.auditoria);
		assertEquals(1, constraintViolations.size());
		assertEquals("Criado por não pode ser vazia", constraintViolations.iterator().next().getMessage());
	}
	
	@Test
	public void deve_retornar_verdadeiro_na_captura_de_erro_quando_data_alteracao_for_vazio() {
		this.auditoria.setDataAlteracao(null);
		Set<ConstraintViolation<Auditoria>> constraintViolations = validator.validate(this.auditoria);
		assertEquals(1, constraintViolations.size());
		assertEquals("Data de alteração não pode ser vazia", constraintViolations.iterator().next().getMessage());
	}
	
	@Test
	public void deve_retornar_verdadeiro_na_captura_de_erro_quando_data_cadastro_for_vazio() {
		this.auditoria.setDataCadastro(null);
		Set<ConstraintViolation<Auditoria>> constraintViolations = validator.validate(this.auditoria);
		assertEquals(1, constraintViolations.size());
		assertEquals("Data de cadastro não pode ser vazia", constraintViolations.iterator().next().getMessage());
	}
	
	@Test
	public void deve_retornar_verdadeiro_na_captura_de_erro_quando_ip_criado_por_for_vazio() {
		this.auditoria.setIpCriadoPor(null);
		Set<ConstraintViolation<Auditoria>> constraintViolations = validator.validate(this.auditoria);
		assertEquals(1, constraintViolations.size());
		assertEquals("IP criado por não pode ser vazia", constraintViolations.iterator().next().getMessage());
	}
	
	@Test
	public void deve_retornar_verdadeiro_na_captura_de_erro_quando_ip_ultima_modificacao_for_vazio() {
		this.auditoria.setIpUltimaModificacao(null);
		Set<ConstraintViolation<Auditoria>> constraintViolations = validator.validate(this.auditoria);
		assertEquals(1, constraintViolations.size());
		assertEquals("IP última modificação não pode ser vazia", constraintViolations.iterator().next().getMessage());
	}
	
	@Test
	public void deve_retornar_verdadeiro_na_captura_de_erro_quando_ultima_modificacao_for_vazio() {
		this.auditoria.setUltimaModificacao(null);
		Set<ConstraintViolation<Auditoria>> constraintViolations = validator.validate(this.auditoria);
		assertEquals(1, constraintViolations.size());
		assertEquals("Última modificação não pode ser vazia", constraintViolations.iterator().next().getMessage());
	}
	
	@Test
	public void deve_retornar_verdadeiro_na_comparacao_do_hashcode_de_dois_objetos_iguais() {
		Auditoria outraAuditoria = this.auditoria;
		assertEquals(this.auditoria.hashCode(), outraAuditoria.hashCode());
	}

	@Test
	public void deve_retornar_falso_na_comparacao_do_hashcode_de_dois_objetos_diferentes() {
		Auditoria outraAuditoria = from(Auditoria.class).gimme("valid");
		assertFalse(this.auditoria.hashCode() == outraAuditoria.hashCode());
	}

	@Test
	public void deve_retornar_verdadeiro_quando_comparado_dois_objetos_iguais_atraves_do_equals() {
		Auditoria outraAuditoria = this.auditoria;
		assertTrue(this.auditoria.equals(outraAuditoria));
	}

	@Test
	public void deve_retornar_falso_quando_comparado_dois_objetos_diferentes_da_mesma_classe_atraves_do_equals() {
		Auditoria outraAuditoria = from(Auditoria.class).gimme("valid");
		assertFalse(this.auditoria.equals(outraAuditoria));
	}

	@Test
	public void deve_retornar_falso_quando_comparado_auditoria_a_um_objeto_nulo_atraves_do_equals() {
		Auditoria outraAuditoria = null;
		assertFalse(this.auditoria.equals(outraAuditoria));
	}

	@Test
	public void deve_retornar_falso_quando_comparado_dois_objetos_de_classes_diferentes_atraves_do_equals() {
		assertFalse(this.auditoria.equals(new Object()));
	}

	@Test
	public void deve_retornar_falso_quando_comparado_auditoria_a_nulo_atraves_do_equals() {
		assertFalse(this.auditoria.equals(null));
	}

	@Test
	public void deve_retornar_verdadeiro_quando_comparado_um_objeto_a_ele_mesmo_atraves_do_equals() {
		assertTrue(this.auditoria.equals(this.auditoria));
	}

}
