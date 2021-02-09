package br.com.contmatic.model.empresa;

import static br.com.contmatic.util.Regex.SOMENTE_LETRAS;
import static org.apache.commons.lang3.builder.EqualsBuilder.reflectionEquals;
import static org.apache.commons.lang3.builder.HashCodeBuilder.reflectionHashCode;
import static org.apache.commons.lang3.builder.ToStringBuilder.reflectionToString;

import java.util.Set;

import javax.validation.Valid;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.apache.commons.lang3.builder.ToStringStyle;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.br.CPF;

import br.com.contmatic.model.auditoria.Auditoria;
import br.com.contmatic.model.endereco.Endereco;
import br.com.contmatic.model.telefone.Telefone;

/**
 * The Class Cliente.
 */
public class Cliente extends Auditoria {

	/** The nome. */
	@NotEmpty(message = "Nome do cliente não pode ser vazio")
	@Pattern(regexp = SOMENTE_LETRAS, message = "Caractere inválido no nome do cliente")
	@Size(min = 1, max = 80, message = "Nome do cliente deve ter no máximo 80 caratceres")
	private String nome;

	/** The cpf. */
	@CPF(message = "CPF do cliente inválido")
	private String cpf;

	/** The email. */
	@Email(message = "E-mail do cliente inválido")
	@NotBlank(message = "Email do cliente não pode ser nulo")
	@Size(min = 1, max = 60, message = "Email do cliente deve ter no máximo 60 caratceres")
	private String email;

	/** The enderecos. */
	@Valid
	@Size(min = 1, max = 1, message = "Somente pode possuir um endereco no cliente")
	private Set<Endereco> enderecos;

	/** The telefones. */
	@Valid
	@Size(min = 1, max = 1, message = "Somente pode possuir um telefone no cliente")
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
		return this.nome;
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
		return this.cpf;
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
		return this.email;
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
		return this.enderecos;
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
