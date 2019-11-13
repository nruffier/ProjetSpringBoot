package com.fr.adaming.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fr.adaming.enumeration.Methodologie;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter	@Setter @AllArgsConstructor @NoArgsConstructor @ToString
public class Contrat extends  AbstractEntity{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Enumerated(EnumType.ORDINAL)
	private Methodologie methodologie;
	private LocalDate dateSignature;
	
	@ManyToOne
	@JoinColumn(name = "id_Client")
	private Client clientC;
	
	@ManyToOne
	@JoinColumn(name = "id_Societe")
	private Societe societeCo;
}
