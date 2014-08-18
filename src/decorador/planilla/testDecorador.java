package decorador.planilla;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.HashMap;

import LogicaHotel.Logica;

import com.Report;

import comu.Servicio_ControlHorario;
import entidades.Controlhorario;
import entidades.ControlhorarioPK;

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
 	
 	/*
 	String nombrehotel = "h9";
 	String Ubicacionhotel = "U9";
 	int idCadena = 1;
 	logica.InsertarHotelACadena(idCadena,nombrehotel, Ubicacionhotel);
   	*/
 	
 	/*
 	String nombreCadena = "Cadenanueva4";	
 	int idCadena = 4;
 	logica.InsertarCadenaHotelera(idCadena, nombreCadena);
 	*/
 	
 	/*
 	String nombreCadena = "Cadenanueva4!!";	
 	int idCadena = 4;
    logica.ActualizarCadenaHotelera(idCadena, nombreCadena);
    */
 	
 	/*
 	int idCadena = 4;
    logica.BorrarCadenaHotelera(idCadena);
	*/
	/*
	int idCadena = 1;
	int idhotel = 1;
 	logica.CrearHabitacion(idCadena, idhotel);
    */
	/*
	int idCadena = 1;
	int idhotel = 1;
	int idhabitacion=1;
	logica.CrearHabitacion(idCadena, idhotel,idhabitacion);
	    */
 	
    	
    
    
    
    	
    	
    	
    	
    	/*
    	//+++++++++++++++++++++++Agregar/insertar un Servicio Extra a una Habitacion+++++++++++++++++++++++
    	//Inicio
    	ServicioServicioExtra SSE = new ServicioServicioExtra();
    	ServicioExtra SE = new ServicioExtra();
    	ServicioHabitacion SHab = new ServicioHabitacion();
    	Habitacione habitacion = new Habitacione();
    	Cadena_Hotelera CH = new Cadena_Hotelera(); //Cadena Existente
    	CH.setIdCadena_Hotelera(new Integer(1));
    	CH.setNombre("CadenaNueva1");
    	CH.setHotels(new ArrayList<Hotel>());
    	
    	Hotel hotel1 = new Hotel(); // hotel existente
    	hotel1.setIdHotel(1);
    	hotel1.setNombre("h1");
    	hotel1.setUbicacion("U1");
    	hotel1.setCadenaHotelera(CH);
    	hotel1.setHabitaciones(new ArrayList<Habitacione>());
    	hotel1.setReservacions(new ArrayList<Reservacion>());
    	hotel1.setServicios(new ArrayList<Servicio>());
    	hotel1.setUsuarios(new ArrayList<Usuario>());
    	CH.getHotels().add(hotel1);
    	
    	habitacion.setHotel(hotel1);
    	habitacion.setIdHabitaciones(1);
    	habitacion.setElementos(new ArrayList<Elemento>());
    	habitacion.setServicioExtras(new ArrayList<ServicioExtra>());
    	
    	
    	SE.setCosto(10000);
    	SE.setDescripcion("Masaje");
    	SE.setHabitacione(habitacion);
    	SE.setHorario(new Date(2013-01-01));
    	SE.setIdServicio_Extra(1);
    	
    	habitacion.getServicioExtras().add(SE);
    	
    	SHab.actualizar(habitacion);
    	SSE.actualizar(SE);
    	//FIN Insertar un Servicio Extra 
    	*/
   
    	/*
    	//+++++++++++++++++++++++Agregar/insertar un nuevo Elemento+++++++++++++++++++++++
    	//Inicio
    	ServicioElemento SEl = new ServicioElemento();
    	Elemento elemento = new Elemento();
    	ServicioHabitacion SHab = new ServicioHabitacion();
    	Habitacione habitacion = new Habitacione();
    	Cadena_Hotelera CH = new Cadena_Hotelera(); //Cadena Existente
    	CH.setIdCadena_Hotelera(new Integer(1));
    	CH.setNombre("CadenaNueva1");
    	CH.setHotels(new ArrayList<Hotel>());
    	
    	Hotel hotel1 = new Hotel(); // hotel existente
    	hotel1.setIdHotel(1);
    	hotel1.setNombre("h1");
    	hotel1.setUbicacion("U1");
    	hotel1.setCadenaHotelera(CH);
    	hotel1.setHabitaciones(new ArrayList<Habitacione>());
    	hotel1.setReservacions(new ArrayList<Reservacion>());
    	hotel1.setServicios(new ArrayList<Servicio>());
    	hotel1.setUsuarios(new ArrayList<Usuario>());
    	CH.getHotels().add(hotel1);
    	
    	habitacion.setHotel(hotel1);
    	habitacion.setIdHabitaciones(1);
    	habitacion.setElementos(new ArrayList<Elemento>());
    	habitacion.setServicioExtras(new ArrayList<ServicioExtra>());
    	
    	elemento.setIdElemento(1);
    	elemento.setDescripcion_Elemento("Cama Matrimonial");
    	elemento.setHabitacione(habitacion);
    	
    	habitacion.getElementos().add(elemento);
    	SEl.insertar(elemento);
    	SHab.actualizar(habitacion);    	
    	
    	//Fin		
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
