package comu;

import java.io.Serializable;
import java.util.List;

import javax.persistence.TypedQuery;

import entidades.Controlhorario;
import entidades.ControlhorarioPK;
import entidades.Usuario;


public class Servicio_ControlHorario extends ServicioEntidad<Controlhorario>
		implements Serializable {
	private static final long serialVersionUID = 1L;

	public Controlhorario buscar_x_id(ControlhorarioPK pk) {
		if (em == null) {
			startEntityManager();
		}
		TypedQuery<Controlhorario> query = em.createNamedQuery("Controlhorario.xId", Controlhorario.class);
		query.setParameter("id_par", pk);
		return query.getSingleResult();
	}

	public List<Controlhorario> buscarTodosCH() {
		if (em == null) {
			startEntityManager();
		}
		TypedQuery<Controlhorario> query = em.createNamedQuery("Controlhorario.findAll", Controlhorario.class);
		return query.getResultList();
	}

}
