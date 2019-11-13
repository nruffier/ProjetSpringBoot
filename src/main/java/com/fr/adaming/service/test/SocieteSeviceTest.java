package com.fr.adaming.service.test;

import java.time.LocalDate;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fr.adaming.entity.Societe;
import com.fr.adaming.service.SocieteService;


@Component
public class SocieteSeviceTest {
	private static final Logger logger = LogManager.getLogger(SocieteSeviceTest.class);
	
	@Autowired
	private SocieteService societeService;


	
	
	Societe societe1 = new Societe("Adaming1", "coucou", LocalDate.of(2009, 12, 21));
	Societe societe2 = new Societe("Adaming2", "coucou", LocalDate.of(2009, 12, 21));
	Societe societe3 = new Societe("Adaming3", "coucou", LocalDate.of(2009, 12, 21));

	public void testAjouter() {
		societe1 = societeService.ajouter(societe1);
		if (societe1 != null) {
			System.out.println("Ajouter SUCCESS");
			logger.debug("Coucou");
			societe2 = societeService.ajouter(societe2);
			societe3 = societeService.ajouter(societe3);
		} else {
			System.out.println("Ajouter FAIL");
		}
	}

	public void testAjouter_IfExist() {
		Societe s = societeService.ajouter(societe1);
		if (s == null) {
			System.out.println("Ajouter_ifExist SUCCES");
		} else {
			System.out.println("Ajouter_ifExist FAIL");
		}
	}

	public void testModifier() {
		societe1.setNom("SOPRA");
		if (societeService.modifier(societe1)) {
			System.out.println("Modifier SUCCESS");
		} else {
			System.out.println("Modifier FAIL");
		}
	}

	public void testModifier_idDontExist() {
		Societe societe4 = new Societe("Adaming4", "coucou", LocalDate.of(2009, 12, 21));
		if (societeService.modifier(societe4)) {
			System.out.println("Modifier FAIL");
		} else {
			System.out.println("Modifier SUCCES");
		}
	}

	public void testAfficher() {
		if (societeService.afficher().isEmpty()) {
			System.out.println("Afficher FAIL");
		} else {
			System.out.println("Afficher SUCCES");
		}
	}

	public void testChercherParId_ifExist() {

		if (societeService.chercherParId(1) != null) {
			System.out.println("ChercherParId_ifExist SUCCES");
		} else {
			System.out.println("ChercherParId FAIL");
		}
	}

	public void testChercherParId_ifDontExist() {

		if (societeService.chercherParId(5) != null) {
			System.out.println("ChercherParId_ifExist FAIL");
		} else {
			System.out.println("ChercherParId_ifExist SUCCES");
		}
	}
	
	public void testChercherParId_ifDeleted() {
		societeService.supprimer(societe2);
		if (societeService.chercherParId(2) != null) {
			System.out.println("ChercherParId_ifDeleted FAIL");
		} else {
			System.out.println("ChercherParId_ifDeleted SUCCES");
		}
	}

	public void testSupprimer() {
		societeService.supprimer(societe3);
		if (societeService.chercherToutId(societe3.getId()).isDeleted()) {
			System.out.println("Supprimer SUCCESS");
		} else {
			System.out.println("Supprimer FAIL");
		}
	}

	public void testSupprimer_ifDontExist() {
		Societe societe4 = new Societe("Adaming4", "coucou", LocalDate.of(2009, 12, 21));
		societe4.setId(8);
		if (societeService.supprimer(societe4)) {
			System.out.println("Supprimer_ifDontExist FAIL");
		} else {
			System.out.println("Supprimer_ifDontExist SUCCES");
		}

	}

	public void testChercherToutId() {
		if (societeService.chercherToutId(2) != null) {
			System.out.println("ChercherToutId SUCCES");
		} else {
			System.out.println("ChercherToutId FAIL");
		}
	}
	public void testChercherToutId_ifDontExist() {
		if (societeService.chercherToutId(9) != null) {
			System.out.println("ChercherToutId_ifDontExist FAIL");
		} else {
			System.out.println("ChercherToutId_ifDontExist SUCCES");
		}
	}
	public void testChercherToutId_ifDeleted() {
		societeService.supprimer(societe2);
		if (societeService.chercherToutId(2) != null) {
			System.out.println("ChercherToutId_ifDeleted SUCCES");
		} else {
			System.out.println("ChercherToutId_ifDeleted FAIL");
		}
	}

	public void testAfficherVraimentTout() {
		societeService.supprimer(societe2);
		if (societeService.afficherVraimentTout().get(2) != null) {
		System.out.println("AfficherVraimentTout SUCCES");
		} else {
			System.out.println("AfficherVraimentTout FAIL");
		}
	}

	public void testVraimentSupprimer() {
		societeService.vraimentSupprimer(societe2);
		if (societeService.chercherToutId(2) != null) {
			System.out.println("vraimentSupprimer FAIL");
		} else {
			System.out.println("vraimentSupprimer SUCCES");
		}
	}

	public void testRestaurer() {
		societeService.supprimer(societe3);
		societeService.restaurer(societe3);
		if (societeService.chercherToutId(3).isDeleted()) {
			System.out.println("restaurer FAIL");
		} else {
			System.out.println("Restaurer SUCCES");
		}
	}

	public void testChercherParNom() {
		if (societeService.chercherParNom("Adaming").isEmpty()) {
			System.out.println("ChercherParNom FAIL");
		} else {
			System.out.println("ChercherParNom SUCCES");
		}
		
	}
}
