package br.com.contmatic.model.endereco;

import static br.com.six2six.fixturefactory.Fixture.from;
import static br.com.six2six.fixturefactory.loader.FixtureFactoryLoader.loadTemplates;
import static javax.validation.Validation.buildDefaultValidatorFactory;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.either;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.apache.commons.lang.RandomStringUtils;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * The Class CidadeTest.
 */
public class CidadeTest {

	/** The cidade. */
	private Cidade cidade;

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
		System.out.println("Fim dos teste para a classe Cidade");
	}

	/**
	 * Sets the up.
	 *
	 * @throws Exception the exception
	 */
	@Before
	public void setUp() throws Exception {
		this.cidade = from(Cidade.class).gimme("valid");
	}

	/**
	 * Tear down.
	 *
	 * @throws Exception the exception
	 */
	@After
	public void tearDown() throws Exception {
		this.cidade = null;
	}

	/**
	 * Should return true to not null.
	 */
	@Test
	public void should_return_true_to_not_null() {
		assertNotNull(this.cidade.getNome());
		assertNotNull(this.cidade.getEstado());
	}

	/**
	 * Should return true to correct input.
	 */
	@Test
	public void should_return_true_to_correct_input() {
		assertThat(this.cidade.getNome(),
				either(containsString("São Paulo")).or(containsString("Campinas")).or(containsString("Bertioga")));
	}

	/**
	 * Should return true to the same hashcode class cidade.
	 */
	@Test
	public void should_return_true_to_the_same_hashcode_class_Cidade() {
		Cidade outroCidade = this.cidade;
		assertEquals(this.cidade.hashCode(), outroCidade.hashCode());
	}

	/**
	 * Should return false to differents hashcode class cidade.
	 */
	@Test
	public void should_return_false_to_differents_hashcode_class_Cidade() {
		Cidade outroCidade = new Cidade(this.cidade.getNome(), this.cidade.getEstado());
		assertFalse(this.cidade.hashCode() == outroCidade.hashCode());
	}

	/**
	 * Deve retornar verdadeiro quando comparado dois objetos iguais atraves do equals.
	 */
	@Test
	public void deve_retornar_verdadeiro_quando_comparado_dois_objetos_iguais_atraves_do_equals() {
		Cidade outroCidade = this.cidade;
		assertTrue(this.cidade.equals(outroCidade));
	}

	/**
	 * Should return false to equals with differents cidade.
	 */
	@Test
	public void should_return_false_to_equals_with_differents_Cidade() {
		Cidade outroCidade = from(Cidade.class).gimme("valid");
		assertFalse(this.cidade.equals(outroCidade));
	}

	/**
	 * Should return false when equals compare with a null class.
	 */
	@Test
	public void should_return_false_when_equals_compare_with_a_null_class() {
		Cidade outroCidade = null;
		assertFalse(this.cidade.equals(outroCidade));
	}

	/**
	 * Should return false when equals compare class with other object.
	 */
	@Test
	public void should_return_false_when_equals_compare_class_with_other_object() {
		assertFalse(this.cidade.equals(new Object()));
	}

	/**
	 * Should return false when equals compare class with a pais with different nome.
	 */
	@Test
	public void should_return_false_when_equals_compare_class_with_a_pais_with_different_nome() {
		Cidade outroCidade = from(Cidade.class).gimme("valid");
		assertFalse(this.cidade.equals(outroCidade));
	}

	/**
	 * Should return true when equals compare class with same object.
	 */
	@Test
	public void should_return_true_when_equals_compare_class_with_same_object() {
		assertTrue(this.cidade.equals(this.cidade));
	}

	/**
	 * Deve retornar verdadeiro quando todos os campos de cidade sao validos.
	 */
	@Test
	public void deve_retornar_verdadeiro_quando_todos_os_campos_de_cidade_sao_validos() {
		Set<ConstraintViolation<Cidade>> constraintViolations = validator.validate(this.cidade);
		assertEquals(0, constraintViolations.size());
	}

	/**
	 * Deve retornar verdadeiro na captura de erro quando nome for vazio.
	 */
	@Test
	public void deve_retornar_verdadeiro_na_captura_de_erro_quando_nome_for_vazio() {
		this.cidade.setNome(null);
		Set<ConstraintViolation<Cidade>> constraintViolations = validator.validate(this.cidade);
		assertEquals(1, constraintViolations.size());
		assertEquals("Nome da cidade não pode ser vazio", constraintViolations.iterator().next().getMessage());
	}

	/**
	 * Deve retornar verdadeiro na captura de erro quando tiver numero no nome.
	 */
	@Test
	public void deve_retornar_verdadeiro_na_captura_de_erro_quando_tiver_numero_no_nome() {
		this.cidade.setNome("9sg1çm85");
		Set<ConstraintViolation<Cidade>> constraintViolations = validator.validate(this.cidade);
		assertEquals(1, constraintViolations.size());
		assertEquals("Caractere inválido no nome da cidade", constraintViolations.iterator().next().getMessage());
	}

	/**
	 * Deve retornar verdadeiro na captura de erro quando nome for maior que o limite.
	 */
	@Test
	public void deve_retornar_verdadeiro_na_captura_de_erro_quando_nome_for_maior_que_o_limite() {
		this.cidade.setNome(RandomStringUtils.randomAlphabetic(81));
		Set<ConstraintViolation<Cidade>> constraintViolations = validator.validate(this.cidade);
		assertEquals(1, constraintViolations.size());
		assertEquals("Nome da cidade deve ter no máximo 80 caracteres", constraintViolations.iterator().next().getMessage());
	}
	
	/**
	 * Deve retornar verdadeiro na captura de erro quando estado for vazio.
	 */
	@Test
	public void deve_retornar_verdadeiro_na_captura_de_erro_quando_estado_for_vazio() {
		this.cidade.setEstado(null);
		Set<ConstraintViolation<Cidade>> constraintViolations = validator.validate(cidade);
		assertEquals(1, constraintViolations.size());
		assertEquals("Estado da cidade não pode ser vazio", constraintViolations.iterator().next().getMessage());
	}

}
