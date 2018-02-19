package ecommerce.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Version;

@Entity
public class Commande {
	@Id
	@GeneratedValue
	private Long id;
	@Version
	private int version;
	private Integer nbProduits;
	private Double prixTotal;
	private Date date;
	@ManyToOne
	@JoinColumn(name = "facturation_id")
	private Adresse facturation;
	@ManyToOne
	@JoinColumn(name = "livraison_id")
	private Adresse livraison;
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name="type", column=@Column(name="cmd_type"))
	})
	private CarteBancaire carteBancaire;
	@OneToMany(mappedBy="commande")
	private List<LigneCommande> ligneCommandes = new ArrayList<>();

	public Commande() {
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

	public Integer getNbProduits() {
		return nbProduits;
	}

	public void setNbProduits(Integer nbProduits) {
		this.nbProduits = nbProduits;
	}

	public Double getPrixTotal() {
		return prixTotal;
	}

	public void setPrixTotal(Double prixTotal) {
		this.prixTotal = prixTotal;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Adresse getFacturation() {
		return facturation;
	}

	public void setFacturation(Adresse facturation) {
		this.facturation = facturation;
	}

	public Adresse getLivraison() {
		return livraison;
	}

	public void setLivraison(Adresse livraison) {
		this.livraison = livraison;
	}

	public List<LigneCommande> getLigneCommandes() {
		return ligneCommandes;
	}

	public void setLigneCommandes(List<LigneCommande> ligneCommandes) {
		this.ligneCommandes = ligneCommandes;
	}
	
	

}
