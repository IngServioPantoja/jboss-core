package co.com.sp.service;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import co.com.sp.dao.ParametroPersonaDao;
import co.com.sp.domain.ParametroPersona;

@Stateless
public class ParametroPersonaServiceImpl implements Serializable, ParametroPersonaService {

	private static final long serialVersionUID = 853093025615386971L;

	@EJB
	private ParametroPersonaDao parametroPersonaDao;
	
	public List<ParametroPersona> findAll()throws SQLException {
		return parametroPersonaDao.findAll();
	}

	public ParametroPersona findById(ParametroPersona parametroPersona)throws SQLException {
		return parametroPersonaDao.findById(parametroPersona);
	}

	public List<ParametroPersona> findByTipo(Long idTipo)throws SQLException {
		return parametroPersonaDao.findByTipo(idTipo);
		
	}
	
	public void persist(ParametroPersona parametroPersona)throws SQLException {
		parametroPersonaDao.persist(parametroPersona);
	}

	public void merge(ParametroPersona parametroPersona)throws SQLException {
		parametroPersonaDao.merge(parametroPersona);
	}

	public void delete(ParametroPersona parametroPersona)throws SQLException {
		parametroPersonaDao.delete(parametroPersona);
	}

}
