package br.com.contmatic.model.empresa;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.either;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.junit.runners.MethodSorters.NAME_ASCENDING;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
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
import br.com.contmatic.model.produto.Produto;
import br.com.contmatic.model.telefone.DDD;
import br.com.contmatic.model.telefone.Telefone;
import br.com.contmatic.model.telefone.TipoTelefone;
import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.loader.FixtureFactoryLoader;

/**
 * The Class EmpresaTest.
 */
@FixMethodOrder(NAME_ASCENDING)
public class EmpresaTest {

	/** The empresa. */
	private Empresa empresa;

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
	 * Set up.
	 */
	@Before
	public void setUp() {
		empresa = Fixture.from(Empresa.class).gimme("valid");
	}

	/**
	 * Deve retornar verdadeiro para um nome nao nulo.
	 */
	@Test
	public void deve_retornar_verdadeiro_para_um_nome_nao_nulo() {
		assertNotNull(empresa.getNome());
	}

	/**
	 * Deve retornar verdadeiro para um cnpj nao nulo.
	 */
	@Test
	public void deve_retornar_verdadeiro_para_um_cnpj_nao_nulo() {
		assertNotNull(empresa.getCnpj());
	}

	/**
	 * Deve retornar verdadeiro para um endereco nao nulo.
	 */
	@Test
	public void deve_retornar_verdadeiro_para_um_endereco_nao_nulo() {
		assertNotNull(empresa.getEnderecos());
	}

	/**
	 * Deve retornar verdadeiro para um telefone nao nulo.
	 */
	@Test
	public void deve_retornar_verdadeiro_para_um_telefone_nao_nulo() {
		assertNotNull(empresa.getTelefones());
	}

	/**
	 * Deve retornar verdadeiro para um site nao nulo.
	 */
	@Test
	public void deve_retornar_verdadeiro_para_um_site_nao_nulo() {
		assertNotNull(empresa.getSite());
	}

	/**
	 * Deve retornar verdadeiro para um funcionario nao nulo.
	 */
	@Test
	public void deve_retornar_verdadeiro_para_um_funcionario_nao_nulo() {
		assertNotNull(empresa.getFuncionarios());
	}

	/**
	 * Deve retornar verdadeiro para um produto nao nulo.
	 */
	@Test
	public void deve_retornar_verdadeiro_para_um_produto_nao_nulo() {
		assertNotNull(empresa.getProdutos());
	}

	/**
	 * Deve retornar verdadeiro na comparacao do get com nome igual do enviado no
	 * set.
	 */
	@Test
	public void deve_retornar_verdadeiro_na_comparacao_do_get_com_nome_igual_do_enviado_no_set() {
		assertThat(empresa.getNome(), either(containsString("Contmatic")).or(containsString("Softmatic")));
	}

	/**
	 * Deve retornar falso na comparacao do get com nome diferente do enviado no
	 * set.
	 */
	@Test
	public void deve_retornar_falso_na_comparacao_do_get_com_nome_diferente_do_enviado_no_set() {
		assertThat(empresa.getNome(), not("Microsoft"));
	}

	/**
	 * Deve retornar verdadeiro na comparacao do get com cnpj igual do enviado no
	 * set.
	 */
	@Test
	public void deve_retornar_verdadeiro_na_comparacao_do_get_com_cnpj_igual_do_enviado_no_set() {
		assertThat(empresa.getCnpj(), is(empresa.getCnpj()));
	}

	/**
	 * Deve retornar falso na comparacao do get com cnpj diferente do enviado no
	 * set.
	 */
	@Test
	public void deve_retornar_falso_na_comparacao_do_get_com_cnpj_diferente_do_enviado_no_set() {
		assertThat(empresa.getCnpj(), not(is("123456788")));
	}

	/**
	 * Deve retornar verdadeiro na comparacao do get com endereco igual do enviado
	 * no set.
	 */
	@Test
	public void deve_retornar_verdadeiro_na_comparacao_do_get_com_endereco_igual_do_enviado_no_set() {
		Set<Endereco> endereco = new HashSet<>();
		endereco.add(Fixture.from(Endereco.class).gimme("valid"));
		empresa.setEnderecos(endereco);
		assertThat(empresa.getEnderecos(), is(endereco));
	}

