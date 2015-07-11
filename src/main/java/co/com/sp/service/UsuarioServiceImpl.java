package co.com.sp.service;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import co.com.sp.dao.UsuarioDao;
import co.com.sp.domain.Usuario;
import co.com.sp.domain.UsuarioRol;

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
	
	public Usuario findByUserName(String username)throws UsernameNotFoundException{
		Usuario user = null;
		try {
			user = usuarioDao.findByUserName(username);
//		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}

	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario user = null;
		try {
			user = usuarioDao.findByUserName(username);
//		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<GrantedAuthority> authorities = buildUserAuthority(user.getUsuarioRoles());

		return buildUserForAuthentication(user, authorities);
	}
	
	private User buildUserForAuthentication(Usuario user, List<GrantedAuthority> authorities) {
		return new User(user.getUsername(), user.getPassword(), user.isActivo(), true, true, true, authorities);
	}
	
	private List<GrantedAuthority> buildUserAuthority(List<UsuarioRol> userRoles) {

		Set<GrantedAuthority> setAuths = new HashSet<GrantedAuthority>();

		for (UsuarioRol userRole : userRoles) {
			setAuths.add(new SimpleGrantedAuthority(userRole.getRol().getSigla()));
		}

		List<GrantedAuthority> Result = new ArrayList<GrantedAuthority>(setAuths);

		return Result;
	}

}
