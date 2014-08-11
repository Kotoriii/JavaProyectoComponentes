package decorador.planilla;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.ControlHorarios;

import comu.ServicioCadena_Hotelera;
import comu.ServicioCliente;
import comu.ServicioElemento;
import comu.ServicioEntidad;
import comu.ServicioHabitacion;
import comu.ServicioHotel;
import comu.ServicioReservacion;
import comu.ServicioServicio;
import comu.ServicioServicioExtra;
import entidades.Cadena_Hotelera;
import entidades.Cliente;
import entidades.Elemento;
import entidades.Factura;
import entidades.Habitacione;
import entidades.Hotel;
import entidades.Reservacion;
import entidades.Servicio;
import entidades.ServicioExtra;
import entidades.Usuario;
import LogicaHotel.Logica;;

/**
 *
 * @author Deiver Kiel
 */
public class testDecorador {

    /**
     * @param args the command line arguments
     */

	
    public static void main(String[] args) {
 	
    	/*
    	//+++++++++++++++++++++++Agregar/insertar una Cadena Hotelera++++++++++++++++++++++++++++++++++
    	//Inicio
    	ServicioCadena_Hotelera SCH = new ServicioCadena_Hotelera(); //Instanciacion del Servicio
    	Cadena_Hotelera CH = new Cadena_Hotelera();//asignacion de un nuevo espacio en memoria
    	CH.setIdCadena_Hotelera(2);
    	CH.setNombre("CadenaNueva2");
    	CH.setHotels(new ArrayList<Hotel>());
    	SCH.insertar(CH);
    	//fin Agregar/insertar una Cadena Hotelera
    	*/
    	
    	
    	/*
    	//+++++++++++++++++++++++Agregar/insertar una Cadena Hotelera Con Hoteles+++++++++++++++++++++++
    	//Inicio
    	ServicioCadena_Hotelera SCH = new ServicioCadena_Hotelera(); //Instanciacion del Servicio
    	Cadena_Hotelera CH = new Cadena_Hotelera();//asignacion de un nuevo espacio en memoria
    	CH.setIdCadena_Hotelera(3);
    	CH.setNombre("CadenaNueva3");
    	CH.setHotels(new ArrayList<Hotel>());
    	
    	Hotel hotel1 = new Hotel();
    	hotel1.setIdHotel(3);
    	hotel1.setNombre("h3");
    	hotel1.setUbicacion("U3");
    	hotel1.setCadenaHotelera(CH);
    	hotel1.setHabitaciones(new ArrayList<Habitacione>());
    	hotel1.setReservacions(new ArrayList<Reservacion>());
    	hotel1.setServicios(new ArrayList<Servicio>());
    	hotel1.setUsuarios(new ArrayList<Usuario>());
    	
    	
    	
    	Hotel hotel2 = new Hotel();
    	hotel2.setIdHotel(4);
    	hotel2.setNombre("h4");
    	hotel2.setUbicacion("U4");
    	hotel2.setCadenaHotelera(CH);
    	hotel2.setHabitaciones(new ArrayList<Habitacione>());
    	hotel2.setReservacions(new ArrayList<Reservacion>());
    	hotel2.setServicios(new ArrayList<Servicio>());
    	hotel2.setUsuarios(new ArrayList<Usuario>());
    	
    	CH.getHotels().add(hotel1);
    	CH.getHotels().add(hotel2);
    	SCH.insertar(CH);
    	//fin Agregar/insertar una Cadena Hotelera Con Hoteles
    	
    	*/
    	

    	
    	/*
    	//+++++++++++++++++++++++Actualizar una Cadena Hotelera para agregarle mas Hoteles+++++++++++++++++++++++
    	//Inicio
    	ServicioCadena_Hotelera SCH = new ServicioCadena_Hotelera(); //Instanciacion del Servicio
    	Cadena_Hotelera CH = new Cadena_Hotelera();//asignacion de un nuevo espacio en memoria
    	CH.setIdCadena_Hotelera(2);
    	CH.setNombre("CadenaNueva2");
    	CH.setHotels(new ArrayList<Hotel>());
    	SCH.startEntityManager();
    	
    	Hotel hotel1 = new Hotel();
    	hotel1.setIdHotel(5);
    	hotel1.setNombre("h5");
    	hotel1.setUbicacion("U5");
    	hotel1.setCadenaHotelera(CH);
    	hotel1.setHabitaciones(new ArrayList<Habitacione>());
    	hotel1.setReservacions(new ArrayList<Reservacion>());
    	hotel1.setServicios(new ArrayList<Servicio>());
    	hotel1.setUsuarios(new ArrayList<Usuario>());
    	
    	
    	
    	Hotel hotel2 = new Hotel();
    	hotel2.setIdHotel(6);
    	hotel2.setNombre("h6");
    	hotel2.setUbicacion("U6");
    	hotel2.setCadenaHotelera(CH);
    	hotel2.setHabitaciones(new ArrayList<Habitacione>());
    	hotel2.setReservacions(new ArrayList<Reservacion>());
    	hotel2.setServicios(new ArrayList<Servicio>());
    	hotel2.setUsuarios(new ArrayList<Usuario>());
    	
    	CH.getHotels().add(hotel1);
    	CH.getHotels().add(hotel2);
    	SCH.actualizar(CH);
    	//fin Actualizar una Cadena Hotelera Con Hoteles
    	*/
    	
    	
    	/*
    	//+++++++++++++++++++++++Agregar/insertar un Cliente+++++++++++++++++++++++
    	//Inicio
    	ServicioCliente SC = new ServicioCliente();
    	Cliente clientenuevo = new Cliente();
    	clientenuevo.setIdCliente(2);
    	clientenuevo.setNombre("clientenuevo2");
    	clientenuevo.setCedula("222222222");
    	clientenuevo.setTelefono("22222222");
    	clientenuevo.setReservacions(new ArrayList<Reservacion>());
    	clientenuevo.setServicios(new ArrayList<Servicio>());
    	SC.insertar(clientenuevo);
    	//FIN Agregar un cliente
    	*/
    
    	
    	/*
    	//+++++++++++++++++++++++Agregar/insertar una Reservacion/Cliente a un hotel+++++++++++++++++++++++
    	//Inicio
    	ServicioCliente SC = new ServicioCliente();
    	ServicioReservacion SR = new ServicioReservacion();
    	ServicioHotel SH= new ServicioHotel();
    	ServicioCadena_Hotelera SCH = new ServicioCadena_Hotelera(); //Instanciacion del Servicio
    	
    	
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
    	
    	Cliente clientenuevo = new Cliente();//cliente existente
    	clientenuevo.setIdCliente(1);
    	clientenuevo.setNombre("clientenuevo1");
    	clientenuevo.setCedula("11111111");
    	clientenuevo.setTelefono("111111111");
    	clientenuevo.setReservacions(new ArrayList<Reservacion>());
    	clientenuevo.setServicios(new ArrayList<Servicio>());
    
    	Reservacion reservacionueva = new Reservacion();//reservacion nueva
    	reservacionueva.setIdReservacion(1);
    	reservacionueva.setHotel(hotel1);
    	reservacionueva.setFecha_Reserva("08/08/2014");
    	reservacionueva.setFecha_Llegada("11/11/2014");
    	reservacionueva.setFecha_Salida("15/11/2014");
    	reservacionueva.setCliente(clientenuevo);
    	reservacionueva.setCosto(10000);
    	reservacionueva.setFacturas(new ArrayList<Factura>());
      	
    	hotel1.getReservacions().add(reservacionueva);
    	
    	SR.insertar(reservacionueva);
    	//FIN Agregar un cliente
    	*/
    	
    	/*
    	//+++++++++++++++++++++++Agregar/insertar un Servicio+++++++++++++++++++++++
    	//Inicio
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
    	
    	ServicioServicio SS = new ServicioServicio(); //Instanciacion del Servicio
    	ServicioCadena_Hotelera SCH = new ServicioCadena_Hotelera(); //Instanciacion del Servicio
    	ServicioHotel SH = new ServicioHotel(); //Instanciacion del Servicio
    	Servicio servicio = new Servicio();
    	
    	servicio.setClientes(new ArrayList<Cliente>());
    	servicio.setCosto(1000);
    	servicio.setDescripcion("Lavanderia");
    	servicio.setHorario(new Date(2013-01-01));
    	servicio.setHotel(hotel1);
    	servicio.setIdServicios(1);
    	
    	SS.insertar(servicio);
    	//FIN Insertar un Servicio 
    	*/
    	
    	/*
    	//+++++++++++++++++++++++Actualizar un Servicio+++++++++++++++++++++++
    	//Inicio
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
    	
    	ServicioServicio SS = new ServicioServicio(); //Instanciacion del Servicio
    	ServicioCadena_Hotelera SCH = new ServicioCadena_Hotelera(); //Instanciacion del Servicio
    	ServicioHotel SH = new ServicioHotel(); //Instanciacion del Servicio
    	Servicio servicio = new Servicio();
    	
    	servicio.setClientes(new ArrayList<Cliente>());
    	servicio.setCosto(2000);
    	servicio.setDescripcion("Lavanderia");
    	servicio.setHorario(new Date(2013-01-01));
    	servicio.setHotel(hotel1);
    	servicio.setIdServicios(1);
    	
    	SS.insertar(servicio);
    	//FIN Actualizar un Servicio 
    	*/
    	
    	/*
    	//+++++++++++++++++++++++Agregar/insertar una Habitacion+++++++++++++++++++++++
    	//Inicio
    	ServicioHabitacion SHabita = new ServicioHabitacion();
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
    	
    	SHabita.insertar(habitacion);
    	
    	//FIN Insertar un Habitacion 
    	*/
    	
    	/*
    	//+++++++++++++++++++++++Actualizar una Habitacion+++++++++++++++++++++++
    	//Inicio
    	ServicioHabitacion SHabita = new ServicioHabitacion();
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
    	
    	SHabita.actualizar(habitacion);
    	
    	//FIN Actualizar un Habitacion 
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
    	
    	
		/*su.startEntityManager();
		Usuario usuario = new Usuario();
		usuario = su.buscar(usuario, 1);
		su.closeEntityManager();
		System.out.println(usuario.getNombre());
		
		ControlHorarios p = ControlHorarios.getInstancia();
		p.iniciarSesionXelDia(usuario);
		
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
