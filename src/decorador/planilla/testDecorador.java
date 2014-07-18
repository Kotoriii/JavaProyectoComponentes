package decorador.planilla;

import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import org.hibernate.Query;

import comu.ServicioEntidad;
import entidades.ServicioExtra;
import entidades.Usuario;

/**
 *
 * @author Deiver Kiel
 */
public class testDecorador {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    	ServicioEntidad<Usuario> su = new ServicioEntidad<Usuario>() {
    		final long serialVersionUID = 1L;
		};
		su.startEntityManager();
		javax.persistence.Query query = su.getEntityManager().createQuery("from "+ Usuario.class.getSimpleName() +" where nombre = '2' and rol = 'o'");
		//query.setParameter("code", "234");
		List list = query.getResultList();
    	for(Usuario u : (List<Usuario>)list){
    		 System.out.println("salario " + u.getSalario());
    	}
    	
    	Calendar cal;
    	DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd"); // formato usado
    																// para las
    																// fechas de
    																// mysql
    	SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");// formato
    													
    	cal = Calendar.getInstance();

    	System.out.println(new Time(cal.getTime().getTime()));
       /* Salario salario1 = new Base();
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
        System.out.println("El monto es: " +  salario1.deduccion(250));   */
    }    
}