	/**
	 * Deve retornar falso na comparacao do get com endereco diferente do enviado no
	 * set.
	 */
	@Test
	public void deve_retornar_falso_na_comparacao_do_get_com_endereco_diferente_do_enviado_no_set() {
		Set<Endereco> endereco = new HashSet<>();
		endereco.add(Fixture.from(Endereco.class).gimme("valid"));
		assertThat(empresa.getEnderecos(), not(endereco));
	}

	/**
	 * Deve retornar verdadeiro na comparacao do get com telefone igual do enviado
	 * no set.
	 */
	@Test
	public void deve_retornar_verdadeiro_na_comparacao_do_get_com_telefone_igual_do_enviado_no_set() {
		Set<Telefone> telefone = new HashSet<>();
		telefone.add(Fixture.from(Telefone.class).gimme("valid"));
		empresa.setTelefones(telefone);
		assertThat(empresa.getTelefones(), is(telefone));
	}

	/**
	 * Deve retornar falso na comparacao do get com telefone diferente do enviado no
	 * set.
	 */
	@Test
	public void deve_retornar_falso_na_comparacao_do_get_com_telefone_diferente_do_enviado_no_set() {
		Set<Telefone> telefone = new HashSet<>();
		telefone.add(new Telefone("999999999", TipoTelefone.CELULAR, DDD.DDD15));
		assertThat(empresa.getTelefones(), not(telefone));
	}

	/**
	 * Deve retornar verdadeiro na comparacao do get com site igual do enviado no
	 * set.
	 */
	@Test
	public void deve_retornar_verdadeiro_na_comparacao_do_get_com_site_igual_do_enviado_no_set() {
		assertThat(empresa.getSite(),
				either(containsString("http://teste.com.br")).or(containsString("http://empresa.com.br")));
	}

	/**
	 * Deve retornar falso na comparacao do get com site diferente do enviado no
	 * set.
	 */
	@Test
	public void deve_retornar_falso_na_comparacao_do_get_com_site_diferente_do_enviado_no_set() {
		assertThat(empresa.getSite(), is(not("http://www.google.com")));
	}

	/**
	 * Deve retornar verdadeiro na comparacao do get com funcionario igual do
	 * enviado no set.
	 */
	@Test
	public void deve_retornar_verdadeiro_na_comparacao_do_get_com_funcionario_igual_do_enviado_no_set() {
		assertTrue(empresa.getFuncionarios().equals(empresa.getFuncionarios()));
	}

	/**
	 * Deve retornar falso na comparacao do get com funcionario diferente do enviado
	 * no set.
	 */
	@Test
	public void deve_retornar_falso_na_comparacao_do_get_com_funcionario_diferente_do_enviado_no_set() {
		assertFalse(empresa.getFuncionarios().equals(empresa.getProdutos()));
	}

	/**
	 * Deve retornar verdadeiro na comparacao do get com produto igual do enviado no
	 * set.
	 */
	@Test
	public void deve_retornar_verdadeiro_na_comparacao_do_get_com_produto_igual_do_enviado_no_set() {
		assertTrue(empresa.getProdutos().equals(empresa.getProdutos()));
	}

	/**
	 * Deve retornar falso na comparacao do get com produto diferente do enviado no
	 * set.
	 */
	@Test
	public void deve_retornar_falso_na_comparacao_do_get_com_produto_diferente_do_enviado_no_set() {
		assertFalse(empresa.getProdutos().equals(empresa.getFuncionarios()));
	}

	/**
	 * Deve retornar verdadeiro na comparacao de dois hascodes iguais.
	 */
	@Test
	public void deve_retornar_verdadeiro_na_comparacao_de_dois_hascodes_iguais() {
		Empresa outraEmpresa = empresa;
		assertEquals(empresa.hashCode(), outraEmpresa.hashCode());
	}

