package com.inti;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table
public class Commande {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idCommande;
	private LocalDate date;
	
	@ManyToOne
	@JoinColumn(name = "idU")
	private Utilisateur utilisateur;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "idP")
	private Paiement paiement;
	
	@OneToMany(mappedBy = "commande", targetEntity = Article.class)
	private List<Article> listeArticle;
	
	public Commande() {
		super();
	}
	
	public Commande(LocalDate date, Utilisateur utilisateur,List<Article> listeArticle) {
		super();
		this.date = date;
		this.utilisateur = utilisateur;
		this.listeArticle = listeArticle;
	}
	public int getIdCommande() {
		return idCommande;
	}
	public void setIdCommande(int idCommande) {
		this.idCommande = idCommande;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	
	public Utilisateur getUtilisateur() {
		return utilisateur;
	}
	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}
	
	public Paiement getPaiement() {
		return paiement;
	}
	public void setPaiement(Paiement paiement) {
		this.paiement = paiement;
	}
	public List<Article> getListeArticle() {
		return listeArticle;
	}
	public void setListeArticle(List<Article> listeArticle) {
		this.listeArticle = listeArticle;
	}
	@Override
	public String toString() {
		return "Commande [idCommande=" + idCommande + ", date=" + date + "]";
	}
	
	
}
