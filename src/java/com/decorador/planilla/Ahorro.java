package com.decorador.planilla;
/**
 * @author deiver
 */
public class Ahorro extends DecoradorDeducciones{
    Salario salario;
    double  resta;
    
    public Ahorro (Salario salario){
        this.salario = salario;
    }

    @Override
    public String getDescription() {
        return salario.getDescription() + " - Ahorro";
    }

    @Override
    public double pago() {
        return resta;
    }

    @Override
    public double adicion(double _adicion) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public double deduccion(double _deduccion) {
        resta = salario.pago() - _deduccion; //Monto fijo de deduccion
        return resta;
    }
}
