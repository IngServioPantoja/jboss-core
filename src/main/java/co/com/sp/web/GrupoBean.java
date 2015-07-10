package co.com.sp.web;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.event.RowEditEvent;

import co.com.sp.domain.Grupo;
import co.com.sp.service.GrupoService;

@ManagedBean
@ViewScoped
public class GrupoBean implements Serializable{

	private static final long serialVersionUID = -295013253961091251L;

	@EJB
	private GrupoService grupoService;
	List<Grupo> grupos;
	List<Grupo> gruposFiltradas;

	public GrupoBean() {

	}

	@PostConstruct
	public void inicializar() {

	}

	public void cargarGrupos(){
		grupos = grupoService.listarGrupos();
	}
	
	public void editListener(RowEditEvent event) {
		Grupo grupo = (Grupo) event.getObject();
		grupoService.modificarGrupo(grupo);
	}

	public List<Grupo> getGrupos() {
		return grupos;
	}

	public void setGrupos(List<Grupo> grupos) {
		this.grupos = grupos;
	}

	public List<Grupo> getGruposFiltradas() {
		return gruposFiltradas;
	}

	public void setGruposFiltradas(List<Grupo> gruposFiltradas) {
		this.gruposFiltradas = gruposFiltradas;
	}
}