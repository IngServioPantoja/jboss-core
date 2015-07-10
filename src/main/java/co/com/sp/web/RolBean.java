package co.com.sp.web;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import co.com.sp.domain.Rol;
import co.com.sp.service.RolService;


@ManagedBean
@ViewScoped
public class RolBean implements Serializable{

	private static final long serialVersionUID = -295013253961091251L;
	
	@ManagedProperty(value="#{sessionBean}")
	private SessionBean sessionBean;
	
	@EJB
	private RolService rolService;
	private Rol rolNuevo;
	private Rol rolSeleccionado;
	private List<Rol> roles;
	List<Rol> rolesFiltrados;
	private int progreso = 0;

	public RolBean() {

	}

	@PostConstruct
	public void inicializar() {

	}

	public void cargarRoles(){
		try {
			roles = rolService.listarRoles();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void limpiarRegistrar(){
		sessionBean.setProgreso(0);
		rolNuevo = new Rol();
		sessionBean.setProgreso(100);
	}

	
	public void registrarRol(){
		sessionBean.setProgreso(0);
		try {
			rolService.registrarRol(rolNuevo);
			roles.add(rolNuevo);
		sessionBean.setProgreso(50);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sessionBean.setProgreso(100);
	}
	
	public void definirActual(Rol rol){
		rolSeleccionado = rol;
	}
	
	public void eliminarRol(){
		sessionBean.setProgreso(0);
		try {
			rolService.eliminarRol(rolSeleccionado);
			sessionBean.setProgreso(50);
			Long idRolEliminar = rolSeleccionado.getIdRol();
			for (Rol rol : roles) {
				if(rol.getIdRol().equals(idRolEliminar)){
					roles.remove(rol);
					break;
				}
			}
			sessionBean.setProgreso(70);
			rolSeleccionado = new Rol();
			String msg = "EL rol ha sido eliminado exitosamente";
			 FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Guardar", msg));
			 sessionBean.setProgreso(100);
		} catch (SQLException e) {
			String msg = "Ha ocurrido un error al eliminar el rol";
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", msg));
		}
	}
	
	public void modificarRol(){
		try {
			rolService.modificarRol(rolSeleccionado);
			Long idRolEliminar = rolSeleccionado.getIdRol();
			for (Rol rol : roles) {
				if(rol.getIdRol().equals(idRolEliminar)){
					roles.remove(rol);
					roles.add(rolSeleccionado);
					break;
				}
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public List<Rol> getRoles() {
		return roles;
	}

	public void setRoles(List<Rol> roles) {
		this.roles = roles;
	}
	
	public List<Rol> getRolesFiltrados() {
		return rolesFiltrados;
	}

	public void setRolesFiltrados(List<Rol> rolesFiltrados) {
		this.rolesFiltrados = rolesFiltrados;
	}

	public Rol getRolNuevo() {
		return rolNuevo;
	}

	public void setRolNuevo(Rol rolNuevo) {
		this.rolNuevo = rolNuevo;
	}

	public Rol getRolSeleccionado() {
		return rolSeleccionado;
	}

	public void setRolSeleccionado(Rol rolSeleccionado) {
		this.rolSeleccionado = rolSeleccionado;
	}

	public int getProgreso() {
		return progreso;
	}

	public void setProgreso(int progreso) {
		this.progreso = progreso;
	}

	public SessionBean getSessionBean() {
		return sessionBean;
	}

	public void setSessionBean(SessionBean sessionBean) {
		this.sessionBean = sessionBean;
	}
		
}