package org.side.entites;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.side.pojo.TypeActivite;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Entreprise implements Serializable {
	@javax.persistence.Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long Id;

	private String Siret;
	@JsonIgnore
	@ManyToOne
	private Entrepreneur entrepreneur;

	@JsonIgnore
	@OneToMany(mappedBy = "entreprise")
	private Collection<ChiffreAffaire> chiffresAffaire;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate dateDebut;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate dateFin;

	private boolean isLiberal;

	private boolean isCommercial;

	private boolean isBeneficaireARCE;

	private TypeActivite typeActivite;

	public Entreprise(String siret, Entrepreneur entrepreneur, LocalDate dateDebut, boolean isLiberal,
			boolean isCommercial, boolean isBeneficaireARCE, TypeActivite typeActivite) {
		Siret = siret;
		this.entrepreneur = entrepreneur;
		this.dateDebut = dateDebut;
		this.isLiberal = isLiberal;
		this.isCommercial = isCommercial;
		this.isBeneficaireARCE = isBeneficaireARCE;
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

	public boolean isLiberal() {
		return isLiberal;
	}

	public void setLiberal(boolean isLiberal) {
		this.isLiberal = isLiberal;
	}

	public boolean isCommercial() {
		return isCommercial;
	}

	public void setCommercial(boolean isCommercial) {
		this.isCommercial = isCommercial;
	}

	public boolean isBeneficaireARCE() {
		return isBeneficaireARCE;
	}

	public void setBeneficaireARCE(boolean isBeneficaireARCE) {
		this.isBeneficaireARCE = isBeneficaireARCE;
	}

	public TypeActivite getTypeActivite() {
		return typeActivite;
	}

	public void setTypeActivite(TypeActivite typeActivite) {
		this.typeActivite = typeActivite;
	}

}
