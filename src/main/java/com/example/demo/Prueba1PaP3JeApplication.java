package com.example.demo;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.correccion.modelo.Cuenta;
import com.example.demo.correccion.service.ICuentaService;
import com.example.demo.correccion.service.ITransferenciaService2;


@SpringBootApplication
public class Prueba1PaP3JeApplication implements CommandLineRunner {
// hola

	@Autowired
	private ICuentaService cuentaService;
	
	@Autowired
	private ITransferenciaService2 iTransferenciaService2;
	
	
	public static void main(String[] args) {
		SpringApplication.run(Prueba1PaP3JeApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Cuenta cuentaOrigen = new Cuenta();
		cuentaOrigen.setNumero("132");
		cuentaOrigen.setTipo("A");
		cuentaOrigen.setSaldo(new BigDecimal(100));
		cuentaOrigen.setCedulaPropietario("1321651");
		
		this.cuentaService.guardar(cuentaOrigen);

		
		Cuenta cuentaDestino = new Cuenta();
		cuentaDestino.setNumero("133");
		cuentaDestino.setTipo("A");
		cuentaDestino.setSaldo(new BigDecimal(50));
		cuentaDestino.setCedulaPropietario("1321651");
		
		this.cuentaService.guardar(cuentaDestino);
		
		
		this.iTransferenciaService2.realizar("132", "133", new BigDecimal(10));
		
		System.out.println("El saldo actual es: ");
		System.out.println(this.cuentaService.encontrar("132").getSaldo());
		
	}

}
