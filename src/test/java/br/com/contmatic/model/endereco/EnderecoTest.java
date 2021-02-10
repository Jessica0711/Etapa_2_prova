package br.com.contmatic.model.endereco;

import static br.com.six2six.fixturefactory.Fixture.from;
import static br.com.six2six.fixturefactory.loader.FixtureFactoryLoader.loadTemplates;
import static javax.validation.Validation.buildDefaultValidatorFactory;
import static org.apache.commons.lang.RandomStringUtils.randomAlphabetic;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
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

import br.com.six2six.fixturefactory.Fixture;

/**
 * The Class EnderecoTest.
 */
public class EnderecoTest {

	/** The endereco. */
	private Endereco endereco;

	/** The validator. */
	private static Validator validator;

	/**
	 * Set up before class.
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
		System.out.println("Fim dos teste para a classe Endereco");
	}

	/**
	 * Set up.
	 */
	@Before
	public void setUp() {
		endereco = from(Endereco.class).gimme("valid");
	}

	/**
	 * Tear down.
	 */
	@After
	public void tearDown() {
		endereco = null;
	}

	/**
	 * Deve retornar verdadeiro para um endereco nao nulo.
	 */
	@Test
	public void should_return_true_to_not_null() {
		assertNotNull(endereco.getRua());
		assertNotNull(endereco.getNumero());
		assertNotNull(endereco.getBairro());
		assertNotNull(endereco.getCep());
		assertNotNull(endereco.getComplemento());
		assertNotNull(endereco.getCidade());
		assertNotNull(endereco.getDataAlteracao());
		assertNotNull(endereco.getDataCadastro());
		assertNotNull(endereco.getCriadoPor());
		assertNotNull(endereco.getUltimaModificacao());
		assertNotNull(endereco.getIpCriadoPor());
		assertNotNull(endereco.getIpUltimaModificacao());
	}

	/**
	 * Deve retornar verdadeiro na comparacao do hashcode de dois objetos iguais.
	 */
	@Test
	public void deve_retornar_verdadeiro_na_comparacao_do_hashcode_de_dois_objetos_iguais() {
		Endereco outroEndereco = endereco;
		assertEquals(endereco.hashCode(), outroEndereco.hashCode());
	}

	/**
	 * Deve retornar falso na comparacao do hashcode de dois objetos diferentes.
	 */
	@Test
	public void deve_retornar_falso_na_comparacao_do_hashcode_de_dois_objetos_diferentes() {
		Endereco outroEndereco = Fixture.from(Endereco.class).gimme("valid");
		outroEndereco.setNumero(12);
		assertFalse(endereco.hashCode() == outroEndereco.hashCode());
	}

	/**
	 * Deve retornar verdadeiro quando comparado dois objetos iguais atraves do
	 * equals.
	 */
	@Test
	public void deve_retornar_verdadeiro_quando_comparado_dois_objetos_iguais_atraves_do_equals() {
		Endereco outroEndereco = endereco;
		assertTrue(endereco.equals(outroEndereco));
	}

	/**
	 * Deve retornar falso quando comparado dois objetos diferentes da mesma classe
	 * atraves do equals.
	 */
	@Test
	public void deve_retornar_falso_quando_comparado_dois_objetos_diferentes_da_mesma_classe_atraves_do_equals() {
		Endereco outroEndereco = new Endereco("123");
		assertFalse(endereco.equals(outroEndereco));
	}

	/**
	 * Deve retornar falso quando comparado endereço a um objeto nulo atraves do
	 * equals.
	 */
	@Test
	public void deve_retornar_falso_quando_comparado_endereco_a_um_objeto_nulo_atraves_do_equals() {
		Endereco outroEndereco = null;
		assertFalse(endereco.equals(outroEndereco));
	}

	/**
	 * Deve retornar falso quando comparado dois objetos de classes diferentes
	 * atraves do equals.
	 */
	@Test
	public void deve_retornar_falso_quando_comparado_dois_objetos_de_classes_diferentes_atraves_do_equals() {
		assertFalse(endereco.equals(new Object()));
	}

	/**
	 * Deve retornar falso quando comparado endereço a nulo atraves do equals.
	 */
	@Test
	public void deve_retornar_falso_quando_comparado_endereco_a_nulo_atraves_do_equals() {
		assertFalse(endereco.equals(null));
	}

	/**
	 * Deve retornar verdadeiro quando comparado um objeto a ele mesmo atraves do
	 * equals.
	 */
	@Test
	public void deve_retornar_verdadeiro_quando_comparado_um_objeto_a_ele_mesmo_atraves_do_equals() {
		assertTrue(endereco.equals(endereco));
	}

	/**
	 * Deve retornar verdadeiro na captura de erro quando rua for vazia.
	 */
	@Test
	public void deve_retornar_verdadeiro_na_captura_de_erro_quando_rua_for_vazia() {
		endereco.setRua(null);
		Set<ConstraintViolation<Endereco>> constraintViolations = validator.validate(endereco);
		assertEquals(1, constraintViolations.size());
		assertEquals("Rua do endereço deve ser preenchida", constraintViolations.iterator().next().getMessage());
	}

