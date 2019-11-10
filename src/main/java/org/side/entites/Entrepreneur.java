package org.side.entites;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Entrepreneur")
@Data
public class Entrepreneur implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private final String login;
	@Getter
	private final String password;
	@OneToOne
	private final Civilite civilite;

	@OneToOne
	private Entreprise entreprise;

	public Entrepreneur(String login, String password, Civilite civilite) {
		super();
		this.login = login;
		this.password = password;
		this.civilite = civilite;
	}

}
