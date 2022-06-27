package com.cibertec.jpa.entity;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.cibertec.model.dto.CitaMedicaDTO;

@Entity
@Table(name = "cita_medica")
public class CitaMedicaJPA implements Serializable{
	
	 @Id
	 @Column(name = "CitaMedicaID")
	 private int id_citamedica;
	 
	 @Column(name = "Fecha_Creacion")
	 private Date fecha_creacion;
	 
	 @Column(name = "PacienteID")
	 private int id_paciente;
	 
	 @Column(name = "MedicoID")
	 private int id_medico;
	 
	 @Column(name = "Area")
	 private String area;
	 
	 @Column(name = "HospitalID")
	 private int id_hospital;
	 
	 @Column(name = "Estado")
	 private String estado;
	 
	 public CitaMedicaJPA(){
		 
	 }

	public CitaMedicaJPA(int id_citamedica, Date fecha_creacion, int id_paciente, int id_medico, String area,
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
	
	public CitaMedicaJPA(CitaMedicaDTO citamedica) {
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
