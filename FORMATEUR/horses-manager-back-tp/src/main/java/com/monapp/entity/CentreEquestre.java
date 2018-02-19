package com.monapp.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
@Table(name="centre_equestre")
public class CentreEquestre {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column
	private String nom;
	
	@Column
	private String adresse;
	
	@Column
	private String codepostal;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="owner_id")
	private Owner owner;
	
	@OneToMany(mappedBy="centreEquestre", fetch=FetchType.EAGER)
	private List<Cheval> cheval = new ArrayList<Cheval>();

	public CentreEquestre() {}
	
	public CentreEquestre(String nom, String adresse, String codepostal) {
		super();
		this.nom = nom;
		this.adresse = adresse;
		this.codepostal = codepostal;
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

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getCodepostal() {
		return codepostal;
	}

	public void setCodepostal(String codepostal) {
		this.codepostal = codepostal;
	}

	public List<Cheval> getCheval() {
		return cheval;
	}

	public void setCheval(List<Cheval> cheval) {
		this.cheval = cheval;
	}

	public Owner getOwner() {
		return owner;
	}

	public void setOwner(Owner owner) {
		this.owner = owner;
	}


}
