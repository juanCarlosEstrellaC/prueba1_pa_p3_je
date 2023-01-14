package com.example.demo.service;

import java.math.BigDecimal;

import com.example.demo.modelo.Transferencia;

public interface ITransferenciaService {

	public void realizarTransferencia(String numeroCuentaOrigen, String numeroCuentaDestino, BigDecimal monto);
	
	public void agregar(Transferencia transferencia);
	public void actualizar(Transferencia transferencia);
	public Transferencia encontrar(Integer id);
	public void eliminar(Integer id);
	
}
