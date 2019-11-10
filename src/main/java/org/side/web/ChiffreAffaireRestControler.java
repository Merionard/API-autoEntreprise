package org.side.web;

import java.util.List;
import java.util.Optional;

import org.side.dao.ChiffreAffaireRepository;
import org.side.dao.EntrepriseRepository;
import org.side.entites.ChiffreAffaire;
import org.side.entites.Entreprise;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
public class ChiffreAffaireRestControler {

	@Autowired
	private ChiffreAffaireRepository caDao;

	@Autowired
	private EntrepriseRepository entrepriseDao;

	@RequestMapping(value = "/chiffreAffaire/{idEntreprise}/{annee}", method = RequestMethod.GET)
	public List<ChiffreAffaire> getCaByIdEntrepriseAndAnnee(@PathVariable Long idEntreprise, int annee) {

		final Optional<Entreprise> entreprise = entrepriseDao.findById(idEntreprise);
		return caDao.findAllByEntrepriseAndAnnee(entreprise.get(), annee);

	}

	@RequestMapping(value = "/chiffreAffaire/{idEntreprise}/", method = RequestMethod.POST)
	public ChiffreAffaire saveChiffreAffaire(@PathVariable Long idEntreprise, ChiffreAffaire ca) {
		final Optional<Entreprise> entreprise = entrepriseDao.findById(idEntreprise);
		entreprise.ifPresent(e -> entrepriseDao.save(e.setChiffresAffaire(ca)));

		return entreprise.isPresent() ? ca : null;
	}

}
