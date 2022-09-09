package com.example.demo.uce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.uce.controller.DTO.ReservaDTO;
import com.example.demo.uce.service.ICompraPasajeService;

@RestController
@RequestMapping("/pasajes")
@CrossOrigin("http://localhost:8080/")
public class ComprarPasajeController {
@Autowired
ICompraPasajeService compraServicio;
@PostMapping
public String comprarPasaje(@RequestBody ReservaDTO r ) {
	return compraServicio.reservar(r);
}
@PutMapping("/{numero}")
public String checkIn(@PathVariable("numero")Integer numero) {
	String mensaje = "checkIn realizado con exito";
	try {
		compraServicio.checkIn(numero);
	} catch (Exception e) {
		mensaje = "Error intente mas tarde";
		
	}

	return mensaje;
}
}
