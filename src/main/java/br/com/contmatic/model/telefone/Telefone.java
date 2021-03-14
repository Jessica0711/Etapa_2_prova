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

public class Telefone extends Auditoria{

	@NotEmpty(message = "Número telefone não pode estar vazio")
	@Size(min = 1, max = 20, message = "Número do telefone deve ter no máximo 20 caracteres")
	@Pattern(regexp = NUMERO_TELEFONE, message = "Caractere inválido no número do telefone")
	private String numero;

	@NotNull(message = "Tipo do telefone não pode estar vazio")
	private TipoTelefone tipo;

	@NotNull(message = "DDD do telefone não pode estar vazio")
	private DDD ddd;

	public Telefone() {
	}

	public Telefone(String numero, TipoTelefone tipo, DDD ddd) {
		setNumero(numero);
		setTipo(tipo);
		setDdd(ddd);
	}

	public String getNumero() {
		return this.numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public TipoTelefone getTipo() {
		return this.tipo;
	}

	public void setTipo(TipoTelefone tipo) {
		this.tipo = tipo;
	}

	public DDD getDdd() {
		return this.ddd;
	}

	public void setDdd(DDD ddd) {
		this.ddd = ddd;
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
