package ecommerce.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class CarteBancaire {
	@Column(name="type")
	private Type type;
	private Long numero;
	private Integer moisExpiration;
	private Integer anneeExpiration;
	private Integer cvc;

	public CarteBancaire() {
		super();
	}

	public CarteBancaire(Type type, Long numero, Integer moisExpiration, Integer anneeExpiration, Integer cvc) {
		super();
		this.type = type;
		this.numero = numero;
		this.moisExpiration = moisExpiration;
		this.anneeExpiration = anneeExpiration;
		this.cvc = cvc;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public Long getNumero() {
		return numero;
	}

	public void setNumero(Long numero) {
		this.numero = numero;
	}

	public Integer getMoisExpiration() {
		return moisExpiration;
	}

	public void setMoisExpiration(Integer moisExpiration) {
		this.moisExpiration = moisExpiration;
	}

	public Integer getAnneeExpiration() {
		return anneeExpiration;
	}

	public void setAnneeExpiration(Integer anneeExpiration) {
		this.anneeExpiration = anneeExpiration;
	}

	public Integer getCvc() {
		return cvc;
	}

	public void setCvc(Integer cvc) {
		this.cvc = cvc;
	}

}
