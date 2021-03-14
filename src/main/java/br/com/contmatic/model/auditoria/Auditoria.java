package br.com.contmatic.model.auditoria;

import static org.apache.commons.lang3.builder.EqualsBuilder.reflectionEquals;
import static org.apache.commons.lang3.builder.HashCodeBuilder.reflectionHashCode;
import static org.apache.commons.lang3.builder.ToStringBuilder.reflectionToString;

import javax.validation.constraints.NotNull;

import org.apache.commons.lang3.builder.ToStringStyle;
import org.hibernate.validator.constraints.NotEmpty;
import org.joda.time.DateTime;

public class Auditoria {

	@NotNull(message = "Data de cadastro não pode ser vazia")
	private DateTime dataCadastro;

	@NotNull(message = "Data de alteração não pode ser vazia")
	private DateTime dataAlteracao;

	@NotEmpty(message = "Criado por não pode ser vazia")
	private String criadoPor;

	@NotEmpty(message = "Última modificação não pode ser vazia")
	private String ultimaModificacao;

	@NotEmpty(message = "IP criado por não pode ser vazia")
	private String ipCriadoPor;

	@NotEmpty(message = "IP última modificação não pode ser vazia")
	private String ipUltimaModificacao;

	public DateTime getDataCadastro() {
		return this.dataCadastro;
	}

	public void setDataCadastro(DateTime dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public DateTime getDataAlteracao() {
		return this.dataAlteracao;
	}

	public void setDataAlteracao(DateTime dataAlteracao) {
		this.dataAlteracao = dataAlteracao;
	}

	public String getCriadoPor() {
		return this.criadoPor;
	}

	public void setCriadoPor(String criadoPor) {
		this.criadoPor = criadoPor;
	}

	public String getUltimaModificacao() {
		return this.ultimaModificacao;
	}

	public void setUltimaModificacao(String ultimaModificacao) {
		this.ultimaModificacao = ultimaModificacao;
	}

	public String getIpCriadoPor() {
		return this.ipCriadoPor;
	}

	public void setIpCriadoPor(String ipCriadoPor) {
		this.ipCriadoPor = ipCriadoPor;
	}

	public String getIpUltimaModificacao() {
		return this.ipUltimaModificacao;
	}

	public void setIpUltimaModificacao(String ipUltimaModificacao) {
		this.ipUltimaModificacao = ipUltimaModificacao;
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
