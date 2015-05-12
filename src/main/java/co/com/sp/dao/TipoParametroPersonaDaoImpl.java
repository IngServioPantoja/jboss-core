package co.com.sp.dao;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import co.com.sp.domain.TipoParametroPersona;

public class TipoParametroPersonaDaoImpl implements TipoParametroPersonaDao,
		Serializable {

	private static final long serialVersionUID = -438777477023653218L;
	
	@PersistenceContext(unitName = "PersonaPU")
	EntityManager em;
	
	@SuppressWarnings("unchecked")
	public List<TipoParametroPersona> findAll()throws SQLException {
		List<TipoParametroPersona> lstTiposParametrosPersona = em.createNamedQuery("TipoParametroPersona.findAll").getResultList();  
		return lstTiposParametrosPersona;
	}

	public TipoParametroPersona findById(
			TipoParametroPersona tipoParametroPersona)throws SQLException {
		return em.find(TipoParametroPersona.class, tipoParametroPersona.getId());
	}

	public void persist(TipoParametroPersona tipoParametroPersona)throws SQLException {
		em.persist(tipoParametroPersona);
		
	}

	public void merge(TipoParametroPersona tipoParametroPersona)throws SQLException {
		em.merge(tipoParametroPersona);
	}

	public void delete(TipoParametroPersona tipoParametroPersona)throws SQLException {
		em.merge(tipoParametroPersona);
		em.remove(tipoParametroPersona);
	}
}
