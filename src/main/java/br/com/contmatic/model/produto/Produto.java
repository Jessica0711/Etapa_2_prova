package br.com.contmatic.model.produto;

import static br.com.contmatic.util.Regex.LETRA_NUMERO;
import static org.apache.commons.lang3.builder.EqualsBuilder.reflectionEquals;
import static org.apache.commons.lang3.builder.HashCodeBuilder.reflectionHashCode;
import static org.apache.commons.lang3.builder.ToStringBuilder.reflectionToString;
import static org.apache.commons.lang3.builder.ToStringStyle.NO_CLASS_NAME_STYLE;

import java.math.BigDecimal;

import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
import org.joda.time.DateTime;

import com.google.common.base.Preconditions;

import br.com.contmatic.model.auditoria.Auditoria;

public class Produto extends Auditoria{

	@NotEmpty(message = "Nome do produto não pode estar vazio")
	@Size(min = 1, max = 80, message = "Nome do produto deve ter no máximo 80 caracteres")
	@Pattern(regexp = LETRA_NUMERO, message = "Caractere inválido no nome do produto")
	private String nome;

	@NotEmpty(message = "Marca do produto não pode estar vazia")
	@Size(min = 1, max = 70, message = "Marca do produto deve ter no máximo 70 caracteres")
	@Pattern(regexp = LETRA_NUMERO, message = "Caractere inválido na marca do produto")
	private String marca;

	@Min(value = 1, message = "Preço do produto minimo é 1")
	@NotNull(message = "Preço do produto não pode ser nulo")
	private BigDecimal preco;

	@NotNull(message = "Codigo do produto não pode ser nulo")
	private Long codigo;

	@Future(message = "Fim da produção do produto deve ser uma data futura")
	private DateTime fimProducao;

	public Produto() {

	}

	public Produto(String nome, String marca, BigDecimal preco, Long codigo) {
		setNome(nome);
		setMarca(marca);
		setPreco(preco);
		setCodigo(codigo);
	}

	public void setPreco(BigDecimal preco) {
		Preconditions.checkArgument(true);
		this.preco = preco;

	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return this.nome;
	}

	public String getMarca() {
		return this.marca;
	}

	public BigDecimal getPreco() {
		return this.preco;
	}

	public Long getCodigo() {
		return this.codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public DateTime getFimProducao() {
		return this.fimProducao;
	}

	public void setFimProducao(DateTime fimProducao) {
		this.fimProducao = fimProducao;
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
