package clases.empleado;

import javax.swing.JOptionPane;

public class EmpleadoEventual extends Empleado{
	private double honorariosPorHora;
	  private String fechaTerminoContrato;
	  
	  @Override
	  public void imprimirDatosPersona(String datos) {
		  super.imprimirDatosPersona(datos);
		  
		  datos = "Horarios por hora: "+honorariosPorHora+"\n";
		  datos+= "Fecha Termino el Contrato: "+fechaTerminoContrato+"\n";
		  
		  System.out.println(datos);
	  }
	  
	  @Override
	  public void registrarDatos() {
		  super.registrarDatos();
		  
		  honorariosPorHora=Double.parseDouble(JOptionPane.showInputDialog("Ingrese el salario Mensual"));
		  fechaTerminoContrato=JOptionPane.showInputDialog("Ingrese fecha de nacimiento (dd/mm/aaaa)");
	  }
	  
	  public double getHonorariosPorHora() {
			return honorariosPorHora;
		}
		public void setHonorariosPorHora(double honorariosPorHora) {
			this.honorariosPorHora = honorariosPorHora;
		}
		public String getFechaTerminoContrato() {
			return fechaTerminoContrato;
		}
		public void setFechaTerminoContrato(String fechaTerminoContrato) {
			this.fechaTerminoContrato = fechaTerminoContrato;
		}
}
