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

import com.cibertec.model.dto.PacienteDTO;
import com.cibertec.service.impl.PacienteServiceImpl;


@RestController
@RequestMapping("apiPaciente")
public class PacienteRestController {
	
	/*
	 * JSON
	 {
	 "nombres": "Juan",
	 "ape_pat": "Flores",
	 "ape_mat": "Rodriguez",
	 "correo": "juanfloresr@gmail.com",
	 "tipo_doc": "DNI",
	 "nro_doc": "44448888",
	 "fecha_nac":"1994-08-20",
	 "edad": 23
	 }
	*/
	@Autowired
	@Qualifier("pacienteservice")
	private PacienteServiceImpl	pacienteService;
	
	//endpoint: http://localhost:8083/apiPaciente/add
	@PostMapping("/add")
	public ResponseEntity<?> registrarPaciente(@RequestBody PacienteDTO paciente){
		System.out.println("ini: registrarPaciente");
		
		boolean flag = pacienteService.crear(paciente);
		
		if(flag) {
			return new ResponseEntity<>(HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}
		
		
	}
	
	//endpoint: http://localhost:8083/apiPaciente/listar
	@GetMapping("/listar")
	public List<PacienteDTO> obtenerPacientes(){
		System.out.println("ini: listarPaciente");
		
		return pacienteService.obtenerPacientes();
	}
	
	/*
	 * JSON
	 {
	 "id_paciente": 11,
	 "nombres": "Armando",
	 "ape_pat": "Flores",
	 "ape_mat": "Rodriguez",
	 "correo": "juanfloresr@gmail.com",
	 "tipo_doc": "DNI",
	 "nro_doc": "44448888",
	 "fecha_nac":"1994-08-20",
	 "edad": 29
	 }
	*/
	
	//endpoint: http://localhost:8083/apiPaciente/update
	@PutMapping("/update")
	public ResponseEntity<?> actualizarPaciente(@RequestBody PacienteDTO paciente){
		System.out.println("ini: actualizarPaciente");
		
		boolean flag = pacienteService.actualizar(paciente);
		
		if(flag) {
			return new ResponseEntity<>(HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}
		
	}
	
	//endpoint: http://localhost:8083/apiPaciente/eliminar
	@DeleteMapping("/eliminar/{id}")
	public ResponseEntity<?> eliminarPaciente(@PathVariable("id") int id){
		System.out.println("ini: borrarPaciente");
		
		boolean flag = pacienteService.borrar(id);
		
		if(flag) {
			return new ResponseEntity<>(HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}
		
	}
	
	//endpoint: http://localhost:8083/apiPaciente/getPaciente
	@GetMapping("/getPaciente/{id}")
	public PacienteDTO obtenerPaciente(@PathVariable("id") int id){
		System.out.println("ini: obtenerPaciente");
		
		return pacienteService.getPacienteById(id);
		
	}
	
}
