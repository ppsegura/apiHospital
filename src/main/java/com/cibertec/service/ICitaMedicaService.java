package com.cibertec.service;

import java.util.List;

import com.cibertec.model.dto.CitaMedicaDTO;

public interface ICitaMedicaService {
	
	public boolean crear(CitaMedicaDTO citamedica);
	
	public boolean actualizar(CitaMedicaDTO citamedica);
	
	public boolean borrar(int id);
	
	public List<CitaMedicaDTO> obtenerCitaMedica();
	
	public CitaMedicaDTO getCitaById(int id);
}
