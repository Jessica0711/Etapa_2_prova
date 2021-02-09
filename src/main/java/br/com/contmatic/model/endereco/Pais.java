package br.com.contmatic.model.endereco;

import static br.com.contmatic.util.Regex.SOMENTE_LETRAS;
import static org.apache.commons.lang3.builder.EqualsBuilder.reflectionEquals;
import static org.apache.commons.lang3.builder.HashCodeBuilder.reflectionHashCode;
import static org.apache.commons.lang3.builder.ToStringBuilder.reflectionToString;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.apache.commons.lang3.builder.ToStringStyle;
import org.hibernate.validator.constraints.NotEmpty;

import br.com.contmatic.model.auditoria.Auditoria;

/**
 * The Class Pais.
 */
public class Pais extends Auditoria {

	/** The nome. */
	@NotEmpty(message = "Nome do país não pode ser vazio")
	@Pattern(regexp = SOMENTE_LETRAS, message = "Caractere inválido no nome do país")
	@Size(min = 1, max = 80, message = "Nome do país deve ter no máximo 80 caratceres")
	private String nome;

	/**
	 * Instantiates a new cidade.
	 */
	public Pais() {
	}
	
	/**
	 * Instantiates a new pais.
	 *
	 * @param nome the nome
	 */
	public Pais(String nome) {
		setNome(nome);
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
