package com.cibertec.rest.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/apiMedico")
public class MedicoRestController {

	@GetMapping("/listado")
	public String Medicos() {
		
		System.out.println("inicio servicio");
		
		String mensaje = "Hola mundo SpringBoot";
				
		return mensaje;
	}
}
