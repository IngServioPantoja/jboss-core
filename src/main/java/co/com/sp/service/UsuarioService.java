package co.com.sp.service;

import java.sql.SQLException;
import java.util.List;

import javax.ejb.Local;

import co.com.sp.domain.Usuario;

@Local
public interface UsuarioService {

	public List<Usuario> listarUsuarios() throws SQLException ;

	public Usuario encontrarUsuarioPorId(Usuario usuario) throws SQLException ;
	
	public Usuario iniciarSesion(String usuario, String password) throws SQLException ;

	public void registrarUsuario(Usuario usuario) throws SQLException ;;

	public void modificarUsuario(Usuario usuario) throws SQLException ;

	public void eliminarUsuario(Usuario usuario) throws SQLException ;
}