	/**
	 * Deve retornar falso na comparacao de dois hascodes diferentes.
	 */
	@Test
	public void deve_retornar_falso_na_comparacao_de_dois_hascodes_diferentes() {
		Empresa outraEmpresa = new Empresa("Empresa 01", "46.166.672/0001-72");
		assertFalse(empresa.hashCode() == outraEmpresa.hashCode());
	}

	/**
	 * Deve retornar verdadeiro quando comparado dois objetos iguais atraves do
	 * equals.
	 */
	@Test
	public void deve_retornar_verdadeiro_quando_comparado_dois_objetos_iguais_atraves_do_equals() {
		Empresa outraEmpresa = empresa;
		assertTrue(empresa.equals(outraEmpresa));
	}

	/**
	 * Deve retornar falso quando comparado dois objetos diferentes da mesma classe
	 * atraves do equals.
	 */
	@Test
	public void deve_retornar_falso_quando_comparado_dois_objetos_diferentes_da_mesma_classe_atraves_do_equals() {
		Empresa outraEmpresa = Fixture.from(Empresa.class).gimme("valid");
		outraEmpresa.setCnpj("56.973.822/0001-03");
		assertFalse(empresa.equals(outraEmpresa));
	}

	/**
	 * Deve retornar falso quando comparado empresa a um objeto nulo atraves do
	 * equals.
	 */
	@Test
	public void deve_retornar_falso_quando_comparado_empresa_a_um_objeto_nulo_atraves_do_equals() {
		Empresa outraEmpresa = null;
		assertFalse(empresa.equals(outraEmpresa));
	}

	/**
	 * Deve retornar falso quando comparado dois objetos de classes diferentes
	 * atraves do equals.
	 */
	@Test
	public void deve_retornar_falso_quando_comparado_dois_objetos_de_classes_diferentes_atraves_do_equals() {
		assertFalse(empresa.equals(new Object()));
	}

	/**
	 * Deve retornar verdadeiro quando comparado um objeto a ele mesmo atraves do
	 * equals.
	 */
	@Test
	public void deve_retornar_verdadeiro_quando_comparado_um_objeto_a_ele_mesmo_atraves_do_equals() {
		assertTrue(empresa.equals(empresa));
	}

	/**
	 * Deve retornar falso quando comparado empresa a nulo atraves do equals.
	 */
	@Test(timeout = 100)
	public void deve_retornar_falso_quando_comparado_empresa_a_nulo_atraves_do_equals() {
		assertFalse(empresa.equals(null));
	}

	/**
	 * Deve retornar verdadeiro quando todos os campos de empresa sao validos.
	 */
	@Test
	public void deve_retornar_verdadeiro_quando_todos_os_campos_de_empresa_sao_validos() {
		Set<ConstraintViolation<Empresa>> constraintViolations = validator.validate(empresa);
		assertEquals(0, constraintViolations.size());
	}

	/**
	 * Deve retornar verdadeiro na captura de erro quando funcionarios e nulo.
	 */
	@Test
	public void deve_retornar_verdadeiro_na_captura_de_erro_quando_funcionarios_e_nulo() {
		empresa.setFuncionarios(null);
		Set<ConstraintViolation<Empresa>> constraintViolations = validator.validate(empresa);
		assertEquals(1, constraintViolations.size());
		assertEquals("Funcionários não pode ser vazio", constraintViolations.iterator().next().getMessage());
	}

	/**
	 * Deve retornar verdadeiro na captura de erro quando produtos e nulo.
	 */
	@Test
	public void deve_retornar_verdadeiro_na_captura_de_erro_quando_produtos_e_nulo() {
		empresa.setProdutos(null);
		Set<ConstraintViolation<Empresa>> constraintViolations = validator.validate(empresa);
		assertEquals(1, constraintViolations.size());
		assertEquals("Produtos não pode ser vazio", constraintViolations.iterator().next().getMessage());
	}

	/**
	 * Deve retornar verdadeiro na captura de erro quando tiver numero no nome.
	 */
	@Test
	public void deve_retornar_verdadeiro_na_captura_de_erro_quando_tiver_numero_no_nome() {
		empresa.setNome("9sg1çm85");
		Set<ConstraintViolation<Empresa>> constraintViolations = validator.validate(empresa);
		assertEquals(1, constraintViolations.size());
		assertEquals("Caractere inválido no nome da Empresa", constraintViolations.iterator().next().getMessage());
	}

