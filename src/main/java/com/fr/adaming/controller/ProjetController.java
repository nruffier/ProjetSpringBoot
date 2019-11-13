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

import com.fr.adaming.entity.Projet;
import com.fr.adaming.service.ProjetService;

@RestController
@RequestMapping(path = "api/projet")
public class ProjetController {
	@Autowired
	private ProjetService service;

	@RequestMapping(path = "/ajouter", method = RequestMethod.POST)
	public String ajouter(@RequestBody Projet projet) {
		if (service.ajouter(projet) != null) {
			return "Ajouter SUCCES";
		} else {
			return "Ajouter FAIL";
		}
	}

	@RequestMapping(path = "/modifier", method = RequestMethod.POST)
	public String modifier(@RequestBody Projet projet) {
		if (service.modifier(projet)) {
			return "Modifier SUCCES";
		} else {
			return "Modifier FAIL";
		}
	}

	@PostMapping(path="/supprimer")
	public boolean supprimer(@RequestBody Projet projet) {
		return service.supprimer(projet);
	}

	@RequestMapping(path="/vraimentsupprimer", method = RequestMethod.DELETE)
	public void vraimentSupprimer(@RequestBody Projet projet) {
		service.vraimentSupprimer(projet);
	}

	@PostMapping(path = "/restaurer")
	public void restaurer(@RequestBody Projet projet) {
		service.restaurer(projet);
	}

	@GetMapping(path = "/afficher")
	public List<Projet> afficher() {
		return service.afficher();
	}

	@GetMapping(path = "/affichertout")
	public List<Projet> afficherVraimentTout() {
		return service.afficherVraimentTout();
	}

	@GetMapping(path = "/{id}/chercherid")
	public Projet chercherParId(@PathVariable(name = "id") Integer id) {
		return service.chercherParId(id);
	}

	@GetMapping(path = "/{id}/cherchertoutid")
	public Projet chercherToutId(@PathVariable(name = "id") Integer id) {
		return service.chercherToutId(id);
	}

}
