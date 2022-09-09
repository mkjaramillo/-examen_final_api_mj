package com.example.demo.uce.service;

import java.time.LocalDate;
import java.util.List;

import com.example.demo.uce.repository.modelo.Vuelo;
import com.example.demo.uce.service.to.Asiento;
import com.example.demo.uce.service.to.vueloTo;

public interface IVueloService {
	public void crearVuelo(Vuelo vuelo);
	public List<vueloTo> buscarVuelos(String origen,String destino, String fecha);
	public Asiento buscarVuelo(Integer numeroVuelo);
	public Vuelo buscarVuelo2(Integer numeroVuelo);
	
	public void actualizarVuelo(Vuelo v);
}
