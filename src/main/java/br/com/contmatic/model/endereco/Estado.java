package br.com.contmatic.model.endereco;

import static org.apache.commons.lang3.builder.EqualsBuilder.reflectionEquals;
import static org.apache.commons.lang3.builder.HashCodeBuilder.reflectionHashCode;
import static org.apache.commons.lang3.builder.ToStringBuilder.reflectionToString;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.apache.commons.lang3.builder.ToStringStyle;

import br.com.contmatic.model.auditoria.Auditoria;

public class Estado extends Auditoria {

	@NotNull(message = "Nome do estado não pode ser vazio")
	private EstadoNome nome;

	@Valid
	@NotNull(message = "País do estado não pode ser vazio")
	private Pais pais;

	public Estado() {
	}

	public Estado(EstadoNome nome, Pais pais) {
		setNome(nome);
		setPais(pais);
	}

	public EstadoNome getNome() {
		return this.nome;
	}

	public void setNome(EstadoNome nome) {
		this.nome = nome;
	}

	public Pais getPais() {
		return this.pais;
	}

	public void setPais(Pais pais) {
		this.pais = pais;
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
