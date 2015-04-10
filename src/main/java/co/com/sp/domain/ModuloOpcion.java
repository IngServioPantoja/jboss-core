package co.com.sp.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity
@Table(name="modulo_opcion")
@NamedQueries({ 
	@NamedQuery(name = "ModuloOpcion.findByRol", 
		query = "SELECT mO FROM ModuloOpcion mO "
			+"LEFT JOIN mO.moduloOpciones as mOmO "
			+"LEFT JOIN mOmO.rol as mOmOr "
			+"WHERE mOmOr.idRol = :idRol "
			+"ORDER BY mO.nombre") 
})
public class ModuloOpcion implements Serializable {


	private static final long serialVersionUID = -7397712340072745008L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_modulo_opcion")
	private Long idModulo;
	
	@Column(name="nombre")
	private String nombre;

	@Column(name="titulo")
	private String titulo;
	
	@Column(name="url")
	private String url;
	
	@Column(name="orden")
	private Long orden;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_modulo")
	private Modulo modulo;

	@LazyCollection(LazyCollectionOption.EXTRA)
	@OneToMany(mappedBy = "moduloOpcion", cascade = { CascadeType.ALL },fetch=FetchType.LAZY)
	private List<RolModuloOpcion> moduloOpciones;
	
	public ModuloOpcion() {

	}

	public ModuloOpcion(Long idModulo) {
		this.idModulo = idModulo;
	}

	public ModuloOpcion(Long idModulo, String nombre, String titulo,
			Long orden, Modulo modulo, List<RolModuloOpcion> moduloOpciones) {
		this.idModulo = idModulo;
		this.nombre = nombre;
		this.titulo = titulo;
		this.orden = orden;
		this.modulo = modulo;
		this.moduloOpciones = moduloOpciones;
	}

	public Long getIdModulo() {
		return idModulo;
	}

	public void setIdModulo(Long idModulo) {
		this.idModulo = idModulo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Long getOrden() {
		return orden;
	}

	public void setOrden(Long orden) {
		this.orden = orden;
	}

	public Modulo getModulo() {
		return modulo;
	}

	public void setModulo(Modulo modulo) {
		this.modulo = modulo;
	}

	public List<RolModuloOpcion> getModuloOpciones() {
		return moduloOpciones;
	}

	public void setModuloOpciones(List<RolModuloOpcion> moduloOpciones) {
		this.moduloOpciones = moduloOpciones;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
		
	
}
