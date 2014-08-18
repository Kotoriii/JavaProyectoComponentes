package LogicaHotel;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import comu.ServicioCadena_Hotelera;
import comu.ServicioCliente;
import comu.ServicioEntidad;
import comu.ServicioHabitacion;
import comu.ServicioHotel;
import comu.ServicioReservacion;
import comu.ServicioServicio;
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
public class Logica {
	
	
	public void InsertarCadenaHotelera(int idCadena, String Nombre){
		ServicioCadena_Hotelera SCH = new ServicioCadena_Hotelera(); //Instanciacion del Servicio
    	SCH.startEntityManager();
		Cadena_Hotelera CH = new Cadena_Hotelera();//asignacion de un nuevo espacio en memoria
    	CH.setIdCadena_Hotelera(idCadena);
    	CH.setNombre(Nombre);
    	CH.setHotels(new ArrayList<Hotel>());
    	SCH.insertar(CH);	
    	SCH.closeEntityManager();
	}
	
	public void ActualizarCadenaHotelera(int idCadena, String NombreNuevo){
		ServicioCadena_Hotelera SCH = new ServicioCadena_Hotelera(); //Instanciacion del Servicio
		SCH.startEntityManager();
		Cadena_Hotelera CH = new Cadena_Hotelera();//asignacion de un nuevo espacio en memoria
		CH = SCH.buscar(idCadena);
    	if(CH!= null)
    	{
    	CH.setIdCadena_Hotelera(idCadena);
    	CH.setNombre(NombreNuevo);
    	CH.setHotels(CH.getHotels());
    	SCH.actualizar(CH);	
    	}else
    		System.out.print("Cadena no existe");
    	
    	SCH.closeEntityManager();
	}
	
	public void BorrarCadenaHotelera(int idCadena){
		ServicioCadena_Hotelera SCH = new ServicioCadena_Hotelera(); //Instanciacion del Servicio
		SCH.startEntityManager();
		Cadena_Hotelera CH;//= new Cadena_Hotelera();//asignacion de un nuevo espacio en memoria
		CH = SCH.buscar(idCadena);
    	if(CH!= null)
    	{
    	CH.setIdCadena_Hotelera(CH.getIdCadena_Hotelera());
    	CH.setNombre(CH.getNombre());
    	CH.setHotels(CH.getHotels());
    	SCH.eliminar(CH);
    	}else
    		System.out.print("Cadena no existe");
    	
    	SCH.closeEntityManager();
	}
	
	
	
	public void InsertarHotelACadena(int idCadena, String Nombre, String Ubicacion){
		ServicioCadena_Hotelera SCH = new ServicioCadena_Hotelera(); //Instanciacion del Servicio
    	Cadena_Hotelera CH = new Cadena_Hotelera();//asignacion de un nuevo espacio en memoria
    	SCH.startEntityManager();
    	CH = SCH.buscar(idCadena);
    	if(CH!= null)
    	{	
    	CH.setIdCadena_Hotelera(CH.getIdCadena_Hotelera());
    	CH.setNombre(CH.getNombre());
    	CH.setHotels(new ArrayList<Hotel>());
    	SCH.startEntityManager();
    	
    	Hotel hotel1 = new Hotel();
    	hotel1.setIdHotel(9);
    	hotel1.setNombre(Nombre);
    	hotel1.setUbicacion(Ubicacion);
    	hotel1.setCadenaHotelera(CH);
    	hotel1.setHabitaciones(new ArrayList<Habitacione>());
    	hotel1.setReservacions(new ArrayList<Reservacion>());
    	hotel1.setServicios(new ArrayList<Servicio>());
    	hotel1.setUsuarios(new ArrayList<Usuario>());
    	
    
    	CH.getHotels().add(hotel1);
    	SCH.actualizar(CH);
    	}else 
    		System.out.print("Cadena hotelera no econtrada");
    	SCH.closeEntityManager();
		
	}
	
	
	public void InsertarCliente(int idcliente, String Nombre,String cedula,String telefono){
		ServicioCliente SC = new ServicioCliente();
    	Cliente clientenuevo = new Cliente();
    	clientenuevo.setIdCliente(2);
    	clientenuevo.setNombre(Nombre);
    	clientenuevo.setCedula(cedula);
    	clientenuevo.setTelefono(telefono);
    	clientenuevo.setReservacions(new ArrayList<Reservacion>());
    	clientenuevo.setServicios(new ArrayList<Servicio>());
    	SC.insertar(clientenuevo);
	}
	