	/**
	 * Deve retornar verdadeiro na captura de erro quando nome for maior que o
	 * limite.
	 */
	@Test
	public void deve_retornar_verdadeiro_na_captura_de_erro_quando_nome_for_maior_que_o_limite() {
		empresa.setNome(RandomStringUtils.randomAlphabetic(41));
		Set<ConstraintViolation<Empresa>> constraintViolations = validator.validate(empresa);
		assertEquals(1, constraintViolations.size());
		assertEquals("Nome com tamanho inválido", constraintViolations.iterator().next().getMessage());
	}

	/**
	 * Deve retornar verdadeiro na captura de erro quando tiver letra no cnpj.
	 */
	@Test
	public void deve_retornar_verdadeiro_na_captura_de_erro_quando_tiver_letra_no_cnpj() {
		empresa.setCnpj("9sg1çm85");
		Set<ConstraintViolation<Empresa>> constraintViolations = validator.validate(empresa);
		assertEquals(1, constraintViolations.size());
		assertEquals("CNPJ inválido", constraintViolations.iterator().next().getMessage());
	}

	/**
	 * Deve retornar verdadeiro na captura de erro quando o cnpj for nulo.
	 */
	@Test
	public void deve_retornar_verdadeiro_na_captura_de_erro_quando_o_cnpj_for_nulo() {
		empresa.setCnpj(null);
		Set<ConstraintViolation<Empresa>> constraintViolations = validator.validate(empresa);
		assertEquals(1, constraintViolations.size());
		assertEquals("CNPJ não pode ser nulo", constraintViolations.iterator().next().getMessage());
	}

	/**
	 * Deve retornar verdadeiro na captura de erro quando inserido um cnpj invalido.
	 */
	@Test
	public void deve_retornar_verdadeiro_na_captura_de_erro_quando_inserido_um_cnpj_invalido() {
		empresa.setCnpj("12.345.678/9012-34");
		Set<ConstraintViolation<Empresa>> constraintViolations = validator.validate(empresa);
		assertEquals(1, constraintViolations.size());
		assertEquals("CNPJ inválido", constraintViolations.iterator().next().getMessage());
	}

	/**
	 * Deve retornar verdadeiro na captura de erros quando o endereco for vazio.
	 */
	@Test
	public void deve_retornar_verdadeiro_na_captura_de_erros_quando_o_endereco_for_vazio() {
		Set<Endereco> endereco = new HashSet<>();
		endereco.add(new Endereco());
		empresa.setEnderecos(endereco);
		Set<ConstraintViolation<Empresa>> constraintViolations = validator.validate(empresa);
		assertEquals(3, constraintViolations.size());
	}

	/**
	 * Deve retornar verdadeiro na captura de erros quando inserido mais de um
	 * endereco.
	 */
	@Test
	public void deve_retornar_verdadeiro_na_captura_de_erros_quando_inserido_mais_de_um_endereco() {
		Set<Endereco> endereco = new HashSet<>();
		endereco.add(Fixture.from(Endereco.class).gimme("valid"));
		endereco.add(Fixture.from(Endereco.class).gimme("valid"));
		endereco.add(Fixture.from(Endereco.class).gimme("valid"));
		empresa.setEnderecos(endereco);
		Set<ConstraintViolation<Empresa>> constraintViolations = validator.validate(empresa);
		assertEquals(1, constraintViolations.size());
		assertEquals("Somente pode possuir um endereco", constraintViolations.iterator().next().getMessage());
	}

	/**
	 * Deve retornar verdadeiro na captura de erros quando o telefone for vazio.
	 */
	@Test
	public void deve_retornar_verdadeiro_na_captura_de_erros_quando_o_telefone_for_vazio() {
		Set<Telefone> tel = new HashSet<>();
		tel.add(new Telefone());
		empresa.setTelefones(tel);
		Set<ConstraintViolation<Empresa>> constraintViolations = validator.validate(empresa);
		assertEquals(1, constraintViolations.size());
	}
	
