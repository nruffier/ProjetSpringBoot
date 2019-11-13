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

import com.fr.adaming.entity.Societe;
import com.fr.adaming.service.SocieteService;

@RestController
@RequestMapping(path = "api/societe")
public class SocieteController {
	@Autowired
	private SocieteService service;

	@RequestMapping(path = "/ajouter", method = RequestMethod.POST)
	public String ajouter(@RequestBody Societe societe) {
		if (service.ajouter(societe) != null) {
			return "Ajouter SUCCES";
		} else {
			return "Ajouter FAIL";
		}
	}

	@RequestMapping(path = "/modifier", method = RequestMethod.POST)
	public String modifier(@RequestBody Societe societe) {
		if (service.modifier(societe)) {
			return "Modifier SUCCES";
		} else {
			return "Modifier FAIL";
		}
	}

	@PostMapping(path="/supprimer")
	public boolean supprimer(@RequestBody Societe societe) {
		return service.supprimer(societe);
	}

	@RequestMapping(path="/vraimentsupprimer", method = RequestMethod.DELETE)
	public void vraimentSupprimer(@RequestBody Societe societe) {
		service.vraimentSupprimer(societe);
	}

	@PostMapping(path = "/restaurer")
	public void restaurer(@RequestBody Societe societe) {
		service.restaurer(societe);
	}

	@GetMapping(path = "/afficher")
	public List<Societe> afficher() {
		return service.afficher();
	}

	@GetMapping(path = "/affichertout")
	public List<Societe> afficherVraimentTout() {
		return service.afficherVraimentTout();
	}

	@GetMapping(path = "/{id}/chercherid")
	public Societe chercherParId(@PathVariable(name = "id") Integer id) {
		return service.chercherParId(id);
	}

	@GetMapping(path = "/{id}/cherchertoutid")
	public Societe chercherToutId(@PathVariable(name = "id") Integer id) {
		return service.chercherToutId(id);
	}
}
