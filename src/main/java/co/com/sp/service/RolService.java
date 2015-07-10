package co.com.sp.service;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

import javax.ejb.Local;

import co.com.sp.domain.Rol;

@Local
public interface RolService extends Serializable {
	
	public List<Rol> listarRoles() throws SQLException;
	
	public Rol encontrarRolPorId(Rol rol) throws SQLException;

	public void registrarRol(Rol rol) throws SQLException;

	public void modificarRol(Rol rol) throws SQLException;

	public void eliminarRol(Rol rol) throws SQLException;
}
