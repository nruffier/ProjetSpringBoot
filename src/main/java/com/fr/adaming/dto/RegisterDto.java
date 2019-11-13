package com.fr.adaming.dto;

import java.time.LocalDate;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
public class RegisterDto {

	private String nom;
	private String email;
	private String pwd;
	private LocalDate dateRecrutement;
}
