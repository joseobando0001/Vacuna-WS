package com.exam.vacuna.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.exam.vacuna.models.User;

public interface UserRepository extends CrudRepository<User, Long> {
	User findByUsername(String username);
	List<User> findById(long id);

}
