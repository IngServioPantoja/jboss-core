package co.com.sp.dao;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import co.com.sp.domain.Grupo;

@Stateless
public class GrupoDaoImpl implements GrupoDao, Serializable {

	private static final long serialVersionUID = -2477192798003721698L;

	@PersistenceContext(unitName = "PersonaPU")
	EntityManager em;
	
	public List<Grupo> findAll() {
		@SuppressWarnings("unchecked")
		List<Grupo> lstGrupos = em.createNamedQuery("Grupo.findAll").getResultList();  
		return lstGrupos;
	}

	public Grupo findGrupoById(Grupo grupo) {
		return em.find(Grupo.class, grupo.getIdGrupo());
	}

	public void insertGrupo(Grupo grupo) {
		em.persist(grupo);
		
	}

	public void updateGrupo(Grupo grupo) {
		em.merge(grupo);
		
	}

	public void deleteGrupo(Grupo grupo) {
		em.merge(grupo);
		em.remove(grupo);
	}
	
}
