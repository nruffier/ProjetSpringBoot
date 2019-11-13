package com.fr.adaming.service;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import javax.persistence.RollbackException;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.TransactionSystemException;

import com.fr.adaming.entity.Client;


@SpringBootTest
public class ClientServiceTest {

	@Autowired
	private ClientService service;

	@Test
	public void createValidClient_shouldReturnUserWithIdNotNull() {
		// préparer input
		Client c = new Client();

		c.setId(null);
		c.setNom("nom1");
		c.setEmail("email@febuzni.fez");
		c.setPrenom("prenom1");
		c.setNomEntrprise("bla");
		c.setNomRepresentant("blabla");
		c.setDomaine("bfeuzize");

		// invoquer méthode
		Client returnedClient = service.ajouter(c);

		// verifier le restultat
		assertNotNull(returnedClient);
		assertNotNull(returnedClient.getId());
	}

	@Test
	public void createExistingClient_shouldReturnUserNull() {
		Client c = new Client();
		c.setNom("nom1");
		c.setEmail("email@febuzni.fez");
		c.setPrenom("prenom1");
		c.setNomEntrprise("bla");
		c.setNomRepresentant("blabla");
		c.setDomaine("bfeuzize");
		
		Client returnedClient = service.ajouter(c);
		assertNull(returnedClient);
		
		
	}
	@Test
	public void createNotValidClient_shouldReturnRollbackException() {
		Client c = new Client();
		c.setNom("nom1");
		c.setEmail("emailpasvalidelol");
		c.setPrenom("prenom1");
		c.setNomEntrprise("bla");
		c.setNomRepresentant("blabla");
		c.setDomaine("bfeuzize");
		
		assertThrows(TransactionSystemException.class, () -> {service.ajouter(c);});

	}
	
	
// Pour faire une attente d'excpetion : 
//
//	exception.expect
}
