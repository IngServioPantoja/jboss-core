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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@NamedQueries( { @NamedQuery(name = "Rol.findAll", query = "SELECT r FROM Rol r ORDER BY r.idRol") })
public class Rol implements Serializable {

	private static final long serialVersionUID = -6823392257881620897L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_rol")
	private Long idRol;
	
	@Column(name="nombre")
	private String nombre;
	
	@Column(name="descripcion")
	private String descripcion;
	
	@LazyCollection(LazyCollectionOption.EXTRA)
	@OneToMany(mappedBy = "rol", cascade = { CascadeType.ALL },fetch=FetchType.LAZY)
	private List<UsuarioRol> usuarioRoles;
	
	@LazyCollection(LazyCollectionOption.EXTRA)
	@OneToMany(mappedBy = "rol", cascade = { CascadeType.ALL },fetch=FetchType.LAZY)
	private List<RolModuloOpcion> moduloOpciones;

	public Rol() {

	}

	@Override
	public String toString() {
		return "Rol [idRol=" + idRol + ", nombre=" + nombre + ", descripcion="
				+ descripcion + "]";
	}

	public Long getIdRol() {
		return idRol;
	}

	public void setIdRol(Long idRol) {
		this.idRol = idRol;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public List<UsuarioRol> getUsuarioRoles() {
		return usuarioRoles;
	}

	public void setUsuarioRoles(List<UsuarioRol> usuarioRoles) {
		this.usuarioRoles = usuarioRoles;
	}

	public List<RolModuloOpcion> getModuloOpciones() {
		return moduloOpciones;
	}

	public void setModuloOpciones(List<RolModuloOpcion> moduloOpciones) {
		this.moduloOpciones = moduloOpciones;
	}
	
	
}
