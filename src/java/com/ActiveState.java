package com;

import interfases.State;

/**
 *
 * @author CarlosJB
 */
public class ActiveState implements State {

    @Override
    public void changeState(Usuario usuario) {
        if(usuario.getEstado().equals("Inactivo")) //Revisa que el estado sea inactivo y lo cambia a activo
            usuario.setEstado("Activo");
        else
            usuario.setChangeState(new InactiveState()); //Si el estado es activo le cambia la instancia a InactiveState
    }

}
