package br.com.contmatic.model.empresa;

import static br.com.six2six.fixturefactory.Fixture.from;
import static br.com.six2six.fixturefactory.loader.FixtureFactoryLoader.loadTemplates;
import static javax.validation.Validation.buildDefaultValidatorFactory;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.either;
import static org.hamcrest.CoreMatchers.is;
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
import br.com.contmatic.model.telefone.Telefone;
import br.com.six2six.fixturefactory.Fixture;

@FixMethodOrder(NAME_ASCENDING)
public class EmpresaTest {

	private Empresa empresa;

	private static Validator validator;

	@BeforeClass
	public static void setUpBeforeClass() {
		loadTemplates("br.com.contmatic.model.template");
		ValidatorFactory factory = buildDefaultValidatorFactory();
		validator = factory.getValidator();
	}

	@Before
	public void setUp() {
		empresa = from(Empresa.class).gimme("valid");
	}

	@Test
	public void deve_retornar_verdadeiro_para_uma_empresa_nao_nulo() {
		assertNotNull(empresa.getNome());
		assertNotNull(empresa.getCnpj());
		assertNotNull(empresa.getEnderecos());
		assertNotNull(empresa.getTelefones());
		assertNotNull(empresa.getSite());
		assertNotNull(empresa.getFuncionarios());
		assertNotNull(empresa.getProdutos());
	}

	@Test
	public void deve_retornar_verdadeiro_na_comparacao_do_get_com_o_enviado_no_set() {
		assertThat(empresa.getNome(), either(containsString("Contmatic")).or(containsString("Softmatic")));
		assertThat(empresa.getCnpj(), is(empresa.getCnpj()));
		assertThat(empresa.getSite(),
				either(containsString("http://teste.com.br")).or(containsString("http://empresa.com.br")));
	}

	@Test
	public void deve_retornar_verdadeiro_na_comparacao_do_get_com_funcionario_igual_do_enviado_no_set() {
		assertTrue(empresa.getFuncionarios().equals(empresa.getFuncionarios()));
	}

	@Test
	public void deve_retornar_falso_na_comparacao_do_get_com_funcionario_diferente_do_enviado_no_set() {
		assertFalse(empresa.getFuncionarios().equals(empresa.getProdutos()));
	}

	@Test
	public void deve_retornar_verdadeiro_na_comparacao_do_get_com_produto_igual_do_enviado_no_set() {
		assertTrue(empresa.getProdutos().equals(empresa.getProdutos()));
	}

	@Test
	public void deve_retornar_falso_na_comparacao_do_get_com_produto_diferente_do_enviado_no_set() {
		assertFalse(empresa.getProdutos().equals(empresa.getFuncionarios()));
	}

	@Test
	public void deve_retornar_verdadeiro_na_comparacao_de_dois_hascodes_iguais() {
		Empresa outraEmpresa = empresa;
		assertEquals(empresa.hashCode(), outraEmpresa.hashCode());
	}

	@Test
	public void deve_retornar_falso_na_comparacao_de_dois_hascodes_diferentes() {
		Empresa outraEmpresa = new Empresa("Empresa 01", "46.166.672/0001-72");
		assertFalse(empresa.hashCode() == outraEmpresa.hashCode());
	}

	@Test
	public void deve_retornar_verdadeiro_quando_comparado_dois_objetos_iguais_atraves_do_equals() {
		Empresa outraEmpresa = empresa;
		assertTrue(empresa.equals(outraEmpresa));
	}

	@Test
	public void deve_retornar_falso_quando_comparado_dois_objetos_diferentes_da_mesma_classe_atraves_do_equals() {
		Empresa outraEmpresa = Fixture.from(Empresa.class).gimme("valid");
		outraEmpresa.setCnpj("56.973.822/0001-03");
		assertFalse(empresa.equals(outraEmpresa));
	}

	@Test
	public void deve_retornar_falso_quando_comparado_empresa_a_um_objeto_nulo_atraves_do_equals() {
		Empresa outraEmpresa = null;
		assertFalse(empresa.equals(outraEmpresa));
	}

	@Test
	public void deve_retornar_falso_quando_comparado_dois_objetos_de_classes_diferentes_atraves_do_equals() {
		assertFalse(empresa.equals(new Object()));
	}