	public void ActualizarCliente(int idcliente, String Nombre,String cedula,String telefono){
		ServicioCliente SC = new ServicioCliente();
    	Cliente clientenuevo = new Cliente();
    	clientenuevo = SC.buscar(idcliente);
    	if(clientenuevo!= null)
    	{
    	clientenuevo.setIdCliente(clientenuevo.getIdCliente());
    	clientenuevo.setNombre(Nombre);
    	clientenuevo.setCedula(cedula);
    	clientenuevo.setTelefono(telefono);
    	clientenuevo.setReservacions(clientenuevo.getReservacions());
    	clientenuevo.setServicios(clientenuevo.getServicios());
    	SC.actualizar(clientenuevo);
    	} else
    	System.out.print("No existe cliente");
	}
	
	
	
	public boolean CrearReservacion (int idCadena, int idHotel, int idCliente, String Llegada, String Salida){
		ServicioCliente SC = new ServicioCliente();
    	ServicioReservacion SR = new ServicioReservacion();
    	ServicioHotel SH= new ServicioHotel();
    	ServicioCadena_Hotelera SCH = new ServicioCadena_Hotelera(); //Instanciacion del Servicio
    	
    	
    	Cadena_Hotelera CH = new Cadena_Hotelera(); //Cadena Existente
    	CH = SCH.buscar(idCadena);
    	CH.setIdCadena_Hotelera(CH.getIdCadena_Hotelera());
    	CH.setNombre(CH.getNombre());
    	CH.setHotels(CH.getHotels());
    	
    	Hotel hotel1 = new Hotel(); // hotel existente
    	hotel1=SH.buscar(idHotel);
    	hotel1.setIdHotel(hotel1.getIdHotel());
    	hotel1.setNombre(hotel1.getNombre());
    	hotel1.setUbicacion(hotel1.getUbicacion());
    	hotel1.setCadenaHotelera(CH);
    	hotel1.setHabitaciones(hotel1.getHabitaciones());
    	hotel1.setReservacions(hotel1.getReservacions());
    	hotel1.setServicios(hotel1.getServicios());
    	hotel1.setUsuarios(hotel1.getUsuarios());
    	
    	for (int i =0; i< CH.getHotels().size();i++)
    	{
    		if(CH.getHotels().get(1).getIdHotel()== hotel1.getIdHotel())
    		{
    			Cliente clientenuevo = new Cliente();//cliente existente
    			if(clientenuevo!=null)
    			{
    			clientenuevo = SC.buscar(idCliente);
    			clientenuevo.setIdCliente(clientenuevo.getIdCliente());
    	    	clientenuevo.setNombre(clientenuevo.getNombre());
    	    	clientenuevo.setCedula(clientenuevo.getCedula());
    	    	clientenuevo.setTelefono(clientenuevo.getTelefono());
    	    	clientenuevo.setReservacions(clientenuevo.getReservacions());
    	    	clientenuevo.setServicios(clientenuevo.getServicios());
    	    
    	    	Reservacion reservacionueva = new Reservacion();//reservacion nueva
    	    	reservacionueva.setIdReservacion(1);
    	    	reservacionueva.setHotel(hotel1);
    	    	reservacionueva.setFecha_Reserva("08/08/2014");
    	    	reservacionueva.setFecha_Llegada(Llegada);
    	    	reservacionueva.setFecha_Salida(Salida);
    	    	reservacionueva.setCliente(clientenuevo);
    	    	reservacionueva.setCosto(10000);
    	    	reservacionueva.setFacturas(new ArrayList<Factura>());
    	      	
    	    	hotel1.getReservacions().add(reservacionueva);
    	    	
    	    	SR.insertar(reservacionueva);
    	    	return true;
    			}
    		}
    	}
    	
    	return false;
    	
	}
	
