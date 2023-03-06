package com.inti;

import java.time.LocalDate;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
// methode 1
//@DiscriminatorValue("1")

// methode 2
//@Table
//@PrimaryKeyJoinColumn(name = "idPaiement")

// methode 3 
@Table
public class Paypal extends Paiement {

	private int numeroCompte;
	

	public Paypal() {
		super();
	}

	public Paypal(int numeroCompte) {
		super();
		this.numeroCompte = numeroCompte;
	}
	

	public Paypal(double montant, LocalDate date, int numeroCompte) {
		super(montant, date);
		this.numeroCompte = numeroCompte;
	}

	public int getNumeroCompte() {
		return numeroCompte;
	}

	public void setNumeroCompte(int numeroCompte) {
		this.numeroCompte = numeroCompte;
	}

	@Override
	public String toString() {
		return "Paypal [numeroCompte=" + numeroCompte + "]";
	}
	
	
}
