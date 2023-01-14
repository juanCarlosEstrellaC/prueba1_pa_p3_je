package com.example.demo.repository;

import org.springframework.stereotype.Repository;

import com.example.demo.modelo.Transferencia;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class TransferenciaRepositoryImpl implements ITransferenciaRepository {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void insertar(Transferencia transferencia) {
		this.entityManager.persist(transferencia);
	}

	@Override
	public void actualizar(Transferencia transferencia) {
		this.entityManager.merge(transferencia);
	}

	@Override
	public Transferencia buscar(Integer id) {
		return this.entityManager.find(Transferencia.class, id);
	}

	@Override
	public void borrar(Integer id) {
		Transferencia t = this.buscar(id);
		this.entityManager.remove(t);
	}

	
	
}
