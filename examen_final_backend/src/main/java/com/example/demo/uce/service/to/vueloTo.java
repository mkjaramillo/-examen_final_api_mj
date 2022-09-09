package com.example.demo.uce.service.to;

import java.io.Serializable;
import java.math.BigDecimal;

import org.springframework.hateoas.RepresentationModel;



public class vueloTo implements Serializable {
	private Integer numero;
	private BigDecimal valorAsiento;
	private String origen;
	private String destino; 
	private String categoria;
	private String nombreAvion;
	public vueloTo(Integer numero, BigDecimal valorAsiento, String origen, String destino, String categoria,
			String nombreAvion) {
		super();
		this.numero = numero;
		this.valorAsiento = valorAsiento;
		this.origen = origen;
		this.destino = destino;
		this.categoria = categoria;
		this.nombreAvion = nombreAvion;
	}
	public Integer getNumero() {
		return numero;
	}
	public void setNumero(Integer numero) {
		this.numero = numero;
	}
	public BigDecimal getValorAsiento() {
		return valorAsiento;
	}
	public void setValorAsiento(BigDecimal valorAsiento) {
		this.valorAsiento = valorAsiento;
	}
	public String getOrigen() {
		return origen;
	}
	public void setOrigen(String origen) {
		this.origen = origen;
	}
	public String getDestino() {
		return destino;
	}
	public void setDestino(String destino) {
		this.destino = destino;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public String getNombreAvion() {
		return nombreAvion;
	}
	public void setNombreAvion(String nombreAvion) {
		this.nombreAvion = nombreAvion;
	}
	
}
