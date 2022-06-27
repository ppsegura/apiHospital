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

import com.cibertec.model.dto.HospitalDTO;
import com.cibertec.service.impl.HospitalServiceImpl;

@RestController
@RequestMapping("apiHospital")
public class HospitalRestController {

	/*
	 * JSON
	 {
	 "departamento": "Ica",
	 "distrito": "Ica",
	 "direccion": "Av Los Nogales 330"
	 }
	*/
	
	@Autowired
	@Qualifier("hospitalservice")
	private HospitalServiceImpl hospitalService;
	
	//endpoint: http://localhost:8083/apiHospital/add
	@PostMapping("/add")
	public ResponseEntity<?> registrarHospital(@RequestBody HospitalDTO hospital){
		System.out.println("ini: registrarHospital");
		
		boolean flag = hospitalService.crear(hospital);
		
		if (flag) {
			return new ResponseEntity<>(HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}
	}
	
	//endpoint: http://localhost:8083/apiHospital/listar
	@GetMapping("/listar")
	public List<HospitalDTO> obtenerHospital(){
		System.out.println("ini: listarHospitales");

		return hospitalService.obtenerHospitales();
	}
	
	//endpoint: http://localhost:8083/apiHospital/update
		@PutMapping("/update")
		public ResponseEntity<?> actualizarHospital(@RequestBody HospitalDTO hospital){
			System.out.println("ini: actualizarHospital");
			
			boolean flag = hospitalService.actualizar(hospital);
			
			if(flag) {
				return new ResponseEntity<>(HttpStatus.OK);
			}else {
				return new ResponseEntity<>(HttpStatus.CONFLICT);
			}
			
		}
		
		//endpoint: http://localhost:8083/apiHospital/eliminar
		@DeleteMapping("/eliminar/{id}")
		public ResponseEntity<?> eliminarHospital(@PathVariable("id") int id){
			System.out.println("ini: borrarHospital");
			
			boolean flag = hospitalService.borrar(id);
			
			if(flag) {
				return new ResponseEntity<>(HttpStatus.OK);
			}else {
				return new ResponseEntity<>(HttpStatus.CONFLICT);
			}
			
		}
		
		//endpoint: http://localhost:8083/apiHospital/getHospital
		@GetMapping("/getHospital/{id}")
		public HospitalDTO obtenerHospital(@PathVariable("id") int id){
			System.out.println("ini: obtenerHospital");
			
			return hospitalService.getHospitalById(id);
			
		}
}
