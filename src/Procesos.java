
import javax.swing.JOptionPane;

import clases.CitaMedica;
import clases.ModeloDatos;
import clases.Paciente;
import clases.empleado.EmpleadoEventual;
import clases.empleado.EmpleadoPlantilla;
import clases.empleado.Medico;

public class Procesos {
ModeloDatos miModeloDatos;
	
	public Procesos() {
		miModeloDatos=new ModeloDatos();
		presentarMenuOpciones();
	}

	private void presentarMenuOpciones() {
    String menu="MENU HOSPITAL\n";
    menu+="1.Registrar Paciente\n";
    menu+="2.Registrar Empleado\n";
    menu+="3.Registrar Cita Medica\n";
    menu+="4.Imprimir Informacion\n";
    menu+="5.Salir\n";
    menu+="INGRESE UNA OPCION\n";
    
    int opcion=0;
   
	   do {
			opcion=Integer.parseInt(JOptionPane.showInputDialog(menu));
			switch (opcion) {
			case 1:
				 registrarPaciente();
				break;
			case 2:
				registrarEmpleado();
				break;
			case 3:
				registrarCitaMedica();
				break;
			case 4:
				imprimirInformacion();
				break;
			case 5:
				 JOptionPane.showInternalMessageDialog(null, "El sistema ha terminado!");
				break;
			default:JOptionPane.showMessageDialog(null,"No existe el codigo,verifique nuevamente ");
				break;
			}
	} while (opcion!=5);

	}
	private void registrarPaciente() {
		Paciente miPaciente=new Paciente();
		miPaciente.registrarDatos();
		
		miModeloDatos.registrarPersona(miPaciente);
	}

	private void registrarEmpleado() {
		String menuTipoEmpleado = JOptionPane.showInputDialog("REGISTRO DE EMPLEADO \n"+
				"1. Empleado Eventual \n"+
				"2. Empleado por Plantilla \n"+
				"3.Seleccione el tipo de empleado a registrar");
		
		int tipoEmpleado = Integer.parseInt(JOptionPane.showInputDialog(menuTipoEmpleado));
		
		switch (tipoEmpleado) {
		case 1://Registro Empleado Eventual
			EmpleadoEventual miEmpleadoEventual=new EmpleadoEventual();
			miEmpleadoEventual.registrarDatos();
			miModeloDatos.registrarPersona(miEmpleadoEventual);
			break;
		case 2:
			String resp = JOptionPane.showInputDialog("Ingres si , si en un medioco , de lo contrario es otro tipo de empleado");
			if (resp.equalsIgnoreCase("si")) {
				//registro de medico
				Medico miMedico=new Medico();
				miMedico.registrarDatos();
				miModeloDatos.registrarPersona(miMedico);
			}else {
				//registrar empleadoPlantilla
				EmpleadoPlantilla miEmpleadoPlantilla=new EmpleadoPlantilla();
				miEmpleadoPlantilla.registrarDatos();
				miModeloDatos.registrarPersona(miEmpleadoPlantilla);
			}
			break;

		default:
			System.out.println("El tipo de empleado no es valido, intentelo nuevamente");
			break;
		}
		
	}
	
	private void registrarCitaMedica() {
		String documentosPaciente=JOptionPane.showInputDialog("Ingrese el documento del paciente");
		
		Paciente pacienteEncontardo= miModeloDatos.consultarPacientePorDocumento(documentosPaciente);
		
		if (pacienteEncontardo!=null) {
			String nombreMedico=JOptionPane.showInputDialog("Ingrese el nombre de el medico");
			Medico medicoEncontrado = miModeloDatos.consultarMedicoPorNombre(nombreMedico);
			if (medicoEncontrado!=null) {
				String servicio = JOptionPane.showInputDialog("INgrese el motivo de la consulta");
				String fechaConsulta = JOptionPane.showInputDialog("Ingrese la fecha de la consulta");
				String horaConsulta = JOptionPane.showInputDialog("Ingrese la hora de la consulta");
				
				String lugar = "La cita sera en consultorio"+medicoEncontrado.getNumerosDeConsultorio();
				CitaMedica miCita=new CitaMedica(pacienteEncontardo, medicoEncontrado, servicio, fechaConsulta, horaConsulta, lugar);
				miModeloDatos.registrarCitasMedicas(miCita);
			}else {
				System.out.println("El medicamento no se encuentra registrado en el sistema");
			}
		}else {
			System.out.println("El paciente no se encuentra registrado en el sistema");
		}
	}
	private void imprimirInformacion() {
		String menuImprimir = JOptionPane.showInputDialog("MENU IMPRECIONES \n"+
				"1. Listar Pacientes \n"+
				"2. Listar Empleados Eventuales \n"+
				"3. Listar Empleado Por Plantilla \n"+
				"4. Listar Medicos\n"+
				"5. Listar Citas Programadas\n"+
				"6. Listar medico empleado \n"+
				"INGRESE UNA OPCION");
		System.out.println("*************************************************");
		
		int opcion = Integer.parseInt(JOptionPane.showInputDialog(menuImprimir));
		switch (opcion) {
		case 1:
			miModeloDatos.imprimirPaciente();
			break;
		case 2:
			miModeloDatos.imprimirEmpleadosEventuales();
			break;
		case 3:
			miModeloDatos.imprimirEmpleadosPorPlantilla();
			break;
		case 4:
			miModeloDatos.imprimirMedicos();
			break;
		case 5:
			miModeloDatos.imprimirCitasMedicasProgramadas();
			break;
		case 6:
			miModeloDatos.mostrarEmpleadosYMedicos();
			break;
		default:
			System.out.println("No existe esta opción");
			break;
		}
		
	}

}
