package com.fr.adaming.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.fr.adaming.dao.SocieteDao;
import com.fr.adaming.entity.Societe;

@Service
public class SocieteService {

	@Autowired
	private SocieteDao societeDao;

	/**
	 * Save a given societe in the database
	 * 
	 * @param societe - the given entity
	 * @return updated societe if the given entity is not already in the database
	 */
	public Societe ajouter(Societe societe) {
		if (societeDao.exists(Example.of(societe))) {
			return null;
		} else {
			return societeDao.save(societe);
		}
	}

	/**
	 * Modify the given entity by Id
	 * 
	 * @param societe - the given entity (must have an id)
	 * @return true is the given entity is in the database and the update is done -
	 *         false if the given entity is not present in the DB
	 */
	public boolean modifier(Societe societe) {
		if (chercherParId(societe.getId()) != null) {
			societeDao.save(societe);
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Switch the state deleted to true
	 * 
	 * @param societe - the given entity
	 */
	public boolean supprimer(Societe societe) {
		LocalDateTime date = LocalDateTime.now();
		if (chercherParId(societe.getId()) != null) {
			societeDao.supprimer(societe.getId(), date);
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Delete the given entity from the database
	 * 
	 * @param societe
	 */
	public void vraimentSupprimer(Societe societe) {
		societeDao.delete(societe);
	}

	/**
	 * Switch the state deleted to false
	 * 
	 * @param societe - the given entity
	 */
	public void restaurer(Societe societe) {
		societeDao.restaurer(societe.getId());
	}

	/**
	 * List
	 * 
	 * @return List<Societe>
	 */
	public List<Societe> afficher() {
		return societeDao.listAll();
	}

	public List<Societe> afficherVraimentTout() {
		return societeDao.findAll();
	}

	public Societe chercherParId(Integer id) {
		try {
			return societeDao.findId(id).get();
		} catch (NoSuchElementException e) {
			return null;
		}
	}

	public Societe chercherToutId(Integer id) {
		try {
			return societeDao.findById(id).get();
		} catch (NoSuchElementException e) {
			return null;
		}
	}

	public List<Societe> chercherParNom(String nom) {
		return societeDao.findByNom(nom);
	}
}
