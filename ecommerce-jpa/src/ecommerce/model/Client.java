package ecommerce.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Version;

@Entity
public class Client {
	@EmbeddedId
	private ClientId id;
	@Version
	private int version;
	@Enumerated(EnumType.STRING)
	private Civilite civilite;
	private String email;
	@OneToOne(mappedBy = "client", fetch=FetchType.LAZY)
	private Login login;
	@OneToMany(mappedBy = "client", fetch=FetchType.LAZY)
	private Set<Adresse> adresses = new HashSet<>();

	public Client() {
		super();
	}

	public Client(String nom, String prenom) {
		super();
		this.id = new ClientId(nom, prenom);
	}

	public ClientId getId() {
		return id;
	}

	public void setId(ClientId id) {
		this.id = id;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public Civilite getCivilite() {
		return civilite;
	}

	public void setCivilite(Civilite civilite) {
		this.civilite = civilite;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Login getLogin() {
		return login;
	}

	public void setLogin(Login login) {
		this.login = login;
	}

	public Set<Adresse> getAdresses() {
		return adresses;
	}

	public void setAdresses(Set<Adresse> adresses) {
		this.adresses = adresses;
	}

}
