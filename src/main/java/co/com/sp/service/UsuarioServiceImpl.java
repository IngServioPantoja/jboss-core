package co.com.sp.service;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import co.com.sp.dao.UsuarioDao;
import co.com.sp.domain.Usuario;

@Stateless
public class UsuarioServiceImpl implements UsuarioService, Serializable {

	private static final long serialVersionUID = 2807572921740573681L;
	
	@EJB
	private UsuarioDao usuarioDao;

	public List<Usuario> listarUsuarios() throws SQLException {
		return usuarioDao.findAllUsuarios();
	}

	public Usuario encontrarUsuarioPorId(Usuario usuario) throws SQLException {
		return usuarioDao.findUsuarioById(usuario);
	}
	
	public Usuario iniciarSesion(String usuario, String password) throws SQLException  {
		return usuarioDao.iniciarSesion(usuario, password);
	}

	public void registrarUsuario(Usuario usuario) throws SQLException {
		usuarioDao.insertUsuario(usuario);
	}

	public void modificarUsuario(Usuario usuario) throws SQLException {
		usuarioDao.updateUsuario(usuario);
	}

	public void eliminarUsuario(Usuario usuario) throws SQLException {
		usuarioDao.deleteUsuario(usuario);
	}

}
