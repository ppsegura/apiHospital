package com.cibertec.util;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

import com.cibertec.jpa.entity.PacienteJPA;
import com.cibertec.model.dto.PacienteDTO;

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

}
