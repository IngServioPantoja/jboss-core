package co.com.sp.dao;

import java.util.List;

import co.com.sp.domain.Rol;

public interface RolDao{

	public List<Rol> findAll();

	public Rol findRolById(Rol rol);

	public void insertRol(Rol rol);

	public void updateRol(Rol rol);

	public void deleteRol(Rol rol);
}
