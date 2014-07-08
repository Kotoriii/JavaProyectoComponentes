package com;

import interfases.State;

/**
 *
 * @author CarlosJB
 */
public class InactiveState implements State {

    @Override
    public void changeState(Usuario usuario) {
        if(usuario.getEstado().equals("Activo")) //Revisa que el estado sea activo y lo cambia a inactivo
            usuario.setEstado("Inactivo");
        else
            usuario.setChangeState(new ActiveState()); //Si el estado es inactivo cambia la instancia a ActiveState
    }

}
