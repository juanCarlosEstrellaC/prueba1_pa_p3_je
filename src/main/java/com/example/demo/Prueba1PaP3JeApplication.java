package com.example.demo;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.modelo.CuentaBancaria;
import com.example.demo.service.ICuentaBancariaService;
import com.example.demo.service.ITransferenciaService;

@SpringBootApplication
public class Prueba1PaP3JeApplication implements CommandLineRunner {

	@Autowired
	private ITransferenciaService iTransferenciaService;
	
	@Autowired
	private ICuentaBancariaService iCuentaBancariaService;
	
	//
	
	public static void main(String[] args) {
		SpringApplication.run(Prueba1PaP3JeApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		CuentaBancaria cuenta1 = new CuentaBancaria();
		cuenta1.setNumero("1");
		cuenta1.setSaldo(new BigDecimal(100));
		cuenta1.setCedulaPropietario("123456789");
		cuenta1.setTipo("Ahorros");
		this.iCuentaBancariaService.agregar(cuenta1);
		
		
		CuentaBancaria cuenta2 = new CuentaBancaria();
		cuenta2.setNumero("2");
		cuenta2.setSaldo(new BigDecimal(10));
		cuenta2.setCedulaPropietario("123456789");
		cuenta2.setTipo("Corriente");
		this.iCuentaBancariaService.agregar(cuenta2);

		
		this.iTransferenciaService.realizarTransferencia(cuenta1.getNumero(), cuenta2.getNumero(), new BigDecimal(50));
		
		this.iCuentaBancariaService.encontrar(cuenta1.getNumero());
	}

}
