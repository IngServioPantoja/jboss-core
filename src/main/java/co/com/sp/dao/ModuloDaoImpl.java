package co.com.sp.dao;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import co.com.sp.domain.Modulo;

@Stateless
public class ModuloDaoImpl implements Serializable, ModuloDao {

	private static final long serialVersionUID = -4559384297575001821L;
	
	@PersistenceContext(unitName = "PersonaPU")
	EntityManager em;
	
	public List<Modulo> findAll() {
		@SuppressWarnings("unchecked")
		List<Modulo> lstModulos = em.createNamedQuery("Modulo.findAll").getResultList();  
		return lstModulos;
	}

	public Modulo findById(Modulo modulo) {
		return em.find(Modulo.class, modulo.getIdModulo());
	}
	
	@SuppressWarnings({ "unchecked", "unused" })	
	public List<Modulo> findByPadre(Modulo modulo) {
		Query query = null;
		if(modulo.getIdModulo() == null){
			query = em.createNamedQuery("Modulo.findByPadreNull");
		}else{
			query = em.createNamedQuery("Modulo.findByPadre");
			HashMap<String, Object> parameters = new HashMap<String, Object>();
			parameters.put("moduloPadre", modulo.getIdModulo());
			for(String parameter : parameters.keySet())
			{
				query.setParameter("moduloPadre", null);

			}
		}
		
		List<Modulo> lstModulos =  query.getResultList(); 
		return lstModulos;
	}

	public void persist(Modulo modulo) {
		em.persist(modulo);
	}

	public void merge(Modulo modulo) {
		em.merge(modulo);
	}

	public void delete(Modulo modulo) {
		modulo = em.find(Modulo.class, modulo.getIdModulo());
		em.remove(modulo);
	}

}
