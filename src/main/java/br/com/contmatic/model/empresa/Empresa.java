package br.com.contmatic.model.empresa;

import static br.com.contmatic.util.Regex.SOMENTE_LETRAS;
import static org.apache.commons.lang3.builder.EqualsBuilder.reflectionEquals;
import static org.apache.commons.lang3.builder.HashCodeBuilder.reflectionHashCode;
import static org.apache.commons.lang3.builder.ToStringBuilder.reflectionToString;

import java.util.List;
import java.util.Set;

import javax.validation.Valid;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.apache.commons.lang3.builder.ToStringStyle;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.URL;
import org.hibernate.validator.constraints.br.CNPJ;

import br.com.contmatic.model.auditoria.Auditoria;
import br.com.contmatic.model.endereco.Endereco;
import br.com.contmatic.model.produto.Produto;
import br.com.contmatic.model.telefone.Telefone;

public class Empresa extends Auditoria{

	@NotEmpty(message = "Nome da empresa não pode ser vazio")
	@Size(min = 1, max = 80, message = "Nome da empresa deve ter no máximo 80 caracteres")
	@Pattern(regexp = SOMENTE_LETRAS, message = "Caractere inválido no nome da empresa")
	private String nome;

	@CNPJ(message = "CNPJ da empresa inválido")
	@NotEmpty(message = "CNPJ da empresa não pode ser nulo")
	private String cnpj;

	@Valid
	@Size(min = 1, message = "Deve possuir no minímo um endereco da empresa")
	private Set<Endereco> enderecos;

	@Valid
	@Size(min = 1, message = "Deve possuir no minímo um telefone da empresa")
	private Set<Telefone> telefones;

	@URL(message = "Site da empresa inválida")
	@Size(min = 1, max = 60, message = "Site da empresa deve ter no máximo 60 caracteres")
	private String site;

	@Valid
	@NotEmpty(message = "Funcionários da empresa não pode ser vazio")
	@Size(min = 1, message = "Funcionários da empresa deve ter no máximo 80 caratceres")
	private List<Funcionario> funcionarios;

	@Valid
	@NotEmpty(message = "Produtos da empresa não pode ser vazio")
	@Size(min = 1, message = "Produtos da empresa deve ter no mínimo 1 item")
	private List<Produto> produtos;

	public Empresa() {
	}

	public Empresa(String nome, String cnpj) {
		setNome(nome);
		setCnpj(cnpj);
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return this.nome;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getCnpj() {
		return this.cnpj;
	}

	public void setEnderecos(Set<Endereco> endereco) {
		this.enderecos = endereco;
	}

	public Set<Endereco> getEnderecos() {
		return this.enderecos;
	}

	public Set<Telefone> getTelefones() {
		return this.telefones;
	}

	public void setTelefones(Set<Telefone> telefones) {
		this.telefones = telefones;
	}

	public String getSite() {
		return this.site;
	}

	public void setSite(String site) {
		this.site = site;
	}

	public List<Funcionario> getFuncionarios() {
		return this.funcionarios;
	}

	public void setFuncionarios(List<Funcionario> funcionarios) {
		this.funcionarios = funcionarios;
	}

	public List<Produto> getProdutos() {
		return this.produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

	@Override
	public int hashCode() {
		return reflectionHashCode(this);
	}

	@Override
	public boolean equals(Object obj) {
		return reflectionEquals(this, obj);
	}

	@Override
	public String toString() {
		return reflectionToString(this, ToStringStyle.NO_CLASS_NAME_STYLE);
	}

}
