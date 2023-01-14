package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.modelo.CuentaBancaria;
import com.example.demo.repository.ICuentaBancariaRepository;

@Service
public class CuentaBancariaServiceImpl implements ICuentaBancariaService{

	@Autowired
	private ICuentaBancariaRepository iCuentaBancariaRepository;
	
	@Override
	public void agregar(CuentaBancaria cuentaBancaria) {
		this.iCuentaBancariaRepository.insertar(cuentaBancaria);
	}

	@Override
	public void actualizar(CuentaBancaria cuentaBancaria) {
		this.iCuentaBancariaRepository.actualizar(cuentaBancaria);
	}

	@Override
	public CuentaBancaria encontrar(String id) {
		return this.iCuentaBancariaRepository.buscar(id);
	}

	@Override
	public void eliminar(String id) {
		this.iCuentaBancariaRepository.borrar(id);
	}

}
