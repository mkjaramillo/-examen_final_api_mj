package com.example.demo.uce.service;

import java.util.List;

import com.example.demo.uce.controller.DTO.ReservaDTO;
import com.example.demo.uce.repository.modelo.CompraPasaje;


public interface ICompraPasajeService {
public String reservar(ReservaDTO r);
public void checkIn(Integer numero);

}
