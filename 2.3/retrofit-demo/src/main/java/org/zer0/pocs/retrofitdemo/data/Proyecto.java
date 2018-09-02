package org.zer0.pocs.retrofitdemo.data;

import java.util.List;

public class Proyecto {

	private String nombreProyecto;
	private String nombreCliente;
	private List<Empleado> lstEmpleados;

	public Proyecto() {
	}
	
	public Proyecto(String nombreProyecto, String nombreCliente) {
		super();
		this.nombreProyecto = nombreProyecto;
		this.nombreCliente = nombreCliente;
	}
	public String getNombreProyecto() {
		return nombreProyecto;
	}
	public void setNombreProyecto(String nombreProyecto) {
		this.nombreProyecto = nombreProyecto;
	}
	public List<Empleado> getLstEmpleados() {
		return lstEmpleados;
	}
	public void setLstEmpleados(List<Empleado> lstEmpleados) {
		this.lstEmpleados = lstEmpleados;
	}
	public String getNombreCliente() {
		return nombreCliente;
	}
	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}
	
}
