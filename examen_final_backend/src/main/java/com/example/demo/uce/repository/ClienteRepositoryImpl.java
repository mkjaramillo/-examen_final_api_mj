package com.example.demo.uce.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.example.demo.uce.repository.modelo.Cliente;
@Repository
@Transactional
public class ClienteRepositoryImpl implements IClienteRepository{
	@PersistenceContext
	private EntityManager entityManager;
	@Override
	public void crearCliente(Cliente c) {
		entityManager.persist(c);
	}

}
