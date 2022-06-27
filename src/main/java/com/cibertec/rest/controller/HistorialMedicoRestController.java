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

import com.cibertec.model.dto.HistorialMedicoDTO;
import com.cibertec.service.impl.HistorialMedicoServiceImpl;

@RestController
@RequestMapping("apiHistorialMedico")
public class HistorialMedicoRestController {
	
	/*
	 * JSON
	 {
	 "id_citamedica": 1,
	 "sintomas": "Náuseas, Dolor de estómago",
	 "diagnostico": "Fiebre",
	 "peso": 70.00,
	 "altura": 165.00
	 }
	*/
	
	@Autowired
	@Qualifier("historialservice")
	private HistorialMedicoServiceImpl historialService;
	
	//endpoint: http://localhost:8083/apiHistorialMedico/add
	@PostMapping("/add")
	public ResponseEntity<?> registrarHistorial(@RequestBody HistorialMedicoDTO historial){
		System.out.println("ini: registrarHistorial");
		
		boolean flag = historialService.crear(historial);
		
		if (flag) {
			return new ResponseEntity<>(HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}
	}
	
	//endpoint: http://localhost:8083/apiHistorialMedico/listar
	@GetMapping("/listar")
	public List<HistorialMedicoDTO> obtenerHistorial(){
		System.out.println("ini: listarHistorial");

		return historialService.obtenerHistorial();
	}
	
	//endpoint: http://localhost:8083/apiHistorialMedico/update
		@PutMapping("/update")
		public ResponseEntity<?> actualizarHistorial(@RequestBody HistorialMedicoDTO historial){
			System.out.println("ini: actualizarHistorial");
			
			boolean flag = historialService.actualizar(historial);
			
			if(flag) {
				return new ResponseEntity<>(HttpStatus.OK);
			}else {
				return new ResponseEntity<>(HttpStatus.CONFLICT);
			}
			
		}
		
		//endpoint: http://localhost:8083/apiHistorialMedico/eliminar
		@DeleteMapping("/eliminar/{id}")
		public ResponseEntity<?> eliminarHistorial(@PathVariable("id") int id){
			System.out.println("ini: borrarHistorial");
			
			boolean flag = historialService.borrar(id);
			
			if(flag) {
				return new ResponseEntity<>(HttpStatus.OK);
			}else {
				return new ResponseEntity<>(HttpStatus.CONFLICT);
			}
			
		}
		
		//endpoint: http://localhost:8083/apiHistorialMedico/getHistorial
		@GetMapping("/getHistorial/{id}")
		public HistorialMedicoDTO obtenerHistorial(@PathVariable("id") int id){
			System.out.println("ini: obtenerHistorial");
			
			return historialService.getHistorialById(id);
			
		}
}
