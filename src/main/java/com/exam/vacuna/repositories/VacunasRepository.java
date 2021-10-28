package com.exam.vacuna.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.exam.vacuna.models.Vacunas;

public interface VacunasRepository extends CrudRepository<Vacunas, Long> {
	List<Vacunas> findById(long id);
}
