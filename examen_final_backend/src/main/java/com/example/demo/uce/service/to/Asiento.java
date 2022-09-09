package com.example.demo.uce.service.to;

import java.io.Serializable;

public class Asiento implements Serializable {
	private Integer asientoDisponible;
	private Integer asientoOcupado;
	public Integer getAsientoDisponible() {
		return asientoDisponible;
	}
	public void setAsientoDisponible(Integer asientoDisponible) {
		this.asientoDisponible = asientoDisponible;
	}
	public Integer getAsientoOcupado() {
		return asientoOcupado;
	}
	public void setAsientoOcupado(Integer asientoOcupado) {
		this.asientoOcupado = asientoOcupado;
	}
	

}
