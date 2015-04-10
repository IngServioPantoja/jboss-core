package co.com.sp.web;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import co.com.sp.domain.Persona;
import co.com.sp.service.PersonaService;



@ManagedBean
@ViewScoped
public class PersonaBean implements Serializable{

	private static final long serialVersionUID = -3211394890842682243L;
	
	@EJB
	private PersonaService personaService;
	
	List<Persona> personas;
	List<Persona> personasFiltradas;
	private Persona persona;

	public PersonaBean() {
		
	}

	@PostConstruct
	public void inicializar() {
		persona = new Persona();
	}

	public void cargarPersonas(){
		personas = personaService.listarPersonas();
	}
//
//	
//	public void definirActual(Persona persona){
//		this.persona = persona;
//	}
//	
	public List<Persona> getPersonas() {
		return personas;
	}

	public void setPersonas(List<Persona> personas) {
		this.personas = personas;
	}

	public List<Persona> getPersonasFiltradas() {
		return personasFiltradas;
	}

	public void setPersonasFiltradas(List<Persona> personasFiltradas) {
		this.personasFiltradas = personasFiltradas;
	}
//
//	public Persona getPersona() {
//		return persona;
//	}
//
//	public void setPersona(Persona persona) {
//		this.persona = persona;
//	}
//
//
//	private String console;
//	public String getConsole() {
//		return console;
//	}
//
//	public void setConsole(String console) {
//		this.console = console;
//	}

	
}