package com.example.demo.uce.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.example.demo.uce.repository.modelo.Cliente;

public interface IClienteRepository {
	
public void crearCliente(Cliente c);
}
