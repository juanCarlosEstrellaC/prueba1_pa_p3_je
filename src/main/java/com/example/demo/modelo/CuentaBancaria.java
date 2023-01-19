package com.example.demo.modelo;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name ="cuenta_bancaria_modif")
public class CuentaBancaria {
	
	@Id
	@Column(name = "cb_numero")
	private String numero;
	
	@Column(name = "cb_tipo")
	private String tipo;
	
	@Column(name = "cb_saldo")
	private BigDecimal saldo;
	
	@Column(name = "cb_cedula_propietario")
	private String cedulaPropietario;

	
	
	@Override
	public String toString() {
		return "CuentaBancaria [numero=" + numero + ", tipo=" + tipo + ", saldo=" + saldo + ", cedulaPropietario="
				+ cedulaPropietario + "]";
	}

	//Get y set
	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public BigDecimal getSaldo() {
		return saldo;
	}

	public void setSaldo(BigDecimal saldo) {
		this.saldo = saldo;
	}

	public String getCedulaPropietario() {
		return cedulaPropietario;
	}

	public void setCedulaPropietario(String cedulaPropietario) {
		this.cedulaPropietario = cedulaPropietario;
	}
	
	
	
	
}
