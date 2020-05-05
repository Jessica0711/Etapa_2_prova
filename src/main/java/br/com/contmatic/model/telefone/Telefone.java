package br.com.contmatic.model.telefone;

import javax.validation.constraints.Pattern;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.hibernate.validator.constraints.NotEmpty;

import br.com.contmatic.util.Regex;

/**
 * The Class Telefone.
 */
public class Telefone {

    /** The numero. */
    @NotEmpty(message = "Número não pode estar vazio")
    @Pattern(regexp = Regex.NUMERO_TELEFONE)
    private String numero;

    /** The tipo. */
    private TipoTelefone tipo;

    /** The ddd. */
    private DDD ddd;

    /**
     * Instantiates a new telefone.
     */
    public Telefone() {
    }

    /**
     * Instantiates a new telefone.
     *
     * @param numero the numero
     * @param tipo the tipo
     * @param ddd the ddd
     */
    public Telefone(String numero, TipoTelefone tipo, DDD ddd) {
        setNumero(numero);
        setTipo(tipo);
        setDdd(ddd);
    }

    /**
     * Gets the numero.
     *
     * @return the numero
     */
    public String getNumero() {
        return numero;
    }

    /**
     * Sets the numero.
     *
     * @param numero the new numero
     */
    public void setNumero(String numero) {
        this.numero = numero;
    }

    /**
     * Gets the tipo.
     *
     * @return the tipo
     */
    public TipoTelefone getTipo() {
        return tipo;
    }

    /**
     * Sets the tipo.
     *
     * @param tipo the tipo to set
     */
    public void setTipo(TipoTelefone tipo) {
        this.tipo = tipo;
    }

    /**
     * Gets the ddd.
     *
     * @return the ddd
     */
    public DDD getDdd() {
        return ddd;
    }

    /**
     * Sets the ddd.
     *
     * @param ddd the new ddd
     */
    public void setDdd(DDD ddd) {
        this.ddd = ddd;
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
