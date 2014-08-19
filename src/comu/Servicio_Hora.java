package comu;

import java.util.List;

import javax.persistence.TypedQuery;

import entidades.Hora;
import entidades.Usuario;

public class Servicio_Hora extends ServicioEntidad<Hora> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public List<Hora> findTodos() {
		if (em == null) {
			startEntityManager();
		}
		TypedQuery<Hora> query = em.createNamedQuery("Hora.findAll", Hora.class);
		return query.getResultList();
	}
}
