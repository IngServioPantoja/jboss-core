package co.com.sp.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;


/**
 * The persistent class for the parametro_persona database table.
 * 
 */
@Entity
@Table(name="parametro_persona")
@NamedQueries({ 
	@NamedQuery(name = "ParametroPersona.findAll", 
		query = "SELECT pP FROM ParametroPersona pP"),
	@NamedQuery(name = "ParametroPersona.findByTipo", 
		query = "SELECT pP FROM ParametroPersona pP "
			+ "INNER JOIN pP.tipoParametroPersona as pPtPP "
			+ "WHERE pPtPP.id = :idTipoParametroPersona") 
})
public class ParametroPersona implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_parametro_persona", unique=true, nullable=false)
	private Long id;

	@Column(nullable=false, length=1)
	private String activo;

	@Column(nullable=false, length=200)
	private String descripcion;

	@Column(nullable=false, length=1)
	private String editable;

	@ManyToOne(cascade={CascadeType.ALL}, fetch=FetchType.LAZY)
	@JoinColumn(name="id_tipo_parametro_persona", nullable=false)
	private TipoParametroPersona tipoParametroPersona;
	
	@LazyCollection(LazyCollectionOption.EXTRA)
	@OneToMany(mappedBy = "genero", cascade = { CascadeType.ALL },fetch=FetchType.LAZY)
	private List<Persona> personas;

	public ParametroPersona() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getActivo() {
		return this.activo;
	}

	public void setActivo(String activo) {
		this.activo = activo;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getEditable() {
		return this.editable;
	}

	public void setEditable(String editable) {
		this.editable = editable;
	}

	public TipoParametroPersona getTipoParametroPersona() {
		return this.tipoParametroPersona;
	}

	public void setTipoParametroPersona(TipoParametroPersona tipoParametroPersona) {
		this.tipoParametroPersona = tipoParametroPersona;
	}

	public List<Persona> getPersonas() {
		return personas;
	}

	public void setPersonas(List<Persona> personas) {
		this.personas = personas;
	}

}