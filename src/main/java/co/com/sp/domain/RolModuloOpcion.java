package co.com.sp.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="rol_modulo_opcion")
public class RolModuloOpcion implements Serializable {

	private static final long serialVersionUID = -1915435838759992946L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_rol_modulo_opcion")
	private Long id;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_rol")
	private Rol rol;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_modulo_opcion")
	private ModuloOpcion moduloOpcion;

	public RolModuloOpcion() {
	}

	public RolModuloOpcion(Long id) {
		this.id = id;
	}

	public RolModuloOpcion(Long id, Rol rol, ModuloOpcion moduloOpcion) {
		this.id = id;
		this.rol = rol;
		this.moduloOpcion = moduloOpcion;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Rol getRol() {
		return rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}

	public ModuloOpcion getModuloOpcion() {
		return moduloOpcion;
	}

	public void setModuloOpcion(ModuloOpcion moduloOpcion) {
		this.moduloOpcion = moduloOpcion;
	}
	
}
