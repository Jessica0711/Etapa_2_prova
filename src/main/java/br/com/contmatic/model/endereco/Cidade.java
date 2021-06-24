package br.com.contmatic.model.endereco;

import static br.com.contmatic.util.Regex.SOMENTE_LETRAS;
import static org.apache.commons.lang3.builder.EqualsBuilder.reflectionEquals;
import static org.apache.commons.lang3.builder.HashCodeBuilder.reflectionHashCode;
import static org.apache.commons.lang3.builder.ToStringBuilder.reflectionToString;
import static org.apache.commons.lang3.builder.ToStringStyle.NO_CLASS_NAME_STYLE;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

import br.com.contmatic.model.auditoria.Auditoria;

public class Cidade extends Auditoria {

	@NotEmpty(message = "Nome da cidade não pode ser vazio")
	@Pattern(regexp = SOMENTE_LETRAS, message = "Caractere inválido no nome da cidade")
	@Size(min = 1, max = 80, message = "Nome da cidade deve ter no máximo 80 caracteres")
	private String nome;

	@Valid
	@NotNull(message = "Estado da cidade não pode ser vazio")
	private Estado estado;

	public Cidade() {
	}

	public Cidade(String nome, Estado estado) {
		setNome(nome);
		setEstado(estado);
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Estado getEstado() {
		return this.estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
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
		return reflectionToString(this, NO_CLASS_NAME_STYLE);
	}

}
