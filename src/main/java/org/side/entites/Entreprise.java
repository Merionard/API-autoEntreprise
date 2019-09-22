package org.side.entites;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.side.pojo.TypeActivite;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class Entreprise implements Serializable {
	@javax.persistence.Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long Id;

	private String Siret;
	@JsonIgnore
	@ManyToOne
	private Entrepreneur entrepreneur;

	@OneToMany
	private Collection<ChiffreAffaire> chiffresAffaire;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate dateDebut;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate dateFin;

	@JsonProperty
	private boolean isBeneficiaireArce;

	@Enumerated(EnumType.STRING)
	private TypeActivite typeActivite;

	public Entreprise(String siret, Entrepreneur entrepreneur, LocalDate dateDebut, boolean isLiberal,
			boolean isCommercial, boolean isBeneficaireARCE, TypeActivite typeActivite) {
		Siret = siret;
		this.entrepreneur = entrepreneur;
		this.dateDebut = dateDebut;
		isBeneficiaireArce = isBeneficaireARCE;
		this.typeActivite = typeActivite;
	}

	public Entreprise() {
		super();
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getSiret() {
		return Siret;
	}

	public void setSiret(String siret) {
		Siret = siret;
	}

	public Entrepreneur getEntrepreneur() {
		return entrepreneur;
	}

	public void setEntrepreneur(Entrepreneur entrepreneur) {
		this.entrepreneur = entrepreneur;
	}

	public Collection<ChiffreAffaire> getChiffresAffaire() {
		return chiffresAffaire;
	}

	public void setChiffresAffaire(Collection<ChiffreAffaire> chiffresAffaire) {
		this.chiffresAffaire = chiffresAffaire;
	}

	public LocalDate getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(LocalDate dateDebut) {
		this.dateDebut = dateDebut;
	}

	public LocalDate getDateFin() {
		return dateFin;
	}

	public void setDateFin(LocalDate dateFin) {
		this.dateFin = dateFin;
	}

	public boolean isBeneficaireArce() {
		return isBeneficiaireArce;
	}

	public void setBeneficaireARCE(boolean isBeneficaireArce) {
		isBeneficiaireArce = isBeneficaireArce;
	}

	public TypeActivite getTypeActivite() {
		return typeActivite;
	}

	public void setTypeActivite(TypeActivite typeActivite) {
		this.typeActivite = typeActivite;
	}

}
