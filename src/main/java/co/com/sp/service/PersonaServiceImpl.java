package co.com.sp.service;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.xml.ws.WebServiceContext;

import co.com.sp.dao.PersonaDao;
import co.com.sp.domain.Persona;

@Stateless
public class PersonaServiceImpl implements PersonaService, Serializable{
	
	private static final long serialVersionUID = 7143324113539318787L;

	@Resource
	private SessionContext contexto;
	
	@Resource
    WebServiceContext wsctx;
	
	@EJB
	private PersonaDao personaDao;
	

	public List<Persona> listarPersonas() {
    
	List<Persona> personas = personaDao.findAllPersonas();
	return personas;
	}
	
	public boolean encontrarCedula(String cedula)throws SQLException{
		return personaDao.encontrarCedula(cedula);
	}

	public Persona encontrarPersonaPorId(Persona persona) {
		return personaDao.findPersonaById(persona);
	}

	public Persona econtrarPersonaPorEmail(Persona persona) {
		return personaDao.findPersonaByEmail(persona);
	}

	public void registrarPersona(Persona persona) {
		personaDao.insertPersona(persona);
	}

	public void modificarPersona(Persona persona) {
		try{
			personaDao.updatePersona(persona);
		}catch(Throwable t){
			contexto.setRollbackOnly();
		}	
	}
	
	public void eliminarPersona(Persona persona) {
		personaDao.deletePersona(persona);
	}

}
