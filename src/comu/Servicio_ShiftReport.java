package comu;

import java.util.List;

import javax.persistence.TypedQuery;

import entidades.Controlhorario;
import entidades.Shiftreport;

public class Servicio_ShiftReport extends ServicioEntidad<Shiftreport> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public List<Shiftreport> findTodos() {
		if (em == null) {
			startEntityManager();
		}
		TypedQuery<Shiftreport> query = em.createNamedQuery("Shiftreport.findAll", Shiftreport.class);
		return query.getResultList();
	}

}
