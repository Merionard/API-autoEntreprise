package org.side.dao;

import java.util.Optional;

import org.side.entites.Entrepreneur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface EntrepreneurRepository extends JpaRepository<Entrepreneur, Long> {

	@Query("select e from Entrepreneur e where e.login= :login")
	public Optional<Entrepreneur> getEntrepreneurByLogin(@Param("login") String login);

}
