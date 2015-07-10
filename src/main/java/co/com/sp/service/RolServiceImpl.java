package co.com.sp.service;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import co.com.sp.dao.RolDao;
import co.com.sp.domain.Rol;

@Stateless
public class RolServiceImpl implements Serializable, RolService {

	private static final long serialVersionUID = 1291988624242430482L;

	@EJB
	private RolDao rolDao;
	
	public List<Rol> listarRoles() {
		return rolDao.findAll();
	}

	public Rol encontrarRolPorId(Rol rol) {
		return rolDao.findRolById(rol);
	}

	public void registrarRol(Rol rol) {
		rolDao.insertRol(rol);
	}

	public void modificarRol(Rol rol) {
		rolDao.updateRol(rol);
	}

	public void eliminarRol(Rol rol) {
		rolDao.deleteRol(rol);
	}

}
