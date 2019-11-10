package org.side.dao;

import java.util.List;

import org.side.entites.ChiffreAffaire;
import org.side.entites.Entreprise;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChiffreAffaireRepository extends JpaRepository<ChiffreAffaire, Long> {

	public List<ChiffreAffaire> findAllByEntrepriseAndAnnee(Entreprise entreprise, int annee);

}
