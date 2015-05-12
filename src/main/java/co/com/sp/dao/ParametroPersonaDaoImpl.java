package co.com.sp.dao;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import co.com.sp.domain.ParametroPersona;

@Stateless
public class ParametroPersonaDaoImpl implements ParametroPersonaDao,
		Serializable {

	private static final long serialVersionUID = -438777477023653218L;
	
	@PersistenceContext(unitName = "PersonaPU")
	EntityManager em;
	
	@SuppressWarnings("unchecked")
	public List<ParametroPersona> findAll()throws SQLException {
		List<ParametroPersona> lstParametrosPersona = em.createNamedQuery("ParametroPersona.findAll").getResultList();  
		return lstParametrosPersona;
	}

	public ParametroPersona findById(
			ParametroPersona parametroPersona)throws SQLException {
		return em.find(ParametroPersona.class, parametroPersona.getId());
	}
	
	@SuppressWarnings("unchecked")
	public List<ParametroPersona> findByTipo(Long idTipo)throws SQLException{
		Query query = em.createNamedQuery("ParametroPersona.findByTipo");
		query.setParameter("idTipoParametroPersona", idTipo);
		List<ParametroPersona> lstParametrosPersona =  query.getResultList(); 
		return lstParametrosPersona;
	}
	
	public void persist(ParametroPersona parametroPersona)throws SQLException {
		em.persist(parametroPersona);
	}

	public void merge(ParametroPersona parametroPersona)throws SQLException {
		em.merge(parametroPersona);
	}

	public void delete(ParametroPersona parametroPersona)throws SQLException {
		em.merge(parametroPersona);
		em.remove(parametroPersona);
	}
}
