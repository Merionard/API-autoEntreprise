package org.side.dao;

import java.util.List;

import org.side.entites.Entreprise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface EntrepriseRepository extends JpaRepository<Entreprise, Long> {

	@Query("select e from Entreprise e where e.entrepreneur.id = :id")
	public List<Entreprise> getEntrepriseByEntrepreneurId(@Param("id") Long id);

}
