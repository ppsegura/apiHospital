package com.cibertec.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.cibertec.jpa.entity.HistorialMedicoJPA;
import com.cibertec.jpa.repository.IHistorialMedicoRepository;
import com.cibertec.model.dto.HistorialMedicoDTO;
import com.cibertec.service.IHistorialMedicoService;
import com.cibertec.util.Convertidor;

@Service("historialservice")
public class HistorialMedicoServiceImpl implements IHistorialMedicoService{
	
	@Autowired
	@Qualifier("repositoriohistorial")
	private IHistorialMedicoRepository repo;
	
	@Autowired
	@Qualifier("convertidor")
	private Convertidor convertidor;
	
	@Override
	public boolean crear(HistorialMedicoDTO historial) {
		// TODO Auto-generated method stub
		System.out.println("ini: Crear Historial Medico");
		try {
			repo.save(new HistorialMedicoJPA(historial));
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("No se creó el historial medico");
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean actualizar(HistorialMedicoDTO historial) {
		// TODO Auto-generated method stub
		System.out.println("ini: Actualizar Historial Medico");
		try {
			repo.save(new HistorialMedicoJPA(historial));
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("No se actualizó el Historial medico");
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean borrar(int id) {
		// TODO Auto-generated method stub
		System.out.println("borrar Historial Medico");
		try {
				Optional<HistorialMedicoJPA> histo = repo.findById(id);
				if (histo.isPresent()) {
					repo.delete(histo.get());
				} else {
					System.out.println("ID no existe");
				}
				
				return true;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("falló al borrar Historial Medico");
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public List<HistorialMedicoDTO> obtenerHistorial() {
		// TODO Auto-generated method stub
		List<HistorialMedicoJPA> historiales = repo.findAll();
		return convertidor.convertirListaHistorial(historiales);
	}

	@Override
	public HistorialMedicoDTO getHistorialById(int id) {
		// TODO Auto-generated method stub
		System.out.println("ini: getHistorialById");
		try {
				Optional<HistorialMedicoJPA> histo = repo.findById(id);
				if (histo.isPresent()) {
					return new HistorialMedicoDTO(histo.get());
				} else {
					System.out.println("ID no existe");
				}
				
				return null;
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("fallo al borrar el historial medico");
			e.printStackTrace();
			return null;
		}
	}
}
