package br.com.contmatic.model.telefone;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * The Enum TipoTelefone.
 */
public enum TipoTelefone {

	/** The fixo. */
	FIXO("fixo", 8),

	/** The celular. */
	CELULAR("celular", 9);

	/** The descricao. */
	private String descricao;

	/** The tamanho. */
	private int tamanho;

	/**
	 * Instantiates a new tipo telefone.
	 *
	 * @param descricao the descricao
	 * @param tamanho   the tamanho
	 */
	private TipoTelefone(String descricao, int tamanho) {
		this.descricao = descricao;
		this.tamanho = tamanho;
	}

	/**
	 * Gets the tamanho.
	 *
	 * @return the tamanho
	 */
	public int getTamanho() {
		return tamanho;
	}

	/**
	 * Gets the descricao.
	 *
	 * @return the descricao
	 */
	public String getDescricao() {
		return descricao;
	}

	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.NO_CLASS_NAME_STYLE);
	}
}
