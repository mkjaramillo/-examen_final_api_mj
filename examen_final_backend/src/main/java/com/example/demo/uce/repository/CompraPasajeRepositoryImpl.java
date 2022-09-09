package com.example.demo.uce.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.example.demo.uce.repository.modelo.CompraPasaje;
import com.example.demo.uce.repository.modelo.Vuelo;

@Repository
@Transactional
public class CompraPasajeRepositoryImpl implements ICompraPasaje {
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void crearCompra(CompraPasaje pasaje) {
		entityManager.persist(pasaje);

	}

	@Override
	public CompraPasaje buscarPasaje(Integer numero) {
		TypedQuery<CompraPasaje> query = this.entityManager
				.createQuery("SELECT c from CompraPasaje c WHERE c.numero=:numero", CompraPasaje.class);
		query.setParameter("numero", numero);
		return query.getResultList().get(0);

	}

	@Override
	public void actualizar(CompraPasaje pasaje) {
		entityManager.merge(pasaje);
		
	}

	

}
