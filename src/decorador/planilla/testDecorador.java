package decorador.planilla;


import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.HashMap;

import LogicaHotel.Logica;

import com.Report;

import comu.ServicioUsuario;
import comu.Servicio_ControlHorario;
import entidades.Controlhorario;
import entidades.ControlhorarioPK;
import entidades.Usuario;

;

/**
 * 
 * @author
 */
public class testDecorador {

	/**
	 * @param args
	 *            the command line arguments
	 */

	public static void main(String[] args) {

		Logica logica = new Logica();
		
		Usuario u = new ServicioUsuario().findPK(new Integer(1));
		System.out.print(u.getNombre());
 	
 	/*
 	String nombrehotel = "h9";
 	String Ubicacionhotel = "U9";
 	int idCadena = 1;
 	logica.InsertarHotelACadena(idCadena,nombrehotel, Ubicacionhotel);
   	*/
 	
 	/*

 	String nombreCadena = "Cadenanueva6";	
 	int idCadena = 4;
 	logica.InsertarCadenaHotelera(idCadena, nombreCadena);
 	*/
	/*	
	String Nombre ="Nombreclientenuevo";
	String cedula = "1212121212";
	String telefono= "2444444444";
		
 	logica.InsertarCliente(Nombre, cedula,telefono);
 	 
 	 */
		/*
		String Nombre ="Nombreclientenuevo";
		String cedula = "1212121212";
		String telefono= "2444444444";	
		int idcliente = 2;
		logica.ActualizarCliente(idcliente, Nombre, cedula, telefono);	
		*/
		
		/*
 	String nombreCadena = "Cadenanueva4!!";	
 	int idCadena = 4;
    logica.ActualizarCadenaHotelera(idCadena, nombreCadena);
    */

	/*	
	int idcadena=6;
	String nombre="hotelnuevoparacadena6";
	String Ubicacion="ubcacionnueva";
	logica.InsertarHotelACadena(idcadena, nombre, Ubicacion);
 	*/
		/*
		int idCadena=2;
		int idhotel=6;
		String Nombre="hotelnuevoparacadena6";
		String Ubicacion="ubcacionnueva22";
		logica.ActualizarHotelACadena(idCadena, idhotel, Nombre, Ubicacion);
		*/
 	/*
 	int idCadena = 4;
    logica.BorrarCadenaHotelera(idCadena);
	*/
	/*
	int idCadena = 1;

	int idhotel = 2;
 	logica.CrearHabitacion(idCadena, idhotel);
    */
	
		/*
	int idCadena = 1;
	int idhotel = 2;
	int idhabitacion=1;
	logica.ActualizarHabitacion(idCadena, idhotel, idhabitacion);
	 */
		/*
		int idCadena = 1;
		int idhotel = 1;
		int idhabitacion=1;
		String descripcion = "ducha";
		logica.AgregarElemento(idCadena, idhotel, idhabitacion, descripcion);
 		*/

    	/*
		int idCadena = 1;
		int idelemento = 1;
		int idhotel = 1;
		int idhabitacion=1;
		String descripcion = "ducha caliente";
		logica.ActualizarElemento(idCadena, idhotel, idhabitacion, idelemento, descripcion);

    */
		/*
		int idCadena = 1;
		int idCliente = 1;
		int idHotel = 1;
		String Llegada="13/12/2014";
		String Salida="17/12/2014";
		logica.CrearReservacion(idCadena, idHotel, idCliente, Llegada, Salida);
    	*/
		
		/*
		int idCadena = 1;
		int idreservacion=1;
		int idCliente = 1;
		int idHotel = 1;
		String Llegada="13/12/2014";
		String Salida="17/12/2014";
		logica.ActualizarReservacion(idCadena, idHotel, idCliente, idreservacion, Llegada, Salida);
		*/
		/*
		int idCadena = 1;
		int costo=100;
		int idCliente = 1;
		int idHotel = 1;
		Date horario = new Date(2013-01-01);
		String Descripcion ="Desayuno al cuarto";
		String Salida="17/12/2014";
    	logica.CrearServicio(idCadena, idHotel, idCliente, Descripcion, horario, costo);
    	*/
		
		/*
		int idCadena = 1;
		int idServicio = 1;
		int costo=10000000;
		int idCliente = 1;
		int idHotel = 1;
		Date horario = new Date(2013-01-01);
		String Descripcion ="Desayuno al cuarto";
		String Salida="17/12/2014";
    	logica.ActualizarServicio(idCadena, idHotel, idCliente, idServicio, Descripcion, horario, costo);
    	*/
		
		/*
		int idcadena = 1;
		int idhabitacion = 1;
		int idelemento =1;
		String descripcion ="masaje terapeutico";
		int costo =100000;
		int idServicio = 1;
		Date horario = new Date(2013-01-01);
		int idCliente = 1;
		int idhotel = 1;
		logica.AgregarServicioExtra(idcadena, idhotel, idhabitacion, idelemento, descripcion, costo, horario);
		*/
		/*
		int idcadena = 1;
		int idse=1;
		int idhabitacion = 1;
		int idelemento =1;
		String descripcion ="masaje terapeutico";
		int costo =100000;
		int idServicio = 1;
		Date horario = new Date(2013-01-01);
		int idCliente = 1;
		int idhotel = 1;
		logica.ActualizarServicioExtra(idcadena, idhotel, idhabitacion, idelemento, descripcion, costo, idse, horario);
		*/
		
		
    	
    	
    	
		//test_Control_Horarios();

		// ServicioEntidad<Usuario> su = new ServicioEntidad<Usuario>() {
		// final long serialVersionUID = 1L;

		// };
		
		/*
		 * su.startEntityManager(); Usuario usuario = new Usuario(); usuario =
		 * su.buscar(usuario, 1); su.closeEntityManager();
		 * System.out.println(usuario.getNombre());
		 * 
		 * ControlHorarios p = ControlHorarios.getInstancia();
		 * p.iniciarSesionXelDia(usuario);
		 * 
		 * /* Salario salario1 = new Base();
		 * System.out.println("El salario es de: " + salario1.getDescription());
		 * System.out.println("El monto es: " + salario1.adicion(450));
		 * 
		 * salario1 = new Bono(salario1);
		 * System.out.println("El salario es de: " + salario1.getDescription());
		 * System.out.println("El monto es: " + salario1.adicion(500));
		 * 
		 * salario1 = new Bono(salario1);
		 * System.out.println("El salario es de: " + salario1.getDescription());
		 * System.out.println("El monto es: " + salario1.adicion(5));
		 * 
		 * salario1 = new Extra(salario1);
		 * System.out.println("El salario es de: " + salario1.getDescription());
		 * System.out.println("El monto es: " + salario1.adicion(0.5));
		 * 
		 * salario1 = new Viaticos(salario1);
		 * System.out.println("El salario es de: " + salario1.getDescription());
		 * System.out.println("El monto es: " + salario1.adicion(300.06));
		 * 
		 * salario1 = new CCSS(salario1);
		 * System.out.println("El salario es de: " + salario1.getDescription());
		 * System.out.println("El monto es: " + salario1.deduccion(0));
		 * 
		 * salario1 = new Prestamo(salario1);
		 * System.out.println("El salario es de: " + salario1.getDescription());
		 * System.out.println("El monto es: " + salario1.deduccion(600));
		 * 
		 * salario1 = new Seguro(salario1);
		 * System.out.println("El salario es de: " + salario1.getDescription());
		 * System.out.println("El monto es: " + salario1.deduccion(250));
		 */

		HashMap parameterMap = new HashMap();
		Report rpt = new Report(parameterMap, "Estados_Usuarios");
		rpt.callReport();
	}

	public static void test_Control_Horarios() {
		/*
		 * DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		 * 
		 * Servicio_ControlHorario serv = new Servicio_ControlHorario();
		 * 
		 * Controlhorario control;
		 * 
		 * ControlhorarioPK controlPK = new ControlhorarioPK();
		 * 
		 * controlPK.setFecha("2014-07-18"); controlPK.setIdUsuario(1);
		 * 
		 * control = serv.buscar_x_id(controlPK);
		 * 
		 * System.out.println("El id del usuario es: " +
		 * control.getId().getIdUsuario()); System.out.println("El dia " +
		 * control.getId().getFecha() + " el usuario entro a las " +
		 * control.getHoraEntrada() + " y salio a las " +
		 * control.getHoraSalida());
		 */
	}
}
