package co.com.sp.service;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import co.com.sp.dao.GrupoDao;
import co.com.sp.domain.Grupo;

@Stateless
public class GrupoServiceImpl implements GrupoService, Serializable {

	private static final long serialVersionUID = 8638893934358266592L;

	@EJB
	private GrupoDao grupoDao;

	public List<Grupo> listarGrupos() {
		return grupoDao.findAll();
	}

	public Grupo encontrarGrupoPorId(Grupo grupo) {
		return grupoDao.findGrupoById(grupo);
	}

	public void registrarGrupo(Grupo grupo) {
		grupoDao.insertGrupo(grupo);
	}

	public void modificarGrupo(Grupo grupo) {
		grupoDao.updateGrupo(grupo);
	}

	public void eliminarGrupo(Grupo grupo) {
		grupoDao.deleteGrupo(grupo);
	}

}
