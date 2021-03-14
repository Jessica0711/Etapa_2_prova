package br.com.contmatic.model.empresa;

import static br.com.contmatic.util.Regex.LETRAS_PARENTESES;
import static br.com.contmatic.util.Regex.SOMENTE_LETRAS;
import static org.apache.commons.lang3.builder.EqualsBuilder.reflectionEquals;
import static org.apache.commons.lang3.builder.HashCodeBuilder.reflectionHashCode;
import static org.apache.commons.lang3.builder.ToStringBuilder.reflectionToString;

import java.math.BigDecimal;
import java.util.Set;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.apache.commons.lang3.builder.ToStringStyle;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.Range;
import org.hibernate.validator.constraints.br.CPF;
import org.joda.time.DateTime;

import br.com.contmatic.model.auditoria.Auditoria;
import br.com.contmatic.model.endereco.Endereco;
import br.com.contmatic.model.telefone.Telefone;

public class Funcionario extends Auditoria {

	@NotBlank(message = "Nome do funcionário não pode ser vazio")
	@Size(min = 1, max = 80, message = "Nome do funcionário deve ter no máximo 80 caracteres")
	@Pattern(regexp = SOMENTE_LETRAS, message = "Caractere inválido no nome do funcionário")
	private String nome;

	@Range(min = 1000, max = 99999, message = "Salário do funcionário com valor fora do permitido")
	private BigDecimal salario;

	@NotBlank(message = "Cargo do funcionário não pode ser vazio")
	@Size(min = 1, max = 70, message = "Cargo do funcionário deve ter no máximo 70 caracteres")
	@Pattern(regexp = LETRAS_PARENTESES, message = "Caractere inválido em cargo do funcionário")
	private String cargo;

	@CPF(message = "CPF do funcionário inválido")
	@NotBlank(message = "CPF do funcionário deve ser preenchido")
	private String cpf;

	@NotNull(message = "Nascimento do funcionário não pode ser vazio")
	private DateTime nascimento;

	@Null(message = "idade do funcionário não deve ser preenchida")
	private String idade;

	@NotNull(message = "Contratação do funcionário não pode ser nula")
	private DateTime contratacao;

	@Valid
	@Size(min = 1, message = "Deve possuir no minímo um telefone do funcionário")
	private Set<Telefone> telefones;

	@Valid
	@Size(min = 1, message = "Deve possuir no minímo um endereco do funcionário")
	private Set<Endereco> enderecos;

	public Funcionario() {
	}

	public Funcionario(String nome, BigDecimal salario, String cargo, String cpf) {
		setNome(nome);
		setSalario(salario);
		setCargo(cargo);
		setCpf(cpf);
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return this.nome;
	}

	public void setSalario(BigDecimal salario) {
		this.salario = salario;
	}

	public BigDecimal getSalario() {
		return this.salario;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public String getCargo() {
		return this.cargo;
	}

	public String getCpf() {
		return this.cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public DateTime getNascimento() {
		return this.nascimento;
	}

	public void setNascimento(DateTime nascimento) {
		this.nascimento = nascimento;
	}

	public DateTime getContratacao() {
		return this.contratacao;
	}

	public void setContratacao(DateTime contratacao) {
		this.contratacao = contratacao;
	}

	public String getIdade() {
		return this.idade;
	}

	public void setIdade(String idade) {
		this.idade = idade;
	}

	public Set<Telefone> getTelefones() {
		return this.telefones;
	}

	public void setTelefones(Set<Telefone> telefones) {
		this.telefones = telefones;
	}

	public Set<Endereco> getEnderecos() {
		return this.enderecos;
	}

	public void setEnderecos(Set<Endereco> enderecos) {
		this.enderecos = enderecos;
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
