package ecommerce.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Version;

@Entity
public class Adresse {
	@Id
	@GeneratedValue
	private Long id;
	@Version
	private int version;
	@Column(length = 255)
	private String rue;
	@Column(length = 10)
	private String codePostal;
	@Column(length = 100)
	private String ville;
	@ManyToOne
	@JoinColumns({ @JoinColumn(name = "client_nom", referencedColumnName = "nom"),
			@JoinColumn(name = "client_prenom", referencedColumnName = "prenom") })
	private Client client;

	public Adresse() {
		super();
	}

	public Adresse(String rue, String codePostal, String ville) {
		super();
		this.rue = rue;
		this.codePostal = codePostal;
		this.ville = ville;
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

	public String getRue() {
		return rue;
	}

	public void setRue(String rue) {
		this.rue = rue;
	}

	public String getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

}
