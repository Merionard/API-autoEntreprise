package org.side.entites;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Collection;
import java.util.HashSet;

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

import lombok.Data;
import lombok.experimental.Accessors;

@Entity
@Data
public class Entreprise implements Serializable {
	@javax.persistence.Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long Id;

	private String Siret;
	@JsonIgnore
	@ManyToOne
	private Entrepreneur entrepreneur;

	@OneToMany(mappedBy = "entreprise")
	private final Collection<ChiffreAffaire> chiffresAffaire = new HashSet<>();

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

	public Entreprise setChiffresAffaire(ChiffreAffaire ca) {
		this.getChiffresAffaire().add(ca);
		return this;
	}

}
