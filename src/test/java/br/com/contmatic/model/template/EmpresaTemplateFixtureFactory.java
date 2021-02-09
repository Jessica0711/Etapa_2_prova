package br.com.contmatic.model.template;

import static br.com.six2six.fixturefactory.Fixture.of;
import static java.math.BigDecimal.valueOf;
import static org.joda.time.DateTime.parse;

import java.math.BigDecimal;
import java.util.Random;

import org.joda.time.DateTime;

import br.com.contmatic.model.auditoria.Auditoria;
import br.com.contmatic.model.empresa.Cliente;
import br.com.contmatic.model.empresa.Empresa;
import br.com.contmatic.model.empresa.Funcionario;
import br.com.contmatic.model.endereco.Cidade;
import br.com.contmatic.model.endereco.Endereco;
import br.com.contmatic.model.endereco.Estado;
import br.com.contmatic.model.endereco.EstadoNome;
import br.com.contmatic.model.endereco.Pais;
import br.com.contmatic.model.produto.Produto;
import br.com.contmatic.model.telefone.DDD;
import br.com.contmatic.model.telefone.Telefone;
import br.com.contmatic.model.telefone.TipoTelefone;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;

/**
 * A factory for creating EmpresaTemplateFixture objects.
 */
public class EmpresaTemplateFixtureFactory implements TemplateLoader {

