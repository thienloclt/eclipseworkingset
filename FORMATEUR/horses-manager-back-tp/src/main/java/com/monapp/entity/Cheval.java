package com.monapp.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
@Table(name="cheval")
public class Cheval {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String nom;
	private String remarque;

	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="centre_equestre_id")
	private CentreEquestre centreEquestre;
	
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="registre_id")
	private Registre registre;
	
	public Cheval() {}
	
	public Cheval(String nom, String remarque) {
		super();
		this.nom = nom;
		this.remarque = remarque;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
	
}
