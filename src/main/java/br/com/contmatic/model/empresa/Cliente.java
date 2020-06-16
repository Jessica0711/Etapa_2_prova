package br.com.contmatic.model.empresa;

import java.util.Set;

import javax.validation.Valid;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.br.CPF;

import br.com.contmatic.model.endereco.Endereco;
import br.com.contmatic.model.telefone.Telefone;
import br.com.contmatic.util.Regex;

/**
 * The Class Cliente.
 */
public class Cliente {

	/** The nome. */
	@NotEmpty(message = "Nome não pode ser vazio")
	@Pattern(regexp = Regex.SOMENTE_LETRAS, message = "Caractere inválido no Nome")
	private String nome;

	/** The cpf. */
	@CPF(message = "CPF inválido")
	private String cpf;

	/** The email. */
	@Email(message = "E-mail inválido")
	@NotBlank(message = "Email não pode ser nulo")
	private String email;

	/** The enderecos. */
	@Valid
	@Size(max = 1, message = "Somente pode possuir um endereco")
	private Set<Endereco> enderecos;

	/** The telefones. */
	@Valid
	@Size(max = 1, message = "Somente pode possuir um telefone")
	private Set<Telefone> telefones;

	/**
	 * Instantiates a new cliente.
	 */
	public Cliente() {
	}

	/**
	 * Instantiates a new cliente.
	 *
	 * @param nome the nome
	 * @param cpf  the cpf
	 */
	public Cliente(String nome, String cpf) {
		setNome(nome);
		setCpf(cpf);
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
	 * Sets the nome.
	 *
	 * @param nome the new nome
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * Gets the cpf.
	 *
	 * @return the cpf
	 */
	public String getCpf() {
		return cpf;
	}

	/**
	 * Sets the cpf.
	 *
	 * @param cpf the new cpf
	 */
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	/**
	 * Gets the email.
	 *
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Sets the email.
	 *
	 * @param email the new email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Gets the enderecos.
	 *
	 * @return the enderecos
	 */
	public Set<Endereco> getEnderecos() {
		return enderecos;
	}

	/**
	 * Sets the enderecos.
	 *
	 * @param enderecos the enderecos to set
	 */
	public void setEnderecos(Set<Endereco> enderecos) {
		this.enderecos = enderecos;
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
