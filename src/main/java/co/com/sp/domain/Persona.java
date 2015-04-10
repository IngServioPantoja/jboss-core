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
@Table(name="persona")
@NamedQueries({ @NamedQuery(name = "Persona.findAll", query = "SELECT p FROM Persona p ORDER BY p.idPersona") })
public class Persona implements Serializable {


	private static final long serialVersionUID = 1516533259537001927L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_persona")
	private Long idPersona;

	@Column(name = "identificacion")
	private String identificacion;

	@Column(name = "apellido_materno")
	private String apeMaterno;

	@Column(name = "apellido_paterno")
	private String apePaterno;

	private String email;

	private String nombre;

	private String telefono;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "id_par_per_genero")
	private ParametroPersona genero;

	@LazyCollection(LazyCollectionOption.EXTRA)
	@OneToMany(mappedBy = "persona", cascade = { CascadeType.ALL },fetch=FetchType.LAZY)
	private List<Usuario> usuarios;

	public Persona() {
	}

	public Persona(Long idPersona) {
		this.idPersona = idPersona;
	}

	public Persona(Long idPersona, String nombre, String apePaterno,
			String apeMaterno, String email, String telefono) {
		this.idPersona = idPersona;
		this.nombre = nombre;
		this.apePaterno = apePaterno;
		this.apeMaterno = apeMaterno;
		this.email = email;
		this.telefono = telefono;
	}

	public Persona(String nombre, String apePaterno, String apeMaterno,
			String email, String telefono) {
		this.nombre = nombre;
		this.apePaterno = apePaterno;
		this.apeMaterno = apeMaterno;
		this.email = email;
		this.telefono = telefono;
	}

	public Long getIdPersona() {
		return this.idPersona;
	}

	public void setIdPersona(Long idPersona) {
		this.idPersona = idPersona;
	}

	public String getApeMaterno() {
		return this.apeMaterno;
	}

	public void setApeMaterno(String apeMaterno) {
		this.apeMaterno = apeMaterno;
	}

	public String getApePaterno() {
		return this.apePaterno;
	}

	public void setApePaterno(String apePaterno) {
		this.apePaterno = apePaterno;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getIdentificacion() {
		return identificacion;
	}

	public void setIdentificacion(String identificacion) {
		this.identificacion = identificacion;
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}
	
	public ParametroPersona getGenero() {
		return genero;
	}

	public void setGenero(ParametroPersona genero) {
		this.genero = genero;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Persona other = (Persona) obj;
		if (apeMaterno == null) {
			if (other.apeMaterno != null)
				return false;
		} else if (!apeMaterno.equals(other.apeMaterno))
			return false;
		if (apePaterno == null) {
			if (other.apePaterno != null)
				return false;
		} else if (!apePaterno.equals(other.apePaterno))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (idPersona != other.idPersona)
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		if (telefono == null) {
			if (other.telefono != null)
				return false;
		} else if (!telefono.equals(other.telefono))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Persona [idPersona=" + idPersona + ", nombre=" + nombre
				+ ", apePaterno=" + apePaterno + ", apeMaterno=" + apeMaterno
				+ ", email=" + email + ", telefono=" + telefono + "]";
	}

}