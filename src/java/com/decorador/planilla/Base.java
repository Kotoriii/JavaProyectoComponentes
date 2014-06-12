package com.decorador.planilla;

/**
 * @author Deiver Kiel
 */
public class Base extends Salario{
    private double suma;
    
    public Base(){
        description = "Base";
    }
    
    @Override
    public double pago() {
        return suma;
    }
    
    @Override
    public double adicion(double _adicion) {
        suma = suma + _adicion;
        return suma ;
    }

    @Override
    public double deduccion(double _adicion) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}