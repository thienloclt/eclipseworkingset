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

	private String name;
	private String remarque;
	
	@ManyToOne
	@JoinColumn(name = "centreEquestre_id")
	private CentreEquestre centreEquestre;
	
	@OneToOne(mappedBy = "cheval")
	private Registre registre;

	public Cheval() {
		super();
	}

	public Cheval(String name, String remarque) {
		super();
		this.name = name;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
}
