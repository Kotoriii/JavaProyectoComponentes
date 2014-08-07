package comu;

import java.io.Serializable;
import java.util.List;

import entidades.Controlhorario;


public class Servicio_ControlHorario extends ServicioEntidad<Controlhorario>
		implements Serializable {
	private static final long serialVersionUID = 1L;

	@Override
	public Controlhorario buscar(Controlhorario item, Object pk) {
		if (em == null) {
			startEntityManager();
		}
		Controlhorario pop = (Controlhorario) em.find(Controlhorario.class, pk);
		if (em != null) {
			closeEntityManager();
		}
		return pop;
	}

	public List<Controlhorario> buscarTodosCH() {
		if (em == null) {
			startEntityManager();
		}
		String qjl = "Select t from " + Controlhorario.class.getSimpleName() + " t";
		List<Controlhorario> popio = (List<Controlhorario>) em.createQuery(qjl, Controlhorario.class)
				.getResultList();
		if (em != null) {
			closeEntityManager();
		}
		return popio;
	}

}