	/**
	 * Deve retornar verdadeiro na captura de erros quando inserido mais de um
	 * telefone.
	 */
	@Test
	public void deve_retornar_verdadeiro_na_captura_de_erros_quando_inserido_mais_de_um_telefone() {
		Set<Telefone> telefone = new HashSet<>();
		telefone.add(Fixture.from(Telefone.class).gimme("valid"));
		telefone.add(Fixture.from(Telefone.class).gimme("valid"));
		telefone.add(Fixture.from(Telefone.class).gimme("valid"));
		empresa.setTelefones(telefone);
		Set<ConstraintViolation<Empresa>> constraintViolations = validator.validate(empresa);
		assertEquals(1, constraintViolations.size());
		assertEquals("Somente pode possuir um telefone", constraintViolations.iterator().next().getMessage());
	}

	/**
	 * Deve retornar verdadeiro na captura de erros quando o site for vazio.
	 */
	@Test
	public void deve_retornar_verdadeiro_na_captura_de_erros_quando_o_site_for_vazio() {
		empresa.setSite(" ");
		Set<ConstraintViolation<Empresa>> constraintViolations = validator.validate(empresa);
		assertEquals(1, constraintViolations.size());
		assertEquals("URL inválida", constraintViolations.iterator().next().getMessage());
	}

	/**
	 * Deve retornar verdadeiro na captura de erros quando o site nao estiver na
	 * formatacao correta.
	 */
	@Test
	public void deve_retornar_verdadeiro_na_captura_de_erros_quando_o_site_nao_estiver_na_formatacao_correta() {
		empresa.setSite("google.com");
		Set<ConstraintViolation<Empresa>> constraintViolations = validator.validate(empresa);
		assertEquals(1, constraintViolations.size());
		assertEquals("URL inválida", constraintViolations.iterator().next().getMessage());
	}

	/**
	 * Deve retornar verdadeiro na captura de erros quando o funcionario for vazio.
	 */
	@Test
	public void deve_retornar_verdadeiro_na_captura_de_erros_quando_o_funcionario_for_vazio() {
		List<Funcionario> func = new ArrayList<>();
		func.add(new Funcionario());
		empresa.setFuncionarios(func);
		Set<ConstraintViolation<Empresa>> constraintViolations = validator.validate(empresa);
		assertEquals(3, constraintViolations.size());
	}

	/**
	 * Deve retornar verdadeiro na captura de erros quando o funcionario for nulo.
	 */
	@Test
	public void deve_retornar_verdadeiro_na_captura_de_erros_quando_o_funcionario_for_nulo() {
		empresa.setFuncionarios(null);
		Set<ConstraintViolation<Empresa>> constraintViolations = validator.validate(empresa);
		assertEquals(1, constraintViolations.size());
		assertEquals("Funcionários não pode ser vazio", constraintViolations.iterator().next().getMessage());
	}

	/**
	 * Deve retornar verdadeiro na captura de erros quando produto for vazio.
	 */
	@Test
	public void deve_retornar_verdadeiro_na_captura_de_erros_quando_produto_for_vazio() {
		List<Produto> prod = new ArrayList<>();
		prod.add(new Produto());
		empresa.setProdutos(prod);
		Set<ConstraintViolation<Empresa>> constraintViolations = validator.validate(empresa);
		assertEquals(3, constraintViolations.size());
	}

	/**
	 * Deve retornar verdadeiro na captura de erros quando produto for vazio.
	 */
	@Test
	public void deve_retornar_verdadeiro_na_captura_de_erros_quando_produto_for_nulo() {
		empresa.setProdutos(null);
		Set<ConstraintViolation<Empresa>> constraintViolations = validator.validate(empresa);
		assertEquals(1, constraintViolations.size());
		assertEquals("Produtos não pode ser vazio", constraintViolations.iterator().next().getMessage());
	}

	/**
	 * Tear down.
	 */
	@After
	public void tearDown() {
		empresa = null;
	}

	/**
	 * Tear down after class.
	 */
	@AfterClass
	public static void tearDownAfterClass() {
		System.out.println("Finalizado os teste para a classe Empresa");
	}
}
