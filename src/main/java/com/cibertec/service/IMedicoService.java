package com.cibertec.service;

import java.util.List;

import com.cibertec.model.dto.MedicoDTO;

public interface IMedicoService {
	
	public boolean crear(MedicoDTO medico);
	
	public boolean actualizar(MedicoDTO medico);
	
	public boolean borrar(int id);
	
	public List<MedicoDTO> obtenerMedicos();
	
	public MedicoDTO getMedicoById(int id);
}
