package com.fr.adaming.dao;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.fr.adaming.entity.Projet;

public interface ProjetDao extends JpaRepository<Projet, Integer> {
	
	@Transactional
	@Modifying(clearAutomatically = true)
	@Query(value= "UPDATE Projet SET deleted = true, date_suppression = :date where id like :id", nativeQuery = true)
	public void supprimer(@Param(value = "id") Integer id, @Param(value = "date") LocalDateTime date);
	
	@Transactional
	@Modifying(clearAutomatically = true)
	@Query(value= "UPDATE Projet SET deleted = false, date_suppression = NULL where id like :id", nativeQuery = true)
	public void restaurer(@Param(value = "id") Integer id);
	
	
	@Query(value = "SELECT * FROM projet WHERE deleted = false", nativeQuery = true)
	public List<Projet> listAll();
	
	
	@Query(value = "SELECT * FROM projet WHERE id = :id AND deleted = false", nativeQuery = true)
	public Optional<Projet> findId(@Param(value = "id") Integer id);
}
