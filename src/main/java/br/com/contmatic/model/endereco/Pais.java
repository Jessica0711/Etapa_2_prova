package br.com.contmatic.model.endereco;

import static br.com.contmatic.util.Regex.SOMENTE_LETRAS;
import static org.apache.commons.lang3.builder.EqualsBuilder.reflectionEquals;
import static org.apache.commons.lang3.builder.HashCodeBuilder.reflectionHashCode;
import static org.apache.commons.lang3.builder.ToStringBuilder.reflectionToString;
import static org.apache.commons.lang3.builder.ToStringStyle.NO_CLASS_NAME_STYLE;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

import br.com.contmatic.model.auditoria.Auditoria;

public class Pais extends Auditoria {

	@NotEmpty(message = "Nome do país não pode ser vazio")
	@Pattern(regexp = SOMENTE_LETRAS, message = "Caractere inválido no nome do país")
	@Size(min = 1, max = 80, message = "Nome do país deve ter no máximo 80 caratceres")
	private String nome;

	public Pais() {
	}
	
	public Pais(String nome) {
		setNome(nome);
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
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
