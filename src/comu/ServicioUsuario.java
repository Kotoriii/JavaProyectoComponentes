package comu;

import java.util.List;

import javax.persistence.TypedQuery;

import entidades.Usuario;

public class ServicioUsuario extends ServicioEntidad<Usuario> {

	private static final long serialVersionUID = 1L;
	
	public Usuario findNombre(String nombre) {
		if (em == null) {
			startEntityManager();
		}
		TypedQuery<Usuario> query = em.createNamedQuery("Usuario.findNombre", Usuario.class);
		query.setParameter("nombrePar", nombre);
		return query.getSingleResult();
		
	}
	
	public List<Usuario> findEstado(String estado) {
		if (em == null) {
			startEntityManager();
		}
		TypedQuery<Usuario> query = em.createNamedQuery("Usuario.findEstado", Usuario.class);
		query.setParameter("estadoPar", estado);
		return query.getResultList();
	}

}