	public boolean CrearServicio (int idCadena, int idHotel, int idCliente, String Descripcion, Date horario, int costo){
		ServicioCadena_Hotelera SCH = new ServicioCadena_Hotelera();
		ServicioHotel SH = new ServicioHotel();
		Cadena_Hotelera CH = new Cadena_Hotelera(); //Cadena Existente
		CH = SCH.buscar(idCadena);
    	CH.setIdCadena_Hotelera(CH.getIdCadena_Hotelera());
    	CH.setNombre(CH.getNombre());
    	CH.setHotels(CH.getHotels());
    	
    	Hotel hotel1 = new Hotel(); // hotel existente
    	hotel1 = SH.buscar(idHotel);
    	hotel1.setIdHotel(hotel1.getIdHotel());
    	hotel1.setNombre(hotel1.getNombre());
    	hotel1.setUbicacion(hotel1.getUbicacion());
    	hotel1.setCadenaHotelera(CH);
    	hotel1.setHabitaciones(hotel1.getHabitaciones());
    	hotel1.setReservacions(hotel1.getReservacions());
    	hotel1.setServicios(hotel1.getServicios());
    	hotel1.setUsuarios(hotel1.getUsuarios());
    	CH.getHotels().add(hotel1);
    	for (int i =0; i< CH.getHotels().size();i++)
    	{
    		if(CH.getHotels().get(1).getIdHotel()== hotel1.getIdHotel())
    		{
    			ServicioServicio SS = new ServicioServicio(); //Instanciacion del Servicio
    			Servicio servicio = new Servicio();
    	
    			servicio.setClientes(new ArrayList<Cliente>());
    			servicio.setCosto(costo);
    			servicio.setDescripcion(Descripcion);
    			servicio.setHorario(horario);
    			servicio.setHotel(hotel1);
    			servicio.setIdServicios(1);
    	
    			SS.insertar(servicio);
    			return true;
    		}
    	}
    	return false;
	}
	
	public boolean ActualizarServicio (int idCadena, int idHotel, int idCliente, int idServicio, String Descripcion, Date horario, int costo){
		ServicioCadena_Hotelera SCH = new ServicioCadena_Hotelera();
		ServicioHotel SH = new ServicioHotel();
		Cadena_Hotelera CH = new Cadena_Hotelera(); //Cadena Existente
		CH = SCH.buscar(idCadena);
    	CH.setIdCadena_Hotelera(CH.getIdCadena_Hotelera());
    	CH.setNombre(CH.getNombre());
    	CH.setHotels(CH.getHotels());
    	
    	Hotel hotel1 = new Hotel(); // hotel existente
    	hotel1 = SH.buscar(idHotel);
    	hotel1.setIdHotel(hotel1.getIdHotel());
    	hotel1.setNombre(hotel1.getNombre());
    	hotel1.setUbicacion(hotel1.getUbicacion());
    	hotel1.setCadenaHotelera(CH);
    	hotel1.setHabitaciones(hotel1.getHabitaciones());
    	hotel1.setReservacions(hotel1.getReservacions());
    	hotel1.setServicios(hotel1.getServicios());
    	hotel1.setUsuarios(hotel1.getUsuarios());
    	CH.getHotels().add(hotel1);
    	for (int i =0; i< CH.getHotels().size();i++)
    	{
    		if(CH.getHotels().get(1).getIdHotel()== hotel1.getIdHotel())
    		{
    			ServicioServicio SS = new ServicioServicio(); //Instanciacion del Servicio
    			Servicio servicio = new Servicio();
    			servicio = SS.buscar(idServicio);
    			if (servicio!= null)
    			{
    			servicio.setClientes(new ArrayList<Cliente>());
    			servicio.setCosto(costo);
    			servicio.setDescripcion(Descripcion);
    			servicio.setHorario(horario);
    			servicio.setHotel(servicio.getHotel());
    			servicio.setIdServicios(servicio.getIdServicios());
    	
    			SS.actualizar(servicio);
    			return true;
    			}else
    				return false;
    		}
    	}
    	return false;
	}
	
