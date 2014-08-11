package comu;

import java.util.List;

import javax.persistence.TypedQuery;

import entidades.Permiso;

public class ServicioPermiso extends ServicioEntidad<Permiso> {

	private static final long serialVersionUID = 1L;

	public Permiso findPKComp(Object idU, String dF) {
		if (em == null) {
			startEntityManager();
		}
		TypedQuery<Permiso> query = em.createNamedQuery("Permiso.findPKComp", Permiso.class);
		query.setParameter("idU", idU).setParameter("desdeF", dF);
		return query.getSingleResult();
	}
	
	public List<Permiso> findXEmpleado(Object idU){
		if (em == null) {
			startEntityManager();
		}
		TypedQuery<Permiso> query = em.createNamedQuery("Permiso.findXEmpleado", Permiso.class);
		query.setParameter("idU", idU);
		return query.getResultList();
	}
	
	public List<Permiso> findXFecha(String dF){
		if (em == null) {
			startEntityManager();
		}
		TypedQuery<Permiso> query = em.createNamedQuery("Permiso.findXFecha", Permiso.class);
		query.setParameter("desdeF", dF);
		return query.getResultList();
	}
	
	public List<Permiso> findTodos(){
		if (em == null) {
			startEntityManager();
		}
		TypedQuery<Permiso> query = em.createNamedQuery("Permiso.findAll", Permiso.class);
		return query.getResultList();
	}
}
