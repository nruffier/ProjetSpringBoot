package com.fr.adaming.dao;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.fr.adaming.entity.Employee;
import com.fr.adaming.enumeration.Fonction;

@Repository
public interface EmployeeDao extends JpaRepository<Employee, Integer>{
	@Transactional
	@Modifying(clearAutomatically = true)
	@Query(value= "UPDATE Employee SET deleted = true, date_suppression = :date where id like :id", nativeQuery = true)
	public void supprimer(@Param(value = "id") Integer id, @Param(value = "date") LocalDateTime date);
	//retour mis a jour ?
	@Transactional
	@Modifying(clearAutomatically = true)
	@Query(value= "UPDATE Employee SET deleted = false, date_suppression = NULL where id like :id", nativeQuery = true)
	public void restaurer(@Param(value = "id") Integer id);
	
	
	@Query(value = "SELECT * FROM employee WHERE deleted = false", nativeQuery = true)
	public List<Employee> listAll();
	
	
	@Query(value = "SELECT * FROM employee WHERE id = :id AND deleted = false", nativeQuery = true)
	public Optional<Employee> findId(@Param(value = "id") Integer id);
	
	public List<Employee> findByNom(String nom);
	
	public List<Employee> findByFonction(Fonction fonction);
	
	public Employee findByEmailAndPwd(String email, String pwd);
}
