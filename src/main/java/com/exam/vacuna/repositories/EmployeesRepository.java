package com.exam.vacuna.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.exam.vacuna.models.Employees;

public interface EmployeesRepository extends CrudRepository<Employees, Long> {
	List<Employees> findById(long id);

}