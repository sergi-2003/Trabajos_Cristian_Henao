package clases;

import javax.swing.JOptionPane;

public class Persona {
	private String numeroDeDNI;
	   private String nombre;
	   private String apellido;
	   private String fechaDeNacimiento;
	   private String direccion;
	   private String ciudadDeProcedecia;
	   
	   public void imprimirDatosPersona(String datos) {
		 
		   datos += "Nombre: "+ nombre+ "\n";
		   datos += "Apellido"+apellido+"\n";
		   datos += "Fecha de nacimiento"+fechaDeNacimiento+"\n";
		   datos += "Direccion"+direccion+"\n";
		   datos += "Ciudad de procedencia"+ciudadDeProcedecia+"\n";
		   
		   System.out.println(datos);
	}
	   public void registrarDatos() {	   
	        numeroDeDNI = validarDato("Ingrese el número de documento");
	        nombre = validarDato("Ingrese el nombre");
	        apellido = validarDato("Ingrese el apellido");
	        fechaDeNacimiento = validarDato("Ingrese la fecha de nacimiento");
	        direccion = validarDato("Ingrese la dirección");
	        ciudadDeProcedecia = validarDato("Ingrese la ciudad de procedencia");

	        // Aquí puedes realizar las acciones adicionales con los datos ingresados
	        System.out.println("Todos los datos han sido registrados exitosamente.");
	    }
	    private  String validarDato(String mensaje) {
	        String dato = JOptionPane.showInputDialog(mensaje);

	        while (datoRepetido(dato)) {
	            JOptionPane.showMessageDialog(null, "El dato ya está registrado. Por favor, ingrese un dato diferente.", "Dato duplicado", JOptionPane.WARNING_MESSAGE);
	            dato = JOptionPane.showInputDialog(mensaje);
	        }

	        return dato;
	    }

	    private  boolean datoRepetido(String dato) {
	        if (dato.equals(numeroDeDNI) ||
	            dato.equals(nombre) ||
	            dato.equals(apellido) ||
	            dato.equals(fechaDeNacimiento) ||
	            dato.equals(direccion) ||
	            dato.equals(ciudadDeProcedecia)) {
	            return true;
	        }

	        return false;
	    }

	   
	   public String getNumeroDeDNI() {
	 		return numeroDeDNI;
	 	}
	 	public void setNumeroDeDNI(String numeroDeDNI) {
	 		this.numeroDeDNI = numeroDeDNI;
	 	}
	 	public String getNombre() {
	 		return nombre;
	 	}
	 	public void setNombre(String nombre) {
	 		this.nombre = nombre;
	 	}
	 	public String getApellido() {
	 		return apellido;
	 	}
	 	public void setApellido(String apellido) {
	 		this.apellido = apellido;
	 	}
	 	public String getFechaDeNacimiento() {
	 		return fechaDeNacimiento;
	 	}
	 	public void setFechaDeNacimiento(String fechaDeNacimiento) {
	 		this.fechaDeNacimiento = fechaDeNacimiento;
	 	}
	 	public String getDireccion() {
	 		return direccion;
	 	}
	 	public void setDireccion(String direccion) {
	 		this.direccion = direccion;
	 	}
	 	public String getCiudadDeProcedecia() {
	 		return ciudadDeProcedecia;
	 	}
	 	public void setCiudadDeProcedecia(String ciudadDeProcedecia) {
	 		this.ciudadDeProcedecia = ciudadDeProcedecia;
	 	}

}
