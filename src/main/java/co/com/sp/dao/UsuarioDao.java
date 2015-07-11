package co.com.sp.dao;

import java.sql.SQLException;
import java.util.List;

import co.com.sp.domain.Usuario;

public interface UsuarioDao {

	public List<Usuario> findAllUsuarios();

	public Usuario findUsuarioById(Usuario usuario);

	public void insertUsuario(Usuario usuario);

	public void updateUsuario(Usuario usuario);

	public void deleteUsuario(Usuario usuario);

	public Usuario iniciarSesion(String usuario, String contrasena)throws SQLException;
	
	Usuario findByUserName(String username)throws SQLException;
}
