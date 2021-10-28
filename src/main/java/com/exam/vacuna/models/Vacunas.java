package com.exam.vacuna.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "vacunas")
public class Vacunas {

	@Id
	@Column(name = "id_vacuna",columnDefinition = "serial")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_vacuna;

	@Column(name = "descripcion")
	private String descripcion;

	public Long getId_vacuna() {
		return id_vacuna;
	}

	public void setId_vacuna(Long id_vacuna) {
		this.id_vacuna = id_vacuna;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

}
