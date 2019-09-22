package org.side.web;

import java.util.List;

import org.side.dao.EntrepreneurRepository;
import org.side.dao.EntrepriseRepository;
import org.side.entites.Entreprise;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
public class EntrepriseRestControler {

	@Autowired
	private EntrepriseRepository entrepriseDao;
	@Autowired
	private EntrepreneurRepository entrepreneurDao;

	@RequestMapping(value = "/entreprise/{id}", method = RequestMethod.GET)
	public List<Entreprise> getListeEntrepriseByEntrepreneurId(@PathVariable Long id) {
		return entrepriseDao.getEntrepriseByEntrepreneurId(id);
	}

	@RequestMapping(value = "/entreprise/{idEntrepreneur}", method = RequestMethod.POST)
	public Entreprise saveEntreprise(@RequestBody Entreprise entreprise, @PathVariable Long idEntrepreneur) {
		entreprise.setEntrepreneur(entrepreneurDao.getOne(idEntrepreneur));
		return entrepriseDao.save(entreprise);
	}

}
