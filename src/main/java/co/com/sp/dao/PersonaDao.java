package co.com.sp.dao;

import java.sql.SQLException;
import java.util.List;

import co.com.sp.domain.Persona;

public interface PersonaDao {

	public List<Persona> findAllPersonas();

	public Persona findPersonaById(Persona persona);

	public Persona findPersonaByEmail(Persona persona);
	
	public boolean encontrarCedula(String cedula)throws SQLException;

	public void insertPersona(Persona persona);

	public void updatePersona(Persona persona);

	public void deletePersona(Persona persona);
}
