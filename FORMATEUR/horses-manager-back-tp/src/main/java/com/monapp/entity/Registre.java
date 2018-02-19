package com.monapp.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
@Table(name="registre")
public class Registre {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "dateDelivrance")	
	private Date dateDelivrance;

	public Registre() {}
	
	public Registre(Date dateDelivrance) {
		super();
		this.dateDelivrance = dateDelivrance;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
	@OneToOne(mappedBy="registre",fetch=FetchType.EAGER)
	private Cheval cheval;
	

}
