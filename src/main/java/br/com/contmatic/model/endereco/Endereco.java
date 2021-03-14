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

public class Endereco extends Auditoria{

	@NotEmpty(message = "Rua do endereço deve ser preenchida")
	@Size(max = 80, message = "Rua do endereço deve ter no máximo 80 caracteres")
	@Pattern(regexp = LETRA_NUMERO, message = "Caractere inválido na rua do endereço")
	private String rua;

	@Max(value = 9999, message = "Número do endereço fora do permitido")
	private int numero;

	@NotEmpty(message = "Bairro do endereço deve ser preenchido")
	@Size(max = 80, message = "Bairro do endereço deve ter no máximo 80 caracteres")
	@Pattern(regexp = SOMENTE_LETRAS, message = "Caractere inválido no bairro do endereço")
	@Length(min = 0, max = 40, message = "Bairro do endereço com tamanho fora do permitido")
	private String bairro;

	@NotEmpty(message = "CEP do endereço deve ser preenchido")
	@Pattern(regexp = CEP, message = "Caractere inválido no CEP do endereço")
	private String cep;

	@Size(max = 80, message = "Complemento do endereço deve ter no máximo 80 caracteres")
	@Pattern(regexp = LETRA_NUMERO, message = "Caractere inválido no complemneto do endereço")
	private String complemento;

	@Valid
	@NotNull(message = "Cidade do endereço deve ser preenchida")
	private Cidade cidade;

	public Endereco() {
	}

	public Endereco(String cep) {
		setCep(cep);
	}

	public String getRua() {
		return this.rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public int getNumero() {
		return this.numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getBairro() {
		return this.bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCep() {
		return this.cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getComplemento() {
		return this.complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public Cidade getCidade() {
		return this.cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
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
