package com.bookmanager.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


@Entity
@Table(name="book")
public class Book {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column
	private String titre;

	@Column
	private String isbn;
	
	@Column
	private int nbrPages;

	public Book(String titre, String isbn, int nbrPages) {
		super();
		this.nbrPages = nbrPages;
		this.isbn = isbn;
		this.titre = titre;
	}
	public Book() {}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public int getNbrPages() {
		return nbrPages;
	}
	public void setNbrPages(int nbrPages) {
		this.nbrPages = nbrPages;
	}




	
}
