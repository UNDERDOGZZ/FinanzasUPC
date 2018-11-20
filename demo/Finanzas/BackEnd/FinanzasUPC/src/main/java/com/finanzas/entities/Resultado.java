package com.finanzas.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "resultados")
public class Resultado {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	//Misc
	
	@ManyToOne
	@JoinColumn(name = "contrato_id", nullable = false)
	private Contrato contratoId;
	
	// Resultados del Arrendamiento
	
	@Column(name = "igv", nullable = false)
	private double igv;

	@Column(name = "valor_venta", nullable = false)
	private double valorVenta;
	
	@Column(name = "monto_leasing", nullable = false)
	private double montoLeasing;

	@Column(name = "porcentaje_TEP",  nullable = false)
	private double porcentajeTEP;
	
	@Column(name = "numero_cuotas_anno", nullable = false)
	private double numeroCuotasAnno;
	
	@Column(name = "numero_total_cuotas", nullable = false)
	private double numeroTotalCuotas;
	
	// Resultados de los costes/gastos periodicos
	@Column(name = "seguro_riesgo", nullable = false)
	private double seguroRiesgo;

	// Resultados por...
	@Column(name = "intereses",  nullable = false)
	private double intereses = 0;

	@Column(name = "amortizacion_capital", nullable = false)
	private double amortizacionCapital = 0;
	
	@Column(name = "seguro_contra_riesgo", nullable = false)
	private double seguroContraRiesgo = 0;
	
	@Column(name = "comisiones_periodicas",  nullable = false)
	private double comisionesPeriodicas = 0;
	
	@Column(name = "recompra", nullable = false)
	private double recompra = 0;
	
	@Column(name = "desembolso_total",  nullable = false)
	private double desembolsoTotal = 0;

	// Datos del costo de oportunidad

	@Column(name = "tcea_flujo_bruto", nullable = false)
	private double tceaFlujoBruto = 0;
	
	@Column(name = "tcea_flujo_neto", nullable = false)
	private double tceaFlujoNeto = 0;
	
	@Column(name = "van_flujo_bruto", nullable = false)
	private double vanFlujoBruto = 0;
	
	@Column(name = "van_flujo_neto", nullable = false)
	private double vanFlujoNeto = 0;

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

	public double getIgv() {
		return igv;
	}

	public void setIgv(double igv) {
		this.igv = igv;
	}

	public double getValorVenta() {
		return valorVenta;
	}

	public void setValorVenta(double valorVenta) {
		this.valorVenta = valorVenta;
	}

	public double getMontoLeasing() {
		return montoLeasing;
	}

	public void setMontoLeasing(double montoLeasing) {
		this.montoLeasing = montoLeasing;
	}

	public double getPorcentajeTEP() {
		return porcentajeTEP;
	}

	public void setPorcentajeTEP(double porcentajeTEP) {
		this.porcentajeTEP = porcentajeTEP;
	}

	public double getNumeroCuotasAnno() {
		return numeroCuotasAnno;
	}

	public void setNumeroCuotasAnno(double numeroCuotasAnno) {
		this.numeroCuotasAnno = numeroCuotasAnno;
	}

	public double getNumeroTotalCuotas() {
		return numeroTotalCuotas;
	}

	public void setNumeroTotalCuotas(double numeroTotalCuotas) {
		this.numeroTotalCuotas = numeroTotalCuotas;
	}

	public double getSeguroRiesgo() {
		return seguroRiesgo;
	}

	public void setSeguroRiesgo(double seguroRiesgo) {
		this.seguroRiesgo = seguroRiesgo;
	}

	public double getIntereses() {
		return intereses;
	}

	public void setIntereses(double intereses) {
		this.intereses = intereses;
	}

	public double getAmortizacionCapital() {
		return amortizacionCapital;
	}

	public void setAmortizacionCapital(double amortizacionCapital) {
		this.amortizacionCapital = amortizacionCapital;
	}

	public double getSeguroContraRiesgo() {
		return seguroContraRiesgo;
	}

	public void setSeguroContraRiesgo(double seguroContraRiesgo) {
		this.seguroContraRiesgo = seguroContraRiesgo;
	}

	public double getComisionesPeriodicas() {
		return comisionesPeriodicas;
	}

	public void setComisionesPeriodicas(double comisionesPeriodicas) {
		this.comisionesPeriodicas = comisionesPeriodicas;
	}

	public double getRecompra() {
		return recompra;
	}

	public void setRecompra(double recompra) {
		this.recompra = recompra;
	}

	public double getDesembolsoTotal() {
		return desembolsoTotal;
	}

	public void setDesembolsoTotal(double desembolsoTotal) {
		this.desembolsoTotal = desembolsoTotal;
	}

	public double getTceaFlujoBruto() {
		return tceaFlujoBruto;
	}

	public void setTceaFlujoBruto(double tceaFlujoBruto) {
		this.tceaFlujoBruto = tceaFlujoBruto;
	}

	public double getTceaFlujoNeto() {
		return tceaFlujoNeto;
	}

	public void setTceaFlujoNeto(double tceaFlujoNeto) {
		this.tceaFlujoNeto = tceaFlujoNeto;
	}

	public double getVanFlujoBruto() {
		return vanFlujoBruto;
	}

	public void setVanFlujoBruto(double vanFlujoBruto) {
		this.vanFlujoBruto = vanFlujoBruto;
	}

	public double getVanFlujoNeto() {
		return vanFlujoNeto;
	}

	public void setVanFlujoNeto(double vanFlujoNeto) {
		this.vanFlujoNeto = vanFlujoNeto;
	}
	
	
}
