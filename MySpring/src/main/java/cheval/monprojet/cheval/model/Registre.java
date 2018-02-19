package monprojet.cheval.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Version;

@Entity
public class Registre {
	@Id
	@GeneratedValue
	private Long id;

	@Version
	private int version;

	private String numero;
	private Date dateDelivrance;
	
	@OneToOne
	@JoinColumn(name="cheval_id")
	private Cheval cheval;
	
	public Registre() {
		super();
	}

	public Registre(String numero, Date date) {
		super();
		this.numero = numero;
		this.dateDelivrance = date;
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

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public Date getDateDelivrance() {
		return dateDelivrance;
	}

	public void setDateDelivrance(Date dateDelivrance) {
		this.dateDelivrance = dateDelivrance;
	}

	public Cheval getCheval() {
		return cheval;
	}

	public void setCheval(Cheval cheval) {
		this.cheval = cheval;
	}
	
}
