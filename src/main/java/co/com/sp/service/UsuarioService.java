package co.com.sp.service;

import java.sql.SQLException;
import java.util.List;

import javax.ejb.Remote;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import co.com.sp.domain.Usuario;

@Remote
public interface UsuarioService extends UserDetailsService {

	List<Usuario> listarUsuarios() throws SQLException ;

	Usuario encontrarUsuarioPorId(Usuario usuario) throws SQLException ;
	
	Usuario iniciarSesion(String usuario, String password) throws SQLException ;

	void registrarUsuario(Usuario usuario) throws SQLException ;;

	void modificarUsuario(Usuario usuario) throws SQLException ;

	void eliminarUsuario(Usuario usuario) throws SQLException ;

//	Usuario loadUserByUsername(String username) throws SQLException ;
	UserDetails loadUserByUsername(String username)throws UsernameNotFoundException;
	Usuario findByUserName(String username)throws UsernameNotFoundException;
}
