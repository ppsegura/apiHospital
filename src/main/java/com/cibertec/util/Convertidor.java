package com.cibertec.util;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

import com.cibertec.jpa.entity.PacienteJPA;
import com.cibertec.model.dto.PacienteDTO;
import com.cibertec.jpa.entity.CitaMedicaJPA;
import com.cibertec.jpa.entity.HistorialMedicoJPA;
import com.cibertec.jpa.entity.HospitalJPA;
import com.cibertec.jpa.entity.MedicoJPA;
import com.cibertec.model.dto.CitaMedicaDTO;
import com.cibertec.model.dto.HistorialMedicoDTO;
import com.cibertec.model.dto.HospitalDTO;
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
	
	public List<HospitalDTO> convertirListaHospital(List<HospitalJPA> listaJPA){

		List<HospitalDTO> lstHospitalModel = new ArrayList<>();
		for(HospitalJPA hospital: listaJPA){
			lstHospitalModel.add(new HospitalDTO(hospital));
		}
		return lstHospitalModel;
	}
	public HospitalDTO convertirHospitalDTO(HospitalJPA nota){
		return new HospitalDTO(nota);
	}
	
	public List<HistorialMedicoDTO> convertirListaHistorial(List<HistorialMedicoJPA> listaJPA){

		List<HistorialMedicoDTO> lstHistorialModel = new ArrayList<>();
		for(HistorialMedicoJPA historial: listaJPA){
			lstHistorialModel.add(new HistorialMedicoDTO(historial));
		}
		return lstHistorialModel;
	}
	
	public HistorialMedicoDTO convertirHistorialDTO(HistorialMedicoJPA nota){
		return new HistorialMedicoDTO(nota);
	}
	
	
	public List<CitaMedicaDTO> convertirListaCita(List<CitaMedicaJPA> listaJPA){

		List<CitaMedicaDTO> lstCitaModel = new ArrayList<>();
		for(CitaMedicaJPA cita: listaJPA){
			lstCitaModel.add(new CitaMedicaDTO(cita));
		}
		return lstCitaModel;
	}
	
	public CitaMedicaDTO convertirCitaDTO(CitaMedicaJPA nota){
		return new CitaMedicaDTO(nota);
	}

}
