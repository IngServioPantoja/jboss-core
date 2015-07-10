package co.com.sp.web;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.event.RowEditEvent;

import co.com.sp.domain.Usuario;
import co.com.sp.service.UsuarioService;

@ManagedBean
@ViewScoped
public class UsuarioBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3211394890842682243L;
	@EJB
	private UsuarioService usuarioService;
	List<Usuario> usuarios;
	List<Usuario> usuariosFiltradas;

	public UsuarioBean() {

	}

	@PostConstruct
	public void inicializar() {

	}

	public void cargarUsuarios(){
		try {
			usuarios = usuarioService.listarUsuarios();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void editListener(RowEditEvent event) {
		Usuario usuario = (Usuario) event.getObject();
		try {
			usuarioService.modificarUsuario(usuario);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public List<Usuario> getUsuariosFiltradas() {
		return usuariosFiltradas;
	}

	public void setUsuariosFiltradas(List<Usuario> usuariosFiltradas) {
		this.usuariosFiltradas = usuariosFiltradas;
	}
}