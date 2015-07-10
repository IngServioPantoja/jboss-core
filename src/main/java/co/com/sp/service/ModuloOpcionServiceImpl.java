package co.com.sp.service;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import co.com.sp.dao.ModuloOpcionDao;
import co.com.sp.domain.ModuloOpcion;
import co.com.sp.domain.Rol;

@Stateless
public class ModuloOpcionServiceImpl implements Serializable,
		ModuloOpcionService {

	private static final long serialVersionUID = 6091732389977597476L;

	@EJB
	private ModuloOpcionDao moduloOpcionDao;
	
	public List<ModuloOpcion> findAll()throws SQLException {
		return moduloOpcionDao.findAll();
	}

	public ModuloOpcion findById(ModuloOpcion moduloOpcion)throws SQLException {
		return moduloOpcionDao.findById(moduloOpcion);
	}
	
	public List<ModuloOpcion> findByRol(Rol rol)throws SQLException {
		return moduloOpcionDao.findByRol(rol);
	}

	public void persist(ModuloOpcion moduloOpcion)throws SQLException {
		moduloOpcionDao.persist(moduloOpcion);
	}

	public void merge(ModuloOpcion moduloOpcion)throws SQLException {
		moduloOpcionDao.merge(moduloOpcion);
	}

	public void delete(ModuloOpcion moduloOpcion)throws SQLException {
		moduloOpcionDao.delete(moduloOpcion);
	}

}
