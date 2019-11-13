package com.fr.adaming.entity;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter	@Setter @AllArgsConstructor @NoArgsConstructor
public class Societe extends AbstractEntity{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nom;
	private String logo;
	private LocalDate dateCreation;
	
	@OneToMany(mappedBy = "societeE")
	private Set<Employee> employees;
	
	@OneToMany(mappedBy = "societeC")
	private Set<Client> clients;
	
	@OneToMany(mappedBy = "societeCo")
	private Set<Contrat> contratsS;

	public Societe(String nom, String logo, LocalDate dateCreation) {
		super();
		this.nom = nom;
		this.logo = logo;
		this.dateCreation = dateCreation;
	}

	@Override
	public String toString() {
		return "Societe [id=" + id + ", nom=" + nom + ", logo=" + logo + ", dateCreation=" + dateCreation
				//+ ", employees=" + employees + ", clients=" + clients + ", contratsS=" + contratsS
				+ ", getDateInsertion()=" + getDateInsertion() + ", getDateModification()=" + getDateModification()
				+ ", getDateSuppression()=" + getDateSuppression() + ", isDeleted()=" + isDeleted() + "]";
	}
	
	
	
	
}
