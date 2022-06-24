package com.cibertec.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cibertec.model.dto.MedicoDTO;
import com.cibertec.service.impl.MedicoServiceImpl;

@RestController
@RequestMapping("apiMedico")
public class MedicoRestController {
	
	/*
	 * JSON
	 {
	 "id_hospital": 2,
	 "nombre": "Carlos",
	 "ape_pat": "Rosales",
	 "ape_mat": "Valdivia",
	 "especialidad": "Cardiologia"
	 }
	*/
	@Autowired
	@Qualifier("medicoservice")
	private MedicoServiceImpl	medicoService;
	
	//endpoint: http://localhost:8083/apiMedico/add
	@PostMapping("/add")
	public ResponseEntity<?> registrarMedico(@RequestBody MedicoDTO medico){
		System.out.println("ini: registrarMedico");
		
		boolean flag = medicoService.crear(medico);
		
		if(flag) {
			return new ResponseEntity<>(HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}
		
		
	}
	
	//endpoint: http://localhost:8083/apiMedico/listar
	@GetMapping("/listar")
	public List<MedicoDTO> obtenerMedicos(){
		System.out.println("ini: listarMedico");
		
		return medicoService.obtenerMedicos();
	}
	
	/*
	 * JSON
	 {
	 "id_medico": 10,
	 "id_hospital": 2,
	 "nombre": "Jose Luis",
	 "ape_pat": "Rosales",
	 "ape_mat": "Abanto",
	 "especialidad": "Cardiologia"
	 }
	*/
	
	//endpoint: http://localhost:8083/apiMedico/update
	@PutMapping("/update")
	public ResponseEntity<?> actualizarMedico(@RequestBody MedicoDTO medico){
		System.out.println("ini: actualizarMedico");
		
		boolean flag = medicoService.actualizar(medico);
		
		if(flag) {
			return new ResponseEntity<>(HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}
		
	}
	
	//endpoint: http://localhost:8083/apiMedico/eliminar
	@DeleteMapping("/eliminar/{id}")
	public ResponseEntity<?> eliminarMedico(@PathVariable("id") int id){
		System.out.println("ini: borrarPaciente");
		
		boolean flag = medicoService.borrar(id);
		
		if(flag) {
			return new ResponseEntity<>(HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}
		
	}
	
	//endpoint: http://localhost:8083/apiMedico/getPaciente
	@GetMapping("/getPaciente/{id}")
	public MedicoDTO obtenerMedico(@PathVariable("id") int id){
		System.out.println("ini: obtenerMedico");
		
		return medicoService.getMedicoById(id);
		
	}

}