	@Test
	public void deve_retornar_verdadeiro_quando_comparado_um_objeto_a_ele_mesmo_atraves_do_equals() {
		assertTrue(empresa.equals(empresa));
	}

	@Test(timeout = 100)
	public void deve_retornar_falso_quando_comparado_empresa_a_nulo_atraves_do_equals() {
		assertFalse(empresa.equals(null));
	}

	@Test
	public void deve_retornar_verdadeiro_quando_todos_os_campos_de_empresa_sao_validos() {
		Set<ConstraintViolation<Empresa>> constraintViolations = validator.validate(empresa);
		assertEquals(0, constraintViolations.size());
	}

	@Test
	public void deve_retornar_verdadeiro_na_captura_de_erro_quando_funcionarios_e_nulo() {
		empresa.setFuncionarios(null);
		Set<ConstraintViolation<Empresa>> constraintViolations = validator.validate(empresa);
		assertEquals(1, constraintViolations.size());
		assertEquals("Funcionários da empresa não pode ser vazio", constraintViolations.iterator().next().getMessage());
	}

	@Test
	public void deve_retornar_verdadeiro_na_captura_de_erro_quando_produtos_e_nulo() {
		empresa.setProdutos(null);
		Set<ConstraintViolation<Empresa>> constraintViolations = validator.validate(empresa);
		assertEquals(1, constraintViolations.size());
		assertEquals("Produtos da empresa não pode ser vazio", constraintViolations.iterator().next().getMessage());
	}

	@Test
	public void deve_retornar_verdadeiro_na_captura_de_erro_quando_tiver_numero_no_nome() {
		empresa.setNome("9sg1çm85");
		Set<ConstraintViolation<Empresa>> constraintViolations = validator.validate(empresa);
		assertEquals(1, constraintViolations.size());
		assertEquals("Caractere inválido no nome da empresa", constraintViolations.iterator().next().getMessage());
	}

	@Test
	public void deve_retornar_verdadeiro_na_captura_de_erro_quando_nome_for_maior_que_o_limite() {
		empresa.setNome(RandomStringUtils.randomAlphabetic(81));
		Set<ConstraintViolation<Empresa>> constraintViolations = validator.validate(empresa);
		assertEquals(1, constraintViolations.size());
		assertEquals("Nome da empresa deve ter no máximo 80 caracteres",
				constraintViolations.iterator().next().getMessage());
	}

	@Test
	public void deve_retornar_verdadeiro_na_captura_de_erro_quando_tiver_letra_no_cnpj() {
		empresa.setCnpj("9sg1çm85");
		Set<ConstraintViolation<Empresa>> constraintViolations = validator.validate(empresa);
		assertEquals(1, constraintViolations.size());
		assertEquals("CNPJ da empresa inválido", constraintViolations.iterator().next().getMessage());
	}

	@Test
	public void deve_retornar_verdadeiro_na_captura_de_erro_quando_o_cnpj_for_nulo() {
		empresa.setCnpj(null);
		Set<ConstraintViolation<Empresa>> constraintViolations = validator.validate(empresa);
		assertEquals(1, constraintViolations.size());
		assertEquals("CNPJ da empresa não pode ser nulo", constraintViolations.iterator().next().getMessage());
	}

	@Test
	public void deve_retornar_verdadeiro_na_captura_de_erro_quando_inserido_um_cnpj_invalido() {
		empresa.setCnpj("12.345.678/9012-34");
		Set<ConstraintViolation<Empresa>> constraintViolations = validator.validate(empresa);
		assertEquals(1, constraintViolations.size());
		assertEquals("CNPJ da empresa inválido", constraintViolations.iterator().next().getMessage());
	}

	@Test
	public void deve_retornar_verdadeiro_na_captura_de_erros_quando_o_endereco_for_vazio() {
		Set<Endereco> endereco = new HashSet<>();
		endereco.add(new Endereco());
		empresa.setEnderecos(endereco);
		Set<ConstraintViolation<Empresa>> constraintViolations = validator.validate(empresa);
		assertEquals(10, constraintViolations.size());
	}

