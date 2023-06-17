package clases;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import javax.swing.JOptionPane;

import clases.empleado.EmpleadoEventual;
import clases.empleado.EmpleadoPlantilla;
import clases.empleado.Medico;

public class ModeloDatos {
	HashMap<String , Paciente> pacientesMap;
	HashMap<String, EmpleadoPlantilla> empleadosPlantillaMap;
	HashMap<String, EmpleadoEventual> empleadoEventualMap;
	HashMap<String, Medico> medicosMap;
	ArrayList<CitaMedica> citasList;
   
	
	public void imprimirPaciente() {
		String msj = "PACIENTES REGISTRADOS\n";
		Iterator<String>iterator=pacientesMap.keySet().iterator();
		while (iterator.hasNext()) {
			String clave = iterator.next();
			pacientesMap.get(clave).imprimirDatosPersona(msj);
			
		}
	}
	
	public void imprimirEmpleadosEventuales() {
		String msj = "EMPLEADOS EVENTUALES REGISTRADOS\n";
        // Verificar si el empleadoEventualMap está vacío utilizando un bucle foreach
        boolean isEmpty = true;
        for (String clave : empleadoEventualMap.keySet()) {
            isEmpty = false;
            break;
        }

        if (!isEmpty) {
            for (String clave : empleadoEventualMap.keySet()) {
                empleadoEventualMap.get(clave).imprimirDatosPersona(msj);
            }
        } else {
            JOptionPane.showMessageDialog(null, "No hay ningún usuario", "Error", JOptionPane.ERROR_MESSAGE);
        }
	}
	
	public void imprimirEmpleadosPorPlantilla() {
		String msj = "EMPLEADOS POR PLANTILLA REGISTRADOS\n";
		boolean isEmpty = true;
		for (String clave : empleadosPlantillaMap.keySet()) {
			 isEmpty = false;
	            break;
		}
		if (!isEmpty) {
		for (CitaMedica clave : citasList) {
			empleadosPlantillaMap.get(clave).imprimirDatosPersona(msj);	
		}
		}else {
			JOptionPane.showMessageDialog(null, "no hay ningun usuario ","Error",JOptionPane.ERROR_MESSAGE);
		}
		
	}
	
	public void imprimirMedicos() {
		String msj = "MEDICOS REGISTRADOS\n";
	
		boolean isEmpty = true;
		for (Map.Entry<String, Medico> elemento : medicosMap.entrySet()) {
			 isEmpty = false;
	            break;
		}
		
		if (!isEmpty) {
			for (Map.Entry<String, Medico> elemento : medicosMap.entrySet()) {
				elemento.getValue().imprimirDatosPersona(msj);	
			}
		}else {
			JOptionPane.showMessageDialog(null, "no hay ningun usuario ","Error",JOptionPane.ERROR_MESSAGE);
		}
	}
	
    public void mostrarEmpleadosYMedicos() {
        StringBuilder mensaje = new StringBuilder();
        mensaje.append("Empleados:\n");
        for (Entry<String, EmpleadoPlantilla> entry : empleadosPlantillaMap.entrySet()) {
            String empleado = entry.getKey();
            EmpleadoPlantilla departamento = entry.getValue();
            mensaje.append(empleado).append(" - ").append(departamento).append("\n");
        }

        mensaje.append("\nMédicos:\n");
        for (Entry<String, Medico> entry : medicosMap.entrySet()) {
            String medico = entry.getKey();
            Medico especialidad = entry.getValue();
            mensaje.append(medico).append(" - ").append(especialidad).append("\n");
        }

        JOptionPane.showMessageDialog(null, mensaje.toString(), "Empleados y Médicos", JOptionPane.INFORMATION_MESSAGE);
    }
	
	public Paciente consultarPacientePorDocumento(String documetoPaciente) {
		Paciente miPaciente=null;
		
		if (pacientesMap.containsKey(documetoPaciente)) {
			miPaciente=pacientesMap.get(documetoPaciente);
		}
		
		return miPaciente;	
	}
	
	public Medico consultarMedicoPorNombre(String nombreMedico) {
		
	for (Medico medico : medicosMap.values()) {
		if (medico.getNombre().equalsIgnoreCase(nombreMedico)) {
			return medico;
		}
	}
	return null;
	}
	
	public void imprimirCitasMedicasProgramadas() {
		String msj = "Citas MEdicas Programadas\n";
		CitaMedica miCita= null;
		
		System.out.println(msj+"\n");
		if (citasList.size()>0) {
			for (int i = 0; i < citasList.size(); i++) {
				miCita=citasList.get(i);
				System.out.println(miCita.informacionCitaMedica());
			}
		}else {
			System.out.println("no ecisten citas programadas");
		}
	}
	
	public ModeloDatos() {
		pacientesMap=new HashMap<String, Paciente>();
		empleadosPlantillaMap=new HashMap<String, EmpleadoPlantilla>();
		medicosMap=new HashMap<String, Medico>();
		empleadoEventualMap=new HashMap<String, EmpleadoEventual>();
		citasList=new ArrayList<CitaMedica>();
	}
	
	public void registrarPersona(Paciente miPaciente) {
		pacientesMap.put(miPaciente.getNumeroDeDNI(),miPaciente);
		System.out.println("se ha registrado el paciente "+ miPaciente.getNombre()+" Satisfactoriamente");
	}
	
	public void registrarPersona(EmpleadoPlantilla miEmpPlantilla) {
		empleadosPlantillaMap.put(miEmpPlantilla.getNumeroDeDNI(),miEmpPlantilla);
		System.out.println("se ha registrado el paciente "+ miEmpPlantilla.getNombre()+" Satisfactoriamente");
	}
	
	public void registrarPersona(EmpleadoEventual miEmpEventual) {
		empleadoEventualMap.put(miEmpEventual.getNumeroDeDNI(),miEmpEventual);
		System.out.println("se ha registrado el paciente "+ miEmpEventual.getNombre()+" Satisfactoriamente");
	}
	
	public void registrarPersona(Medico miMedico ) {
		medicosMap.put(miMedico.getNumeroDeDNI(),miMedico);
		System.out.println("se ha registrado el paciente "+ miMedico.getNombre()+" Satisfactoriamente");
	}
	public void registrarCitasMedicas(CitaMedica miCita) {
		citasList.add(miCita);
		System.out.println("Se ha registrado la cita con exito \n");
		System.out.println(miCita.informacionCitaMedica());
	}


}
