package co.com.sp.web;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import co.com.sp.domain.ModuloOpcion;
import co.com.sp.domain.Usuario;
import co.com.sp.service.ModuloOpcionService;
import co.com.sp.service.UsuarioService;


@ManagedBean
@SessionScoped
public class SessionBean implements Serializable{

	private static final long serialVersionUID = -124466934030612288L;
	private List<ModuloOpcion> opcionesActivas;
	private Usuario usuarioLogueado;
	private int progreso = 0;
	
	@EJB
	private UsuarioService usuarioService;
	
	@EJB
	private ModuloOpcionService moduloOpcionService;

    public SessionBean() {System.out.println("SessionBean");

    }
    
    @PostConstruct
	public void inicializar() {System.out.println("SessionBean inicializar");
	
	}
    
    public void definirSesionUsuario(String usuario,String password){
    	try {
			usuarioLogueado = usuarioService.iniciarSesion(usuario, password);
			System.out.println("SessionBean definirSesionUsuario Exito");
			System.out.println("SessionBean cargandoOpciones del sistema");
			opcionesActivas = moduloOpcionService.findByRol(usuarioLogueado.getUsuarioRoles().get(0).getRol());
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
	public List<ModuloOpcion> getOpcionesActivas() {
		return opcionesActivas;
	}

	public Usuario getUsuarioLogueado() {
		return usuarioLogueado;
	}

	public int getProgreso() {
		return progreso;
	}

	public void setProgreso(int progreso) {
		this.progreso = progreso;
	}
    
}
