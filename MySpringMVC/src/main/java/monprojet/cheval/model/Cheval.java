package monprojet.cheval.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Version;

@Entity
public class Cheval {
	@Id
	@GeneratedValue
	private Long id;

	@Version
	private int version;

	private String nom;
	private String remarque;

	@ManyToOne
	@JoinColumn(name = "centreEquestre_id")
	private CentreEquestre centreEquestre;

	@OneToOne
	@JoinColumn(name = "registre_id")
	private Registre registre;

	public Cheval() {
		super();
	}

	public Cheval(String name, String remarque) {
		super();
		this.nom = name;
		this.remarque = remarque;
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

	public String getRemarque() {
		return remarque;
	}

	public void setRemarque(String remarque) {
		this.remarque = remarque;
	}

	public CentreEquestre getCentreEquestre() {
		return centreEquestre;
	}

	public void setCentreEquestre(CentreEquestre centreEquestre) {
		this.centreEquestre = centreEquestre;
	}
	
	public Registre getRegistre() {
		return registre;
	}

	public void setRegistre(Registre registre) {
		this.registre = registre;
	}

	@Override
	public String toString() {
		return "Cheval [nom=" + nom + ", remarque=" + remarque + "]";
	}
}
