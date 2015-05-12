package co.com.sp.dao;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import co.com.sp.domain.Rol;

@Stateless
public class RolDaoImpl implements RolDao,Serializable {

	private static final long serialVersionUID = 8687698728894900360L;

	@PersistenceContext(unitName = "PersonaPU")
	EntityManager em;
	
	public List<Rol> findAll() {
		@SuppressWarnings("unchecked")
		List<Rol> lstRoles = em.createNamedQuery("Rol.findAll").getResultList();  
		return lstRoles;
	}

	public Rol findRolById(Rol rol) {
		return em.find(Rol.class, rol.getIdRol());
	}

	public void insertRol(Rol rol) {
		em.persist(rol);
		
	}

	public void updateRol(Rol rol) {
		em.merge(rol);
		
	}

	public void deleteRol(Rol rol) {
		rol = em.find(Rol.class, rol.getIdRol());
		em.remove(rol);
	}
	
	
	
	
}
