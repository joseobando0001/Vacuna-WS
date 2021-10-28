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
import com.exam.vacuna.models.Vacunas;
import com.exam.vacuna.repositories.VacunasRepository;

@CrossOrigin(origins = { DominiosConstantes.DOMAIN_1, DominiosConstantes.DOMAIN_2, DominiosConstantes.DOMAIN_4 })
@RestController
@RequestMapping(DominiosConstantes.context)
public class VacunasController {
	public static final Logger logger = LoggerFactory.getLogger(VacunasController.class);

	@Autowired
	VacunasRepository repository;
	// Muestra todas las preguntas

	@GetMapping("/vacunas")
	public List<Vacunas> getAllVacunas() {
		System.out.println("Get all Vacunas ...");

		List<Vacunas> vacunas = new ArrayList<>();
		repository.findAll().forEach(vacunas::add);

		return vacunas;
	}

	@GetMapping(value = "vacuna/{id}")
	public List<Vacunas> findById(@PathVariable int id) {

		List<Vacunas> vacuna = repository.findById(id);
		return vacuna;
	}

	// Crea una nueva Vacuna
	@PostMapping(value = "/vacuna")
	public Vacunas post(@RequestBody Vacunas Vacunas) {
		Vacunas vacuna = repository.save(Vacunas);

		return vacuna;
	}

	// Funcion Eliminar
	@DeleteMapping(value = "/vacuna/{id}")
	public ResponseEntity deleteById(@PathVariable long id) {
		logger.info("Delete vacuna with id {}", id);
		repository.deleteById(id);
		return new ResponseEntity(true, HttpStatus.OK);
	}
}
