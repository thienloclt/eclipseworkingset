package monprojet.cheval.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Version;

@Entity
public class Login {
	@Id
	@GeneratedValue
	private Long id;
	
	@Version
	private int version;
	
	private String login;
	private String passwrd;
	
	@Enumerated(EnumType.STRING)
	private Role role;

	public Login() {
		super();
	}

	public Login(String login, String passwrd, Role role) {
		super();
		this.login = login;
		this.passwrd = passwrd;
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

	public String getpasswrd() {
		return passwrd;
	}

	public void setpasswrd(String passwrd) {
		this.passwrd = passwrd;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}
}
