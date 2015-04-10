package co.com.sp.domain;

import java.io.Serializable;

import javax.persistence.*;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import java.util.List;


/**
 * The persistent class for the tipo_parametro_persona database table.
 * 
 */
@Entity
@Table(name="tipo_parametro_persona")
@NamedQuery(name="TipoParametroPersona.findAll", query="SELECT t FROM TipoParametroPersona t")
public class TipoParametroPersona implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_tipo_parametro_persona", unique=true, nullable=false)
	private Long id;

	@Column(nullable=false, length=1)
	private String activo;

	@Column(nullable=false, length=200)
	private String descripcion;

	@Column(nullable=false, length=1)
	private String editable;

	@LazyCollection(LazyCollectionOption.EXTRA)
	@OneToMany(mappedBy="tipoParametroPersona", cascade={CascadeType.ALL},fetch=FetchType.LAZY)
	private List<ParametroPersona> parametroPersonas;

	public TipoParametroPersona() {
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

	public List<ParametroPersona> getParametroPersonas() {
		return parametroPersonas;
	}

	public void setParametroPersonas(List<ParametroPersona> parametroPersonas) {
		this.parametroPersonas = parametroPersonas;
	}

}