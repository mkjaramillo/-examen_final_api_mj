package com.example.demo.uce.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.stereotype.Service;


import com.example.demo.uce.controller.VueloRestfulController;
import com.example.demo.uce.controller.DTO.ReservaDTO;
import com.example.demo.uce.repository.ICompraPasaje;
import com.example.demo.uce.repository.modelo.Cliente;
import com.example.demo.uce.repository.modelo.CompraPasaje;
import com.example.demo.uce.repository.modelo.Vuelo;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Service
public class CompraPasajeServiceImpl implements ICompraPasajeService {
	@Autowired
	private ICompraPasaje pasajeRepository;
	@Autowired
	private IVueloService vueloServicio;
	@Autowired
	private IClienteService clienteService;

	@Override
	public String reservar(ReservaDTO r) {
		if(vueloServicio.buscarVuelo2(r.getNumero())==null) {
			return "El vuelo no esta disponible no se puede realizar la compra";
		}else {
			Vuelo v= vueloServicio.buscarVuelo2(r.getNumero());
			CompraPasaje c= new CompraPasaje();
			Cliente cl= new Cliente();
			if(r.getCantidad()>v.getAsientosDisponibles()) {
				return "exede la cantidad de asientos disponibles";
			}else {
				cl.setNombre(r.getNombre());
				c.setFechaCompra(LocalDate.now());
				c.setNumeroTarjeta(r.getTarjeta());
				c.setNumero(new Date().getSeconds());
				c.setCantidadAsientosComprados(r.getCantidad());
				c.setEstado("R");
				c.setVuelo(v);
				c.setCliente(cl);
				clienteService.crearCliente(cl);
				pasajeRepository.crearCompra(c);
				Integer asiento=v.getAsientosDisponibles()-r.getCantidad();
				v.setAsientosDisponibles(asiento);
				if(asiento==0) {
					v.setEstado("ND");
				}
				vueloServicio.actualizarVuelo(v);
				return "se realizo con exito la reserva";
				
			}
		}

	}

	@Override
	public void checkIn(Integer numero) {
		CompraPasaje c=pasajeRepository.buscarPasaje(numero);
		c.setEstado("I");
		pasajeRepository.actualizar(c);
		
		
	}

	

}
