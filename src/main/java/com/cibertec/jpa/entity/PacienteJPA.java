package com.cibertec.jpa.entity;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.cibertec.model.dto.PacienteDTO;

@Entity
@Table(name="paciente")
public class PacienteJPA implements Serializable {

	@Id
	@Column(name="PacienteID")
	private int id_paciente;
	
	@Column(name="Nombres")
	private String nombres;
	
	@Column(name="ApePat")
	private String ape_pat;
	
	@Column(name="ApeMat")
	private String ape_mat;
	
	@Column(name="Email")
	private String correo;
	
	@Column(name="Tipo_Doc")
	private String tipo_doc;
	
	@Column(name="Nro_Doc")
	private String nro_doc;
	
	@Column(name="Fecha_Nacimiento")
	private Date fecha_nac;
	
	@Column(name="Edad")
	private int edad;
	
	public PacienteJPA() {
		
	}

	public PacienteJPA(int id_paciente, String nombres, String ape_pat, String ape_mat, String correo, String tipo_doc,
			String nro_doc, Date fecha_nac, int edad) {
		super();
		this.id_paciente = id_paciente;
		this.nombres = nombres;
		this.ape_pat = ape_pat;
		this.ape_mat = ape_mat;
		this.correo = correo;
		this.tipo_doc = tipo_doc;
		this.nro_doc = nro_doc;
		this.fecha_nac = fecha_nac;
		this.edad = edad;
	}
	
	public PacienteJPA(PacienteDTO paci) {
		this.id_paciente = paci.getId_paciente();
		this.nombres = paci.getNombres();
		this.ape_pat = paci.getApe_pat();
		this.ape_mat = paci.getApe_mat();
		this.correo = paci.getCorreo();
		this.tipo_doc = paci.getTipo_doc();
		this.nro_doc = paci.getNro_doc();
		this.fecha_nac = paci.getFecha_nac();
		this.edad = paci.getEdad();
	}

	public int getId_paciente() {
		return id_paciente;
	}

	public void setId_paciente(int id_paciente) {
		this.id_paciente = id_paciente;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
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

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getTipo_doc() {
		return tipo_doc;
	}

	public void setTipo_doc(String tipo_doc) {
		this.tipo_doc = tipo_doc;
	}

	public String getNro_doc() {
		return nro_doc;
	}

	public void setNro_doc(String nro_doc) {
		this.nro_doc = nro_doc;
	}

	public Date getFecha_nac() {
		return fecha_nac;
	}

	public void setFecha_nac(Date fecha_nac) {
		this.fecha_nac = fecha_nac;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}
	
	
}
