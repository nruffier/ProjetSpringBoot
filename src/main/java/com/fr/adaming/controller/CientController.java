package com.fr.adaming.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fr.adaming.entity.Client;
import com.fr.adaming.service.ClientService;

@RestController
@RequestMapping(path = "api/client")
public class CientController {

	@Autowired
	private ClientService service;

	@RequestMapping(path = "/ajouter", method = RequestMethod.POST)
	public String ajouter(@RequestBody Client client) {
		if (service.ajouter(client) != null) {
			return "Ajouter SUCCES";
		} else {
			return "Ajouter FAIL";
		}
	}

	@RequestMapping(path = "/modifier", method = RequestMethod.POST)
	public String modifier(@RequestBody Client client) {
		if (service.modifier(client)) {
			return "Modifier SUCCES";
		} else {
			return "Modifier FAIL";
		}
	}

	@PostMapping(path="/supprimer")
	public boolean supprimer(@RequestBody Client client) {
		return service.supprimer(client);
	}

	@RequestMapping(path="/vraimentsupprimer", method = RequestMethod.DELETE)
	public void vraimentSupprimer(@RequestBody Client client) {
		service.vraimentSupprimer(client);
	}

	@PostMapping(path = "/restaurer")
	public void restaurer(@RequestBody Client client) {
		service.restaurer(client);
	}

	@GetMapping(path = "/afficher")
	public List<Client> afficher() {
		return service.afficher();
	}

	@GetMapping(path = "/affichertout")
	public List<Client> afficherVraimentTout() {
		return service.afficherVraimentTout();
	}

	@GetMapping(path = "/{id}/chercherid")
	public Client chercherParId(@PathVariable(name = "id") Integer id) {
		return service.chercherParId(id);
	}

	@GetMapping(path = "/{id}/cherchertoutid")
	public Client chercherToutId(@PathVariable(name = "id") Integer id) {
		return service.chercherToutId(id);
	}

	@GetMapping(path = "/{nom}/cherchernom")
	public List<Client> chercherParNom(@PathVariable(name = "nom") String nom) {
		return service.chercherParNom(nom);
	}

//	public boolean equals(Object obj) {
//		return service.equals(obj);
//	}
	
	
	
}
