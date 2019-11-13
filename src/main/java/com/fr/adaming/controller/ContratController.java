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

import com.fr.adaming.entity.Contrat;
import com.fr.adaming.service.ContratService;

@RestController
@RequestMapping(path = "api/contrat")
public class ContratController {
	@Autowired
	private ContratService service;

	@RequestMapping(path = "/ajouter", method = RequestMethod.POST)
	public String ajouter(@RequestBody Contrat contrat) {
		if (service.ajouter(contrat) != null) {
			return "Ajouter SUCCES";
		} else {
			return "Ajouter FAIL";
		}
	}

	@RequestMapping(path = "/modifier", method = RequestMethod.POST)
	public String modifier(@RequestBody Contrat contrat) {
		if (service.modifier(contrat)) {
			return "Modifier SUCCES";
		} else {
			return "Modifier FAIL";
		}
	}

	@PostMapping(path="/supprimer")
	public boolean supprimer(@RequestBody Contrat contrat) {
		return service.supprimer(contrat);
	}

	@RequestMapping(path="/vraimentsupprimer", method = RequestMethod.DELETE)
	public void vraimentSupprimer(@RequestBody Contrat contrat) {
		service.vraimentSupprimer(contrat);
	}

	@PostMapping(path = "/restaurer")
	public void restaurer(@RequestBody Contrat contrat) {
		service.restaurer(contrat);
	}

	@GetMapping(path = "/afficher")
	public List<Contrat> afficher() {
		return service.afficher();
	}

	@GetMapping(path = "/affichertout")
	public List<Contrat> afficherVraimentTout() {
		return service.afficherVraimentTout();
	}

	@GetMapping(path = "/{id}/chercherid")
	public Contrat chercherParId(@PathVariable(name = "id") Integer id) {
		return service.chercherParId(id);
	}

	@GetMapping(path = "/{id}/cherchertoutid")
	public Contrat chercherToutId(@PathVariable(name = "id") Integer id) {
		return service.chercherToutId(id);
	}
}
