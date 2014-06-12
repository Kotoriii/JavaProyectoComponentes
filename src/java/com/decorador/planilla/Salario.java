package com.decorador.planilla;

/**
 * @author Deiver Kiel
 */
public abstract class Salario {
    String description = "Salario";
    
    /*public void setDescription(String _description){
        this.description = description + " " + _description;
    }*/
    
    public String getDescription(){
        return description;
    }
    
    public abstract double pago();
    public abstract double adicion(double _adicion);
    public abstract double deduccion(double _deduccion);
}
