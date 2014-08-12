package comu;

import java.util.List;

import javax.persistence.TypedQuery;

import entidades.Usuario;

public class ServicioUsuario extends ServicioEntidad<Usuario> {

	private static final long serialVersionUID = 1L;
	
	public Usuario findPK(Object pk) {
		if (em == null) {
			startEntityManager();
		}
		TypedQuery<Usuario> query = em.createNamedQuery("Usuario.findPK", Usuario.class);
		query.setParameter("pk", pk);
		return query.getSingleResult();
	}
	
	public Usuario findNombre(String nombre) {
		if (em == null) {
			startEntityManager();
		}
		TypedQuery<Usuario> query = em.createNamedQuery("Usuario.findNombre", Usuario.class);
		query.setParameter("nombrePar", nombre);
		Usuario usuario = query.getSingleResult();
		return usuario;
	}
	
	public List<Usuario> findEstado(String estado) {
		if (em == null) {
			startEntityManager();
		}
		TypedQuery<Usuario> query = em.createNamedQuery("Usuario.findEstado", Usuario.class);
		query.setParameter("estadoPar", estado);
		return query.getResultList();
	}
	
	public List<Usuario> findTodos() {
		if (em == null) {
			startEntityManager();
		}
		TypedQuery<Usuario> query = em.createNamedQuery("Usuario.findAll", Usuario.class);
		return query.getResultList();
	}

}
