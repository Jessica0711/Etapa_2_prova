/*
 * 
 */
package br.com.contmatic.model.empresa;

import java.util.List;
import java.util.Set;

import javax.validation.Valid;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.URL;
import org.hibernate.validator.constraints.br.CNPJ;

import br.com.contmatic.model.endereco.Endereco;
import br.com.contmatic.model.produto.Produto;
import br.com.contmatic.model.telefone.Telefone;
import br.com.contmatic.util.Regex;

/**
 * The Class Empresa.
 */
public class Empresa {

	/** The nome. */
	@NotEmpty(message = "Nome não pode ser vazio")
	@Size(min = 1, max = 40, message = "Nome com tamanho inválido")
	@Pattern(regexp = Regex.SOMENTE_LETRAS, message = "Caractere inválido no nome da Empresa")
	private String nome;

	/** The cnpj. */
	@CNPJ(message = "CNPJ inválido")
	@NotEmpty(message = "CNPJ não pode ser nulo")
	private String cnpj;

	/** The enderecos. */
	@Valid
	@Size(max = 1, message = "Somente pode possuir um endereco")
	private Set<Endereco> enderecos;

	/** The telefones. */
	@Valid
	@Size(max = 1, message = "Somente pode possuir um telefone")
	private Set<Telefone> telefones;

	/** The site. */
	@URL(message = "URL inválida")
	private String site;

	/** The funcionarios. */
	@Valid
	@NotEmpty(message = "Funcionários não pode ser vazio")
	private List<Funcionario> funcionarios;

	/** The produtos. */
	@Valid
	@NotEmpty(message = "Produtos não pode ser vazio")
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
		return nome;
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
		return cnpj;
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
		return enderecos;
	}

	/**
	 * Gets the telefones.
	 *
	 * @return the telefones
	 */
	public Set<Telefone> getTelefones() {
		return telefones;
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
		return site;
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
		return funcionarios;
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
		return produtos;
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
		return HashCodeBuilder.reflectionHashCode(this);
	}

	/**
	 * Equals.
	 *
	 * @param obj the obj
	 * @return true, if successful
	 */
	@Override
	public boolean equals(Object obj) {
		return EqualsBuilder.reflectionEquals(this, obj);
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.NO_CLASS_NAME_STYLE);
	}

}
