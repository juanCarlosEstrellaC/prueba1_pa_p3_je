package com.example.demo.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.modelo.CuentaBancaria;
import com.example.demo.modelo.Transferencia;
import com.example.demo.repository.ICuentaBancariaRepository;
import com.example.demo.repository.ITransferenciaRepository;

@Service
public class TransferenciaServiceImpl implements ITransferenciaService {

	//@Autowired
	//private ITransferenciaService iTransferenciaService;
	
	@Autowired
	private ICuentaBancariaRepository iCuentaBancariaRepository;
	
	@Autowired
	private ITransferenciaRepository iTransferenciaRepository;
	
	@Override
	public void realizarTransferencia(String numeroCuentaOrigen, String numeroCuentaDestino, BigDecimal monto) {
		//Origen:
		CuentaBancaria origen = this.iCuentaBancariaRepository.buscar(numeroCuentaOrigen);
		
		BigDecimal val = monto.multiply(new BigDecimal(0.05));
		BigDecimal total = monto.add(val);

		
		if(total.compareTo(origen.getSaldo()) == -1){
			origen.setSaldo(origen.getSaldo().subtract(total));
		}else {
			System.out.println("No tiene saldo suficiente");
		}
		
		this.iCuentaBancariaRepository.actualizar(origen);
		
		
		//Destino:
		CuentaBancaria destino = this.iCuentaBancariaRepository.buscar(numeroCuentaDestino);
		
		destino.setSaldo(destino.getSaldo().add(monto));

		this.iCuentaBancariaRepository.actualizar(destino);	
		
		
		//Transferencia:
		Transferencia transfer = new Transferencia();
		//id dado por secuencia
		transfer.setFechaTransferencia(LocalDateTime.now());
		transfer.setCuentaOrigen(numeroCuentaOrigen);
		transfer.setCuentaDestino(numeroCuentaDestino);
		transfer.setMonto(monto);
		transfer.setComision(val);

		this.iTransferenciaRepository.insertar(transfer);
	}
	
	
	@Override
	public void agregar(Transferencia transferencia) {
		//this.iTransferenciaService.agregar(transferencia);
	}

	@Override
	public void actualizar(Transferencia transferencia) {
		
	}

	@Override
	public Transferencia encontrar(Integer id) {
		return null;
	}

	@Override
	public void eliminar(Integer id) {
		
	}



}