	@Test
	public void deve_retornar_verdadeiro_na_captura_de_erros_quando_inserido_mais_de_um_endereco() {
		Set<Endereco> endereco = new HashSet<>();
		endereco.add(Fixture.from(Endereco.class).gimme("valid"));
		endereco.add(Fixture.from(Endereco.class).gimme("valid"));
		endereco.add(Fixture.from(Endereco.class).gimme("valid"));
		empresa.setEnderecos(endereco);
		Set<ConstraintViolation<Empresa>> constraintViolations = validator.validate(empresa);
		assertEquals(1, constraintViolations.size());
		assertEquals("Somente pode possuir um endereco da empresa",
				constraintViolations.iterator().next().getMessage());
	}

	@Test
	public void deve_retornar_verdadeiro_na_captura_de_erros_quando_o_telefone_for_vazio() {
		Set<Telefone> tel = new HashSet<>();
		tel.add(new Telefone());
		empresa.setTelefones(tel);
		Set<ConstraintViolation<Empresa>> constraintViolations = validator.validate(empresa);
		assertEquals(9, constraintViolations.size());
	}

	@Test
	public void deve_retornar_verdadeiro_na_captura_de_erros_quando_inserido_mais_de_um_telefone() {
		Set<Telefone> telefone = new HashSet<>();
		telefone.add(Fixture.from(Telefone.class).gimme("valid"));
		telefone.add(Fixture.from(Telefone.class).gimme("valid"));
		telefone.add(Fixture.from(Telefone.class).gimme("valid"));
		empresa.setTelefones(telefone);
		Set<ConstraintViolation<Empresa>> constraintViolations = validator.validate(empresa);
		assertEquals(1, constraintViolations.size());
		assertEquals("Somente pode possuir um telefone da empresa",
				constraintViolations.iterator().next().getMessage());
	}

	@Test
	public void deve_retornar_verdadeiro_na_captura_de_erros_quando_o_site_for_vazio() {
		empresa.setSite(" ");
		Set<ConstraintViolation<Empresa>> constraintViolations = validator.validate(empresa);
		assertEquals(1, constraintViolations.size());
		assertEquals("Site da empresa inválida", constraintViolations.iterator().next().getMessage());
	}

	@Test
	public void deve_retornar_verdadeiro_na_captura_de_erros_quando_o_site_nao_estiver_na_formatacao_correta() {
		empresa.setSite("google.com");
		Set<ConstraintViolation<Empresa>> constraintViolations = validator.validate(empresa);
		assertEquals(1, constraintViolations.size());
		assertEquals("Site da empresa inválida", constraintViolations.iterator().next().getMessage());
	}

	@Test
	public void deve_retornar_verdadeiro_na_captura_de_erros_quando_o_funcionario_for_vazio() {
		List<Funcionario> func = new ArrayList<>();
		func.add(new Funcionario());
		empresa.setFuncionarios(func);
		Set<ConstraintViolation<Empresa>> constraintViolations = validator.validate(empresa);
		assertEquals(11, constraintViolations.size());
	}

	@Test
	public void deve_retornar_verdadeiro_na_captura_de_erros_quando_o_funcionario_for_nulo() {
		empresa.setFuncionarios(null);
		Set<ConstraintViolation<Empresa>> constraintViolations = validator.validate(empresa);
		assertEquals(1, constraintViolations.size());
		assertEquals("Funcionários da empresa não pode ser vazio", constraintViolations.iterator().next().getMessage());
	}

	@Test
	public void deve_retornar_verdadeiro_na_captura_de_erros_quando_produto_for_vazio() {
		List<Produto> prod = new ArrayList<>();
		prod.add(new Produto());
		empresa.setProdutos(prod);
		Set<ConstraintViolation<Empresa>> constraintViolations = validator.validate(empresa);
		assertEquals(9, constraintViolations.size());
	}

	@Test
	public void deve_retornar_verdadeiro_na_captura_de_erros_quando_produto_for_nulo() {
		empresa.setProdutos(null);
		Set<ConstraintViolation<Empresa>> constraintViolations = validator.validate(empresa);
		assertEquals(1, constraintViolations.size());
		assertEquals("Produtos da empresa não pode ser vazio", constraintViolations.iterator().next().getMessage());
	}

	@After
	public void tearDown() {
		empresa = null;
	}

	@AfterClass
	public static void tearDownAfterClass() {
		System.out.println("Finalizado os teste para a classe Empresa");
	}
}
