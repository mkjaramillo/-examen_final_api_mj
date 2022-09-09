package com.example.demo.uce.controller;

import java.util.List;
import javax.xml.ws.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.uce.repository.modelo.Vuelo;
import com.example.demo.uce.service.IVueloService;
import com.example.demo.uce.service.to.Asiento;
import com.example.demo.uce.service.to.vueloTo;



@RestController
@RequestMapping("/vuelos")
@CrossOrigin("http://localhost:8080/")
public class VueloRestfulController {
	@Autowired
	private IVueloService vueloServicio;
	@PostMapping
	public String crearVuelo(@RequestBody Vuelo v) {
		vueloServicio.crearVuelo(v);
		return "se creo vuelo";
		
	}
	@GetMapping
	public List<vueloTo> mostraVuelo(@RequestParam("origen")String origen,@RequestParam("destino")String destino,@RequestParam("fecha") String fecha){
		return vueloServicio.buscarVuelos(origen, destino, fecha);
		
	}
	@GetMapping("disponibles/{numero}")
	public ResponseEntity<Asiento> buscarVueloDisponible(@PathVariable("numero")Integer numero) {
		return	ResponseEntity.ok((vueloServicio.buscarVuelo(numero)));
	}
	
	
}
