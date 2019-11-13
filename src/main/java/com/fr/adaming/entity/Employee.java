package com.fr.adaming.entity;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import com.fr.adaming.enumeration.Fonction;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter	@Setter @AllArgsConstructor @NoArgsConstructor @ToString
public class Employee extends User{

	private String pwd;
	private double salaire;
	@Enumerated(EnumType.ORDINAL)
	private Fonction fonction;
	private LocalDate dateRecrutement;
	
	@ManyToMany(mappedBy = "employees")
	private Set<Projet> projetsE;
	
	@ManyToOne
	@JoinColumn(name = "id_Societe")
	private Societe societeE;
	
}
