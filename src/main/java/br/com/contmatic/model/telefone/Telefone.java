package br.com.contmatic.model.telefone;

import static br.com.contmatic.util.Regex.NUMERO_TELEFONE;
import static org.apache.commons.lang3.builder.EqualsBuilder.reflectionEquals;
import static org.apache.commons.lang3.builder.HashCodeBuilder.reflectionHashCode;
import static org.apache.commons.lang3.builder.ToStringBuilder.reflectionToString;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.apache.commons.lang3.builder.ToStringStyle;
import org.hibernate.validator.constraints.NotEmpty;

import br.com.contmatic.model.auditoria.Auditoria;

/**
 * The Class Telefone.
 */
public class Telefone extends Auditoria{

	/** The numero. */
	@NotEmpty(message = "Número telefone não pode estar vazio")
	@Size(min = 1, max = 20, message = "Número do telefone deve ter no máximo 20 caracteres")
	@Pattern(regexp = NUMERO_TELEFONE, message = "Caractere inválido no número do telefone")
	private String numero;

	/** The tipo. */
	@NotNull(message = "Tipo do telefone não pode estar vazio")
	private TipoTelefone tipo;

	/** The ddd. */
	@NotNull(message = "DDD do telefone não pode estar vazio")
	private DDD ddd;

	/**
	 * Instantiates a new telefone.
	 */
	public Telefone() {
	}

	/**
	 * Instantiates a new telefone.
	 *
	 * @param numero the numero
	 * @param tipo   the tipo
	 * @param ddd    the ddd
	 */
	public Telefone(String numero, TipoTelefone tipo, DDD ddd) {
		setNumero(numero);
		setTipo(tipo);
		setDdd(ddd);
	}

	/**
	 * Gets the numero.
	 *
	 * @return the numero
	 */
	public String getNumero() {
		return this.numero;
	}

	/**
	 * Sets the numero.
	 *
	 * @param numero the new numero
	 */
	public void setNumero(String numero) {
		this.numero = numero;
	}

	/**
	 * Gets the tipo.
	 *
	 * @return the tipo
	 */
	public TipoTelefone getTipo() {
		return this.tipo;
	}

	/**
	 * Sets the tipo.
	 *
	 * @param tipo the tipo to set
	 */
	public void setTipo(TipoTelefone tipo) {
		this.tipo = tipo;
	}

	/**
	 * Gets the ddd.
	 *
	 * @return the ddd
	 */
	public DDD getDdd() {
		return this.ddd;
	}

	/**
	 * Sets the ddd.
	 *
	 * @param ddd the new ddd
	 */
	public void setDdd(DDD ddd) {
		this.ddd = ddd;
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
