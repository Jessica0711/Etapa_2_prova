package br.com.contmatic.model.endereco;

import javax.validation.constraints.Max;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import br.com.contmatic.util.Regex;

/**
 * The Class Endereco.
 */
public class Endereco {

    @NotEmpty
    @Pattern(regexp = Regex.LETRA_NUMERO, message = "Caractere invalido")
    private String rua;

    @Max(value = 9999)
    private int numero;

    @NotEmpty
    @Length(min = 0, max=40)
    @Pattern(regexp = Regex.SOMENTE_LETRAS, message = "Caractere invalido")
    private String bairro;

    @NotEmpty
    @Pattern(regexp = Regex.CEP, message = "Caractere invalido")
    private String cep;

    @Size(max = 30)
    @Pattern(regexp = Regex.LETRA_NUMERO, message = "Caractere invalido")
    private String complemento;

    private Estado estado;

    /**
     * Instantiates a new endereco.
     */
    public Endereco() {
    }

    public Endereco(String cep) {
        setCep(cep);
    }

    /**
     * Gets the rua.
     *
     * @return the rua
     */
    public String getRua() {
        return rua;
    }

    /**
     * Sets the rua.
     *
     * @param rua the new rua
     */
    public void setRua(String rua) {
        this.rua = rua;
    }

    /**
     * Gets the numero.
     *
     * @return the numero
     */
    public int getNumero() {
        return numero;
    }

    /**
     * Sets the numero.
     *
     * @param numero the new numero
     */
    public void setNumero(int numero) {
        this.numero = numero;
    }

    /**
     * Gets the bairro.
     *
     * @return the bairro
     */
    public String getBairro() {
        return bairro;
    }

    /**
     * Sets the bairro.
     *
     * @param bairro the new bairro
     */
    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    /**
     * Gets the cep.
     *
     * @return the cep
     */
    public String getCep() {
        return cep;
    }

    /**
     * Sets the cep.
     *
     * @param cep the new cep
     */
    public void setCep(String cep) {
        this.cep = cep;
    }

    /**
     * Gets the complemento.
     *
     * @return the complemento
     */
    public String getComplemento() {
        return complemento;
    }

    /**
     * Sets the complemento.
     *
     * @param complemento the new complemento
     */
    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    /**
     * Gets the estado.
     *
     * @return the estado
     */
    public Estado getEstado() {
        return estado;
    }

    /**
     * Sets the estado.
     *
     * @param estado the new estado
     */
    public void setEstado(Estado estado) {
        this.estado = estado;
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
