package com.fr.adaming.entity;

import java.time.LocalDateTime;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter	@Setter @AllArgsConstructor @NoArgsConstructor @ToString
public class Projet extends  AbstractEntity{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nomEquipe;
	private String nomProjet;
	@ManyToMany
	@JoinTable(name = "EmployeeProjet",
		joinColumns = @JoinColumn(name = "id_projet"),
		inverseJoinColumns = @JoinColumn(name = "id_Employee"))
	private Set<Employee> employees;
	
	@ManyToOne
	@JoinColumn(name = "id_client")
	private Client clientP;

	public Projet(String nomEquipe, String nomProjet) {
		this.nomEquipe = nomEquipe;
		this.nomProjet = nomProjet;
	}
	
	
}
