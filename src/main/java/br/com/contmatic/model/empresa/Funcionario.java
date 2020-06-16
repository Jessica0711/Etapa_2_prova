package br.com.contmatic.model.empresa;

import java.math.BigDecimal;
import java.util.Set;

import javax.validation.Valid;
import javax.validation.constraints.Null;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.Range;
import org.hibernate.validator.constraints.br.CPF;
import org.joda.time.DateTime;

import br.com.contmatic.model.endereco.Endereco;
import br.com.contmatic.model.telefone.Telefone;
import br.com.contmatic.util.Regex;

/**
 * The Class Funcionario.
 */
public class Funcionario {

	/** The nome. */
	@NotBlank(message = "Nome não pode ser vazio")
	@Pattern(regexp = Regex.SOMENTE_LETRAS, message = "Caractere inválido no nome do funcionário")
	private String nome;

	/** The salario. */
	@Range(min = 1000, max = 99999, message = "Salário com valor fora do permitido")
	private BigDecimal salario;

	/** The cargo. */
	@NotBlank(message = "Cargo não pode ser vazio")
	@Pattern(regexp = Regex.LETRAS_PARENTESES, message = "Caractere inválido em cargo")
	private String cargo;

	/** The cpf. */
	@CPF(message = "CPF inválido")
	@NotBlank(message = "CPF deve ser preenchido")
	private String cpf;

	/** The nascimento. */
	private DateTime nascimento;

	/** The idade. */
	@Null(message = "idade não deve ser preenchida")
	private String idade;

	/** The contratacao. */
	private DateTime contratacao;

	/** The telefones. */
	@Valid
	@Size(max = 1, message = "Somente é permitido um telefone")
	private Set<Telefone> telefones;

	/** The enderecos. */
	@Valid
	@Size(max = 1, message = "Somente pode possuir um endereco")
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
		return cargo;
	}

	/**
	 * Gets the cpf.
	 *
	 * @return the cpf
	 */
	public String getCpf() {
		return cpf;
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
		return nascimento;
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
		return contratacao;
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
		return idade;
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
		return telefones;
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
		return enderecos;
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
		return HashCodeBuilder.reflectionHashCode(this);
	}

	/**
	 * Equals.
	 *
	 * @param obj the obj
	 * @return true, if successful
	 */
	@Override
	public boolean equals(Object obj) {
		return EqualsBuilder.reflectionEquals(this, obj);
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.NO_CLASS_NAME_STYLE);
	}

}