	/**
	 * Load.
	 */
	@Override
	public void load() {

		of(Empresa.class).addTemplate("valid", new Rule() {
			{
				add("nome", random("Contmatic", "Softmatic"));
				add("cnpj", cnpj(true));
				add("enderecos", has(1).of(Endereco.class, "valid"));
				add("telefones", has(1).of(Telefone.class, "valid"));
				add("funcionarios", has(2).of(Funcionario.class, "valid"));
				add("produtos", has(2).of(Produto.class, "valid"));
				add("site", random("http://teste.com.br", "http://empresa.com.br"));
				add("dataCadastro", parse("2021-03-02"));
				add("dataAlteracao", parse("2021-03-02"));
				add("criadoPor", random("admim", "user"));
				add("ultimaModificacao", random("admim", "user"));
				add("ipCriadoPor", random("1111111", "2222222", "3333333"));
				add("ipUltimaModificacao", random("1111111", "2222222", "3333333"));
			}
		});

		of(Endereco.class).addTemplate("valid", new Rule() {
			{
				add("rua", random("Avenida 01", "Avenida 02", "Rua 02", "Rua 03"));
				add("numero", new Random().nextInt(900));
				add("bairro", random("Itaquera", "Tatuapé", "Brás", "Moema"));
				add("cep", random("01234-567", "98765-412", "78945-816"));
				add("complemento", random("Apt 01", "Apt 02", "Não possui"));
				add("cidade", one(Cidade.class, "valid"));
				add("dataCadastro", parse("2021-03-02"));
				add("dataAlteracao", parse("2021-03-02"));
				add("criadoPor", random("admim", "user"));
				add("ultimaModificacao", random("admim", "user"));
				add("ipCriadoPor", random("1111111", "2222222", "3333333"));
				add("ipUltimaModificacao", random("1111111", "2222222", "3333333"));
			}
		});

		of(Cidade.class).addTemplate("valid", new Rule() {
			{
				add("nome", random("São Paulo", "Campinas", "Bertioga"));
				add("estado", one(Estado.class, "valid"));
				add("dataCadastro", parse("2021-03-02"));
				add("dataAlteracao", parse("2021-03-02"));
				add("criadoPor", random("admim", "user"));
				add("ultimaModificacao", random("admim", "user"));
				add("ipCriadoPor", random("1111111", "2222222", "3333333"));
				add("ipUltimaModificacao", random("1111111", "2222222", "3333333"));
			}
		});

		of(Estado.class).addTemplate("valid", new Rule() {
			{
				add("nome", EstadoNome.values()[new Random().nextInt(27)]);
				add("cidades", has(2).of(Cidade.class, "valid"));
				add("pais", one(Pais.class, "valid"));
				add("dataCadastro", parse("2021-03-02"));
				add("dataAlteracao", parse("2021-03-02"));
				add("criadoPor", random("admim", "user"));
				add("ultimaModificacao", random("admim", "user"));
				add("ipCriadoPor", random("1111111", "2222222", "3333333"));
				add("ipUltimaModificacao", random("1111111", "2222222", "3333333"));
			}
		});

		of(Pais.class).addTemplate("valid", new Rule() {
			{
				add("nome", random("Brasil", "México", "Itália"));
				add("dataCadastro", parse("2021-03-02"));
				add("dataAlteracao", parse("2021-03-02"));
				add("criadoPor", random("admim", "user"));
				add("ultimaModificacao", random("admim", "user"));
				add("ipCriadoPor", random("1111111", "2222222", "3333333"));
				add("ipUltimaModificacao", random("1111111", "2222222", "3333333"));
			}
		});

		of(Funcionario.class).addTemplate("valid", new Rule() {
			{
				add("nome", name());
				add("cpf", random("820.314.100-59", "432.678.378-80"));
				add("salario", valueOf(1000 + (new Random().nextDouble() * (1900 - 1000))));
				add("cargo", random("Vendedor(a)", "Gerente", "Caixa", "Diretor(a)"));
				add("nascimento", parse("1995-06-07"));
				add("idade", null);
				add("contratacao", parse("2019-09-11"));
				add("telefones", has(1).of(Telefone.class, "valid"));
				add("enderecos", has(1).of(Endereco.class, "valid"));
				add("dataCadastro", parse("2021-03-02"));
				add("dataAlteracao", parse("2021-03-02"));
				add("criadoPor", random("admim", "user"));
				add("ultimaModificacao", random("admim", "user"));
				add("ipCriadoPor", random("1111111", "2222222", "3333333"));
				add("ipUltimaModificacao", random("1111111", "2222222", "3333333"));
			}
		});

		of(Produto.class).addTemplate("valid", new Rule() {
			{
				add("nome", random("Shorts", "Calça", "Camisa", "Vestido"));
				add("marca", random("Camaleon", "Addidas", "Nike"));
				add("preco", BigDecimal.valueOf(30 + (new Random().nextDouble() * (100 - 30))));
				add("codigo", new Random().nextLong());
				add("fimProducao", DateTime.parse("2030-03-11"));
				add("dataCadastro", parse("2021-03-02"));
				add("dataAlteracao", parse("2021-03-02"));
				add("criadoPor", random("admim", "user"));
				add("ultimaModificacao", random("admim", "user"));
				add("ipCriadoPor", random("1111111", "2222222", "3333333"));
				add("ipUltimaModificacao", random("1111111", "2222222", "3333333"));
			}
		});

		of(Cliente.class).addTemplate("valid", new Rule() {
			{
				add("nome", name());
				add("cpf", random("820.314.100-59", "432.678.378-80"));
				add("enderecos", has(1).of(Endereco.class, "valid"));
				add("telefones", has(1).of(Telefone.class, "valid"));
				add("email", random("exemplo@teste.com", "testando@test.com"));
				add("dataCadastro", parse("2021-03-02"));
				add("dataAlteracao", parse("2021-03-02"));
				add("criadoPor", random("admim", "user"));
				add("ultimaModificacao", random("admim", "user"));
				add("ipCriadoPor", random("1111111", "2222222", "3333333"));
				add("ipUltimaModificacao", random("1111111", "2222222", "3333333"));
			}
		});

		of(Telefone.class).addTemplate("valid", new Rule() {
			{
				add("numero", random("947268218", "24874321", "974524542"));
				add("ddd", DDD.values()[new Random().nextInt(66)]);
				add("tipo", TipoTelefone.values()[new Random().nextInt(2)]);
				add("dataCadastro", parse("2021-03-02"));
				add("dataAlteracao", parse("2021-03-02"));
				add("criadoPor", random("admim", "user"));
				add("ultimaModificacao", random("admim", "user"));
				add("ipCriadoPor", random("1111111", "2222222", "3333333"));
				add("ipUltimaModificacao", random("1111111", "2222222", "3333333"));
			}
		});
		
		of(Auditoria.class).addTemplate("valid", new Rule() {
			{
				add("dataCadastro", parse("2021-03-02"));
				add("dataAlteracao", parse("2021-03-02"));
				add("criadoPor", random("admim", "user"));
				add("ultimaModificacao", random("admim", "user"));
				add("ipCriadoPor", random("1111111", "2222222", "3333333"));
				add("ipUltimaModificacao", random("1111111", "2222222", "3333333"));
			}
		});

	}

}
