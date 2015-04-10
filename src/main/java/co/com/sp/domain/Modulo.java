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
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity
@Table(name="modulo")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@NamedQueries( { @NamedQuery(name = "Modulo.findAll", query = "SELECT m FROM Modulo m ORDER BY m.idModulo"),
	@NamedQuery(name = "Modulo.findByPadre", 
		query = "SELECT m FROM Modulo m "
			+ "WHERE m.moduloPadre = :moduloPadre "
			+ "ORDER BY m.orden"),
	@NamedQuery(name = "Modulo.findByPadreNull", 
		query = "SELECT m FROM Modulo m "
			+ "WHERE m.moduloPadre is null "
			+ "ORDER BY m.orden")
})
public class Modulo implements Serializable {

	private static final long serialVersionUID = 2584818335850182072L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_modulo")
	private Long idModulo;
	
	@Column(name="nombre")
	private String nombre;
	
	@Column(name="descripcion")
	private String descripcion;
	
	@Column(name="orden")
	private Long orden;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_modulo_padre")
	private Modulo moduloPadre;
	
	@LazyCollection(LazyCollectionOption.EXTRA)
	@OneToMany(mappedBy = "moduloPadre", cascade = { CascadeType.ALL },fetch=FetchType.LAZY)
	private List<Modulo> modulosHijos;
	
	@LazyCollection(LazyCollectionOption.EXTRA)
	@OneToMany(mappedBy = "modulo", cascade = { CascadeType.ALL },fetch=FetchType.LAZY)
	private List<ModuloOpcion> opciones;

	public Modulo() {

	}

	public Modulo(Long idModulo) {
		this.idModulo = idModulo;
	}
	
	public Modulo(Long idModulo, String nombre) {
		this.idModulo = idModulo;
		this.nombre = nombre;
	}

	public Modulo(String nombre) {
		this.nombre = nombre;
	}

	public Modulo(Long idModulo, String nombre, String descripcion, Long orden,
			Modulo moduloPadre) {
		this.idModulo = idModulo;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.orden = orden;
		this.moduloPadre = moduloPadre;
	}
	
	@Override
	public String toString() {
		return "Modulo [idModulo=" + idModulo + ", nombre=" + nombre
				+ ", descripcion=" + descripcion + ", orden=" + orden
				+ ", moduloPadre=" + moduloPadre + ", modulosHijos="
				+ modulosHijos + ", opciones=" + opciones + "]";
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

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Long getOrden() {
		return orden;
	}

	public void setOrden(Long orden) {
		this.orden = orden;
	}

	public Modulo getModuloPadre() {
		return moduloPadre;
	}

	public void setModuloPadre(Modulo moduloPadre) {
		this.moduloPadre = moduloPadre;
	}

	public List<Modulo> getModulosHijos() {
		return modulosHijos;
	}

	public void setModulosHijos(List<Modulo> modulosHijos) {
		this.modulosHijos = modulosHijos;
	}

	public List<ModuloOpcion> getOpciones() {
		return opciones;
	}

	public void setOpciones(List<ModuloOpcion> opciones) {
		this.opciones = opciones;
	}
	
}
