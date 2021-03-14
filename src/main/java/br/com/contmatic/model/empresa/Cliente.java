package br.com.contmatic.model.empresa;

import static br.com.contmatic.util.Regex.SOMENTE_LETRAS;
import static org.apache.commons.lang3.builder.EqualsBuilder.reflectionEquals;
import static org.apache.commons.lang3.builder.HashCodeBuilder.reflectionHashCode;
import static org.apache.commons.lang3.builder.ToStringBuilder.reflectionToString;

import java.util.Set;

import javax.validation.Valid;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.apache.commons.lang3.builder.ToStringStyle;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.br.CPF;

import br.com.contmatic.model.auditoria.Auditoria;
import br.com.contmatic.model.endereco.Endereco;
import br.com.contmatic.model.telefone.Telefone;

public class Cliente extends Auditoria {

	@NotEmpty(message = "Nome do cliente não pode ser vazio")
	@Pattern(regexp = SOMENTE_LETRAS, message = "Caractere inválido no nome do cliente")
	@Size(min = 1, max = 80, message = "Nome do cliente deve ter no máximo 80 caratceres")
	private String nome;

	@CPF(message = "CPF do cliente inválido")
	private String cpf;

	@Email(message = "E-mail do cliente inválido")
	@NotBlank(message = "Email do cliente não pode ser nulo")
	@Size(min = 1, max = 60, message = "Email do cliente deve ter no máximo 60 caratceres")
	private String email;

	@Valid
	@Size(min = 1, message = "Deve possuir no minímo um endereco no cliente")
	private Set<Endereco> enderecos;

	@Valid
	@Size(min = 1, message = "Deve possuir no minímo um telefone no cliente")
	private Set<Telefone> telefones;

	public Cliente() {
	}

	public Cliente(String nome, String cpf) {
		setNome(nome);
		setCpf(cpf);
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return this.cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Set<Endereco> getEnderecos() {
		return this.enderecos;
	}

	public void setEnderecos(Set<Endereco> enderecos) {
		this.enderecos = enderecos;
	}

	public Set<Telefone> getTelefones() {
		return this.telefones;
	}

	public void setTelefones(Set<Telefone> telefones) {
		this.telefones = telefones;
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
