package com.cibertec.model.dto;

import java.io.Serializable;

import com.cibertec.jpa.entity.HistorialMedicoJPA;

public class HistorialMedicoDTO implements Serializable{

	private int id_historialmedico;
	private int id_citamedica;
	private String sintomas;
	private String diagnostico;
	private double peso;
	private double altura;
	
	public HistorialMedicoDTO() {
		
	}

	public HistorialMedicoDTO(int id_historialmedico, int id_citamedica, String sintomas, String diagnostico,
			double peso, double altura) {
		super();
		this.id_historialmedico = id_historialmedico;
		this.id_citamedica = id_citamedica;
		this.sintomas = sintomas;
		this.diagnostico = diagnostico;
		this.peso = peso;
		this.altura = altura;
	}
	
	public HistorialMedicoDTO(HistorialMedicoJPA hmedico) {
		
		this.id_historialmedico = hmedico.getId_historialmedico();
		this.id_citamedica = hmedico.getId_citamedica();
		this.sintomas = hmedico.getSintomas();
		this.diagnostico = hmedico.getDiagnostico();
		this.peso = hmedico.getPeso();
		this.altura = hmedico.getAltura();
	}

	public int getId_historialmedico() {
		return id_historialmedico;
	}

	public void setId_historialmedico(int id_historialmedico) {
		this.id_historialmedico = id_historialmedico;
	}

	public int getId_citamedica() {
		return id_citamedica;
	}

	public void setId_citamedica(int id_citamedica) {
		this.id_citamedica = id_citamedica;
	}

	public String getSintomas() {
		return sintomas;
	}

	public void setSintomas(String sintomas) {
		this.sintomas = sintomas;
	}

	public String getDiagnostico() {
		return diagnostico;
	}

	public void setDiagnostico(String diagnostico) {
		this.diagnostico = diagnostico;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	public double getAltura() {
		return altura;
	}

	public void setAltura(double altura) {
		this.altura = altura;
	}
	
}
