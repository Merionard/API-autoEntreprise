package org.side.entites;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.side.pojo.TypeActivite;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ChargeGenerale {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private TypeActivite typeActivite;

	private double taux;
}
