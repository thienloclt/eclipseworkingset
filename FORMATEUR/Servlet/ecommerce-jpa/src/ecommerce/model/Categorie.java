package ecommerce.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Version;

@Entity
public class Categorie {
	@Id
	@SequenceGenerator(name = "categorieGen", sequenceName = "SEQcategory")
	@GeneratedValue(generator = "categorieGen")
	private Long id;
	@Version
	private int version;
	private String nom;
	@Lob
	@Basic(fetch = FetchType.LAZY)
	@Column(columnDefinition="TEXT")
	private String description;
	@OneToMany(mappedBy = "categorie", fetch = FetchType.EAGER)
	private Set<Produit> produits = new HashSet<>();

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "mere_id")
	private Categorie mere;

	@OneToMany(mappedBy = "mere")
	private List<Categorie> filles = new ArrayList<>();

	public Categorie() {
		super();
	}

	public Categorie(String nom) {
		super();
		this.nom = nom;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Set<Produit> getProduits() {
		return produits;
	}

	public void setProduits(Set<Produit> produits) {
		this.produits = produits;
	}

	public Categorie getMere() {
		return mere;
	}

	public void setMere(Categorie mere) {
		this.mere = mere;
	}

	public List<Categorie> getFilles() {
		return filles;
	}

	public void setFilles(List<Categorie> filles) {
		this.filles = filles;
	}

}
