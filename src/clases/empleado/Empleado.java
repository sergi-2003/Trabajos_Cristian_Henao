package clases.empleado;

import javax.swing.JOptionPane;

import clases.Persona;

public class Empleado extends Persona {
	private String codigoDeEmpleado;
	private int numeroDeHorasExtras;
	private String fechaDeIngreso;
	private String area;
	private String cargo;
	
	@Override
	public void imprimirDatosPersona(String datos) {
		super.imprimirDatosPersona(datos);
		
		datos= "Codigo De Empleados: "+codigoDeEmpleado+"\n";
		datos+= "Numeros de Horas extras: "+numeroDeHorasExtras+"\n";
		datos+="Fecha de Ingreso"+fechaDeIngreso+"\n";
		datos+="Area "+area+"\n";
		datos+="Cargo: "+cargo+"\n";
		
		System.out.println(datos);
	}
	public void registrarDatos() {
		super.registrarDatos();
		
		codigoDeEmpleado=JOptionPane.showInputDialog("Ingrese el codigo de el empleado");
		numeroDeHorasExtras=Integer.parseInt(JOptionPane.showInputDialog("Ingrese el numro de horas Extras: "));
		fechaDeIngreso=JOptionPane.showInputDialog("Ingrese la fecha de ingreso dd/mm/aaaa");
		area=JOptionPane.showInputDialog("Ingrese el area");
		cargo=JOptionPane.showInputDialog("Ingrese el cargo");
	}
	
	
	public String getCodigoDeEmpleado() {
		return codigoDeEmpleado;
	}
	public void setCodigoDeEmpleado(String codigoDeEmpleado) {
		this.codigoDeEmpleado = codigoDeEmpleado;
	}
	public int getNumeroDeHorasExtras() {
		return numeroDeHorasExtras;
	}
	public void setNumeroDeHorasExtras(int numeroDeHorasExtras) {
		this.numeroDeHorasExtras = numeroDeHorasExtras;
	}
	public String getFechaDeIngreso() {
		return fechaDeIngreso;
	}
	public void setFechaDeIngreso(String fechaDeIngreso) {
		this.fechaDeIngreso = fechaDeIngreso;
	}
	public String getAre() {
		return area;
	}
	public void setAre(String area) {
		this.area = area;
	}
	public String getCargo() {
		return cargo;
	}
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	
}
