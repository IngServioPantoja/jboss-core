package co.com.sp.service;

import java.util.List;

import javax.ejb.Local;

import co.com.sp.domain.Grupo;

@Local
public interface GrupoService {

	public List<Grupo> listarGrupos();
	
	public Grupo encontrarGrupoPorId(Grupo grupo);

	public void registrarGrupo(Grupo grupo);

	public void modificarGrupo(Grupo grupo);

	public void eliminarGrupo(Grupo grupo);
}
