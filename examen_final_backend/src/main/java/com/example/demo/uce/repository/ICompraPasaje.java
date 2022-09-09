package com.example.demo.uce.repository;

import java.util.List;

import com.example.demo.uce.repository.modelo.CompraPasaje;

public interface ICompraPasaje {
public void crearCompra(CompraPasaje pasaje);
public CompraPasaje buscarPasaje(Integer numero);
public void actualizar(CompraPasaje pasaje);

} 
