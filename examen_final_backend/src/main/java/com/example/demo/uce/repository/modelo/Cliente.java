package com.example.demo.uce.repository.modelo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "cliente")
public class Cliente {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "secCliente")
	@SequenceGenerator(name = "secCliente", sequenceName = "secCliente",allocationSize = 1)
	@Column(name = "clie_id")
	private Integer id;
	@Column(name = "clie_nombre")
	private String nombre;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "cliente",fetch = FetchType.LAZY)
	private List<CompraPasaje> listaPasaje= new ArrayList<>();
	
	public List<CompraPasaje> getListaPasaje() {
		return listaPasaje;
	}

	public void setListaPasaje(List<CompraPasaje> listaPasaje) {
		this.listaPasaje = listaPasaje;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}
