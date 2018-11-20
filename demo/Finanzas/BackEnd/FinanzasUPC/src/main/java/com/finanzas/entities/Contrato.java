package com.finanzas.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;

@Entity
@Table(name = "contratos")
public class Contrato {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	//Misc
	
	@ManyToOne
	@JoinColumn(name = "usuario_id", nullable = false)
	private Usuario usuarioId;
	
	@Column(name = "moneda", nullable = false)
	private String moneda;
	
	//Datos del Prestamo
	@Column(name = "precio_venta", nullable = false)
	private double precioVenta;

	@Column(name = "numero_annos", nullable = false)
	private double numeroAnnos;
	
	@Column(name = "frecuencia_de_pago", nullable = false)
	private double frecuenciaDePago;

	@Column(name = "numero_dias_por_anno", nullable = false)
	private double numeroDiasPorAnno;

	@Column(name = "porcentaje_TEA", nullable = false)
	private double porcentajeTEA;

	@Column(name = "porcentaje_IGV", nullable = false)
	private double porcentajeIGV = 0.18;

	@Column(name = "porcentaje_impuesto_renta", nullable = false)
	private double porcentajeImpuestoRenta;

	@Column(name = "porcentaje_recompra", nullable = false)
	private double porcentajeRecompra;

	// Datos de los costes/gastos iniciales
	
	@Column(name = "costes_notariales", nullable = false)
	private double costesNotariales = 0;

	@Column(name = "costes_registrales", nullable = false)
	private double costesRegistrales = 0;

	@Column(name = "tasacion", nullable = false)
	private double tasacion = 0;

	@Column(name = "comision_estudio", nullable = false)
	private double comisionEstudio = 0;

	@Column(name = "comision_activacion", nullable = false)
	private double comisionActivacion = 0;

	// Datos de los costes/gastos periodicos

	@Column(name = "comision_periodica", nullable = false)
	private double comisionPeriodica = 0;

	@Column(name = "porcentaje_seguro_riesgo", nullable = false)
	private double porcentajeSeguroRiesgo = 0;

	// Datos del costo de oportunidad

	@Column(name = "tasa_descuento_k", nullable = false)
	private double tasaDescuentoKs = 0;

	@Column(name = "tasa_descuento_wacc", nullable = false)
	private double tasaDescuentoWACC = 0;

	//Plazo de gracia
	
	@Column(name = "plazogracia", nullable = false)
	private String plazogracia;
	
	@Column(name = "numeroCuotasPG", nullable = false)
	private int numeroCuotasPG = 0;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Usuario getUsuarioId() {
		return usuarioId;
	}

	public void setUsuarioId(Usuario usuarioId) {
		this.usuarioId = usuarioId;
	}

	public String getMoneda() {
		return moneda;
	}

	public void setMoneda(String moneda) {
		this.moneda = moneda;
	}

	public double getPrecioVenta() {
		return precioVenta;
	}

	public void setPrecioVenta(double precioVenta) {
		this.precioVenta = precioVenta;
	}

	public double getNumeroAnnos() {
		return numeroAnnos;
	}

	public void setNumeroAnnos(double numeroAnnos) {
		this.numeroAnnos = numeroAnnos;
	}

	public double getFrecuenciaDePago() {
		return frecuenciaDePago;
	}

	public void setFrecuenciaDePago(double frecuenciaDePago) {
		this.frecuenciaDePago = frecuenciaDePago;
	}

	public double getNumeroDiasPorAnno() {
		return numeroDiasPorAnno;
	}

	public void setNumeroDiasPorAnno(double numeroDiasPorAnno) {
		this.numeroDiasPorAnno = numeroDiasPorAnno;
	}

	public double getPorcentajeTEA() {
		return porcentajeTEA;
	}

	public void setPorcentajeTEA(double porcentajeTEA) {
		this.porcentajeTEA = porcentajeTEA;
	}

	public double getPorcentajeIGV() {
		return porcentajeIGV;
	}

	public void setPorcentajeIGV(double porcentajeIGV) {
		this.porcentajeIGV = porcentajeIGV;
	}

	public double getPorcentajeImpuestoRenta() {
		return porcentajeImpuestoRenta;
	}

	public void setPorcentajeImpuestoRenta(double porcentajeImpuestoRenta) {
		this.porcentajeImpuestoRenta = porcentajeImpuestoRenta;
	}

	public double getPorcentajeRecompra() {
		return porcentajeRecompra;
	}

	public void setPorcentajeRecompra(double porcentajeRecompra) {
		this.porcentajeRecompra = porcentajeRecompra;
	}

	public double getCostesNotariales() {
		return costesNotariales;
	}

	public void setCostesNotariales(double costesNotariales) {
		this.costesNotariales = costesNotariales;
	}

	public double getCostesRegistrales() {
		return costesRegistrales;
	}

	public void setCostesRegistrales(double costesRegistrales) {
		this.costesRegistrales = costesRegistrales;
	}

	public double getTasacion() {
		return tasacion;
	}

	public void setTasacion(double tasacion) {
		this.tasacion = tasacion;
	}

	public double getComisionEstudio() {
		return comisionEstudio;
	}

	public void setComisionEstudio(double comisionEstudio) {
		this.comisionEstudio = comisionEstudio;
	}

	public double getComisionActivacion() {
		return comisionActivacion;
	}

	public void setComisionActivacion(double comisionActivacion) {
		this.comisionActivacion = comisionActivacion;
	}

	public double getComisionPeriodica() {
		return comisionPeriodica;
	}

	public void setComisionPeriodica(double comisionPeriodica) {
		this.comisionPeriodica = comisionPeriodica;
	}

	public double getPorcentajeSeguroRiesgo() {
		return porcentajeSeguroRiesgo;
	}

	public void setPorcentajeSeguroRiesgo(double porcentajeSeguroRiesgo) {
		this.porcentajeSeguroRiesgo = porcentajeSeguroRiesgo;
	}

	public double getTasaDescuentoKs() {
		return tasaDescuentoKs;
	}

	public void setTasaDescuentoKs(double tasaDescuentoKs) {
		this.tasaDescuentoKs = tasaDescuentoKs;
	}

	public double getTasaDescuentoWACC() {
		return tasaDescuentoWACC;
	}

	public void setTasaDescuentoWACC(double tasaDescuentoWACC) {
		this.tasaDescuentoWACC = tasaDescuentoWACC;
	}

	public String getPlazogracia() {
		return plazogracia;
	}

	public void setPlazogracia(String plazogracia) {
		this.plazogracia = plazogracia;
	}

	public int getNumeroCuotasPG() {
		return numeroCuotasPG;
	}

	public void setNumeroCuotasPG(int numeroCuotasPG) {
		this.numeroCuotasPG = numeroCuotasPG;
	}
		
	
}