	public boolean CrearHabitacion (int idcadena, int idhotel){
		ServicioHabitacion SHabita = new ServicioHabitacion();
		ServicioCadena_Hotelera SCH = new ServicioCadena_Hotelera();
    	ServicioHotel SH = new ServicioHotel();
		Habitacione habitacion = new Habitacione();
    	
    	Cadena_Hotelera CH = new Cadena_Hotelera(); //Cadena Existente
    	SCH.startEntityManager();
    	CH= SCH.buscar(idcadena);
    	if(CH!= null)
    	{
    		CH.setIdCadena_Hotelera(CH.getIdCadena_Hotelera());
        	CH.setNombre(CH.getNombre());
        	CH.setHotels(CH.getHotels());
    	Hotel hotel1 = new Hotel(); // hotel existente
    	SH.startEntityManager();
    	hotel1=SH.buscar(idhotel);
    	if(hotel1!=null)
    	{
    		hotel1.setIdHotel(hotel1.getIdHotel());
        	hotel1.setNombre(hotel1.getNombre());
        	hotel1.setUbicacion(hotel1.getUbicacion());
        	hotel1.setCadenaHotelera(hotel1.getCadenaHotelera());
        	hotel1.setHabitaciones(hotel1.getHabitaciones());
        	hotel1.setReservacions(hotel1.getReservacions());
        	hotel1.setServicios(hotel1.getServicios());
        	hotel1.setUsuarios(hotel1.getUsuarios());
    	for (int i = 0; i < CH.getHotels().size();i++)
    	{
    		if((CH.getHotels().get(i).getIdHotel()) == (hotel1.getIdHotel()))
    			{
    				habitacion.setHotel(hotel1);
    				habitacion.setIdHabitaciones(3);
    				habitacion.setElementos(new ArrayList<Elemento>());
    				habitacion.setServicioExtras(new ArrayList<ServicioExtra>());
    				SHabita.insertar(habitacion);
    				SH.closeEntityManager();
    				SCH.closeEntityManager();
    				return true;
    			}
    	}
    	SCH.closeEntityManager();
    	SH.closeEntityManager();
    	return false;
    	}
    	
    	else{
    		SH.closeEntityManager();
    		SCH.closeEntityManager();
    		return false;
    		}
    	}
    	else{ 
    		SH.closeEntityManager();
    		SCH.closeEntityManager();
    		return false;
    		}
    	}
	
	public boolean ActualizarHabitacion (int idcadena, int idhotel, int idhabitacion){
		ServicioHabitacion SHabita = new ServicioHabitacion();
		ServicioCadena_Hotelera SCH = new ServicioCadena_Hotelera();
    	ServicioHotel SH = new ServicioHotel();
		Habitacione habitacion = new Habitacione();
    	
    	Cadena_Hotelera CH = new Cadena_Hotelera(); //Cadena Existente
    	SCH.startEntityManager();
    	CH= SCH.buscar(idcadena);
    	CH.setIdCadena_Hotelera(CH.getIdCadena_Hotelera());
    	CH.setNombre(CH.getNombre());
    	CH.setHotels(CH.getHotels());
    	if(CH!= null)
    	{
    	Hotel hotel1 = new Hotel(); // hotel existente
    	SH.startEntityManager();
    	hotel1=SH.buscar(idhotel);
    	hotel1.setIdHotel(hotel1.getIdHotel());
    	hotel1.setNombre(hotel1.getNombre());
    	hotel1.setUbicacion(hotel1.getUbicacion());
    	hotel1.setCadenaHotelera(hotel1.getCadenaHotelera());
    	hotel1.setHabitaciones(hotel1.getHabitaciones());
    	hotel1.setReservacions(hotel1.getReservacions());
    	hotel1.setServicios(hotel1.getServicios());
    	hotel1.setUsuarios(hotel1.getUsuarios());
    	if(hotel1!=null)
    	{
    	for (int i = 0; i < CH.getHotels().size();i++)
    	{
    		if((CH.getHotels().get(i).getIdHotel()) == (hotel1.getIdHotel()))
    			{
    				SHabita.startEntityManager();
    				habitacion = SHabita.buscar(idhabitacion);
    				if(habitacion!=null)
    				{
    				habitacion.setHotel(habitacion.getHotel());
    				habitacion.setIdHabitaciones(habitacion.getIdHabitaciones());
    				habitacion.setElementos(habitacion.getElementos());
    				habitacion.setServicioExtras(habitacion.getServicioExtras());
    				
    				SHabita.actualizar(habitacion);
    				SHabita.closeEntityManager();
    				SH.closeEntityManager();
    				SCH.closeEntityManager();
    				return true;
    				}else{
    					SHabita.closeEntityManager();
						SH.closeEntityManager();
						SCH.closeEntityManager();
    					return false;			
    				}}
    	}
    	SCH.closeEntityManager();
    	SH.closeEntityManager();
    	return false;
    	}
    	
    	else{
    		SH.closeEntityManager();
    		SCH.closeEntityManager();
    		return false;
    		}
    	}
    	else{ 
    		SH.closeEntityManager();
    		SCH.closeEntityManager();
    		return false;
    		}
    	}
	
	
	
	
	
	
};

