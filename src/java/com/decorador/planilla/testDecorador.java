package com.decorador.planilla;
/**
 *
 * @author Deiver Kiel
 */
public class testDecorador {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Salario salario1 = new Base();
        System.out.println("El salario es de: " + salario1.getDescription());
        System.out.println("El monto es: " + salario1.adicion(450));
        
        salario1 = new Bono(salario1);
        System.out.println("El salario es de: " + salario1.getDescription());
        System.out.println("El monto es: " + salario1.adicion(500));
        
        salario1 = new Bono(salario1);
        System.out.println("El salario es de: " + salario1.getDescription());
        System.out.println("El monto es: " +  salario1.adicion(5));
        
        salario1 = new Extra(salario1);
        System.out.println("El salario es de: " + salario1.getDescription());
        System.out.println("El monto es: " +  salario1.adicion(0.5));
        
        salario1 = new Viaticos(salario1);
        System.out.println("El salario es de: " + salario1.getDescription());
        System.out.println("El monto es: " +  salario1.adicion(300.06));
        
        salario1 = new CCSS(salario1);
        System.out.println("El salario es de: " + salario1.getDescription());
        System.out.println("El monto es: " +  salario1.deduccion(0));
        
        salario1 = new Prestamo(salario1);
        System.out.println("El salario es de: " + salario1.getDescription());
        System.out.println("El monto es: " +  salario1.deduccion(600));
        
        salario1 = new Seguro(salario1);
        System.out.println("El salario es de: " + salario1.getDescription());
        System.out.println("El monto es: " +  salario1.deduccion(250));   
    }    
}
