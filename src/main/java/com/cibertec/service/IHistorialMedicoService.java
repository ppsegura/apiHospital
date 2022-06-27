package com.cibertec.service;

import java.util.List;

import com.cibertec.model.dto.HistorialMedicoDTO;

public interface IHistorialMedicoService {
	
	public boolean crear(HistorialMedicoDTO historial);
	
	public boolean actualizar(HistorialMedicoDTO historial);
	
	public boolean borrar(int id);
	
	public List<HistorialMedicoDTO> obtenerHistorial();
	
	public HistorialMedicoDTO getHistorialById(int id);
}
