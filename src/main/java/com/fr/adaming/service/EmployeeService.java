package com.fr.adaming.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.fr.adaming.dao.EmployeeDao;
import com.fr.adaming.entity.Employee;
import com.fr.adaming.enumeration.Fonction;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeDao employeeDao;

	public Employee ajouter(Employee employee) {
		if (employeeDao.exists(Example.of(employee))) {
			return null;
		} else {
			return employeeDao.save(employee);
		}

	}

	public boolean modifier(Employee employee) {
		if (chercherParId(employee.getId()) != null) {
			employeeDao.save(employee);
			return true;
		} else {
			return false;
		}
	}

	public boolean supprimer(Employee employee) {
		LocalDateTime date = LocalDateTime.now();
		if (chercherParId(employee.getId()) != null) {
			employeeDao.supprimer(employee.getId(), date);
			return true;
		} else {
			return false;
		}
	}

	public void vraimentSupprimer(Employee employee) {
		employeeDao.delete(employee);
	}

	public void restaurer(Employee employee) {
		employeeDao.restaurer(employee.getId());
	}

	public List<Employee> afficher() {
		return employeeDao.listAll();
	}

	public List<Employee> afficherVraimentTout() {
		return employeeDao.findAll();
	}

	public Employee chercherParId(Integer id) {
		try {
			return employeeDao.findId(id).get();
		} catch (NoSuchElementException e) {
			return null;
		}
	}

	public Employee chercherToutId(Integer id) {
		try {
			return employeeDao.findById(id).get();
		} catch (NoSuchElementException e) {
			return null;
		}
	}

	public List<Employee> chercherParNom(String nom) {
		return employeeDao.findByNom(nom);
	}

	public List<Employee> chercherParFonction(Fonction fonction) {
		return employeeDao.findByFonction(fonction);
	}

	public Employee login(String email, String pwd) {
		return employeeDao.findByEmailAndPwd(email, pwd);
	}
}
