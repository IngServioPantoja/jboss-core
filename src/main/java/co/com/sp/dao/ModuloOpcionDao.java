package co.com.sp.dao;

import java.sql.SQLException;
import java.util.List;

import co.com.sp.domain.ModuloOpcion;
import co.com.sp.domain.Rol;

public interface ModuloOpcionDao{

	public List<ModuloOpcion> findAll()throws SQLException;

	public ModuloOpcion findById(ModuloOpcion moduloOpcion)throws SQLException;

	public List<ModuloOpcion> findByRol(Rol rol)throws SQLException;

	public void persist(ModuloOpcion moduloOpcion)throws SQLException;

	public void merge(ModuloOpcion moduloOpcion)throws SQLException;

	public void delete(ModuloOpcion moduloOpcion)throws SQLException;
}
