package com.cibertec.service;

import java.util.List;

import com.cibertec.model.dto.HospitalDTO;

public interface IHospitalService {

	public boolean crear(HospitalDTO hospital);
	
	public boolean actualizar(HospitalDTO hospital);
	
	public boolean borrar(int id);
	
	public List<HospitalDTO> obtenerHospitales();
	
	public HospitalDTO getHospitalById(int id);
}
