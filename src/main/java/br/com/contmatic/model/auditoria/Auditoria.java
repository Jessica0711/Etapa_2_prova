package br.com.contmatic.model.auditoria;

import static org.apache.commons.lang3.builder.EqualsBuilder.reflectionEquals;
import static org.apache.commons.lang3.builder.HashCodeBuilder.reflectionHashCode;
import static org.apache.commons.lang3.builder.ToStringBuilder.reflectionToString;

import javax.validation.constraints.NotNull;

import org.apache.commons.lang3.builder.ToStringStyle;
import org.hibernate.validator.constraints.NotEmpty;
import org.joda.time.DateTime;

/**
 * The Class Auditoria.
 */
public class Auditoria {

	/** The data cadastro. */
	@NotNull(message = "Data de cadastro não pode ser vazia")
	private DateTime dataCadastro;

	/** The data alteracao. */
	@NotNull(message = "Data de alteração não pode ser vazia")
	private DateTime dataAlteracao;

	/** The criado por. */
	@NotEmpty(message = "Criado por não pode ser vazia")
	private String criadoPor;

	/** The ultima modificacao. */
	@NotEmpty(message = "Última modificação não pode ser vazia")
	private String ultimaModificacao;

	/** The ip criado por. */
	@NotEmpty(message = "IP criado por não pode ser vazia")
	private String ipCriadoPor;

	/** The ip ultima modificacao. */
	@NotEmpty(message = "IP última modificação não pode ser vazia")
	private String ipUltimaModificacao;

	/**
	 * Gets the data cadastro.
	 *
	 * @return the data cadastro
	 */
	public DateTime getDataCadastro() {
		return this.dataCadastro;
	}

	/**
	 * Sets the data cadastro.
	 *
	 * @param dataCadastro the new data cadastro
	 */
	public void setDataCadastro(DateTime dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	/**
	 * Gets the data alteracao.
	 *
	 * @return the data alteracao
	 */
	public DateTime getDataAlteracao() {
		return this.dataAlteracao;
	}

	/**
	 * Sets the data alteracao.
	 *
	 * @param dataAlteracao the new data alteracao
	 */
	public void setDataAlteracao(DateTime dataAlteracao) {
		this.dataAlteracao = dataAlteracao;
	}

	/**
	 * Gets the criado por.
	 *
	 * @return the criado por
	 */
	public String getCriadoPor() {
		return this.criadoPor;
	}

	/**
	 * Sets the criado por.
	 *
	 * @param criadoPor the new criado por
	 */
	public void setCriadoPor(String criadoPor) {
		this.criadoPor = criadoPor;
	}

	/**
	 * Gets the ultima modificacao.
	 *
	 * @return the ultima modificacao
	 */
	public String getUltimaModificacao() {
		return this.ultimaModificacao;
	}

	/**
	 * Sets the ultima modificacao.
	 *
	 * @param ultimaModificacao the new ultima modificacao
	 */
	public void setUltimaModificacao(String ultimaModificacao) {
		this.ultimaModificacao = ultimaModificacao;
	}

	/**
	 * Gets the ip criado por.
	 *
	 * @return the ip criado por
	 */
	public String getIpCriadoPor() {
		return this.ipCriadoPor;
	}

	/**
	 * Sets the ip criado por.
	 *
	 * @param ipCriadoPor the new ip criado por
	 */
	public void setIpCriadoPor(String ipCriadoPor) {
		this.ipCriadoPor = ipCriadoPor;
	}

	/**
	 * Gets the ip ultima modificacao.
	 *
	 * @return the ip ultima modificacao
	 */
	public String getIpUltimaModificacao() {
		return this.ipUltimaModificacao;
	}

	/**
	 * Sets the ip ultima modificacao.
	 *
	 * @param ipUltimaModificacao the new ip ultima modificacao
	 */
	public void setIpUltimaModificacao(String ipUltimaModificacao) {
		this.ipUltimaModificacao = ipUltimaModificacao;
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
