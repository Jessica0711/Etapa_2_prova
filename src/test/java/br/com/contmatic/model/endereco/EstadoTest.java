package br.com.contmatic.model.endereco;

import static br.com.six2six.fixturefactory.Fixture.from;
import static br.com.six2six.fixturefactory.loader.FixtureFactoryLoader.loadTemplates;
import static javax.validation.Validation.buildDefaultValidatorFactory;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
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

public class EstadoTest {

	private Estado estado;

	private static Validator validator;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		loadTemplates("br.com.contmatic.model.template");
		ValidatorFactory factory = buildDefaultValidatorFactory();
		validator = factory.getValidator();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("Fim dos teste para a classe Estado");
	}

	@Before
	public void setUp() throws Exception {
		this.estado = from(Estado.class).gimme("valid");
	}

	@After
	public void tearDown() throws Exception {
		this.estado = null;
	}

	@Test
	public void should_return_true_to_not_null() {
		assertNotNull(this.estado.getNome());
		assertNotNull(this.estado.getPais());
	}

	@Test
	public void should_return_true_to_the_same_hashcode_class_estado() {
		Estado outroEstado = this.estado;
		assertEquals(this.estado.hashCode(), outroEstado.hashCode());
	}

	@Test
	public void should_return_false_to_differents_hashcode_class_Cidade() {
		Estado outroEstado = from(Estado.class).gimme("valid");
		assertFalse(this.estado.hashCode() == outroEstado.hashCode());
	}

	@Test
	public void deve_retornar_verdadeiro_quando_comparado_dois_objetos_iguais_atraves_do_equals() {
		Estado outroEstado = this.estado;
		assertTrue(this.estado.equals(outroEstado));
	}

	@Test
	public void should_return_false_to_equals_with_differents_Cidade() {
		Estado outroEstado = from(Estado.class).gimme("valid");
		assertFalse(this.estado.equals(outroEstado));
	}

	@Test
	public void should_return_false_when_equals_compare_with_a_null_class() {
		Estado outroEstado = null;
		assertFalse(this.estado.equals(outroEstado));
	}

	@Test
	public void should_return_false_when_equals_compare_class_with_other_object() {
		assertFalse(this.estado.equals(new Object()));
	}

	@Test
	public void should_return_true_when_equals_compare_class_with_same_object() {
		assertTrue(this.estado.equals(this.estado));
	}

	@Test
	public void deve_retornar_verdadeiro_quando_todos_os_campos_de_estado_sao_validos() {
		Set<ConstraintViolation<Estado>> constraintViolations = validator.validate(this.estado);
		assertEquals(0, constraintViolations.size());
	}

	@Test
	public void deve_retornar_verdadeiro_na_captura_de_erro_quando_nome_for_vazio() {
		this.estado.setNome(null);
		Set<ConstraintViolation<Estado>> constraintViolations = validator.validate(this.estado);
		assertEquals(1, constraintViolations.size());
		assertEquals("Nome do estado não pode ser vazio", constraintViolations.iterator().next().getMessage());
	}

	@Test
	public void deve_retornar_verdadeiro_na_captura_de_erro_quando_pais_for_vazio() {
		this.estado.setPais(null);
		Set<ConstraintViolation<Estado>> constraintViolations = validator.validate(this.estado);
		assertEquals(1, constraintViolations.size());
		assertEquals("País do estado não pode ser vazio", constraintViolations.iterator().next().getMessage());
	}

}
