package br.com.contmatic.model.produto;

import static br.com.contmatic.util.Regex.LETRA_NUMERO;
import static org.apache.commons.lang3.builder.EqualsBuilder.reflectionEquals;
import static org.apache.commons.lang3.builder.HashCodeBuilder.reflectionHashCode;
import static org.apache.commons.lang3.builder.ToStringBuilder.reflectionToString;

import java.math.BigDecimal;

import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.apache.commons.lang3.builder.ToStringStyle;
import org.hibernate.validator.constraints.NotEmpty;
import org.joda.time.DateTime;

import br.com.contmatic.model.auditoria.Auditoria;

/**
 * The Class Produto.
 */
public class Produto extends Auditoria{

	/** The nome. */
	@NotEmpty(message = "Nome do produto não pode estar vazio")
	@Size(min = 1, max = 80, message = "Nome do produto deve ter no máximo 80 caracteres")
	@Pattern(regexp = LETRA_NUMERO, message = "Caractere inválido no nome do produto")
	private String nome;

	/** The marca. */
	@NotEmpty(message = "Marca do produto não pode estar vazia")
	@Size(min = 1, max = 70, message = "Marca do produto deve ter no máximo 70 caracteres")
	@Pattern(regexp = LETRA_NUMERO, message = "Caractere inválido na marca do produto")
	private String marca;

	/** The preco. */
	@Min(value = 1, message = "Preço do produto minimo é 1")
	@NotNull(message = "Preço do produto não pode ser nulo")
	private BigDecimal preco;

	/** The codigo. */
	private long codigo;

	/** The fim producao. */
	@Future(message = "Fim da produção do produto deve ser uma data futura")
	private DateTime fimProducao;

	/**
	 * Instantiates a new produto.
	 */
	public Produto() {

	}

	/**
	 * Instantiates a new produto.
	 *
	 * @param nome   the nome
	 * @param marca  the marca
	 * @param preco  the preco
	 * @param codigo the codigo
	 */
	public Produto(String nome, String marca, BigDecimal preco, long codigo) {
		setNome(nome);
		setMarca(marca);
		setPreco(preco);
		setCodigo(codigo);
	}

	/**
	 * Sets the preco.
	 *
	 * @param preco the new preco
	 */
	public void setPreco(BigDecimal preco) {
		this.preco = preco;

	}

	/**
	 * Sets the marca.
	 *
	 * @param marca the new marca
	 */
	public void setMarca(String marca) {
		this.marca = marca;
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
	 * Gets the marca.
	 *
	 * @return the marca
	 */
	public String getMarca() {
		return this.marca;
	}

	/**
	 * Gets the preco.
	 *
	 * @return the preco
	 */
	public BigDecimal getPreco() {
		return this.preco;
	}

	/**
	 * Gets the codigo.
	 *
	 * @return the codigo
	 */
	public long getCodigo() {
		return this.codigo;
	}

	/**
	 * Sets the codigo.
	 *
	 * @param codigo the codigo to set
	 */
	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}

	/**
	 * Gets the fim producao.
	 *
	 * @return the fimProducao
	 */
	public DateTime getFimProducao() {
		return this.fimProducao;
	}

	/**
	 * Sets the fim producao.
	 *
	 * @param fimProducao the fimProducao to set
	 */
	public void setFimProducao(DateTime fimProducao) {
		this.fimProducao = fimProducao;
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
