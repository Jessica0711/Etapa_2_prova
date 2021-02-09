package br.com.contmatic.model.endereco;

import static br.com.contmatic.util.Regex.SOMENTE_LETRAS;
import static org.apache.commons.lang3.builder.EqualsBuilder.reflectionEquals;
import static org.apache.commons.lang3.builder.HashCodeBuilder.reflectionHashCode;
import static org.apache.commons.lang3.builder.ToStringBuilder.reflectionToString;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.apache.commons.lang3.builder.ToStringStyle;
import org.hibernate.validator.constraints.NotEmpty;

import br.com.contmatic.model.auditoria.Auditoria;

/**
 * The Class Cidade.
 */
public class Cidade extends Auditoria {

	/** The nome. */
	@NotEmpty(message = "Nome da cidade não pode ser vazio")
	@Pattern(regexp = SOMENTE_LETRAS, message = "Caractere inválido no nome da cidade")
	@Size(min = 1, max = 80, message = "Nome da cidade deve ter no máximo 80 caracteres")
	private String nome;

	/** The estado. */
	@Valid
	@NotNull(message = "Estado da cidade não pode ser vazio")
	private Estado estado;

	/**
	 * Instantiates a new cidade.
	 */
	public Cidade() {
	}

	/**
	 * Instantiates a new cidade.
	 *
	 * @param nome   the nome
	 * @param estado the estado
	 */
	public Cidade(String nome, Estado estado) {
		setNome(nome);
		setEstado(estado);
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
	 * Gets the estado.
	 *
	 * @return the estado
	 */
	public Estado getEstado() {
		return this.estado;
	}

	/**
	 * Sets the estado.
	 *
	 * @param estado the new estado
	 */
	public void setEstado(Estado estado) {
		this.estado = estado;
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
