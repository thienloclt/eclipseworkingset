package ecommerce.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SecondaryTable;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name = "produit")
@SecondaryTable(name = "produit_bis")
@NamedQueries({
		@NamedQuery(name = "Produit.findAllByPrix", query = "select p from Produit p where p.prix >= :min and p.prix <= :max") })
public class Produit {
	@Id
	@SequenceGenerator(name = "produitGen", sequenceName = "SEQproduct")
	@GeneratedValue(generator = "produitGen")
	private Long id;
	@Version
	private int version;
	private String nom;
	private Double prix;
	@Lob
	@Basic(fetch = FetchType.LAZY)
	@Column(table = "produit_bis")
	private String description;
	private Integer stock;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "categorie_id")
	private Categorie categorie;
	@OneToMany(mappedBy = "produit")
	private List<LigneCommande> ligneCommandes = new ArrayList<>();

	public Produit() {
		super();
	}

	public Produit(String nom, Double prix, Integer stock) {
		super();
		this.nom = nom;
		this.prix = prix;
		this.stock = stock;
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

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Double getPrix() {
		return prix;
	}

	public void setPrix(Double prix) {
		this.prix = prix;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

	public Categorie getCategorie() {
		return categorie;
	}

	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}

	public List<LigneCommande> getLigneCommandes() {
		return ligneCommandes;
	}

	public void setLigneCommandes(List<LigneCommande> ligneCommandes) {
		this.ligneCommandes = ligneCommandes;
	}

}
