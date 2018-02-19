package com.monapp.metier;



import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="cd")
public class CD 
{
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
	
	private String nom;
	
	private int anneeProduction;

	private int nombrePistes;
	
	@ManyToOne()
	@JoinColumn(name="artiste_id")
	private Artiste artiste;

	
	public CD(){}

	public CD(String nom, int anneeProduction, int nombrePistes, Artiste monArtiste) 
	{
		this.nom = nom;
		this.anneeProduction = anneeProduction;
		this.nombrePistes = nombrePistes;
		this.artiste = monArtiste;
	}
	
	public CD(String nom, int anneeProduction, int nombrePistes) 
	{
		this.nom = nom;
		this.anneeProduction = anneeProduction;
		this.nombrePistes = nombrePistes;
	}

	public int getId() 
	{
		return id;
	}

	public void setId(int id) 
	{
		this.id = id;
	}

	public String getNom() 
	{
		return nom;
	}

	public void setNom(String nom) 
	{
		this.nom = nom;
	}

	public int getNombrePistes() 
	{
		return nombrePistes;
	}

	public void setNombrePistes(int nombrePistes) 
	{
		this.nombrePistes = nombrePistes;
	}

	public int getAnneeProduction() {
		return anneeProduction;
	}

	public void setAnneeProduction(int anneeProduction) {
		this.anneeProduction = anneeProduction;
	}

	public Artiste getArtiste() {
		return artiste;
	}

	public void setArtiste(Artiste artiste) {
		this.artiste = artiste;
	}


}
