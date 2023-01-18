package com.example.demo.correccion.repository;

import org.springframework.stereotype.Repository;

import com.example.demo.correccion.modelo.Cuenta;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class CuentaRepoImpl implements ICuentaRepo {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void insertar(Cuenta cuenta) {
		this.entityManager.persist(cuenta);
	}

	@Override
	public void actualizar(Cuenta cuenta) {
		this.entityManager.merge(cuenta);
	}

	@Override
	public Cuenta buscar(String numero) {
		return this.entityManager.find(Cuenta.class, numero);
	}

	@Override
	public void eliminar(String numero) {
		Cuenta cuenta = this.buscar(numero);
		this.entityManager.remove(cuenta);
	}

}
