package com.cibertec.service;

import java.util.List;

import com.cibertec.model.dto.PacienteDTO;

public interface IPacienteService {
	
	public boolean crear(PacienteDTO paciente);
	
	public boolean actualizar(PacienteDTO paciente);
	
	public boolean borrar(int id);
	
	public List<PacienteDTO> obtenerPacientes();
	
	public PacienteDTO getPacienteById(int id);
}
