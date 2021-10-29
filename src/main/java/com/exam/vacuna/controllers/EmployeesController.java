package com.exam.vacuna.controllers;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exam.vacuna.constants.DominiosConstantes;
import com.exam.vacuna.models.Employees;
import com.exam.vacuna.repositories.EmployeesRepository;

@CrossOrigin(origins = "*", allowedHeaders = "*", maxAge = 3600)
@RestController
@RequestMapping(DominiosConstantes.context)
public class EmployeesController {
	public static final Logger logger = LoggerFactory.getLogger(EmployeesController.class);

	@Autowired
	EmployeesRepository repository;
	// Muestra todas las preguntas

	@GetMapping("/empleados")
	public List<Employees> getAllEmployees() {
		System.out.println("Get all Employees ...");

		List<Employees> employees = new ArrayList<>();
		repository.findAll().forEach(employees::add);

		return employees;
	}

	@GetMapping(value = "empleado/{id}")
	public List<Employees> findById(@PathVariable int id) {

		List<Employees> employees = repository.findById(id);
		return employees;
	}
	
	@GetMapping(value = "empleadocedula/{id}")
	public List<Employees> findByCedula(@PathVariable int id) {

		List<Employees> employees = repository.findByCedula(id);
		return employees;
	}

	// Crea un nuevo Empleado
	@PostMapping(value = "/empleado")
	public Employees post(@RequestBody Employees Employees) {
		Employees employees = repository.save(Employees);

		return employees;
	}

	// Funcion Eliminar
	@DeleteMapping(value = "/empleado/{id}")
	public ResponseEntity deleteById(@PathVariable long id) {
		logger.info("Delete empleado with id {}", id);
		repository.deleteById(id);
		return new ResponseEntity(true, HttpStatus.OK);
	}
}
