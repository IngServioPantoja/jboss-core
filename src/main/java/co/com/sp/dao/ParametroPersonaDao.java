package co.com.sp.dao;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

import co.com.sp.domain.ParametroPersona;


public interface ParametroPersonaDao extends Serializable {

	public List<ParametroPersona> findAll()throws SQLException;

	public ParametroPersona findById(ParametroPersona parametroPersona)throws SQLException;
	
	public List<ParametroPersona> findByTipo(Long idTipo)throws SQLException;

	public void persist(ParametroPersona parametroPersona)throws SQLException;

	public void merge(ParametroPersona parametroPersona)throws SQLException;

	public void delete(ParametroPersona parametroPersona)throws SQLException;
	
}
