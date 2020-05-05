package br.com.contmatic.model.telefone;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.either;
import static org.hamcrest.CoreMatchers.is;
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

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.loader.FixtureFactoryLoader;

/**
 * The Class TelefoneTest.
 */
public class TelefoneTest {

    /** The telefone. */
    private Telefone telefone;

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
        System.out.println("Finalizados os teste da classe Telefone");
    }

    /**
     * Set up.
     */
    @Before
    public void setUp() {
        telefone = Fixture.from(Telefone.class).gimme("valid");
    }

    /**
     * Tear down.
     */
    @After
    public void tearDown() {
        telefone = null;
    }

    /**
     * Deve retornar verdadeiro para um numero nao nulo.
     */
    @Test
    public void deve_retornar_verdadeiro_para_um_numero_nao_nulo() {
        assertNotNull(telefone.getNumero());
    }

    /**
     * Deve retornar verdadeiro para um ddd nao nulo.
     */
    @Test
    public void deve_retornar_verdadeiro_para_um_ddd_nao_nulo() {
        assertNotNull(telefone.getDdd());
    }

    /**
     * Deve retornar verdadeiro para um tipo nao nulo.
     */
    @Test
    public void deve_retornar_verdadeiro_para_um_tipo_nao_nulo() {
        assertNotNull(telefone.getTipo());
    }

    /**
     * Deve retornar verdadeiro na comparacao do get com numero igual do enviado no set.
     */
    @Test
    public void deve_retornar_verdadeiro_na_comparacao_do_get_com_numero_igual_do_enviado_no_set() {
        assertThat(telefone.getNumero(), either(containsString("947268218")).or(containsString("24874321")).or(containsString("974524542")));
    }

    /**
     * Deve retornar verdadeiro na comparacao do get com a regiao do ddd igual do enviado no set.
     */
    @Test
    public void deve_retornar_verdadeiro_na_comparacao_do_get_com_a_regiao_do_ddd_igual_do_enviado_no_set() {
        DDD ddd = DDD.DDD11;
        telefone.setDdd(ddd);
        assertThat(telefone.getDdd().getRegiao(), is("Região Metropolitana de São Paulo"));
    }

    /**
     * Deve retornar verdadeiro na comparacao do get com ddd igual do enviado no set.
     */
    @Test
    public void deve_retornar_verdadeiro_na_comparacao_do_get_com_ddd_igual_do_enviado_no_set() {
        assertFalse(telefone.getDdd().getDdd() == 10);
    }

    /**
     * Deve retornar verdadeiro na comparacao do get com a tipo igual do enviado no set.
     */
    @Test
    public void deve_retornar_verdadeiro_na_comparacao_do_get_com_a_tipo_igual_do_enviado_no_set() {
        assertThat(telefone.getTipo().getDescricao(), either(containsString("celular")).or(containsString("fixo")));
    }

    /**
     * Deve retornar verdadeiro na comparacao do get com tamanho do tipo igual do enviado no set.
     */
    @Test
    public void deve_retornar_verdadeiro_na_comparacao_do_get_com_tamanho_do_tipo_igual_do_enviado_no_set() {
        assertTrue(telefone.getTipo().getTamanho() == 9 || telefone.getTipo().getTamanho() == 8);
    }

    /**
     * Deve retornar falso na comparacao de dois hascodes diferentes.
     */
    @Test
    public void deve_retornar_falso_na_comparacao_de_dois_hascodes_diferentes() {
        Telefone outroTelefone = Fixture.from(Telefone.class).gimme("valid");
        telefone.setTipo(TipoTelefone.CELULAR);
        telefone.setNumero("947821648");
        assertFalse(telefone.hashCode() == outroTelefone.hashCode());
    }

    /**
     * Deve retornar verdadeiro na comparacao de dois hascodes iguais.
     */
    @Test
    public void deve_retornar_verdadeiro_na_comparacao_de_dois_hascodes_iguais() {
        Telefone outroTelefone = telefone;
        assertEquals(telefone.hashCode(), outroTelefone.hashCode());
    }

    /**
     * Deve retornar verdadeiro na comparacao de dois telefones iguais com equals.
     */
    @Test
    public void deve_retornar_verdadeiro_na_comparacao_de_dois_telefones_iguais_com_equals() {
        Telefone outroTelefone = telefone;
        assertTrue(telefone.equals(outroTelefone));
    }

    /**
     * Deve retornar falso na comparacao de dois telefones diferentes com equals.
     */
    @Test
    public void deve_retornar_falso_na_comparacao_de_dois_telefones_diferentes_com_equals() {
        Telefone outroTelefone = Fixture.from(Telefone.class).gimme("valid");
        telefone.setTipo(TipoTelefone.CELULAR);
        telefone.setNumero("999964434");
        assertFalse(telefone.equals(outroTelefone));
    }

    /**
     * Deve retornar falso na comparacao de um telefone com null usando o equals.
     */
    @Test
    public void deve_retornar_falso_na_comparacao_de_um_telefone_com_null_usando_o_equals_() {
        assertFalse(telefone.equals(null));
    }

    /**
     * Deve retornar falso na comparacao de um telefone com outro obejto usando equals.
     */
    @Test
    public void deve_retornar_falso_na_comparacao_de_um_telefone_com_outro_obejto_usando_equals() {
        assertFalse(telefone.equals(new Object()));
    }

    /**
     * Deve retornar verdadeiro se no to string contem o numero.
     */
    @Test
    public void deve_retornar_verdadeiro_se_no_toString_contem_o_numero() {
        assertThat(telefone.toString(), containsString("numero"));
    }

    /**
     * Deve retornar verdadeiro se no to string contem o ddd.
     */
    @Test
    public void deve_retornar_verdadeiro_se_no_toString_contem_o_ddd() {
        assertThat(telefone.toString(), containsString("ddd"));
    }

    /**
     * Deve retornar verdadeiro se no to string contem o tipo.
     */
    @Test
    public void deve_retornar_verdadeiro_se_no_toString_contem_o_tipo() {
        assertThat(telefone.toString(), containsString("tipo"));
    }

    /**
     * Deve retornar verdadeiro quando todos os campos de telefone sao validos.
     */
    @Test
    public void deve_retornar_verdadeiro_quando_todos_os_campos_de_telefone_sao_validos() {
        Set<ConstraintViolation<Telefone>> constraintViolations = validator.validate(telefone);
        assertEquals(0, constraintViolations.size());
    }

    /**
     * Deve retornar verdadeiro na captura de erro quando o numero de telefone e nulo.
     */
    @Test
    public void deve_retornar_verdadeiro_na_captura_de_erro_quando_o_numero_de_telefone_e_nulo() {
        telefone.setNumero(null);
        Set<ConstraintViolation<Telefone>> constraintViolations = validator.validate(telefone);
        assertEquals(1, constraintViolations.size());
        assertEquals("Número não pode estar vazio", constraintViolations.iterator().next().getMessage());
    }

    /**
     * Deve retornar verdadeiro na captura de erro quando o numero tiver letra ou caractere especial.
     */
    @Test
    public void deve_retornar_verdadeiro_na_captura_de_erro_quando_o_numero_tiver_letra_ou_caractere_especial() {
        telefone.setNumero("abcDVG:(:)");
        Set<ConstraintViolation<Telefone>> constraintViolations = validator.validate(telefone);
        assertEquals(1, constraintViolations.size());
    }

}
