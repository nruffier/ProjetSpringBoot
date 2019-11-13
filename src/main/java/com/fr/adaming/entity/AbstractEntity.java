package com.fr.adaming.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@MappedSuperclass
@Getter	@Setter @AllArgsConstructor @NoArgsConstructor @ToString
public abstract class AbstractEntity {

	@CreationTimestamp
	@Column(updatable = false)
	protected LocalDateTime dateInsertion;
	
	@UpdateTimestamp
	protected LocalDateTime dateModification;
	protected LocalDateTime dateSuppression;
	protected boolean deleted;
	
	
	
	
	
}
