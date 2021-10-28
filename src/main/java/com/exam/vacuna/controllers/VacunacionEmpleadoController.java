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
import com.exam.vacuna.models.VacunacionEmpleado;
import com.exam.vacuna.repositories.VacunacionEmpleadoRepository;

@CrossOrigin(origins = "*", allowedHeaders = "*", maxAge = 3600)
@RestController
@RequestMapping(DominiosConstantes.context)
public class VacunacionEmpleadoController {
	public static final Logger logger = LoggerFactory.getLogger(VacunacionEmpleadoController.class);

	@Autowired
	VacunacionEmpleadoRepository repository;
	// Muestra todas las preguntas

	@GetMapping("/vacunacion")
	public List<VacunacionEmpleado> getAllVacunacion() {
		System.out.println("Get all Vacunacion ...");

		List<VacunacionEmpleado> vacunacion = new ArrayList<>();
		repository.findAll().forEach(vacunacion::add);

		return vacunacion;
	}

	@GetMapping(value = "vacunacion/{id}")
	public List<VacunacionEmpleado> findById(@PathVariable int id) {

		List<VacunacionEmpleado> vacunacion = repository.findById(id);
		return vacunacion;
	}

	// Crea una nueva Vacuna
	@PostMapping(value = "/vacunacion")
	public VacunacionEmpleado post(@RequestBody VacunacionEmpleado VacunacionEmpleado) {
		VacunacionEmpleado vacunacion = repository.save(VacunacionEmpleado);

		return vacunacion;
	}

	// Funcion Eliminar
	@DeleteMapping(value = "/vacunacion/{id}")
	public ResponseEntity deleteById(@PathVariable long id) {
		logger.info("Delete vacunacion with id {}", id);
		repository.deleteById(id);
		return new ResponseEntity(true, HttpStatus.OK);
	}
}
