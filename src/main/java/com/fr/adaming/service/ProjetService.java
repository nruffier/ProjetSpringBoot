package com.fr.adaming.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.fr.adaming.dao.ProjetDao;
import com.fr.adaming.entity.Projet;

@Service
public class ProjetService {

	@Autowired
	private ProjetDao projetDao;

	public Projet ajouter(Projet projet) {
		if (projetDao.exists(Example.of(projet))) {
			return null;
		} else {
			return projetDao.save(projet);
		}

	}

	public boolean modifier(Projet projet) {
		if (chercherParId(projet.getId()) != null) {
			projetDao.save(projet);
			return true;
		} else {
			return false;
		}
	}

	public boolean supprimer(Projet projet) {
		LocalDateTime date = LocalDateTime.now();
		if (chercherParId(projet.getId()) != null) {
			projetDao.supprimer(projet.getId(), date);
			return true;
		} else {
			return false;
		}
	}

	public void vraimentSupprimer(Projet projet) {
		projetDao.delete(projet);
	}

	public void restaurer(Projet projet) {
		projetDao.restaurer(projet.getId());
	}

	public List<Projet> afficher() {
		return projetDao.listAll();
	}

	public List<Projet> afficherVraimentTout() {
		return projetDao.findAll();
	}

	public Projet chercherParId(Integer id) {
		try {
			return projetDao.findId(id).get();
		} catch (NoSuchElementException e) {
			return null;
		}
	}

	public Projet chercherToutId(Integer id) {
		try {
			return projetDao.findById(id).get();
		} catch (NoSuchElementException e) {
			return null;
		}
	}
}
