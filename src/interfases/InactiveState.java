package interfases;

import entidades.Usuario;

/**
 * 
 * @author CarlosJB
 */
public class InactiveState implements State {

	@Override
	public void changeState(Usuario usuario) {
		usuario.setEstado("Inactivo");
	}

}
