package co.com.sp.dao;

import java.util.List;

import co.com.sp.domain.Grupo;

public interface GrupoDao{

	public List<Grupo> findAll();

	public Grupo findGrupoById(Grupo grupo);

	public void insertGrupo(Grupo grupo);

	public void updateGrupo(Grupo grupo);

	public void deleteGrupo(Grupo grupo);
}
