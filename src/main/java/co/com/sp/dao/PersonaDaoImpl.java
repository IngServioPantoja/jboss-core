package co.com.sp.dao;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import co.com.sp.domain.Persona;

@Stateless
public class PersonaDaoImpl implements PersonaDao, Serializable{

	private static final long serialVersionUID = -8339847219157556056L;

	@PersistenceContext(unitName = "jboss-core-pu")
	EntityManager em;

	@SuppressWarnings("unchecked")
	public List<Persona> findAllPersonas() {
		List<Persona> lstPersonas = em.createNamedQuery("Persona.findAll").getResultList();
		if(lstPersonas.size()>0){
			return lstPersonas;
		}else{
			return new ArrayList<Persona>();
		}
		
	}

	public Persona findPersonaById(Persona persona) {
		return em.find(Persona.class, persona.getIdPersona());
	}

	public Persona findPersonaByEmail(Persona persona) {
		Query query = em.createQuery("from Persona p where p.email = :email");
		query.setParameter("email", persona.getEmail());
		return (Persona) query.getSingleResult();
	}
	
	@SuppressWarnings("unused")
	public boolean encontrarCedula(String cedula)throws SQLException{
		
		 try{
		 	Query query = em.createQuery("from Persona p where p.identificacion = :identificacion");
			query.setParameter("identificacion", cedula);
			Persona persona = (Persona) query.getSingleResult();
			return true;
	    } catch(NoResultException e) {
	        return false;
	    }
	}

	public void insertPersona(Persona persona) {
		em.persist(persona);
	}

	public void updatePersona(Persona persona) {
		em.merge( persona );
	}

	public void deletePersona(Persona persona) {
		persona = em.find(Persona.class, persona.getIdPersona());
		em.remove( persona );
	}

}
