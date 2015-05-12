package co.com.sp.dao;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

import co.com.sp.domain.TipoParametroPersona;


public interface TipoParametroPersonaDao extends Serializable {

	public List<TipoParametroPersona> findAll()throws SQLException;

	public TipoParametroPersona findById(TipoParametroPersona tipoParametroPersona)throws SQLException;

	public void persist(TipoParametroPersona tipoParametroPersona)throws SQLException;

	public void merge(TipoParametroPersona tipoParametroPersona)throws SQLException;

	public void delete(TipoParametroPersona tipoParametroPersona)throws SQLException;
	
}
