package br.com.contmatic.model.endereco;

import static br.com.contmatic.util.Regex.CEP;
import static br.com.contmatic.util.Regex.LETRA_NUMERO;
import static br.com.contmatic.util.Regex.SOMENTE_LETRAS;
import static org.apache.commons.lang3.builder.EqualsBuilder.reflectionEquals;
import static org.apache.commons.lang3.builder.HashCodeBuilder.reflectionHashCode;
import static org.apache.commons.lang3.builder.ToStringBuilder.reflectionToString;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.apache.commons.lang3.builder.ToStringStyle;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import br.com.contmatic.model.auditoria.Auditoria;

/**
 * The Class Endereco.
 */
public class Endereco extends Auditoria{

	/** The rua. */
	@NotEmpty(message = "Rua do endereço deve ser preenchida")
	@Size(max = 80, message = "Rua do endereço deve ter no máximo 80 caracteres")
	@Pattern(regexp = LETRA_NUMERO, message = "Caractere inválido na rua do endereço")
	private String rua;

	/** The numero. */
	@Max(value = 9999, message = "Número do endereço fora do permitido")
	private int numero;

	/** The bairro. */
	@NotEmpty(message = "Bairro do endereço deve ser preenchido")
	@Size(max = 80, message = "Bairro do endereço deve ter no máximo 80 caracteres")
	@Pattern(regexp = SOMENTE_LETRAS, message = "Caractere inválido no bairro do endereço")
	@Length(min = 0, max = 40, message = "Bairro do endereço com tamanho fora do permitido")
	private String bairro;

	/** The cep. */
	@NotEmpty(message = "CEP do endereço deve ser preenchido")
	@Pattern(regexp = CEP, message = "Caractere inválido no CEP do endereço")
	private String cep;

	/** The complemento. */
	@Size(max = 80, message = "Complemento do endereço deve ter no máximo 80 caracteres")
	@Pattern(regexp = LETRA_NUMERO, message = "Caractere inválido no complemneto do endereço")
	private String complemento;

	/** The cidade. */
	@Valid
	@NotNull(message = "Cidade do endereço deve ser preenchida")
	private Cidade cidade;

	/**
	 * Instantiates a new endereco.
	 */
	public Endereco() {
	}

	/**
	 * Instantiates a new endereco.
	 *
	 * @param cep the cep
	 */
	public Endereco(String cep) {
		setCep(cep);
	}

	/**
	 * Gets the rua.
	 *
	 * @return the rua
	 */
	public String getRua() {
		return this.rua;
	}

	/**
	 * Sets the rua.
	 *
	 * @param rua the new rua
	 */
	public void setRua(String rua) {
		this.rua = rua;
	}

	/**
	 * Gets the numero.
	 *
	 * @return the numero
	 */
	public int getNumero() {
		return this.numero;
	}

	/**
	 * Sets the numero.
	 *
	 * @param numero the new numero
	 */
	public void setNumero(int numero) {
		this.numero = numero;
	}

	/**
	 * Gets the bairro.
	 *
	 * @return the bairro
	 */
	public String getBairro() {
		return this.bairro;
	}

	/**
	 * Sets the bairro.
	 *
	 * @param bairro the new bairro
	 */
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	/**
	 * Gets the cep.
	 *
	 * @return the cep
	 */
	public String getCep() {
		return this.cep;
	}

	/**
	 * Sets the cep.
	 *
	 * @param cep the new cep
	 */
	public void setCep(String cep) {
		this.cep = cep;
	}

	/**
	 * Gets the complemento.
	 *
	 * @return the complemento
	 */
	public String getComplemento() {
		return this.complemento;
	}

	/**
	 * Sets the complemento.
	 *
	 * @param complemento the new complemento
	 */
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	/**
	 * Gets the cidade.
	 *
	 * @return the cidade
	 */
	public Cidade getCidade() {
		return this.cidade;
	}

	/**
	 * Sets the cidade.
	 *
	 * @param cidade the new cidade
	 */
	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
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
