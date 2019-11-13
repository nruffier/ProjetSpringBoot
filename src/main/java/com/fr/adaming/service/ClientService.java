package com.fr.adaming.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.fr.adaming.dao.ClientDao;
import com.fr.adaming.entity.Client;

@Service
public class ClientService {

	@Autowired
	private ClientDao clientDao;

	public Client ajouter(Client client) {
		if (clientDao.exists(Example.of(client))) {
			return null;
		} else {
		return clientDao.save(client);
		}
	}

	public boolean modifier(Client client) {
		if (chercherParId(client.getId()) != null) {
			clientDao.save(client);
			return true;
		} else {
			return false;
		}
	}
	
	public boolean supprimer(Client client) {
		LocalDateTime date = LocalDateTime.now();
		if (chercherParId(client.getId()) != null) {
		clientDao.supprimer(client.getId(), date);
		return true;
		} else {
			return false;
		}
	}
	
	public void vraimentSupprimer(Client client) {
		clientDao.delete(client);
	}
	
	public void restaurer(Client client) {
		clientDao.restaurer(client.getId());
	}
	
	public List<Client> afficher() {
		return clientDao.listAll();
	}
	
	public List<Client> afficherVraimentTout() {
		return clientDao.findAll();
	}
	
	public Client chercherParId(Integer id) {
		try {
		return clientDao.findId(id).get();
	} catch (NoSuchElementException e) {
		return null;
	}
	}
	
	public Client chercherToutId(Integer id) {
		try {
		return clientDao.findById(id).get();
		} catch (NoSuchElementException e) {
			return null;
		}
	}
	
	public List<Client> chercherParNom(String nom) {
		return clientDao.findByNom(nom);
	}
}
