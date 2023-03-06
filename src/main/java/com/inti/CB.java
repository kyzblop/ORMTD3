package com.inti;

import java.time.LocalDate;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
// methode 1
//@DiscriminatorValue("2")

// methode 2
//@Table
//@PrimaryKeyJoinColumn(name = "idPaiement")

// methode 3
@Table
public class CB extends Paiement{

	private int numeroCarte;
	private LocalDate dateExpiration;
	public CB() {
		super();
	}
	public CB(int numeroCarte, LocalDate dateExpiration) {
		super();
		this.numeroCarte = numeroCarte;
		this.dateExpiration = dateExpiration;
	}
	
	public CB(double montant, LocalDate date, int numeroCarte, LocalDate dateExpiration) {
		super(montant, date);
		this.numeroCarte = numeroCarte;
		this.dateExpiration = dateExpiration;
	}
	public int getNumeroCarte() {
		return numeroCarte;
	}
	public void setNumeroCarte(int numeroCarte) {
		this.numeroCarte = numeroCarte;
	}
	public LocalDate getDateExpiration() {
		return dateExpiration;
	}
	public void setDateExpiration(LocalDate dateExpiration) {
		this.dateExpiration = dateExpiration;
	}
	@Override
	public String toString() {
		return "CB [numeroCarte=" + numeroCarte + ", dateExpiration=" + dateExpiration + "]";
	}
	
	
}
