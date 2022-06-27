package com.cibertec.jpa.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.cibertec.model.dto.HistorialMedicoDTO;

@Entity
@Table(name = "historial_medico")
public class HistorialMedicoJPA implements Serializable{
	
	@Id
	@Column(name = "HistorialMedicoID")
	private int id_historialmedico;
	
	@Column(name = "CitaMedicaID")
	private int id_citamedica;
	
	@Column(name = "Sintomas")
	private String sintomas;
	
	@Column(name = "Diagnostico")
	private String diagnostico;
	
	@Column(name = "Peso")
	private double peso;
	
	@Column(name = "Altura")
	private double altura;
	
	public HistorialMedicoJPA() {
		
	}

	public HistorialMedicoJPA(int id_historialmedico, int id_citamedica, String sintomas, String diagnostico,
			double peso, double altura) {
		super();
		this.id_historialmedico = id_historialmedico;
		this.id_citamedica = id_citamedica;
		this.sintomas = sintomas;
		this.diagnostico = diagnostico;
		this.peso = peso;
		this.altura = altura;
	}
	
	public HistorialMedicoJPA(HistorialMedicoDTO hmedico) {
		
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
