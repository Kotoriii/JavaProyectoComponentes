package com.decorador.planilla;

/**
 * @author deiver
 */
public class CCSS extends DecoradorDeducciones{
    Salario salario;
    double  resta;
    
    public CCSS (Salario salario){
        this.salario = salario;
    }

    @Override
    public String getDescription() {
        return salario.getDescription() + " - CCSS";
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
        if (_deduccion <= 0)
            resta = salario.pago() - (salario.pago() * 0.09); //Deduccion fija, si no ingresan algo mayor a 0
        else
            resta = salario.pago() - (salario.pago() * _deduccion); //Solo por si cambia la deduccion, para casos especiales
        return resta;
    }
}
