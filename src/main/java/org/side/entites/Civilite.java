package org.side.entites;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Civilite implements Serializable {
	public Civilite() {
		super();
	}

	public Civilite(String nom, String prenom, String adresse, LocalDate dateNaissance) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.dateNaissance = dateNaissance;
	}

	@Id
	private String nom;
	private String prenom;
	private String adresse;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate dateNaissance;

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public LocalDate getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(LocalDate dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

}
