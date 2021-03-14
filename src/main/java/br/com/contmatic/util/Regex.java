package br.com.contmatic.util;

public final class Regex {

	private Regex() {
	}

	public static final String SOMENTE_LETRAS = "^[A-Za-záàâãéèêíïóôõöúçñÁÀÂÃÉÈÍÏÓÔÕÖÚÇÑ ]+$";

	public static final String LETRAS_PARENTESES = "^[A-Za-záàâãéèêíïóôõöúçñÁÀÂÃÉÈÍÏÓÔÕÖÚÇÑ ()]+$";

	public static final String LETRA_NUMERO = "^[0-9A-Za-záàâãéèêíïóôõöúçñÁÀÂÃÉÈÍÏÓÔÕÖÚÇÑ ]+$";

	public static final String CEP = "^[0-9]{5}-[\\d]{3}+$";

	public static final String NUMERO_TELEFONE = "^(\\(\\d{2}\\)?\\s?|\\d{2}(\\-|\\s))?\\d{2,4}(\\-|\\s)?\\d{4,5}$";
}
