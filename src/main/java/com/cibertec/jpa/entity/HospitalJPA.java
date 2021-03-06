package com.cibertec.jpa.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.cibertec.model.dto.HospitalDTO;

@Entity
@Table(name ="hospital")
public class HospitalJPA implements Serializable{
	
	@Id
	@Column(name ="HospitalID")
	private int id_hospital;
	
	@Column(name ="Departamento")
	private String departamento;
	
	@Column(name ="Distrito")
	private String distrito;
	
	@Column(name ="Direccion")
	private String direccion;
	
	public HospitalJPA() {
		
	}

	public HospitalJPA(int id_hospital, String departamento, String distrito, String direccion) {
		super();
		this.id_hospital = id_hospital;
		this.departamento = departamento;
		this.distrito = distrito;
		this.direccion = direccion;
	}
	
	public HospitalJPA(HospitalDTO hospital) {
		
		this.id_hospital = hospital.getId_hospital();
		this.departamento = hospital.getDepartamento();
		this.distrito = hospital.getDistrito();
		this.direccion = hospital.getDireccion();
	}

	public int getId_hospital() {
		return id_hospital;
	}

	public void setId_hospital(int id_hospital) {
		this.id_hospital = id_hospital;
	}

	public String getDepartamento() {
		return departamento;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}

	public String getDistrito() {
		return distrito;
	}

	public void setDistrito(String distrito) {
		this.distrito = distrito;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
	
}
