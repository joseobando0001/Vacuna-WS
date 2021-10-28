package com.exam.vacuna.models;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "vacunacion_empleado")
public class VacunacionEmpleado {

	@Id
	@Column(name = "id_vacunacionempleado", columnDefinition = "serial")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_vacunacionempleado;

	@Column(name = "id_vacuna")
	private Integer id_vacuna;

	@Column(name = "fecha_vacunacion")
	private Date fecha;

	@Column(name = "numero_dosis")
	private String numero_dosis;

	@Column(name = "cedula")
	private Integer cedula;

	public Integer getCedula() {
		return cedula;
	}

	public void setCedula(Integer cedula) {
		this.cedula = cedula;
	}

	public Long getId_vacunacionempleado() {
		return id_vacunacionempleado;
	}

	public void setId_vacunacionempleado(Long id_vacunacionempleado) {
		this.id_vacunacionempleado = id_vacunacionempleado;
	}

	public Integer getId_vacuna() {
		return id_vacuna;
	}

	public void setId_vacuna(Integer id_vacuna) {
		this.id_vacuna = id_vacuna;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getNumero_dosis() {
		return numero_dosis;
	}

	public void setNumero_dosis(String numero_dosis) {
		this.numero_dosis = numero_dosis;
	}

}
