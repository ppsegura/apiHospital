package com.cibertec.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.cibertec.jpa.entity.PacienteJPA;
import com.cibertec.jpa.repository.IPacienteRepository;
import com.cibertec.model.dto.PacienteDTO;
import com.cibertec.service.IPacienteService;
import com.cibertec.util.Convertidor;

@Service("pacienteservice")
public class PacienteServiceImpl implements IPacienteService{

	@Autowired
	@Qualifier("repositoriopaciente")
	private IPacienteRepository repo;
	
	@Autowired
	@Qualifier("convertidor")
	private Convertidor convertidor;
	
	@Override
	public boolean crear(PacienteDTO paciente) {
		System.out.println("ini: crear Paciente");
		try {
			repo.save(new PacienteJPA(paciente));
			return true;
		} catch (Exception e) {
			System.out.println("No se creo Paciente");
			e.printStackTrace();
			return false;
		}
			
	}

	@Override
	public boolean actualizar(PacienteDTO paciente) {
		System.out.println("ini: actualizar Paciente");
		try {
			repo.save(new PacienteJPA(paciente));
			return true;
		} catch (Exception e) {
			System.out.println("No se actualizó el Paciente");
			e.printStackTrace();
			return false;
		}
		
	}
	
	@Override
	public boolean borrar(int id) {
		System.out.println("ini: borrar Paciente");
		try {
			
			Optional<PacienteJPA> paci = repo.findById(id);
			if(paci.isPresent()) {
				repo.delete(paci.get());
			}else {
				System.out.println("ID no existe");
			}
			
			return true;
			
		} catch (Exception e) {
			System.out.println("fallo al borrar Paciente");
			e.printStackTrace();
			return false;
		}
		
	}
	
	@Override
	public List <PacienteDTO> obtenerPacientes(){
		List<PacienteJPA> pacientes = repo.findAll();
		
		return convertidor.convertirLista(pacientes);
	}
	
	@Override
	public PacienteDTO getPacienteById(int id) {
		System.out.println("ini: getPacienteById");
		try {
			
			Optional<PacienteJPA> paci = repo.findById(id);
			if(paci.isPresent()) {
				return new PacienteDTO(paci.get());
			}else {
				System.out.println("ID no existe");
			}
			
			return null;
			
		} catch (Exception e) {
			System.out.println("fallo al obtener al paciente");
			e.printStackTrace();
			return null;
		}
		
	}
	

}
