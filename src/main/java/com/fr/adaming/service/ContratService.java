package com.fr.adaming.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.fr.adaming.dao.ContratDao;
import com.fr.adaming.entity.Client;
import com.fr.adaming.entity.Contrat;

@Service
public class ContratService {

	@Autowired
	private ContratDao contratDao;

	public Contrat ajouter(Contrat contrat) {
		if (contratDao.exists(Example.of(contrat))) {
			return null;
		} else {
		return contratDao.save(contrat);
		}
	}

	public boolean modifier(Contrat contrat) {
		if (chercherParId(contrat.getId()) != null) {
			contratDao.save(contrat);
			return true;
		} else {
			return false;
		}
	}
	
	public boolean supprimer(Contrat contrat) {
		LocalDateTime date = LocalDateTime.now();
		if (chercherParId(contrat.getId()) != null) {
		contratDao.supprimer(contrat.getId(), date);
		return true;
		} else {
			return false;
		}
	}
	
	public void vraimentSupprimer(Contrat contrat) {
		contratDao.delete(contrat);
	}
	
	public void restaurer(Contrat contrat) {
		contratDao.restaurer(contrat.getId());
	}
	
	public List<Contrat> afficher() {
		return contratDao.listAll();
	}
	
	public List<Contrat> afficherVraimentTout() {
		return contratDao.findAll();
	}
	
	public Contrat chercherParId(Integer id) {
		try {
		return contratDao.findId(id).get();
	} catch (NoSuchElementException e) {
		return null;
	}
	}
	
	public Contrat chercherToutId(Integer id) {
		try {
		return contratDao.findById(id).get();
	} catch (NoSuchElementException e) {
		return null;
	}
	}
	
	public List<Contrat> chercherParClient(Client client) {
		return contratDao.findByclientC(client);
	}
}
