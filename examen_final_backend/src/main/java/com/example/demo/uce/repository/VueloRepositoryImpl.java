package com.example.demo.uce.repository;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.example.demo.uce.repository.modelo.Vuelo;

@Repository
@Transactional
public class VueloRepositoryImpl implements IVueloRepository {
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<Vuelo> buscarVuelos() {
		TypedQuery<Vuelo> query = this.entityManager.createQuery("SELECT v from Vuelo v WHERE v.estado='D'",
				Vuelo.class);

		return query.getResultList();
	}

	

	@Override
	public void actualizarVuelo(Vuelo v) {
		entityManager.merge(v);

	}

	@Override
	public Vuelo buscarVueloDisponible(Integer numeroVuelo) {
		TypedQuery<Vuelo> query = this.entityManager
				.createQuery("SELECT v from Vuelo v WHERE v.numero=:numeroVuelo AND v.estado='D'", Vuelo.class);
		query.setParameter("numeroVuelo", numeroVuelo);
		List<Vuelo> lis = query.getResultList();
		if (lis.isEmpty()) {
			return null;
		} else {
			return lis.get(0);
		}
		
	}



	@Override
	public void crearVuelo(Vuelo vuelo) {
		entityManager.persist(vuelo);
		
	}

}
