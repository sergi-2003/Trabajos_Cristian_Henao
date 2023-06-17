package clases;

import clases.empleado.Medico;

public class CitaMedica {
private Paciente paciente;
private Medico medico;
private String servicio;
private String fechaConsulta;
private String horaConsulta;
private String lugar;

public CitaMedica(Paciente paciente,Medico medico, String servicio,String fechaConsulta,String horaConsulta,String lugar) {
	this.paciente=paciente;
	this.medico=medico;
	this.servicio=servicio;
	this.fechaConsulta= fechaConsulta;
	this.horaConsulta=horaConsulta;
	this.lugar=lugar;
}

public String informacionCitaMedica() {
	String datosCitas="INFROMACION CITA MEDICA \n";
	datosCitas+= "Paciente: "+paciente.getNombre()+"\n";
	datosCitas+= "Medicos: "+medico.getNombre()+"\n";
	datosCitas+= "Motivo Consulta: "+servicio+"\n";
	datosCitas+= "Fecha Consulta: "+fechaConsulta+"\n";
	datosCitas+= "Lugar: "+lugar+"\n\n";
	
	return datosCitas;
}

public Paciente getPaciente() {
	return paciente;
}
public void setPaciente(Paciente paciente) {
	this.paciente = paciente;
}
public Medico getMedico() {
	return medico;
}
public void setMedico(Medico medico) {
	this.medico = medico;
}
public String getServicio() {
	return servicio;
}
public void setServicio(String servicio) {
	this.servicio = servicio;
}
public String getFechaConsulta() {
	return fechaConsulta;
}
public void setFechaConsulta(String fechaConsulta) {
	this.fechaConsulta = fechaConsulta;
}
public String getHoraConsulta() {
	return horaConsulta;
}
public void setHoraConsulta(String horaConsulta) {
	this.horaConsulta = horaConsulta;
}
public String getLugar() {
	return lugar;
}
public void setLugar(String lugar) {
	this.lugar = lugar;
}




}
