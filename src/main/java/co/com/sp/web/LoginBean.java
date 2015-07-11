package co.com.sp.web;


import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import co.com.sp.service.UsuarioService;


@ManagedBean
@ViewScoped
public class LoginBean implements Serializable{

	private static final long serialVersionUID = -5992119866159438146L;
	
	
	@ManagedProperty(value="#{sessionBean}")
	private SessionBean sessionBean;
	
	@EJB
	private UsuarioService usuarioServiceImpl;
	
	private String username = "";
	private String password = "";

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public LoginBean() {

	}

	@PostConstruct
	public void inicializar() {
		System.out.println("LoginBean inicializar");

	}

	public String login() {
		FacesContext context = FacesContext.getCurrentInstance();
		HttpServletRequest request = (HttpServletRequest) context
				.getExternalContext().getRequest();
//		try {
//			request.login(this.username, this.password);
		usuarioServiceImpl.loadUserByUsername(username);
			String msg = "Usuario logueado exitosamente Bienvenido@";
			 FacesMessage facesMessage = new FacesMessage
			(FacesMessage.SEVERITY_INFO, "Session", msg);
			 FacesContext facesContext = FacesContext.getCurrentInstance();
			 facesContext.addMessage(null, facesMessage);
			 sessionBean.definirSesionUsuario(this.username, this.password);
			 
//		} catch (ServletException e) {
//
//			 String msg = "El usuario o contraseņa con incorrectos";
//			 FacesMessage facesMessage = new FacesMessage
//			 (FacesMessage.SEVERITY_INFO, "Error", msg);
//			 FacesContext facesContext = FacesContext.getCurrentInstance();
//			 facesContext.addMessage(null, facesMessage);
//			 
//			 return null;
//		}
		return "/admin/roles/roles?faces-redirect=true";
	}

	public String logout() {
		FacesContext context = FacesContext.getCurrentInstance();
		HttpServletRequest request = (HttpServletRequest) context
				.getExternalContext().getRequest();
	        try {
				request.logout();
				FacesContext.getCurrentInstance().getExternalContext().invalidateSession();

			} catch (ServletException e) {
				e.printStackTrace();
			}

		return "/public/login?faces-redirect=true";
		
	}

	public SessionBean getSessionBean() {
		return sessionBean;
	}

	public void setSessionBean(SessionBean sessionBean) {
		this.sessionBean = sessionBean;
	}
	
}