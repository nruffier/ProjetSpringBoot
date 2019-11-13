package com.fr.adaming.service.test;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fr.adaming.entity.Projet;
import com.fr.adaming.service.ProjetService;

@Component
public class ProjetServiceTest {
	@Autowired
	private ProjetService projetService;


	Projet projet1 = new Projet("Equipe1", "Projet1");
	Projet projet2 = new Projet("Equipe2", "Projet2");
	Projet projet3 = new Projet("Equipe3", "Projet3");

	public void testAjouter() {
		projet1 = projetService.ajouter(projet1);
		if (projet1 != null) {
			System.out.println("Ajouter SUCCESS");
			projet2 = projetService.ajouter(projet2);
			projet3 = projetService.ajouter(projet3);
		} else {
			System.out.println("Ajouter FAIL");
		}
	}

	public void testAjouter_IfExist() {
		Projet s = projetService.ajouter(projet1);
		if (s == null) {
			System.out.println("Ajouter_ifExist SUCCES");
		} else {
			System.out.println("Ajouter_ifExist FAIL");
		}
	}

	public void testModifier() {
		projet1.setNomEquipe("Equipe1000");
		if (projetService.modifier(projet1)) {
			System.out.println("Modifier SUCCESS");
		} else {
			System.out.println("Modifier FAIL");
		}
	}

	public void testModifier_idDontExist() {
		Projet projet4 = new Projet("Equipe4", "Projet4");
		if (projetService.modifier(projet4)) {
			System.out.println("Modifier FAIL");
		} else {
			System.out.println("Modifier SUCCES");
		}
	}

	public void testAfficher() {
		if (projetService.afficher().isEmpty()) {
			System.out.println("Afficher FAIL");
		} else {
			System.out.println("Afficher SUCCES");
		}
	}

	public void testChercherParId_ifExist() {

		if (projetService.chercherParId(1) != null) {
			System.out.println("ChercherParId_ifExist SUCCES");
		} else {
			System.out.println("ChercherParId FAIL");
		}
	}

	public void testChercherParId_ifDontExist() {

		if (projetService.chercherParId(5) != null) {
			System.out.println("ChercherParId_ifExist FAIL");
		} else {
			System.out.println("ChercherParId_ifExist SUCCES");
		}
	}
	
	public void testChercherParId_ifDeleted() {
		projetService.supprimer(projet2);
		if (projetService.chercherParId(2) != null) {
			System.out.println("ChercherParId_ifDeleted FAIL");
		} else {
			System.out.println("ChercherParId_ifDeleted SUCCES");
		}
	}

	public void testSupprimer() {
		projetService.supprimer(projet3);
		if (projetService.chercherToutId(projet3.getId()).isDeleted()) {
			System.out.println("Supprimer SUCCESS");
		} else {
			System.out.println("Supprimer FAIL");
		}
	}

	public void testSupprimer_ifDontExist() {
		Projet projet8 = new Projet("Equipe8", "Projet8");
		projet8.setId(8);
		if (projetService.supprimer(projet8)) {
			System.out.println("Supprimer_ifDontExist FAIL");
		} else {
			System.out.println("Supprimer_ifDontExist SUCCES");
		}

	}

	public void testChercherToutId() {
		if (projetService.chercherToutId(2) != null) {
			System.out.println("ChercherToutId SUCCES");
		} else {
			System.out.println("ChercherToutId FAIL");
		}
	}
	public void testChercherToutId_ifDontExist() {
		if (projetService.chercherToutId(9) != null) {
			System.out.println("ChercherToutId_ifDontExist FAIL");
		} else {
			System.out.println("ChercherToutId_ifDontExist SUCCES");
		}
	}
	public void testChercherToutId_ifDeleted() {
		projetService.supprimer(projet2);
		if (projetService.chercherToutId(2) != null) {
			System.out.println("ChercherToutId_ifDeleted SUCCES");
		} else {
			System.out.println("ChercherToutId_ifDeleted FAIL");
		}
	}

	public void testAfficherVraimentTout() {
		projetService.supprimer(projet2);
		if (projetService.afficherVraimentTout().get(2) != null) {
		System.out.println("AfficherVraimentTout SUCCES");
		} else {
			System.out.println("AfficherVraimentTout FAIL");
		}
	}

	public void testVraimentSupprimer() {
		projetService.vraimentSupprimer(projet2);
		if (projetService.chercherToutId(2) != null) {
			System.out.println("vraimentSupprimer FAIL");
		} else {
			System.out.println("vraimentSupprimer SUCCES");
		}
	}

	public void testRestaurer() {
		projetService.supprimer(projet3);
		projetService.restaurer(projet3);
		if (projetService.chercherToutId(3).isDeleted()) {
			System.out.println("restaurer FAIL");
		} else {
			System.out.println("Restaurer SUCCES");
		}
	}

}
