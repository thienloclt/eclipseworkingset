package ecommerce.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Version;

@Entity
public class LigneCommande {
	@Id
	@SequenceGenerator(name = "ligneCommandeGen", sequenceName = "SEQcommandLine")
	@GeneratedValue(generator = "ligneCommandeGen")
	private Long id;
	@Version
	private int version;
	private Integer quantite;
	private Double montant;
	@ManyToOne
	@JoinColumn(name = "commande_id")
	private Commande commande;
	@ManyToOne
	@JoinColumn(name = "produit_id")
	private Produit produit;

	public LigneCommande() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public Integer getQuantite() {
		return quantite;
	}

	public void setQuantite(Integer quantite) {
		this.quantite = quantite;
	}

	public Double getMontant() {
		return montant;
	}

	public void setMontant(Double montant) {
		this.montant = montant;
	}

	public Commande getCommande() {
		return commande;
	}

	public void setCommande(Commande commande) {
		this.commande = commande;
	}

	public Produit getProduit() {
		return produit;
	}

	public void setProduit(Produit produit) {
		this.produit = produit;
	}

}
