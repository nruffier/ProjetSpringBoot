package com.fr.adaming.service;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.Rule;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.jdbc.Sql;
//import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.transaction.TransactionSystemException;

import com.fr.adaming.entity.Client;


@SpringBootTest
public class ClientServiceTest {

	@Autowired
	private ClientService service;

	@Test
	//@Sql(statements = {"truncate user", "show tables"}, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
	//@Sql(statements = "delete from user where id=1", executionPhase = ExecutionPhase.AFTER_TEST_METHOD)
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
	public void createNotValidClient_shouldReturnTransactionSystemException() {
		Client c = new Client();
		c.setNom("nom1");
		c.setEmail("emailpasvalidelol");
		c.setPrenom("prenom1");
		c.setNomEntrprise("bla");
		c.setNomRepresentant("blabla");
		c.setDomaine("bfeuzize");
		
		assertThrows(TransactionSystemException.class, () -> {service.ajouter(c);});

	}
	
	@Rule
	public ExpectedException exception = ExpectedException.none();
	
	//Avec une autre method pour une exception
	@Test
	public void createNotValidClient_shouldReturnTransactionSystemException2() {
		Client c = new Client();
		c.setNom("nom1");
		c.setEmail("emailpasvalidelol");
		c.setPrenom("prenom1");
		c.setNomEntrprise("bla");
		c.setNomRepresentant("blabla");
		c.setDomaine("bfeuzize");
		
		
		exception.expect(TransactionSystemException.class);
		exception.expectMessage("Could not commit JPA transaction; nested exception is javax.persistence.RollbackException: Error while committing the transaction");
		service.ajouter(c);
	}
	
}
