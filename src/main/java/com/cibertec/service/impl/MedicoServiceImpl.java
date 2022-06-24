package com.cibertec.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.cibertec.jpa.entity.MedicoJPA;
import com.cibertec.jpa.entity.PacienteJPA;
import com.cibertec.jpa.repository.IMedicoRepository;
import com.cibertec.model.dto.MedicoDTO;
import com.cibertec.service.IMedicoService;
import com.cibertec.util.Convertidor;

@Service("medicoservice")
public class MedicoServiceImpl implements IMedicoService{
	
	@Autowired
	@Qualifier("repositoriomedico")
	private IMedicoRepository repo;
	
	@Autowired
	@Qualifier("convertidor")
	private Convertidor convertidor;
	
	@Override
	public boolean crear(MedicoDTO medico) {
		// TODO Auto-generated method stub
		System.out.println("ini: Crear Medico");
		try {
			repo.save(new MedicoJPA(medico));
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("No se creo al médico");
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean actualizar(MedicoDTO medico) {
		// TODO Auto-generated method stub
				System.out.println("ini: Crear Medico");
				try {
					repo.save(new MedicoJPA(medico));
					return true;
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println("No se creo al médico");
					e.printStackTrace();
					return false;
				}
	}

	@Override
	public boolean borrar(int id) {
		System.out.println("ini: borrar Medico");
		try {
			
			Optional<MedicoJPA> medi = repo.findById(id);
			if(medi.isPresent()) {
				repo.delete(medi.get());
			}else {
				System.out.println("ID no existe");
			}
			
			return true;
			
		} catch (Exception e) {
			System.out.println("fallo al borrar Medico");
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public List<MedicoDTO> obtenerMedicos() {
		// TODO Auto-generated method stub
		List<MedicoJPA> medicos = repo.findAll();
		return convertidor.convertirListaMedico(medicos);
	}

	@Override
	public MedicoDTO getMedicoById(int id) {
		System.out.println("ini: getMedicoById");
		try {
			
			Optional<MedicoJPA> medi = repo.findById(id);
			if(medi.isPresent()) {
				return new MedicoDTO(medi.get());
			}else {
				System.out.println("ID no existe");
			}
			
			return null;
			
		} catch (Exception e) {
			System.out.println("fallo al borrar al Medico");
			e.printStackTrace();
			return null;
		}
		
	}
}
