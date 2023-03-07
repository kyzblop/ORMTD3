package com.inti;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table
public class Article {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idArticle;
	private String nom;
	private double prix;
	
	@ManyToOne
	@JoinColumn(name = "idCom")
	private Commande commande;
	
	public Article() {
		super();
	}
	
	public Article(String nom, double prix) {
		super();
		this.nom = nom;
		this.prix = prix;
	}
	public int getIdArticle() {
		return idArticle;
	}
	public void setIdArticle(int idArticle) {
		this.idArticle = idArticle;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public double getPrix() {
		return prix;
	}
	public void setPrix(double prix) {
		this.prix = prix;
	}
	@Override
	public String toString() {
		return "Article [idArticle=" + idArticle + ", nom=" + nom + ", prix=" + prix + "]";
	}
	
	
	
}
