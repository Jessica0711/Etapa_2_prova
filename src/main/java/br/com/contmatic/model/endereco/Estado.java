package br.com.contmatic.model.endereco;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * The Enum Estado.
 */
public enum Estado {

	/** The ac. */
	AC("Acre"),

	/** The al. */
	AL("Alagoas"),

	/** The ap. */
	AP("Amapá"),

	/** The am. */
	AM("Amazonas"),

	/** The ba. */
	BA("Bahia"),

	/** The ce. */
	CE("Ceará"),

	/** The df. */
	DF("Distrito Federal"),

	/** The es. */
	ES("Espírito Santo"),

	/** The go. */
	GO("Goiás"),

	/** The ma. */
	MA("Maranhão"),

	/** The mt. */
	MT("Mato Grosso"),

	/** The ms. */
	MS("Mato Grosso do Sul"),

	/** The mg. */
	MG("Minas Gerais"),

	/** The pa. */
	PA("Pará"),

	/** The pb. */
	PB("Paraíba"),

	/** The pe. */
	PE("Pernambuco"),

	/** The pi. */
	PI("Piauí"),

	/** The rj. */
	RJ("Rio de Janeiro"),

	/** The rn. */
	RN("Rio Grande do Norte"),

	/** The rs. */
	RS("Rio Grande do Sul"),

	/** The ro. */
	RO("Rondônia"),

	/** The rr. */
	RR("Roraima"),

	/** The sc. */
	SC("Santa Catarina"),

	/** The sp. */
	SP("São Paulo"),

	/** The se. */
	SE("Sergipe"),

	/** The to. */
	TO("Tocantins");

	/** The nome. */
	private String nome;

	/**
	 * Instantiates a new estado.
	 *
	 * @param nome the nome
	 */
	private Estado(String nome) {
		this.nome = nome;
	}

	/**
	 * Gets the nome.
	 *
	 * @return the nome
	 */
	public String getNome() {
		return nome;
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
