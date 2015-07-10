package co.com.sp.service;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Local;

import co.com.sp.domain.Modulo;

@Local
public interface ModuloService extends Serializable {
	
	public List<Modulo> findAll();
	
	public Modulo findById(Modulo modulo);
	
	public List<Modulo> findByPadre(Modulo modulo);

	public void persist(Modulo modulo);

	public void merge(Modulo modulo);

	public void delete(Modulo modulo);
}
