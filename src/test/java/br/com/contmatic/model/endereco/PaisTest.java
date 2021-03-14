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

public class PaisTest {

	private Pais pais;
	
	private static Validator validator;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		loadTemplates("br.com.contmatic.model.template");
		ValidatorFactory factory = buildDefaultValidatorFactory();
		validator = factory.getValidator();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("Fim dos teste para a classe Pais");
	}

	@Before
	public void setUp() throws Exception {
		this.pais = from(Pais.class).gimme("valid");
	}

	@After
	public void tearDown() throws Exception {
		this.pais = null;
	}

	@Test
	public void should_return_true_to_not_null() {
		assertNotNull(this.pais.getNome());
	}

	@Test
	public void should_return_true_to_correct_input() {
		assertThat(this.pais.getNome(), either(containsString("Brasil")).or(containsString("México")).or(containsString("Itália")));
	}

	@Test
	public void should_return_true_to_the_same_hashcode_class_Pais() {
		Pais outroPais = this.pais;
		assertEquals(this.pais.hashCode(), outroPais.hashCode());
	}

	@Test
	public void should_return_false_to_differents_hashcode_class_Pais() {
		Pais outroPais = from(Pais.class).gimme("valid");
		assertFalse(this.pais.hashCode() == outroPais.hashCode());
	}

	@Test
	public void should_return_true_to_same_equals_class_Pais() {
		Pais outroPais = this.pais;
		assertTrue(this.pais.equals(outroPais));
	}

	@Test
	public void should_return_false_to_equals_with_differents_Pais() {
		Pais outroPais = from(Pais.class).gimme("valid");
		assertFalse(this.pais.equals(outroPais));
	}

	@Test
	public void should_return_false_when_equals_compare_with_a_null_class() {
		Pais outroPais = null;
		assertFalse(this.pais.equals(outroPais));
	}

	@Test
	public void should_return_false_when_equals_compare_class_with_another_object() {
		assertFalse(this.pais.equals(new Object()));
	}

	@Test
	public void should_return_true_when_equals_compare_class_with_same_object() {
		assertTrue(this.pais.equals(this.pais));
	}
	
	@Test
	public void deve_retornar_verdadeiro_quando_todos_os_campos_de_cidade_sao_validos() {
		Set<ConstraintViolation<Pais>> constraintViolations = validator.validate(this.pais);
		assertEquals(0, constraintViolations.size());
	}

	@Test
	public void deve_retornar_verdadeiro_na_captura_de_erro_quando_nome_for_vazio() {
		this.pais.setNome(null);
		Set<ConstraintViolation<Pais>> constraintViolations = validator.validate(this.pais);
		assertEquals(1, constraintViolations.size());
		assertEquals("Nome do país não pode ser vazio", constraintViolations.iterator().next().getMessage());
	}

	@Test
	public void deve_retornar_verdadeiro_na_captura_de_erro_quando_tiver_numero_no_nome() {
		this.pais.setNome("9sg1çm85");
		Set<ConstraintViolation<Pais>> constraintViolations = validator.validate(this.pais);
		assertEquals(1, constraintViolations.size());
		assertEquals("Caractere inválido no nome do país", constraintViolations.iterator().next().getMessage());
	}

	@Test
	public void deve_retornar_verdadeiro_na_captura_de_erro_quando_nome_for_maior_que_o_limite() {
		this.pais.setNome(RandomStringUtils.randomAlphabetic(81));
		Set<ConstraintViolation<Pais>> constraintViolations = validator.validate(this.pais);
		assertEquals(1, constraintViolations.size());
		assertEquals("Nome do país deve ter no máximo 80 caratceres", constraintViolations.iterator().next().getMessage());
	}

}
