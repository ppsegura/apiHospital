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

import com.cibertec.model.dto.CitaMedicaDTO;
import com.cibertec.service.impl.CitaMedicaServiceImpl;

@RestController
@RequestMapping("apiCitaMedica")
public class CitaMedicaRestController {
	
	/*
	 * JSON
	 {
	 "fecha_creacion": "2022-06-20",
	 "id_paciente": 1,
	 "id_medico": 1,
	 "area": "Cargiologia",
	 "id_hospital": 2,
	 "estado": "En Proceso"
	 }
	*/
	
	@Autowired
	@Qualifier("citamedicaservice")
	private CitaMedicaServiceImpl citaService;
	
	//endpoint: http://localhost:8083/apiCitaMedica/add
	@PostMapping("/add")
	public ResponseEntity<?> registrarCitaMedica(@RequestBody CitaMedicaDTO cita){
		System.out.println("ini: registrarCitaMedica");
		
		boolean flag = citaService.crear(cita);
		
		if (flag) {
			return new ResponseEntity<>(HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}
	}
	
	//endpoint: http://localhost:8083/apiCitaMedica/listar
	@GetMapping("/listar")
	public List<CitaMedicaDTO> obtenerCita(){
		System.out.println("ini: listarCitaMedica");

		return citaService.obtenerCitaMedica();
	}
	
	//endpoint: http://localhost:8083/apiCitaMedica/update
		@PutMapping("/update")
		public ResponseEntity<?> actualizarCitaMedica(@RequestBody CitaMedicaDTO cita){
			System.out.println("ini: actualizarCitaMedica");
			
			boolean flag = citaService.actualizar(cita);
			
			if(flag) {
				return new ResponseEntity<>(HttpStatus.OK);
			}else {
				return new ResponseEntity<>(HttpStatus.CONFLICT);
			}
			
		}
		
		//endpoint: http://localhost:8083/apiCitaMedica/eliminar
		@DeleteMapping("/eliminar/{id}")
		public ResponseEntity<?> eliminarCitaMedica(@PathVariable("id") int id){
			System.out.println("ini: eliminarCitaMedica");
			
			boolean flag = citaService.borrar(id);
			
			if(flag) {
				return new ResponseEntity<>(HttpStatus.OK);
			}else {
				return new ResponseEntity<>(HttpStatus.CONFLICT);
			}
			
		}
		
		//endpoint: http://localhost:8083/apiCitaMedica/getCitaMedica
		@GetMapping("/getCitaMedica/{id}")
		public CitaMedicaDTO obtenerCitaMedica(@PathVariable("id") int id){
			System.out.println("ini: obtenerCitaMedica");
			
			return citaService.getCitaById(id);
			
		}
}
