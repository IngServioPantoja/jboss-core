package co.com.sp.dao;

import java.io.Serializable;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import co.com.sp.domain.Usuario;

@Stateless
public class UsuarioDaoImpl implements UsuarioDao, Serializable {


	private static final long serialVersionUID = -3367343963076410688L;

	@PersistenceContext(unitName = "PersonaPU")
	EntityManager em;

	@SuppressWarnings("unchecked")
	public List<Usuario> findAllUsuarios() {  
		List<Usuario> lstUsuarios = em.createNamedQuery("Usuario.findAll").getResultList();  
		for (int i = 0; i < lstUsuarios.size(); i++) {
			
			if(lstUsuarios.get(i).getPersona()!=null){
				System.out.println(lstUsuarios.get(i).getPersona().getNombre()+lstUsuarios.get(i).getPersona().getApeMaterno());
			}
		}
		return lstUsuarios;
	}

	public Usuario findUsuarioById(Usuario usuario) {
		return em.find(Usuario.class, usuario.getIdUsuario());
	}

	public void insertUsuario(Usuario usuario) {
		em.persist(usuario);
	}

	public void updateUsuario(Usuario usuario) {
		em.merge( usuario );
	}

	public void deleteUsuario(Usuario usuario) {
		em.merge(usuario);
		em.remove( usuario );
	}
	
	public Usuario iniciarSesion(String usuario, String contrasena)throws SQLException{
		Query query = em.createQuery("FROM Usuario u "
		+ "LEFT JOIN FETCH u.usuarioRoles as uuR "
		+ "LEFT JOIN FETCH uuR.rol as uuRr "
		+ "WHERE u.username = :username AND u.password = :password");
		query.setParameter("username", usuario);
		MessageDigest md;
		try {
			md = MessageDigest.getInstance("MD5");
		
	    md.update(contrasena.getBytes());

	    byte byteData[] = md.digest();

	    StringBuffer sb = new StringBuffer();
	    for (int i = 0; i < byteData.length; i++)
	        sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));

	    System.out.println("Digest(in hex format):: " + sb.toString());
		query.setParameter("password", sb.toString());
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Usuario usuarioLogueado = (Usuario) query.getSingleResult();
		if(usuarioLogueado.getIdUsuario()!=null){
			return usuarioLogueado;
		}else{
			return null;
		}
		
	}
	
	public Usuario findByUserName(String username)throws SQLException{
		Query query = em.createNamedQuery("Usuario.byUsername");
		query.setParameter("username", username);
		Usuario result = new Usuario();
		result = (Usuario) query.getSingleResult();
		return result;
	}

}
