package com.example.demo.correccion.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.correccion.modelo.Cuenta;
import com.example.demo.correccion.repository.ICuentaRepo;
import com.example.demo.correccion.repository.ITransferenciaRepo;
import com.example.demo.modelo.Transferencia;

@Service
public class TransferenciaServiceImpl2 implements ITransferenciaService2 {
	
	@Autowired
	private ICuentaRepo cuentaRepo;

	@Autowired
	private ITransferenciaRepo iTransferenciaRepo;
	@Override
	public void realizar(String numeroOrigen, String numeroDestino, BigDecimal monto) {
		// Origen:
		Cuenta origen = this.cuentaRepo.buscar(numeroOrigen);
		BigDecimal comision = monto.multiply(new BigDecimal(0.05));
		BigDecimal mondoDebitar = monto.add(comision);
		BigDecimal saldoActualOrigen = origen.getSaldo();

		
		if(saldoActualOrigen.compareTo(mondoDebitar)<0){
			System.out.println("Monto no permitido");
		}else {
			//Se realiza la transferencia:
			origen.setSaldo(saldoActualOrigen.subtract(mondoDebitar));
			this.cuentaRepo.actualizar(origen);
			
			// Destino:
			Cuenta destino = this.cuentaRepo.buscar(numeroDestino);
			BigDecimal saldoActualDestino = destino.getSaldo();
			destino.setSaldo(saldoActualDestino.add(monto));
			this.cuentaRepo.actualizar(destino);
			
			// Transferencia:
			Transferencia transfer = new Transferencia();
			transfer.setComision(comision);
			transfer.setFechaTransferencia(LocalDateTime.now());
			transfer.setMonto(monto);
			transfer.setCuentaOrigen(numeroOrigen);
			transfer.setCuentaDestino(numeroDestino);
			
			this.iTransferenciaRepo.insertar(transfer);
			
		}
		
		
		
		
	}

}
