package com.example.demo.correccion.repository;

import org.springframework.stereotype.Repository;

import com.example.demo.correccion.modelo.Transferencia2;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class TransferenciaRepoImpl implements ITransferenciaRepo {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void insertar(Transferencia2 transferencia) {
		this.entityManager.persist(transferencia);
	}

	
}
