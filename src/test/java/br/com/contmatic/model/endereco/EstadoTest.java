package br.com.contmatic.model.endereco;

import static br.com.six2six.fixturefactory.Fixture.from;
import static br.com.six2six.fixturefactory.loader.FixtureFactoryLoader.loadTemplates;
import static javax.validation.Validation.buildDefaultValidatorFactory;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
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
 * The Class EstadoTest.
 */
public class EstadoTest {

	/** The estado. */
	private Estado estado;
	
	/** The validator. */
	private static Validator validator;

	/**
	 * Sets the up before class.
	 *
	 * @throws Exception the exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		loadTemplates("br.com.contmatic.model.template");
		ValidatorFactory factory = buildDefaultValidatorFactory();
		validator = factory.getValidator();
	}

	/**
	 * Tear down after class.
	 *
	 * @throws Exception the exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("Fim dos teste para a classe Estado");
	}

	/**
	 * Sets the up.
	 *
	 * @throws Exception the exception
	 */
	@Before
	public void setUp() throws Exception {
		this.estado = from(Estado.class).gimme("valid");
	}

	/**
	 * Tear down.
	 *
	 * @throws Exception the exception
	 */
	@After
	public void tearDown() throws Exception {
		this.estado = null;
	}

	/**
	 * Should return true to not null.
	 */
	@Test
	public void should_return_true_to_not_null() {
		assertNotNull(this.estado.getNome());
		assertNotNull(this.estado.getPais());
		assertNotNull(this.estado.getCidades());
	}

	/**
	 * Should return true to the same hashcode class cidade.
	 */
	@Test
	public void should_return_true_to_the_same_hashcode_class_Cidade() {
		Estado outroEstado = from(Estado.class).gimme("valid");
		outroEstado.setCidades(this.estado.getCidades());
		assertEquals(this.estado.hashCode(), outroEstado.hashCode());
	}

	/**
	 * Should return false to differents hashcode class cidade.
	 */
	@Test
	public void should_return_false_to_differents_hashcode_class_Cidade() {
		Estado outroEstado = from(Estado.class).gimme("valid");
		assertFalse(this.estado.hashCode() == outroEstado.hashCode());
	}

	/**
	 * Deve retornar verdadeiro quando comparado dois objetos iguais atraves do equals.
	 */
	@Test
	public void deve_retornar_verdadeiro_quando_comparado_dois_objetos_iguais_atraves_do_equals() {
		Estado outroEstado = new Estado(this.estado.getNome(), this.estado.getPais());
		outroEstado.setCidades(this.estado.getCidades());
		assertTrue(this.estado.equals(outroEstado));
	}

	/**
	 * Should return false to equals with differents cidade.
	 */
	@Test
	public void should_return_false_to_equals_with_differents_Cidade() {
		Estado outroEstado = from(Estado.class).gimme("valid");
		assertFalse(this.estado.equals(outroEstado));
	}

	/**
	 * Should return false when equals compare with a null class.
	 */
	@Test
	public void should_return_false_when_equals_compare_with_a_null_class() {
		Estado outroEstado = null;
		assertFalse(this.estado.equals(outroEstado));
	}

	/**
	 * Should return false when equals compare class with other object.
	 */
	@Test
	public void should_return_false_when_equals_compare_class_with_other_object() {
		assertFalse(this.estado.equals(new Object()));
	}

	/**
	 * Should return true when equals compare class with same object.
	 */
	@Test
	public void should_return_true_when_equals_compare_class_with_same_object() {
		assertTrue(this.estado.equals(this.estado));
	}

	/**
	 * Deve retornar verdadeiro quando todos os campos de estado sao validos.
	 */
	@Test
	public void deve_retornar_verdadeiro_quando_todos_os_campos_de_estado_sao_validos() {
		Set<ConstraintViolation<Estado>> constraintViolations = validator.validate(this.estado);
		assertEquals(0, constraintViolations.size());
	}
	
	/**
	 * Deve retornar verdadeiro na captura de erro quando nome for vazio.
	 */
	@Test
	public void deve_retornar_verdadeiro_na_captura_de_erro_quando_nome_for_vazio() {
		this.estado.setNome(null);
		Set<ConstraintViolation<Estado>> constraintViolations = validator.validate(this.estado);
		assertEquals(1, constraintViolations.size());
		assertEquals("Nome do estado não pode ser vazio", constraintViolations.iterator().next().getMessage());
	}

	/**
	 * Deve retornar verdadeiro na captura de erro quando pais for vazio.
	 */
	@Test
	public void deve_retornar_verdadeiro_na_captura_de_erro_quando_pais_for_vazio() {
		this.estado.setPais(null);
		Set<ConstraintViolation<Estado>> constraintViolations = validator.validate(this.estado);
		assertEquals(1, constraintViolations.size());
		assertEquals("País do estado não pode ser vazio", constraintViolations.iterator().next().getMessage());
	}
	
	/**
	 * Deve retornar verdadeiro na captura de erro quando cidade for uma lista vazio.
	 */
	@Test
	public void deve_retornar_verdadeiro_na_captura_de_erro_quando_cidade_for_uma_lista_vazio() {
		this.estado.setCidades(new ArrayList<>());
		Set<ConstraintViolation<Estado>> constraintViolations = validator.validate(this.estado);
		assertEquals(1, constraintViolations.size());
		assertEquals("Estado deve possuir no minímo 1 cidade", constraintViolations.iterator().next().getMessage());
	}
}
