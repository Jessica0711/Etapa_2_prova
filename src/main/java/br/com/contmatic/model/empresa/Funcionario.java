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

/**
 * The Class Funcionario.
 */
public class Funcionario extends Auditoria {

	/** The nome. */
	@NotBlank(message = "Nome do funcionário não pode ser vazio")
	@Size(min = 1, max = 80, message = "Nome do funcionário deve ter no máximo 80 caracteres")
	@Pattern(regexp = SOMENTE_LETRAS, message = "Caractere inválido no nome do funcionário")
	private String nome;

	/** The salario. */
	@Range(min = 1000, max = 99999, message = "Salário do funcionário com valor fora do permitido")
	private BigDecimal salario;

	/** The cargo. */
	@NotBlank(message = "Cargo do funcionário não pode ser vazio")
	@Size(min = 1, max = 70, message = "Cargo do funcionário deve ter no máximo 70 caracteres")
	@Pattern(regexp = LETRAS_PARENTESES, message = "Caractere inválido em cargo do funcionário")
	private String cargo;

	/** The cpf. */
	@CPF(message = "CPF do funcionário inválido")
	@NotBlank(message = "CPF do funcionário deve ser preenchido")
	private String cpf;

	/** The nascimento. */
	@NotNull(message = "Nascimento do funcionário não pode ser vazio")
	private DateTime nascimento;

	/** The idade. */
	@Null(message = "idade do funcionário não deve ser preenchida")
	private String idade;

	/** The contratacao. */
	@NotNull(message = "Contratação do funcionário não pode ser nula")
	private DateTime contratacao;

	/** The telefones. */
	@Valid
	@Size(min = 1, max = 1, message = "Somente é permitido um telefone do funcionário")
	private Set<Telefone> telefones;

	/** The enderecos. */
	@Valid
	@Size(min = 1, max = 1, message = "Somente pode possuir um endereco do funcionário")
	private Set<Endereco> enderecos;

	/**
	 * Instantiates a new funcionario.
	 */
	public Funcionario() {
	}

	/**
	 * Instantiates a new funcionario.
	 *
	 * @param nome    the nome
	 * @param salario the salario
	 * @param cargo   the cargo
	 * @param cpf     the cpf
	 */
	public Funcionario(String nome, BigDecimal salario, String cargo, String cpf) {
		setNome(nome);
		setSalario(salario);
		setCargo(cargo);
		setCpf(cpf);
	}

	/**
	 * Sets the nome.
	 *
	 * @param nome the new nome
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * Gets the nome.
	 *
	 * @return the nome
	 */
	public String getNome() {
		return this.nome;
	}

	/**
	 * Sets the salario.
	 *
	 * @param salario the new salario
	 */
	public void setSalario(BigDecimal salario) {
		this.salario = salario;
	}

	/**
	 * Gets the salario.
	 *
	 * @return the salario
	 */
	public BigDecimal getSalario() {
		return this.salario;
	}

	/**
	 * Sets the cargo.
	 *
	 * @param cargo the new cargo
	 */
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	/**
	 * Gets the cargo.
	 *
	 * @return the cargo
	 */
	public String getCargo() {
		return this.cargo;
	}

	/**
	 * Gets the cpf.
	 *
	 * @return the cpf
	 */
	public String getCpf() {
		return this.cpf;
	}

	/**
	 * Sets the cpf.
	 *
	 * @param cpf the new cpf
	 */
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	/**
	 * Gets the nascimento.
	 *
	 * @return the nascimento
	 */
	public DateTime getNascimento() {
		return this.nascimento;
	}

	/**
	 * Sets the nascimento.
	 *
	 * @param nascimento the nascimento to set
	 */
	public void setNascimento(DateTime nascimento) {
		this.nascimento = nascimento;
	}

	/**
	 * Gets the contratacao.
	 *
	 * @return the contratacao
	 */
	public DateTime getContratacao() {
		return this.contratacao;
	}

	/**
	 * Sets the contratacao.
	 *
	 * @param contratacao the new contratacao
	 */
	public void setContratacao(DateTime contratacao) {
		this.contratacao = contratacao;
	}

	/**
	 * Gets the idade.
	 *
	 * @return the idade
	 */
	public String getIdade() {
		return this.idade;
	}

	/**
	 * Sets the idade.
	 *
	 * @param idade the idade to set
	 */
	public void setIdade(String idade) {
		this.idade = idade;
	}

	/**
	 * Gets the telefones.
	 *
	 * @return the telefones
	 */
	public Set<Telefone> getTelefones() {
		return this.telefones;
	}

	/**
	 * Sets the telefones.
	 *
	 * @param telefones the telefones to set
	 */
	public void setTelefones(Set<Telefone> telefones) {
		this.telefones = telefones;
	}

	/**
	 * Gets the enderecos.
	 *
	 * @return the enderecos
	 */
	public Set<Endereco> getEnderecos() {
		return this.enderecos;
	}

	/**
	 * Sets the enderecos.
	 *
	 * @param enderecos the enderecos to set
	 */
	public void setEnderecos(Set<Endereco> enderecos) {
		this.enderecos = enderecos;
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
