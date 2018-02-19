package com.monapp.metier;

import java.util.*;

import javax.persistence.*;

@Entity
@Table(name="artiste")
public class Artiste 
{
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
	
	
	@Column(name="nom")
	private String nom;
	
	@Column(name="prenom")
	private String prenom;
	
	@OneToMany(mappedBy="artiste", fetch=FetchType.EAGER, cascade = CascadeType.ALL)
	private List<CD> CDs=new ArrayList<CD>();
	
	public List<CD> getCDs() {
		return CDs;
	}

	public void setCDs(List<CD> cDs) {
		CDs = cDs;
	}

	public Artiste()
	{
		
	}

	public Artiste(String nom, String prenom) 
	{
		this.nom = nom;
		this.prenom = prenom;
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

	public String getPrenom() 
	{
		return prenom;
	}

	public void setPrenom(String prenom) 
	{
		this.prenom = prenom;
	}
	
	public String toString() 
	{
		return "Artiste[id: " + id + ", nom: " + nom + ", prenom: " + prenom +"]";
	}
	public String getFullName() {
		return this.prenom +" "+this.getNom();
	}
	
}
