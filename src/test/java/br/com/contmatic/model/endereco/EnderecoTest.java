package br.com.contmatic.model.endereco;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.either;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import br.com.contmatic.model.endereco.Endereco;
import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.loader.FixtureFactoryLoader;

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
        FixtureFactoryLoader.loadTemplates("br.com.contmatic.model.template");
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
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
        endereco = Fixture.from(Endereco.class).gimme("valid");
    }

    /**
     * Tear down.
     */
    @After
    public void tearDown() {
        endereco = null;
    }

    /**
     * Deve retornar verdadeiro para um rua nao nulo.
     */
    @Test
    public void deve_retornar_verdadeiro_para_um_rua_nao_nulo() {
        assertNotNull(endereco.getRua());
    }

    /**
     * Deve retornar verdadeiro para um numero nao nulo.
     */
    @Test
    public void deve_retornar_verdadeiro_para_um_numero_nao_nulo() {
        assertNotNull(endereco.getNumero());
    }

    /**
     * Deve retornar verdadeiro para um bairro nao nulo.
     */
    @Test
    public void deve_retornar_verdadeiro_para_um_bairro_nao_nulo() {
        assertNotNull(endereco.getBairro());
    }

    /**
     * Deve retornar verdadeiro para um cep nao nulo.
     */
    @Test
    public void deve_retornar_verdadeiro_para_um_cep_nao_nulo() {
        assertNotNull(endereco.getCep());
    }

    /**
     * Deve retornar verdadeiro para um complemento nao nulo.
     */
    @Test
    public void deve_retornar_verdadeiro_para_um_complemento_nao_nulo() {
        assertNotNull(endereco.getComplemento());
    }

    /**
     * Deve retornar verdadeiro para um estado nao nulo.
     */
    @Test
    public void deve_retornar_verdadeiro_para_um_estado_nao_nulo() {
        assertNotNull(endereco.getEstado());
    }

    /**
     * Deve retornar verdadeiro na comparacao do get com rua igual do enviado no set.
     */
    @Test
    public void deve_retornar_verdadeiro_na_comparacao_do_get_com_rua_igual_do_enviado_no_set() {
        assertThat(endereco.getRua(), either(containsString("Avenida 01")).or(containsString("Rua 02")).or(containsString("Rua 03")));
    }

    /**
     * Deve retornar falso na comparacao do get com rua diferente do enviado no set.
     */
    @Test
    public void deve_retornar_falso_na_comparacao_do_get_com_rua_diferente_do_enviado_no_set() {
        assertThat(endereco.getRua(), not("Rua um"));
    }

    /**
     * Deve retornar verdadeiro na comparacao do get com numero igual do enviado no set.
     */
    @Test
    public void deve_retornar_verdadeiro_na_comparacao_do_get_com_numero_igual_do_enviado_no_set() {
        int numero = endereco.getNumero();
        assertThat(endereco.getNumero(), is(numero));
    }

    /**
     * Deve retornar falso na comparacao do get com numero diferente do enviado no set.
     */
    @Test
    public void deve_retornar_falso_na_comparacao_do_get_com_numero_diferente_do_enviado_no_set() {
        assertThat(endereco.getNumero(), not(2));
    }

    /**
     * Deve retornar verdadeiro na comparacao do get com bairro igual do enviado no set.
     */
    @Test
    public void deve_retornar_verdadeiro_na_comparacao_do_get_com_bairro_igual_do_enviado_no_set() {
        assertThat(endereco.getBairro(), either(containsString("Itaquera")).or(containsString("Tatuapé")).or(containsString("Moema")));
    }

    /**
     * Deve retornar falso na comparacao do get com bairro diferente do enviado no set.
     */
    @Test
    public void deve_retornar_falso_na_comparacao_do_get_com_bairro_diferente_do_enviado_no_set() {
        assertThat(endereco.getBairro(), not("Brás"));
    }

    /**
     * Deve retornar verdadeiro na comparacao do get com cep igual do enviado no set.
     */
    @Test
    public void deve_retornar_verdadeiro_na_comparacao_do_get_com_cep_igual_do_enviado_no_set() {
        assertThat(endereco.getCep(), either(containsString("01234-567")).or(containsString("98765-412")).or(containsString("78945-816")));
    }

    /**
     * Deve retornar falso na comparacao do get com cep diferente do enviado no set.
     */
    @Test
    public void deve_retornar_falso_na_comparacao_do_get_com_cep_diferente_do_enviado_no_set() {
        assertThat(endereco.getCep(), not("43210-765"));
    }

    /**
     * Deve retornar verdadeiro na comparacao do get com complemento igual do enviado no set.
     */
    @Test
    public void deve_retornar_verdadeiro_na_comparacao_do_get_com_complemento_igual_do_enviado_no_set() {
        assertThat(endereco.getComplemento(), either(containsString("Apt 01")).or(containsString("Não possui")));
    }

    /**
     * Deve retornar falso na comparacao do get com complemente diferente do enviado no set.
     */
    @Test
    public void deve_retornar_falso_na_comparacao_do_get_com_complemente_diferente_do_enviado_no_set() {
        assertThat(endereco.getComplemento(), not("Apt 08"));
    }

    /**
     * Deve retornar verdadeiro na comparacao do get com estado igual do enviado no set.
     */
    @Test
    public void deve_retornar_verdadeiro_na_comparacao_do_get_com_estado_igual_do_enviado_no_set() {
        endereco.setEstado(Estado.SP);
        assertThat(endereco.getEstado().getNome(), is("São Paulo"));
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
     * Deve retornar verdadeiro quando comparado dois objetos iguais atraves do equals.
     */
    @Test
    public void deve_retornar_verdadeiro_quando_comparado_dois_objetos_iguais_atraves_do_equals() {
        Endereco outroEndereco = endereco;
        assertTrue(endereco.equals(outroEndereco));
    }

    /**
     * Deve retornar falso quando comparado dois objetos diferentes da mesma classe atraves do equals.
     */
    @Test
    public void deve_retornar_falso_quando_comparado_dois_objetos_diferentes_da_mesma_classe_atraves_do_equals() {
        Endereco outroEndereco = new Endereco("123");
        assertFalse(endereco.equals(outroEndereco));
    }

    /**
     * Deve retornar falso quando comparado endereco a um objeto nulo atraves do equals.
     */
    @Test
    public void deve_retornar_falso_quando_comparado_endereco_a_um_objeto_nulo_atraves_do_equals() {
        Endereco outroEndereco = null;
        assertFalse(endereco.equals(outroEndereco));
    }

    /**
     * Deve retornar falso quando comparado dois objetos de classes diferentes atraves do equals.
     */
    @Test
    public void deve_retornar_falso_quando_comparado_dois_objetos_de_classes_diferentes_atraves_do_equals() {
        assertFalse(endereco.equals(new Object()));
    }

    /**
     * Deve retornar falso quando comparado endereco a nulo atraves do equals.
     */
    @Test
    public void deve_retornar_falso_quando_comparado_endereco_a_nulo_atraves_do_equals() {
        assertFalse(endereco.equals(null));
    }

    /**
     * Deve retornar verdadeiro quando comparado um objeto a ele mesmo atraves do equals.
     */
    @Test
    public void deve_retornar_verdadeiro_quando_comparado_um_objeto_a_ele_mesmo_atraves_do_equals() {
        assertTrue(endereco.equals(endereco));
    }

    /**
     * Deve retornar verdadeiro se no to string contem rua.
     */
    @Test
    public void deve_retornar_verdadeiro_se_no_toString_contem_rua() {
        assertThat(endereco.toString(), containsString("rua"));
    }

    /**
     * Deve retornar verdadeiro se no to string contem numero.
     */
    @Test
    public void deve_retornar_verdadeiro_se_no_toString_contem_numero() {
        assertThat(endereco.toString(), containsString("1"));
    }

    /**
     * Deve retornar verdadeiro se no to string contem bairro.
     */
    @Test
    public void deve_retornar_verdadeiro_se_no_toString_contem_bairro() {
        assertThat(endereco.toString(), containsString("bairro"));
    }

    /**
     * Deve retornar verdadeiro se no to string contem cep.
     */
    @Test
    public void deve_retornar_verdadeiro_se_no_toString_contem_cep() {
        assertThat(endereco.toString(), containsString("cep"));
    }

    /**
     * Deve retornar verdadeiro se no to string contem complemento.
     */
    @Test
    public void deve_retornar_verdadeiro_se_no_toString_contem_complemento() {
        assertThat(endereco.toString(), containsString("complemento"));
    }

    /**
     * Deve retornar verdadeiro na captura de erro quando rua for vazia.
     */
    @Test
    public void deve_retornar_verdadeiro_na_captura_de_erro_quando_rua_for_vazia() {
        endereco.setRua(null);
        Set<ConstraintViolation<Endereco>> constraintViolations = validator.validate(endereco);
        assertEquals(1, constraintViolations.size());
    }

    /**
     * Deve retornar verdadeiro na captura de erro quando rua tiver caractere especial.
     */
    @Test
    public void deve_retornar_verdadeiro_na_captura_de_erro_quando_rua_tiver_caractere_especial() {
        endereco.setRua("!@#$%¨&*()");
        Set<ConstraintViolation<Endereco>> constraintViolations = validator.validate(endereco);
        assertEquals(1, constraintViolations.size());
        assertEquals("Caractere invalido", constraintViolations.iterator().next().getMessage());
    }

    /**
     * Deve retornar verdadeiro na captura de erro quando numero for maior que o permitido.
     */
    @Test
    public void deve_retornar_verdadeiro_na_captura_de_erro_quando_numero_for_maior_que_o_permitido() {
        endereco.setNumero(10000);
        Set<ConstraintViolation<Endereco>> constraintViolations = validator.validate(endereco);
        assertEquals(1, constraintViolations.size());
    }

    /**
     * Deve retornar verdadeiro na captura de erro quando bairro for nulo.
     */
    @Test
    public void deve_retornar_verdadeiro_na_captura_de_erro_quando_bairro_for_nulo() {
        endereco.setBairro(null);
        Set<ConstraintViolation<Endereco>> constraintViolations = validator.validate(endereco);
        assertEquals(1, constraintViolations.size());
    }

    /**
     * Deve retornar verdadeiro na captura de erro quando for inserido numero no bairro.
     */
    @Test
    public void deve_retornar_verdadeiro_na_captura_de_erro_quando_for_inserido_numero_no_bairro() {
        endereco.setBairro("15684!@#$");
        Set<ConstraintViolation<Endereco>> constraintViolations = validator.validate(endereco);
        assertEquals(1, constraintViolations.size());
        assertEquals("Caractere invalido", constraintViolations.iterator().next().getMessage());
    }

    /**
     * Deve retornar verdadeiro na captura de erro quando bairro tiver mais de 40 caracteres.
     */
    @Test
    public void deve_retornar_verdadeiro_na_captura_de_erro_quando_bairro_tiver_mais_de_40_caracteres() {
        endereco.setBairro("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
        Set<ConstraintViolation<Endereco>> constraintViolations = validator.validate(endereco);
        assertEquals(1, constraintViolations.size());
    }

    /**
     * Deve retornar verdadeiro na captura de erro quando cep for nulo.
     */
    @Test
    public void deve_retornar_verdadeiro_na_captura_de_erro_quando_cep_for_nulo() {
        endereco.setCep(null);
        Set<ConstraintViolation<Endereco>> constraintViolations = validator.validate(endereco);
        assertEquals(1, constraintViolations.size());
    }

    /**
     * Deve retornar verdadeiro na captura de erro quando for inserido letra no cep.
     */
    @Test
    public void deve_retornar_verdadeiro_na_captura_de_erro_quando_for_inserido_letra_no_cep() {
        endereco.setCep("AbCdEf!@#$");
        Set<ConstraintViolation<Endereco>> constraintViolations = validator.validate(endereco);
        assertEquals(1, constraintViolations.size());
        assertEquals("Caractere invalido", constraintViolations.iterator().next().getMessage());
    }

    /**
     * Deve retornar verdadeiro na captura de erro quando for inserido caractere especial no complemento.
     */
    @Test
    public void deve_retornar_verdadeiro_na_captura_de_erro_quando_for_inserido_caractere_especial_no_complemento() {
        endereco.setComplemento("*_*-_-:):(:$;):*(");
        Set<ConstraintViolation<Endereco>> constraintViolations = validator.validate(endereco);
        assertEquals(1, constraintViolations.size());
        assertEquals("Caractere invalido", constraintViolations.iterator().next().getMessage());
    }

    /**
     * Deve retornar verdadeiro na captura de erro quando o complemento for maior que o tamanho maximo.
     */
    @Test
    public void deve_retornar_verdadeiro_na_captura_de_erro_quando_o_complemento_for_maior_que_o_tamanho_maximo() {
        endereco.setComplemento("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
        Set<ConstraintViolation<Endereco>> constraintViolations = validator.validate(endereco);
        assertEquals(1, constraintViolations.size());
    }

}
