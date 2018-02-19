package ecommerce.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.OneToOne;
import javax.persistence.Version;

@Entity
public class Login {
	@Id
	@GeneratedValue
	private Long id;
	@Version
	private int version;
	private String login;
	private String motDePasse;
	@Enumerated(EnumType.STRING)
	private Role role;
	@OneToOne
	@JoinColumns({ @JoinColumn(name = "client_nom", referencedColumnName = "nom"),
			@JoinColumn(name = "client_prenom", referencedColumnName = "prenom") })
	private Client client;

	public Login() {
		super();
	}

	public Login(String login, String motDePasse, Role role) {
		super();
		this.login = login;
		this.motDePasse = motDePasse;
		this.role = role;
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

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getMotDePasse() {
		return motDePasse;
	}

	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	

	
}
