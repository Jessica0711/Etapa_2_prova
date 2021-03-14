package br.com.contmatic.model.telefone;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public enum TipoTelefone {

	FIXO("fixo", 8),

	CELULAR("celular", 9);

	private String descricao;

	private int tamanho;

	private TipoTelefone(String descricao, int tamanho) {
		this.descricao = descricao;
		this.tamanho = tamanho;
	}

	public int getTamanho() {
		return tamanho;
	}

	public String getDescricao() {
		return descricao;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.NO_CLASS_NAME_STYLE);
	}
}
