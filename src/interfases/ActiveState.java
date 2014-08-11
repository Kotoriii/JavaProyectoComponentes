package interfases;

import entidades.Usuario;

/**
 * 
 * @author CarlosJB
 */
public class ActiveState implements State {

	@Override
	public void changeState(Usuario usuario) {
		usuario.setEstado("Activo");
	}

}