	/**
	 * Deve retornar verdadeiro na captura de erro quando rua tiver caractere
	 * especial.
	 */
	@Test
	public void deve_retornar_verdadeiro_na_captura_de_erro_quando_rua_tiver_caractere_especial() {
		endereco.setRua("!@#$%¨&*()");
		Set<ConstraintViolation<Endereco>> constraintViolations = validator.validate(endereco);
		assertEquals(1, constraintViolations.size());
		assertEquals("Caractere inválido na rua do endereço", constraintViolations.iterator().next().getMessage());
	}

	/**
	 * Deve retornar verdadeiro na captura de erro quando numero for maior que o
	 * permitido.
	 */
	@Test
	public void deve_retornar_verdadeiro_na_captura_de_erro_quando_numero_for_maior_que_o_permitido() {
		endereco.setNumero(10000);
		Set<ConstraintViolation<Endereco>> constraintViolations = validator.validate(endereco);
		assertEquals(1, constraintViolations.size());
		assertEquals("Número do endereço fora do permitido", constraintViolations.iterator().next().getMessage());
	}

	/**
	 * Deve retornar verdadeiro na captura de erro quando bairro for nulo.
	 */
	@Test
	public void deve_retornar_verdadeiro_na_captura_de_erro_quando_bairro_for_nulo() {
		endereco.setBairro(null);
		Set<ConstraintViolation<Endereco>> constraintViolations = validator.validate(endereco);
		assertEquals(1, constraintViolations.size());
		assertEquals("Bairro do endereço deve ser preenchido", constraintViolations.iterator().next().getMessage());
	}

	/**
	 * Deve retornar verdadeiro na captura de erro quando for inserido numero no
	 * bairro.
	 */
	@Test
	public void deve_retornar_verdadeiro_na_captura_de_erro_quando_for_inserido_numero_no_bairro() {
		endereco.setBairro("15684!@#$");
		Set<ConstraintViolation<Endereco>> constraintViolations = validator.validate(endereco);
		assertEquals(1, constraintViolations.size());
		assertEquals("Caractere inválido no bairro do endereço", constraintViolations.iterator().next().getMessage());
	}

	/**
	 * Deve retornar verdadeiro na captura de erro quando bairro tiver mais de 40
	 * caracteres.
	 */
	@Test
	public void deve_retornar_verdadeiro_na_captura_de_erro_quando_bairro_tiver_mais_de_40_caracteres() {
		endereco.setBairro(RandomStringUtils.randomAlphabetic(41));
		Set<ConstraintViolation<Endereco>> constraintViolations = validator.validate(endereco);
		assertEquals(1, constraintViolations.size());
		assertEquals("Bairro do endereço com tamanho fora do permitido", constraintViolations.iterator().next().getMessage());
	}

	/**
	 * Deve retornar verdadeiro na captura de erro quando cep for nulo.
	 */
	@Test
	public void deve_retornar_verdadeiro_na_captura_de_erro_quando_cep_for_nulo() {
		endereco.setCep(null);
		Set<ConstraintViolation<Endereco>> constraintViolations = validator.validate(endereco);
		assertEquals(1, constraintViolations.size());
		assertEquals("CEP do endereço deve ser preenchido", constraintViolations.iterator().next().getMessage());
	}
	
	/**
	 * Deve retornar verdadeiro na captura de erro quando cidade for nulo.
	 */
	@Test
	public void deve_retornar_verdadeiro_na_captura_de_erro_quando_cidade_for_nulo() {
		endereco.setCidade(null);
		Set<ConstraintViolation<Endereco>> constraintViolations = validator.validate(endereco);
		assertEquals(1, constraintViolations.size());
		assertEquals("Cidade do endereço deve ser preenchida", constraintViolations.iterator().next().getMessage());
	}

	/**
	 * Deve retornar verdadeiro na captura de erro quando for inserido letra no cep.
	 */
	@Test
	public void deve_retornar_verdadeiro_na_captura_de_erro_quando_for_inserido_letra_no_cep() {
		endereco.setCep("AbCdEf!@#$");
		Set<ConstraintViolation<Endereco>> constraintViolations = validator.validate(endereco);
		assertEquals(1, constraintViolations.size());
		assertEquals("Caractere inválido no CEP do endereço", constraintViolations.iterator().next().getMessage());
	}

	/**
	 * Deve retornar verdadeiro na captura de erro quando for inserido caractere
	 * especial no complemento.
	 */
	@Test
	public void deve_retornar_verdadeiro_na_captura_de_erro_quando_for_inserido_caractere_especial_no_complemento() {
		endereco.setComplemento("*_*-_-:):(:$;):*(");
		Set<ConstraintViolation<Endereco>> constraintViolations = validator.validate(endereco);
		assertEquals(1, constraintViolations.size());
		assertEquals("Caractere inválido no complemneto do endereço", constraintViolations.iterator().next().getMessage());
	}

	/**
	 * Deve retornar verdadeiro na captura de erro quando o complemento for maior
	 * que o tamanho maximo.
	 */
	@Test
	public void deve_retornar_verdadeiro_na_captura_de_erro_quando_o_complemento_for_maior_que_o_tamanho_maximo() {
		endereco.setComplemento(randomAlphabetic(81));
		Set<ConstraintViolation<Endereco>> constraintViolations = validator.validate(endereco);
		assertEquals(1, constraintViolations.size());
		assertEquals("Complemento do endereço deve ter no máximo 80 caracteres", constraintViolations.iterator().next().getMessage());
	}

}
