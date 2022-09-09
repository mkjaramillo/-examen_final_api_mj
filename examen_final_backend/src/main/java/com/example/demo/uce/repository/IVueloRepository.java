package com.example.demo.uce.repository;

import java.util.List;

import com.example.demo.uce.repository.modelo.Vuelo;

public interface IVueloRepository {
	public void crearVuelo(Vuelo vuelo);
	public List<Vuelo> buscarVuelos();
	public Vuelo buscarVueloDisponible(Integer numeroVuelo);
	public void actualizarVuelo(Vuelo v);
	
	
	
}
