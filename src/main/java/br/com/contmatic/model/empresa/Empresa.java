/*
 * 
 */
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

/**
 * The Class Empresa.
 */
public class Empresa extends Auditoria{

	/** The nome. */
	@NotEmpty(message = "Nome da empresa não pode ser vazio")
	@Size(min = 1, max = 80, message = "Nome da empresa deve ter no máximo 80 caracteres")
	@Pattern(regexp = SOMENTE_LETRAS, message = "Caractere inválido no nome da empresa")
	private String nome;

	/** The cnpj. */
	@CNPJ(message = "CNPJ da empresa inválido")
	@NotEmpty(message = "CNPJ da empresa não pode ser nulo")
	private String cnpj;

	/** The enderecos. */
	@Valid
	@Size(min = 1, max = 1, message = "Somente pode possuir um endereco da empresa")
	private Set<Endereco> enderecos;

	/** The telefones. */
	@Valid
	@Size(min = 1, max = 1, message = "Somente pode possuir um telefone da empresa")
	private Set<Telefone> telefones;

	/** The site. */
	@URL(message = "Site da empresa inválida")
	@Size(min = 1, max = 60, message = "Site da empresa deve ter no máximo 60 caracteres")
	private String site;

	/** The funcionarios. */
	@Valid
	@NotEmpty(message = "Funcionários da empresa não pode ser vazio")
	@Size(min = 1, message = "Funcionários da empresa deve ter no máximo 80 caratceres")
	private List<Funcionario> funcionarios;

	/** The produtos. */
	@Valid
	@NotEmpty(message = "Produtos da empresa não pode ser vazio")
	@Size(min = 1, message = "Produtos da empresa deve ter no mínimo 1 item")
	private List<Produto> produtos;

	/**
	 * Instantiates a new empresa.
	 */
	public Empresa() {
	}

	/**
	 * Instantiates a new empresa.
	 *
	 * @param nome the nome
	 * @param cnpj the cnpj
	 */
	public Empresa(String nome, String cnpj) {
		setNome(nome);
		setCnpj(cnpj);
	}

	/**
	 * Sets the nome.
	 *
	 * @param nome the new nome
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * Gets the nome.
	 *
	 * @return the nome
	 */
	public String getNome() {
		return this.nome;
	}

	/**
	 * Sets the cnpj.
	 *
	 * @param cnpj the new cnpj
	 */
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	/**
	 * Gets the cnpj.
	 *
	 * @return the cnpj
	 */
	public String getCnpj() {
		return this.cnpj;
	}

	/**
	 * Sets the endereco.
	 *
	 * @param endereco the new endereco
	 */
	public void setEnderecos(Set<Endereco> endereco) {
		this.enderecos = endereco;
	}

	/**
	 * Gets the endereco.
	 *
	 * @return the endereco
	 */
	public Set<Endereco> getEnderecos() {
		return this.enderecos;
	}

	/**
	 * Gets the telefones.
	 *
	 * @return the telefones
	 */
	public Set<Telefone> getTelefones() {
		return this.telefones;
	}

	/**
	 * Sets the telefones.
	 *
	 * @param telefones the telefones to set
	 */
	public void setTelefones(Set<Telefone> telefones) {
		this.telefones = telefones;
	}

	/**
	 * Gets the site.
	 *
	 * @return the site
	 */
	public String getSite() {
		return this.site;
	}

	/**
	 * Sets the site.
	 *
	 * @param site the site to set
	 */
	public void setSite(String site) {
		this.site = site;
	}

	/**
	 * Gets the funcionarios.
	 *
	 * @return the funcionarios
	 */
	public List<Funcionario> getFuncionarios() {
		return this.funcionarios;
	}

	/**
	 * Sets the funcionarios.
	 *
	 * @param funcionarios the new funcionarios
	 */
	public void setFuncionarios(List<Funcionario> funcionarios) {
		this.funcionarios = funcionarios;
	}

	/**
	 * Gets the produtos.
	 *
	 * @return the produtos
	 */
	public List<Produto> getProdutos() {
		return this.produtos;
	}

	/**
	 * Sets the produtos.
	 *
	 * @param produtos the new produtos
	 */
	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

	/**
	 * Hash code.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		return reflectionHashCode(this);
	}

	/**
	 * Equals.
	 *
	 * @param obj the obj
	 * @return true, if successful
	 */
	@Override
	public boolean equals(Object obj) {
		return reflectionEquals(this, obj);
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return reflectionToString(this, ToStringStyle.NO_CLASS_NAME_STYLE);
	}

}
