package com.exam.vacuna.controllers;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exam.vacuna.constants.DominiosConstantes;
import com.exam.vacuna.vo.UserVo;

@CrossOrigin(origins = { DominiosConstantes.DOMAIN_1, DominiosConstantes.DOMAIN_2, DominiosConstantes.DOMAIN_4 })
@RestController
@RequestMapping(DominiosConstantes.context)
public class UserOptionsController {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@GetMapping("userced/{id}")
	public List<UserVo> findUserbyCedula(@PathVariable String id) throws SQLException {
		String q = "SELECT id_user as user,username, tipo_user as tipo FROM public.user where cedula = " + id + " ;";
		System.out.println("USUARIO POR CEDULA:  " + id);
		return jdbcTemplate.query(q, new BeanPropertyRowMapper<>(UserVo.class));
	}
	
	@GetMapping("vacunced/{id}")
	public List<UserVo> findVacunacionrbyCedula(@PathVariable String id) throws SQLException {
		String q = "SELECT id_vacunacionempleado as id,numero_dosis as numero FROM public.vacunacion_empleado where cedula = " + id + " ;";
		System.out.println("VACUNACION POR CEDULA:  " + id);
		return jdbcTemplate.query(q, new BeanPropertyRowMapper<>(UserVo.class));
	}
}
