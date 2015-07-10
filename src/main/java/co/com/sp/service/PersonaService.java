package co.com.sp.service;

import java.sql.SQLException;
import java.util.List;

import javax.ejb.Local;

import co.com.sp.domain.Persona;

@Local
public interface PersonaService {

	public List<Persona> listarPersonas();
	
	public boolean encontrarCedula(String cedula) throws SQLException;
	
	public Persona encontrarPersonaPorId(Persona persona);
	
	public Persona econtrarPersonaPorEmail(Persona persona);

	public void registrarPersona(Persona persona);

	public void modificarPersona(Persona persona);

	public void eliminarPersona(Persona persona)throws SQLException;
}
