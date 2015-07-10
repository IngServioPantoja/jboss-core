package co.com.sp.service;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.xml.ws.WebServiceContext;

import co.com.sp.dao.PersonaDao;
import co.com.sp.dao.UsuarioDao;
import co.com.sp.domain.Persona;
import co.com.sp.dto.OrdenCompra;
import co.com.sp.interfaces.MensajeServiceRemote;

@Stateless(name="personaService")
public class PersonaServiceImpl implements PersonaService, Serializable, MensajeServiceRemote{
	
	private static final long serialVersionUID = 7143324113539318787L;

	@Resource
	private SessionContext contexto;
	
	@Resource
    WebServiceContext wsctx;
	
	@EJB
	private PersonaDao personaDao;
	
	@EJB
	private UsuarioDao usuarioDao;
	
	public PersonaServiceImpl(){
		
	}
	
	public List<Persona> listarPersonas() {
    
//    Principal principal = contexto.getCallerPrincipal();
//	System.out.println(principal.getName());
//		List<Persona> personas = personaDao.findAllPersonas();
		List<Persona> personas = new ArrayList<Persona>();
		personas.add(new Persona((long)1));
		personas.add(new Persona((long)2));
		personas.add(new Persona((long)3));
		personas.add(new Persona((long)4));
		personas.add(new Persona((long)5));
		personas.add(new Persona((long)6));
		personas.add(new Persona((long)7));
		recorrerPersonas(personas);
		return personas;

	}
	public boolean encontrarCedula(String cedula)throws SQLException{
		System.out.println(cedula);
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
//			contexto.setRollbackOnly();
		}	
	}
	
	public void eliminarPersona(Persona persona) {
		personaDao.deletePersona(persona);
	}
	
	private void recorrerPersonas(List<Persona> personas){
		for (int i = 0; i < personas.size(); i++) {
			System.out.println(personas.get(i).getIdPersona());
		}
	}

	public void setPersonaDao(PersonaDao personaDao) {
		this.personaDao = personaDao;
	}

	public void setUsuarioDao(UsuarioDao usuarioDao) {
		this.usuarioDao = usuarioDao;
	}

	public OrdenCompra enviarMensaje(OrdenCompra orden) {
		orden.setId(orden.getId()+1);
		orden.setNombreSocio(orden.getNombreSocio()+" procesado");
		orden.setNumeroOrden(orden.getNumeroOrden()+" procesado");
		return orden;
	}
}
