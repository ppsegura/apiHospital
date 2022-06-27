package com.cibertec.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.cibertec.jpa.entity.HospitalJPA;
import com.cibertec.jpa.repository.IHospitalRepository;
import com.cibertec.model.dto.HospitalDTO;
import com.cibertec.service.IHospitalService;
import com.cibertec.util.Convertidor;

@Service("hospitalservice")
public class HospitalServiceImpl implements IHospitalService{
	
	@Autowired
	@Qualifier("repositoriohospital")
	private IHospitalRepository repo;
	
	@Autowired
	@Qualifier("convertidor")
	private Convertidor convertidor;
	
	@Override
	public boolean crear(HospitalDTO hospital) {
		// TODO Auto-generated method stub
		System.out.println("ini: Crear Hospital");
		try {
			repo.save(new HospitalJPA(hospital));
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("No se creó el Hospital");
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean actualizar(HospitalDTO hospital) {
		// TODO Auto-generated method stub
		System.out.println("ini: Actualizar Hospital");
		try {
			repo.save(new HospitalJPA(hospital));
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("No se actualizó el Hospital");
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean borrar(int id) {
		// TODO Auto-generated method stub
		System.out.println("borrar Hospital");
		try {
				Optional<HospitalJPA> hospi = repo.findById(id);
				if (hospi.isPresent()) {
					repo.delete(hospi.get());
				} else {
					System.out.println("ID no existe");
				}
				
				return true;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("falló al borrar Hospital");
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public List<HospitalDTO> obtenerHospitales() {
		// TODO Auto-generated method stub
		List<HospitalJPA> hospitales = repo.findAll();
		return convertidor.convertirListaHospital(hospitales);
	}

	@Override
	public HospitalDTO getHospitalById(int id) {
		// TODO Auto-generated method stub
		System.out.println("ini: getHospitalById");
		try {
				Optional<HospitalJPA> hospi = repo.findById(id);
				if (hospi.isPresent()) {
					return new HospitalDTO(hospi.get());
				} else {
					System.out.println("ID no existe");
				}
				
				return null;
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("fallo al borrar el hospital");
			e.printStackTrace();
			return null;
		}
	}

}
