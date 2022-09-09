package com.example.demo.uce.repository.modelo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "avion")
public class Avion {
	@Id
	@Column(name = "avio_id")
	private Integer id;
	@Column(name = "avio_capacidad_asientos")
	private Integer capacidadAsientos;
	@Column(name = "avio_nombre")
	private String nombreAvion;
	
	
	

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "avion",fetch = FetchType.LAZY)
	private List<Vuelo> listaVuelo= new ArrayList<>();
	public String getNombreAvion() {
		return nombreAvion;
	}

	public void setNombreAvion(String nombreAvion) {
		this.nombreAvion = nombreAvion;
	}
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCapacidadAsientos() {
		return capacidadAsientos;
	}

	public void setCapacidadAsientos(Integer capacidadAsientos) {
		this.capacidadAsientos = capacidadAsientos;
	}

	public List<Vuelo> getListaVuelo() {
		return listaVuelo;
	}

	public void setListaVuelo(List<Vuelo> listaVuelo) {
		this.listaVuelo = listaVuelo;
	}

}
