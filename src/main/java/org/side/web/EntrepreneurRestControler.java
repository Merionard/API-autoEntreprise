package org.side.web;

import java.util.Optional;

import org.side.dao.CiviliteRepository;
import org.side.dao.EntrepreneurRepository;
import org.side.entites.Entrepreneur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
public class EntrepreneurRestControler {

	@Autowired
	private EntrepreneurRepository entrepreneurDao;
	@Autowired
	private CiviliteRepository civiliteDao;

	@RequestMapping(value = "/entrepreneur/{login}", method = RequestMethod.GET)
	public Optional<Entrepreneur> getEntrepreneurByLogin(@PathVariable String login) {

		return entrepreneurDao.getEntrepreneurByLogin(login);

	}

	@RequestMapping(value = "/entrepreneur", method = RequestMethod.POST)
	public Entrepreneur saveEntrepreneur(@RequestBody Entrepreneur entrepreneur) {
		civiliteDao.save(entrepreneur.getCivilite());
		return entrepreneurDao.save(entrepreneur);
	}

}
