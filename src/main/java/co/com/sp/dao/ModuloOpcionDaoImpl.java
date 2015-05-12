package co.com.sp.dao;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import co.com.sp.domain.ModuloOpcion;
import co.com.sp.domain.Rol;

@Stateless
public class ModuloOpcionDaoImpl implements Serializable, ModuloOpcionDao {

	private static final long serialVersionUID = 3741212114809244607L;
	
	@PersistenceContext(unitName = "PersonaPU")
	EntityManager em;
	
	@SuppressWarnings("unchecked")
	public List<ModuloOpcion> findAll()throws SQLException {
		List<ModuloOpcion> lstModuloOpcion =  em.createNamedQuery("ModuloOpcion.findAll").getResultList();
		return lstModuloOpcion;
	}

	public ModuloOpcion findById(ModuloOpcion moduloOpcion)throws SQLException {
		return em.find(ModuloOpcion.class, moduloOpcion.getIdModulo());
	}

	@SuppressWarnings("unchecked")
	public List<ModuloOpcion> findByRol(Rol rol)throws SQLException {
		Query query = null;
		query = em.createNamedQuery("ModuloOpcion.findByRol");
		query.setParameter("idRol", rol.getIdRol());
		List<ModuloOpcion> lstModuloOpcion =  query.getResultList(); 
		return lstModuloOpcion;
	}

	public void persist(ModuloOpcion moduloOpcion)throws SQLException {
		em.persist(moduloOpcion);
	}

	public void merge(ModuloOpcion moduloOpcion)throws SQLException {
		em.merge(moduloOpcion);
	}

	public void delete(ModuloOpcion moduloOpcion)throws SQLException{
		moduloOpcion = em.find(ModuloOpcion.class, moduloOpcion.getIdModulo());
		em.remove(moduloOpcion);

	}

}
