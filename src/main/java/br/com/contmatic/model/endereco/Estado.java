package br.com.contmatic.model.endereco;

import static org.apache.commons.lang3.builder.EqualsBuilder.reflectionEquals;
import static org.apache.commons.lang3.builder.HashCodeBuilder.reflectionHashCode;
import static org.apache.commons.lang3.builder.ToStringBuilder.reflectionToString;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.apache.commons.lang3.builder.ToStringStyle;

import br.com.contmatic.model.auditoria.Auditoria;

/**
 * The Class Estado.
 */
public class Estado extends Auditoria {

	/** The nome. */
	@NotNull(message = "Nome do estado não pode ser vazio")
	private EstadoNome nome;

	/** The cidades. */
	@Valid
	@Size(min = 1, message = "Estado deve possuir no minímo 1 cidade")
	private List<Cidade> cidades;

	/** The pais. */
	@Valid
	@NotNull(message = "País do estado não pode ser vazio")
	private Pais pais;

	/**
	 * Instantiates a new cidade.
	 */
	public Estado() {
	}
	
	/**
	 * Instantiates a new estado.
	 *
	 * @param nome the nome
	 * @param pais the pais
	 */
	public Estado(EstadoNome nome, Pais pais) {
		setNome(nome);
		setPais(pais);
	}

	/**
	 * Gets the nome.
	 *
	 * @return the nome
	 */
	public EstadoNome getNome() {
		return this.nome;
	}

	/**
	 * Sets the nome.
	 *
	 * @param nome the new nome
	 */
	public void setNome(EstadoNome nome) {
		this.nome = nome;
	}

	/**
	 * Gets the pais.
	 *
	 * @return the pais
	 */
	public Pais getPais() {
		return this.pais;
	}

	/**
	 * Sets the pais.
	 *
	 * @param pais the new pais
	 */
	public void setPais(Pais pais) {
		this.pais = pais;
	}

	/**
	 * @return the cidades
	 */
	public List<Cidade> getCidades() {
		return cidades;
	}

	/**
	 * @param cidades the cidades to set
	 */
	public void setCidades(List<Cidade> cidades) {
		validarCidadesPertencentesAoEstado(cidades);
		this.cidades = cidades;
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

	/**
	 * Validar cidades pertencentes ao estado.
	 *
	 * @param cidades the cidades
	 */
	private void validarCidadesPertencentesAoEstado(List<Cidade> cidades) {
		for (Cidade cidade : cidades) {
			if (!cidade.getEstado().equals(this)) {
				throw new IllegalStateException(
						String.format("A cidade %s não pertence ao estado %s", cidade.getNome(), this.nome));
			}
		}
	}
}
