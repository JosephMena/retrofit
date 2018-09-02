package org.zer0.pocs.retrofitdemo.data;

public class Contrato {

	private double salarioBruto;
	private String nombreEmpleador;
	private int periodoEnMeses;
	
	public Contrato() {
	}
	
	public Contrato(double salarioBruto, String nombreEmpleador, int periodoEnMeses) {
		super();
		this.salarioBruto = salarioBruto;
		this.nombreEmpleador = nombreEmpleador;
		this.periodoEnMeses = periodoEnMeses;
	}

	public double getSalarioBruto() {
		return salarioBruto;
	}
	public void setSalarioBruto(double salarioBruto) {
		this.salarioBruto = salarioBruto;
	}
	public String getNombreEmpleador() {
		return nombreEmpleador;
	}
	public void setNombreEmpleador(String nombreEmpleador) {
		this.nombreEmpleador = nombreEmpleador;
	}
	public int getPeriodoEnMeses() {
		return periodoEnMeses;
	}
	public void setPeriodoEnMeses(int periodoEnMeses) {
		this.periodoEnMeses = periodoEnMeses;
	}
}
