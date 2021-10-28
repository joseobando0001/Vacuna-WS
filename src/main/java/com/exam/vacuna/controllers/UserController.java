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
import com.exam.vacuna.models.Status;
import com.exam.vacuna.models.User;
import com.exam.vacuna.repositories.UserRepository;

@CrossOrigin(origins = "*", allowedHeaders = "*", maxAge = 3600)
@RestController
@RequestMapping(DominiosConstantes.context)
public class UserController {
	public static final Logger logger = LoggerFactory.getLogger(UserController.class);
	@Autowired
	UserRepository repository;
	// Muestra todas las preguntas

	@GetMapping("/users")
	public List<User> getAllUsers() {
		System.out.println("Get all Users ...");

		List<User> users = new ArrayList<>();
		repository.findAll().forEach(users::add);

		return users;
	}

	@GetMapping(value = "user/{id}")
	public List<User> findById(@PathVariable int id) {

		List<User> user = repository.findById(id);
		return user;
	}

	// Crea un nuevo Usuario
	@PostMapping(value = "/user")
	public User post(@RequestBody User User) {
		User user = repository.save(User);

		return user;
	}

	// Funcion Eliminar
	@DeleteMapping(value = "/user/{id}")
	public ResponseEntity deleteById(@PathVariable long id) {
		logger.info("Delete user with id {}", id);
		repository.deleteById(id);
		return new ResponseEntity(true, HttpStatus.OK);
	}

	// Funcion Login

	@PostMapping("/user/login")
	public boolean login(@RequestBody User user) {
		return user.getUsername().equals("username") && user.getPassword().equals("password");
	}
}
