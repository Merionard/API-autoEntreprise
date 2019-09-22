package org.side.entites;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Entrepreneur")
public class Entrepreneur implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String login;

	private String password;
	@OneToOne
	private Civilite civilite;

	@OneToMany(mappedBy = "entrepreneur")
	private Collection<Entreprise> entreprise;

	public Entrepreneur(String login, String password, Civilite civilite) {
		super();
		this.login = login;
		this.password = password;
		this.civilite = civilite;
	}

	public Long getId() {
		return id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Civilite getCivilite() {
		return civilite;
	}

	public void setCivilite(Civilite civilite) {
		this.civilite = civilite;
	}

	public Collection<Entreprise> getEntreprise() {
		return entreprise;
	}

	public void setEntreprise(Collection<Entreprise> entreprise) {
		this.entreprise = entreprise;
	}

	public Entrepreneur() {
		super();
	}

}
