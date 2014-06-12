package com.decorador.planilla;
/**
 * @author Deiver Kiel
 */
public class Extra extends DecoradorAdicionales{
    Salario salario;
    double  suma;
    
    public Extra (Salario salario){
        this.salario = salario;
    }

    @Override
    public String getDescription() {
        return salario.getDescription() + " + Extra";
    }

    @Override
    public double pago() {
        return suma;
    }

    @Override
    public double adicion(double _adicion) {
        suma = _adicion + salario.pago();
        return _adicion + salario.pago();
    }

    @Override
    public double deduccion(double _adicion) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}