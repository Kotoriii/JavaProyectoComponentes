/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com;

import interfases.Observer;

/**
 *
 * @author Andrea
 */
public class ObservadorUsuario implements Observer{
    Usuario usuario = null;
    private static ObservadorUsuario observador = null;

    private ObservadorUsuario() {
        
    }
    public static ObservadorUsuario getInstancia(){
    if(observador == null){
        observador = new ObservadorUsuario();
    }
    return observador;
    }
    
    public Usuario getUsuario(){
        return usuario;
    }
    
    public void setUsuario(Usuario usuario){
        this.usuario = usuario;
    }

    @Override
    public void update(Usuario usuario) {
        this.usuario = usuario;
    }
    
    
}
