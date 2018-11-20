package com.finanzas.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "flujos")
public class Flujo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	//Misc
	@ManyToOne
	@JoinColumn(name = "contrato_id", nullable = false)
	private Contrato contratoId;
	
	//Resultados del Arrendamiento
	@Size(min = 3, message = "Plazo de gracia debe tener como minimo 3 caracteres")
	@Column(name = "plazo_gracia", nullable = false, length = 150)
	private String plazoGracia;

	@Column(name = "saldo_inicial", nullable = false)
	private double saldoInicial;
	
	@Column(name = "interes", nullable = false)
	private double interes;
	
	@Column(name = "cuota", nullable = false)
	private double cuota;
	
	@Column(name = "amortizacion", nullable = false)
	private double amortizacion;
	
	@Column(name = "seguro_riesgo", nullable = false)
	private double seguroRiesgo;
	
	@Column(name = "comision", nullable = false)
	private double comision;
	
	@Column(name = "recompra", nullable = false)
	private double recompra;
	
	@Column(name = "saldo_final", nullable = false)
	private double saldoFinal;
	
	@Column(name = "depreciacion", nullable = false)
	private double depreciacion;
	
	@Column(name = "ahorro_tributario", nullable = false)
	private double ahorroTributario;

	@Column(name = "igv", nullable = false)
	private double igv;
	
	@Column(name = "flujo_bruto", nullable = false)
	private double flujoBruto;
	
	@Column(name = "flujo_igv", nullable = false)
	private double flujoIGV;
	
	@Column(name = "flujo_neto", nullable = false)
	private double flujoNeto;

	@Column(name = "numeroFila", nullable = false)
	private int numeroFila;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Contrato getContratoId() {
		return contratoId;
	}

	public void setContratoId(Contrato contratoId) {
		this.contratoId = contratoId;
	}

	public String getPlazoGracia() {
		return plazoGracia;
	}

	public void setPlazoGracia(String plazoGracia) {
		this.plazoGracia = plazoGracia;
	}

	public double getSaldoInicial() {
		return saldoInicial;
	}

	public void setSaldoInicial(double saldoInicial) {
		this.saldoInicial = saldoInicial;
	}

	public double getInteres() {
		return interes;
	}

	public void setInteres(double interes) {
		this.interes = interes;
	}

	public double getCuota() {
		return cuota;
	}

	public void setCuota(double cuota) {
		this.cuota = cuota;
	}

	public double getAmortizacion() {
		return amortizacion;
	}

	public void setAmortizacion(double amortizacion) {
		this.amortizacion = amortizacion;
	}

	public double getSeguroRiesgo() {
		return seguroRiesgo;
	}

	public void setSeguroRiesgo(double seguroRiesgo) {
		this.seguroRiesgo = seguroRiesgo;
	}

	public double getComision() {
		return comision;
	}

	public void setComision(double comision) {
		this.comision = comision;
	}

	public double getRecompra() {
		return recompra;
	}

	public void setRecompra(double recompra) {
		this.recompra = recompra;
	}

	public double getSaldoFinal() {
		return saldoFinal;
	}

	public void setSaldoFinal(double saldoFinal) {
		this.saldoFinal = saldoFinal;
	}

	public double getDepreciacion() {
		return depreciacion;
	}

	public void setDepreciacion(double depreciacion) {
		this.depreciacion = depreciacion;
	}

	public double getAhorroTributario() {
		return ahorroTributario;
	}

	public void setAhorroTributario(double ahorroTributario) {
		this.ahorroTributario = ahorroTributario;
	}

	public double getIgv() {
		return igv;
	}

	public void setIgv(double igv) {
		this.igv = igv;
	}

	public double getFlujoBruto() {
		return flujoBruto;
	}

	public void setFlujoBruto(double flujoBruto) {
		this.flujoBruto = flujoBruto;
	}

	public double getFlujoIGV() {
		return flujoIGV;
	}

	public void setFlujoIGV(double flujoIGV) {
		this.flujoIGV = flujoIGV;
	}

	public double getFlujoNeto() {
		return flujoNeto;
	}

	public void setFlujoNeto(double flujoNeto) {
		this.flujoNeto = flujoNeto;
	}
	
	
}
