package co.com.sp.web;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.model.DefaultTreeNode;
import org.primefaces.model.TreeNode;

import co.com.sp.domain.Modulo;
import co.com.sp.service.ModuloService;

@ViewScoped
@ManagedBean
public class ModuloBean implements Serializable {

	private static final long serialVersionUID = -5054870197672390897L;
	
	@EJB
	private ModuloService moduloService;
	private TreeNode root;
	private TreeNode nodoSeleccionado;
	
	public ModuloBean(){
		
	}
	
	@PostConstruct
	public void inicializar(){
		System.out.println("ModuloBean inicializar()");
	}
	
	public void cargarArbol(){System.out.println("ModuloBean cargarArbol()");
	Modulo padre = new Modulo();
	padre.setIdModulo(null);
	padre.setNombre("Padre");
	System.out.println(""+padre.getIdModulo());
	root = new DefaultTreeNode(padre, null);
	generarDependencias(padre);
	}
	
	private TreeNode generarDependencias(Modulo moduloPadre){
		List<Modulo> modulos = moduloService.findByPadre(moduloPadre);
		if(moduloPadre.getIdModulo()==null){
			for (Modulo modulo : modulos) {
				System.out.println(modulo.getNombre());
				new DefaultTreeNode(modulo, root);
			}
		}
		
		return root;
	}

	public TreeNode getRoot() {
		return root;
	}

	public void setRoot(TreeNode root) {
		this.root = root;
	}

	public TreeNode getNodoSeleccionado() {
		return nodoSeleccionado;
	}

	public void setNodoSeleccionado(TreeNode nodoSeleccionado) {
		this.nodoSeleccionado = nodoSeleccionado;
	}
	
}
