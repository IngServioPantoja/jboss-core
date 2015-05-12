package co.com.sp.dao;

import java.io.Serializable;
import java.util.List;

import co.com.sp.domain.Modulo;

public interface ModuloDao extends Serializable {
	
	public List<Modulo> findAll();

	public Modulo findById(Modulo modulo);

	public List<Modulo> findByPadre(Modulo modulo);

	public void persist(Modulo modulo);

	public void merge(Modulo modulo);

	public void delete(Modulo modulo);
}
