package br.com.contmatic.util;

/**
 * The Class Regex.
 */
public final class Regex {

	/**
	 * Instantiates a new regex.
	 */
	private Regex() {
	}

	/** The Constant SOMENTE_LETRAS. */
	public static final String SOMENTE_LETRAS = "^[A-Za-záàâãéèêíïóôõöúçñÁÀÂÃÉÈÍÏÓÔÕÖÚÇÑ ]+$";

	/** The Constant LETRAS_PARENTESES. */
	public static final String LETRAS_PARENTESES = "^[A-Za-záàâãéèêíïóôõöúçñÁÀÂÃÉÈÍÏÓÔÕÖÚÇÑ ()]+$";

	/** The Constant LETRA_NUMERO. */
	public static final String LETRA_NUMERO = "^[0-9A-Za-záàâãéèêíïóôõöúçñÁÀÂÃÉÈÍÏÓÔÕÖÚÇÑ ]+$";

	/** The Constant CEP. */
	public static final String CEP = "^[0-9]{5}-[\\d]{3}+$";

	/** The Constant NUMERO_TELEFONE. */
	public static final String NUMERO_TELEFONE = "^(\\(\\d{2}\\)?\\s?|\\d{2}(\\-|\\s))?\\d{2,4}(\\-|\\s)?\\d{4,5}$";
}
