package com.fr.adaming.entity;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter	@Setter @AllArgsConstructor @NoArgsConstructor @ToString
public class Client extends User {
	
	private String domaine;
	private String nomRepresentant;
	private String nomEntrprise;
	
	@ManyToOne
	@JoinColumn(name = "id_Societe")
	private Societe societeC;
	
	@OneToMany(mappedBy = "clientP")
	private Set<Projet> projetsC;
	
	@OneToMany(mappedBy = "clientC")
	private Set<Contrat> contratsC;
}
