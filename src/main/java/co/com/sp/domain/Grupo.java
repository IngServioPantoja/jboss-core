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
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity
@Table(name="grupo")
@NamedQueries( { @NamedQuery(name = "Grupo.findAll", query = "SELECT g FROM Grupo g ORDER BY g.idGrupo") })
public class Grupo implements Serializable {

	private static final long serialVersionUID = 5430923933867329359L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_grupo")
	private Long idGrupo;
	
	@Column(name="nombre")
	private String nombre;
	
	@LazyCollection(LazyCollectionOption.EXTRA)
	@OneToMany(mappedBy = "grupo", cascade = { CascadeType.ALL },fetch=FetchType.LAZY)
	private List<UsuarioGrupo> usuariosGrupos;
	
	public Grupo(){
		
	}

	@Override
	public String toString() {
		return "Grupo [idGrupo=" + idGrupo + ", nombre=" + nombre
				+ ", usuariosGrupos=" + usuariosGrupos + "]";
	}

	public Long getIdGrupo() {
		return idGrupo;
	}

	public void setIdGrupo(Long idGrupo) {
		this.idGrupo = idGrupo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<UsuarioGrupo> getUsuariosGrupos() {
		return usuariosGrupos;
	}

	public void setUsuariosGrupos(List<UsuarioGrupo> usuariosGrupos) {
		this.usuariosGrupos = usuariosGrupos;
	}
	
}
