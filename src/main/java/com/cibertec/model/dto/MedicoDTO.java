package com.cibertec.model.dto;

import java.io.Serializable;

import com.cibertec.jpa.entity.MedicoJPA;

public class MedicoDTO implements Serializable{
	
	private int id_medico;
	private int id_hospital;
	private String nombre;
	private String ape_pat;
	private String ape_mat;
	private String especialidad;
	private String area;
	
	public MedicoDTO() {}
	
	public MedicoDTO(int id_medico, int id_hospital, String nombre, String ape_pat, String ape_mat, String especialidad,
			String area) {
		super();
		this.id_medico = id_medico;
		this.id_hospital = id_hospital;
		this.nombre = nombre;
		this.ape_pat = ape_pat;
		this.ape_mat = ape_mat;
		this.especialidad = especialidad;
		this.area = area;
	}

	public MedicoDTO(MedicoJPA medi) {
		this.id_medico = medi.getId_medico();
		this.id_hospital = medi.getId_hospital();
		this.nombre = medi.getNombre();
		this.ape_pat = medi.getApe_pat();
		this.ape_mat = medi.getApe_mat();
		this.especialidad = medi.getEspecialidad();
		this.area = medi.getArea();
	}


	public int getId_medico() {
		return id_medico;
	}

	public void setId_medico(int id_medico) {
		this.id_medico = id_medico;
	}

	public int getId_hospital() {
		return id_hospital;
	}

	public void setId_hospital(int id_hospital) {
		this.id_hospital = id_hospital;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApe_pat() {
		return ape_pat;
	}

	public void setApe_pat(String ape_pat) {
		this.ape_pat = ape_pat;
	}

	public String getApe_mat() {
		return ape_mat;
	}

	public void setApe_mat(String ape_mat) {
		this.ape_mat = ape_mat;
	}

	public String getEspecialidad() {
		return especialidad;
	}

	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}
	
	
}
