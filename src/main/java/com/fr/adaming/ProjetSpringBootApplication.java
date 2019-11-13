package com.fr.adaming;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.fr.adaming.service.test.ProjetServiceTest;
import com.fr.adaming.service.test.SocieteSeviceTest;

@SpringBootApplication
public class ProjetSpringBootApplication {
	private final static Logger logger = LogManager.getLogger(ProjetSpringBootApplication.class);
	



	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(ProjetSpringBootApplication.class, args);
	
		
		SocieteSeviceTest societeServiceTest = context.getBean(SocieteSeviceTest.class);
		
		ProjetServiceTest projetServiceTest = context.getBean(ProjetServiceTest.class);
	
	
	projetServiceTest.testAjouter();
//	projetServiceTest.testAjouter_IfExist();
//	projetServiceTest.testModifier();
//	projetServiceTest.testModifier_idDontExist();
//	projetServiceTest.testAfficher();
//	projetServiceTest.testChercherParId_ifExist();
//	projetServiceTest.testChercherParId_ifDontExist();
//	projetServiceTest.testChercherParId_ifDeleted();
//	projetServiceTest.testSupprimer();
//	projetServiceTest.testSupprimer_ifDontExist();
//	projetServiceTest.testChercherToutId();
//	projetServiceTest.testChercherParId_ifDontExist();
//	projetServiceTest.testChercherParId_ifDeleted();
//	projetServiceTest.testAfficherVraimentTout();
//	projetServiceTest.testVraimentSupprimer();
//	projetServiceTest.testRestaurer();
	
	
	societeServiceTest.testAjouter();
	logger.warn("coucou");
	logger.debug("coucou");
//	societeServiceTest.testAjouter_IfExist();
//	societeServiceTest.testModifier();
//	societeServiceTest.testModifier_idDontExist();
//	societeServiceTest.testAfficher();
//	societeServiceTest.testChercherParId_ifExist();
//	societeServiceTest.testChercherParId_ifDontExist();
//	societeServiceTest.testChercherParId_ifDeleted();
//	societeServiceTest.testSupprimer();
//	societeServiceTest.testSupprimer_ifDontExist();
//	societeServiceTest.testChercherToutId();
//	societeServiceTest.testChercherParId_ifDontExist();
//	societeServiceTest.testChercherParId_ifDeleted();
//	societeServiceTest.testAfficherVraimentTout();
//	societeServiceTest.testVraimentSupprimer();
//	societeServiceTest.testRestaurer();

	
		
	}

}
