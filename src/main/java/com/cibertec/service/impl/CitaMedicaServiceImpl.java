package com.cibertec.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.cibertec.jpa.entity.CitaMedicaJPA;
import com.cibertec.jpa.repository.ICitaMedicaRepository;
import com.cibertec.model.dto.CitaMedicaDTO;
import com.cibertec.service.ICitaMedicaService;
import com.cibertec.util.Convertidor;

@Service("citamedicaservice")
public class CitaMedicaServiceImpl implements ICitaMedicaService{
	@Autowired
	@Qualifier("repositoriocita")
	private ICitaMedicaRepository repo;
	
	@Autowired
	@Qualifier("convertidor")
	private Convertidor convertidor;
	
	@Override
	public boolean crear(CitaMedicaDTO cita) {
		// TODO Auto-generated method stub
		System.out.println("ini: Crear Cita Médica");
		try {
			repo.save(new CitaMedicaJPA(cita));
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("No se creó la Cita Médica");
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean actualizar(CitaMedicaDTO cita) {
		// TODO Auto-generated method stub
		System.out.println("ini: Actualizar Cita Médica");
		try {
			repo.save(new CitaMedicaJPA(cita));
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("No se actualizó la Cita Médica");
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean borrar(int id) {
		// TODO Auto-generated method stub
		System.out.println("borrar Cita Médica");
		try {
				Optional<CitaMedicaJPA> cita = repo.findById(id);
				if (cita.isPresent()) {
					repo.delete(cita.get());
				} else {
					System.out.println("ID no existe");
				}
				
				return true;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("falló al borrar la Cita Médica");
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public List<CitaMedicaDTO> obtenerCitaMedica() {
		// TODO Auto-generated method stub
		List<CitaMedicaJPA> citas = repo.findAll();
		return convertidor.convertirListaCita(citas);
	}

	@Override
	public CitaMedicaDTO getCitaById(int id) {
		// TODO Auto-generated method stub
		System.out.println("ini: getCitaById");
		try {
				Optional<CitaMedicaJPA> cita = repo.findById(id);
				if (cita.isPresent()) {
					return new CitaMedicaDTO(cita.get());
				} else {
					System.out.println("ID no existe");
				}
				
				return null;
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("fallo al borrar la cita médica");
			e.printStackTrace();
			return null;
		}
	}
}
