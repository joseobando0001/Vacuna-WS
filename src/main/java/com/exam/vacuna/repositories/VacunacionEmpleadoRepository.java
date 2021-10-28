package com.exam.vacuna.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.exam.vacuna.models.VacunacionEmpleado;

public interface VacunacionEmpleadoRepository extends CrudRepository<VacunacionEmpleado, Long> {
	List<VacunacionEmpleado> findById(long id);
}
