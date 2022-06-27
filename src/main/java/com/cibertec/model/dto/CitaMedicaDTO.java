package com.cibertec.model.dto;

import java.io.Serializable;
import java.sql.Date;

import com.cibertec.jpa.entity.CitaMedicaJPA;

public class CitaMedicaDTO implements Serializable{

	 private int id_citamedica;
	 private Date fecha_creacion;
	 private int id_paciente;
	 private int id_medico;
	 private String area;
	 private int id_hospital;
	 private String estado;
	 
	 public CitaMedicaDTO() {
		 
	 }

	public CitaMedicaDTO(int id_citamedica, Date fecha_creacion, int id_paciente, int id_medico, String area,
			int id_hospital, String estado) {
		super();
		this.id_citamedica = id_citamedica;
		this.fecha_creacion = fecha_creacion;
		this.id_paciente = id_paciente;
		this.id_medico = id_medico;
		this.area = area;
		this.id_hospital = id_hospital;
		this.estado = estado;
	}
	
	public CitaMedicaDTO(CitaMedicaJPA citamedica) {
		
		this.id_citamedica = citamedica.getId_citamedica();
		this.fecha_creacion = citamedica.getFecha_creacion();
		this.id_paciente = citamedica.getId_paciente();
		this.id_medico = citamedica.getId_medico();
		this.area = citamedica.getArea();
		this.id_hospital = citamedica.getId_hospital();
		this.estado = citamedica.getEstado();
	 }

	public int getId_citamedica() {
		return id_citamedica;
	}

	public void setId_citamedica(int id_citamedica) {
		this.id_citamedica = id_citamedica;
	}

	public Date getFecha_creacion() {
		return fecha_creacion;
	}

	public void setFecha_creacion(Date fecha_creacion) {
		this.fecha_creacion = fecha_creacion;
	}

	public int getId_paciente() {
		return id_paciente;
	}

	public void setId_paciente(int id_paciente) {
		this.id_paciente = id_paciente;
	}

	public int getId_medico() {
		return id_medico;
	}

	public void setId_medico(int id_medico) {
		this.id_medico = id_medico;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public int getId_hospital() {
		return id_hospital;
	}

	public void setId_hospital(int id_hospital) {
		this.id_hospital = id_hospital;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	 
}
