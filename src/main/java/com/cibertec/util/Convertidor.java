package com.cibertec.util;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

import com.cibertec.jpa.entity.PacienteJPA;
import com.cibertec.model.dto.PacienteDTO;

import com.cibertec.jpa.entity.MedicoJPA;
import com.cibertec.model.dto.MedicoDTO;

@Component("convertidor")

public class Convertidor{

	
	public List<PacienteDTO> convertirLista(List<PacienteJPA> listaJPA){

		List<PacienteDTO> lstPacienteModel = new ArrayList<>();
		for(PacienteJPA paciente: listaJPA){
			lstPacienteModel.add(new PacienteDTO(paciente));
		}
		return lstPacienteModel;
	}
	
	public PacienteDTO convertirDTO(PacienteJPA nota){
		return new PacienteDTO(nota);
	}
	
	public List<MedicoDTO> convertirListaMedico(List<MedicoJPA> listaJPA){

		List<MedicoDTO> lstMedicoModel = new ArrayList<>();
		for(MedicoJPA medico: listaJPA){
			lstMedicoModel.add(new MedicoDTO(medico));
		}
		return lstMedicoModel;
	}
	
	public MedicoDTO convertirMedicoDTO(MedicoJPA nota){
		return new MedicoDTO(nota);
	}

}
