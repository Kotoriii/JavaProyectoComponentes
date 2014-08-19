package LogicaHotel;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
public class Logica {
	
	
	public void InsertarCadenaHotelera(int idCadena, String Nombre){
		ServicioCadena_Hotelera SCH = new ServicioCadena_Hotelera(); //Instanciacion del Servicio
    	SCH.startEntityManager();
		Cadena_Hotelera CH = new Cadena_Hotelera();//asignacion de un nuevo espacio en memoria
    	CH.setIdCadena_Hotelera(SCH.siguienteId());
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

    	SCH.closeEntityManager();
    	}else
    	{
    		System.out.print("Cadena no existe");
    		SCH.closeEntityManager();
    	}
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

    	SCH.closeEntityManager();
    	}else
    	{
    		System.out.print("Cadena no existe");
    		SCH.closeEntityManager();
    	}
	}
	
	
	
	public void InsertarHotelACadena(int idCadena, String Nombre, String Ubicacion){
		ServicioCadena_Hotelera SCH = new ServicioCadena_Hotelera(); //Instanciacion del Servicio

    	ServicioHotel SH = new ServicioHotel();
		Cadena_Hotelera CH = new Cadena_Hotelera();//asignacion de un nuevo espacio en memoria

    	SCH.startEntityManager();
    	CH = SCH.buscar(idCadena);
    	if(CH!= null)
    	{	
    	CH.setIdCadena_Hotelera(CH.getIdCadena_Hotelera());
    	CH.setNombre(CH.getNombre());
    	CH.setHotels(new ArrayList<Hotel>());
    	SCH.startEntityManager();

    	SH.startEntityManager();
    	Hotel hotel1 = new Hotel();
    	hotel1.setIdHotel(SH.siguienteId());
    	hotel1.setNombre(Nombre);
    	hotel1.setUbicacion(Ubicacion);
    	hotel1.setCadenaHotelera(CH);
    	hotel1.setHabitaciones(new ArrayList<Habitacione>());
    	hotel1.setReservacions(new ArrayList<Reservacion>());
    	hotel1.setServicios(new ArrayList<Servicio>());
    	hotel1.setUsuarios(new ArrayList<Usuario>());
    	
    
    	CH.getHotels().add(hotel1);
    	SCH.actualizar(CH);

    	SH.closeEntityManager();
    	}else {
    			System.out.print("Cadena hotelera no econtrada");
    			SCH.closeEntityManager();
    			SH.closeEntityManager();
    	}
	}
	
	
	public boolean ActualizarHotelACadena(int idCadena,int idhotel, String Nombre, String Ubicacion){
		ServicioCadena_Hotelera SCH = new ServicioCadena_Hotelera(); //Instanciacion del Servicio
    	ServicioHotel SH = new ServicioHotel();
		Cadena_Hotelera CH = new Cadena_Hotelera();//asignacion de un nuevo espacio en memoria
    	SCH.startEntityManager();
    	CH = SCH.buscar(idCadena);
    	if(CH!= null)
    	{	
    	CH.setIdCadena_Hotelera(CH.getIdCadena_Hotelera());
    	CH.setNombre(CH.getNombre());
    	CH.setHotels(new ArrayList<Hotel>());
    	SCH.startEntityManager();
    	SH.startEntityManager();
    	Hotel hotel1 = new Hotel();
    	hotel1 = SH.buscar(idhotel);
    	if(hotel1!=null)
    	{
    	hotel1.setIdHotel(hotel1.getIdHotel());
    	hotel1.setNombre(Nombre);
    	hotel1.setUbicacion(Ubicacion);
    	hotel1.setCadenaHotelera(CH);
    	hotel1.setHabitaciones(hotel1.getHabitaciones());
    	hotel1.setReservacions(hotel1.getReservacions());
    	hotel1.setServicios(hotel1.getServicios());
    	hotel1.setUsuarios(hotel1.getUsuarios());
    	CH.getHotels().add(hotel1);
    	SCH.actualizar(CH);
    	SH.closeEntityManager();
    	return true;
    	}else
    	{
    		SCH.closeEntityManager();
			SH.closeEntityManager();
			return false;
    	}
    	}else {
    			SCH.closeEntityManager();
    			SH.closeEntityManager();
    			return false;
    	}
	}
	
	
	public void InsertarCliente(String Nombre,String cedula,String telefono){
		ServicioCliente SC = new ServicioCliente();
		SC.startEntityManager();
    	Cliente clientenuevo = new Cliente();
    	clientenuevo.setIdCliente(SC.siguienteId());
    	clientenuevo.setNombre(Nombre);
    	clientenuevo.setCedula(cedula);
    	clientenuevo.setTelefono(telefono);
    	clientenuevo.setReservacions(new ArrayList<Reservacion>());
    	clientenuevo.setServicios(new ArrayList<Servicio>());
    	SC.insertar(clientenuevo);

    	SC.closeEntityManager();
	}
	
	public boolean ActualizarCliente(int idcliente, String Nombre,String cedula,String telefono){
		ServicioCliente SC = new ServicioCliente();
    	Cliente clientenuevo = new Cliente();
    	SC.startEntityManager();
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
    	SC.closeEntityManager();
    	return true;
    	} else{
    		SC.closeEntityManager();
    		return false;
    	}
	}
	
	
	
	public boolean CrearReservacion (int idHotel, int idCliente, String Llegada, String Salida){
		ServicioCliente SC = new ServicioCliente();
    	ServicioReservacion SR = new ServicioReservacion();
    	ServicioHotel SH= new ServicioHotel();
    	ServicioCadena_Hotelera SCH = new ServicioCadena_Hotelera(); //Instanciacion del Servicio
    	SH.startEntityManager();
    	Hotel hotel1 = new Hotel(); // hotel existente
    	hotel1=SH.buscar(idHotel);
    	
    	
    	Cadena_Hotelera CH = new Cadena_Hotelera(); //Cadena Existente

    	SCH.startEntityManager();
    	CH=hotel1.getCadenaHotelera();
    	if(CH!=null){
    	CH.setIdCadena_Hotelera(CH.getIdCadena_Hotelera());
    	CH.setNombre(CH.getNombre());
    	CH.setHotels(CH.getHotels());
    	
    	SH.startEntityManager();
    	hotel1=SH.buscar(idHotel);
    	if(hotel1!=null)
    	{
    	hotel1.setIdHotel(hotel1.getIdHotel());
    	hotel1.setNombre(hotel1.getNombre());
    	hotel1.setUbicacion(hotel1.getUbicacion());
    	hotel1.setCadenaHotelera(CH);
    	hotel1.setHabitaciones(hotel1.getHabitaciones());
    	hotel1.setReservacions(hotel1.getReservacions());
    	hotel1.setServicios(hotel1.getServicios());
    	hotel1.setUsuarios(hotel1.getUsuarios());
   
    			Cliente clientenuevo = new Cliente();//cliente existente
    			SC.startEntityManager();
    			clientenuevo = SC.buscar(idCliente);
    			if(clientenuevo!=null)
    			{
    			clientenuevo.setIdCliente(clientenuevo.getIdCliente());
    	    	clientenuevo.setNombre(clientenuevo.getNombre());
    	    	clientenuevo.setCedula(clientenuevo.getCedula());
    	    	clientenuevo.setTelefono(clientenuevo.getTelefono());
    	    	clientenuevo.setReservacions(clientenuevo.getReservacions());
    	    	clientenuevo.setServicios(clientenuevo.getServicios());
    	    	SR.startEntityManager();
    	    	Reservacion reservacionueva = new Reservacion();//reservacion nueva
    	    	reservacionueva.setIdReservacion(SR.siguienteId());
    	    	reservacionueva.setHotel(hotel1);
    	    	reservacionueva.setFecha_Reserva("08/08/2014");
    	    	reservacionueva.setFecha_Llegada(Llegada);
    	    	reservacionueva.setFecha_Salida(Salida);
    	    	reservacionueva.setCliente(clientenuevo);
    	    	reservacionueva.setCosto(10000);
    	    	reservacionueva.setFacturas(new ArrayList<Factura>());
    	      	
    	    	hotel1.getReservacions().add(reservacionueva);
    	    	clientenuevo.getReservacions().add(reservacionueva);
    	    	
    	    	SR.insertar(reservacionueva);
    	    	SC.closeEntityManager();
    	    	SR.closeEntityManager();
    	    	SH.closeEntityManager();
    	    	SCH.closeEntityManager();
    	    	return true;
    			}else
    			{
    				SC.closeEntityManager();
    				SH.closeEntityManager();
    	    		SCH.closeEntityManager();
    	        	return false;
    			}
    		
    	}else
    	{	
    		SH.closeEntityManager();
    		SCH.closeEntityManager();
        	return false;
    	}
    	}else{
	    	SCH.closeEntityManager();
    	return false;
    	}
	}
	
	
	public boolean ActualizarReservacion (int idHotel, int idCliente, int idreservacion, String Llegada, String Salida){
		ServicioCliente SC = new ServicioCliente();
    	ServicioReservacion SR = new ServicioReservacion();
    	ServicioHotel SH= new ServicioHotel();
    	ServicioCadena_Hotelera SCH = new ServicioCadena_Hotelera(); //Instanciacion del Servicio
    	SH.startEntityManager();
    	Hotel hotel1 = new Hotel(); // hotel existente
    	hotel1=SH.buscar(idHotel);
    	
    	Cadena_Hotelera CH = new Cadena_Hotelera(); //Cadena Existente
    	SCH.startEntityManager();
    	CH = hotel1.getCadenaHotelera();
    	if(CH!=null){
    	CH.setIdCadena_Hotelera(CH.getIdCadena_Hotelera());
    	CH.setNombre(CH.getNombre());
    	CH.setHotels(CH.getHotels());
    	
    	SH.startEntityManager();
    	hotel1=SH.buscar(idHotel);
    	if(hotel1!=null)
    	{
    	hotel1.setIdHotel(hotel1.getIdHotel());
    	hotel1.setNombre(hotel1.getNombre());
    	hotel1.setUbicacion(hotel1.getUbicacion());
    	hotel1.setCadenaHotelera(CH);
    	hotel1.setHabitaciones(hotel1.getHabitaciones());
    	hotel1.setReservacions(hotel1.getReservacions());
    	hotel1.setServicios(hotel1.getServicios());
    	hotel1.setUsuarios(hotel1.getUsuarios());
   
    			Cliente clientenuevo = new Cliente();//cliente existente
    			SC.startEntityManager();
    			clientenuevo = SC.buscar(idCliente);
    			if(clientenuevo!=null)
    			{
    			clientenuevo.setIdCliente(clientenuevo.getIdCliente());
    	    	clientenuevo.setNombre(clientenuevo.getNombre());
    	    	clientenuevo.setCedula(clientenuevo.getCedula());
    	    	clientenuevo.setTelefono(clientenuevo.getTelefono());
    	    	clientenuevo.setReservacions(clientenuevo.getReservacions());
    	    	clientenuevo.setServicios(clientenuevo.getServicios());
    	    
    	    	SR.startEntityManager();
    	    	Reservacion reservacionueva = new Reservacion();//reservacion nueva
    	    	reservacionueva=SR.buscar(idreservacion);
    	    	if(reservacionueva!=null)
    	    	{
    	    	reservacionueva.setIdReservacion(reservacionueva.getIdReservacion());
    	    	reservacionueva.setHotel(reservacionueva.getHotel());
    	    	reservacionueva.setFecha_Reserva("08/08/2014");
    	    	reservacionueva.setFecha_Llegada(Llegada);
    	    	reservacionueva.setFecha_Salida(Salida);
    	    	reservacionueva.setCliente(reservacionueva.getCliente());
    	    	reservacionueva.setCosto(10000);
    	    	reservacionueva.setFacturas(new ArrayList<Factura>());
    	      	
    	    	hotel1.getReservacions().add(reservacionueva);
    	    	clientenuevo.getReservacions().add(reservacionueva);
    	    	
    	    	SR.actualizar(reservacionueva);
    	    	SC.closeEntityManager();
    	    	SR.closeEntityManager();
    	    	SH.closeEntityManager();
    	    	SCH.closeEntityManager();
    	    	return true;
    	    	}else
    	    	{
    	    		SR.closeEntityManager();
    	    		SC.closeEntityManager();
    				SH.closeEntityManager();
    	    		SCH.closeEntityManager();
    	        	return false;
    	    	}
    			}else
    			{
    				SC.closeEntityManager();
    				SH.closeEntityManager();
    	    		SCH.closeEntityManager();
    	        	return false;
    			}
    		
    	}else
    	{	
    		SH.closeEntityManager();
    		SCH.closeEntityManager();
        	return false;
    	}
    	}else{
	    	SCH.closeEntityManager();
    	return false;
    	}
	}
	
	

	
	
	public boolean CrearServicio (int idHotel, int idCliente, String Descripcion, int costo){

		ServicioCadena_Hotelera SCH = new ServicioCadena_Hotelera();
		Date horario = new Date(20-8-2014);
		ServicioHotel SH = new ServicioHotel();
		Hotel hotel1 = new Hotel(); // hotel existente
    	SH.startEntityManager();
    	hotel1 = SH.buscar(idHotel);
		Cadena_Hotelera CH = new Cadena_Hotelera(); //Cadena Existente
		SCH.startEntityManager();
		CH = hotel1.getCadenaHotelera();
		if(CH!=null)
		{
    	CH.setIdCadena_Hotelera(CH.getIdCadena_Hotelera());
    	CH.setNombre(CH.getNombre());
    	CH.setHotels(CH.getHotels());
    	
    	if(hotel1!=null)
    	{
    	hotel1.setIdHotel(hotel1.getIdHotel());
    	hotel1.setNombre(hotel1.getNombre());
    	hotel1.setUbicacion(hotel1.getUbicacion());
    	hotel1.setCadenaHotelera(CH);
    	hotel1.setHabitaciones(hotel1.getHabitaciones());
    	hotel1.setReservacions(hotel1.getReservacions());
    	hotel1.setServicios(hotel1.getServicios());
    	hotel1.setUsuarios(hotel1.getUsuarios());
    	CH.getHotels().add(hotel1);
    	
    			ServicioServicio SS = new ServicioServicio(); //Instanciacion del Servicio
    			Servicio servicio = new Servicio();
    			SS.startEntityManager();
    			servicio.setClientes(new ArrayList<Cliente>());
    			servicio.setCosto(costo);
    			servicio.setDescripcion(Descripcion);
    			servicio.setHorario(horario);
    			servicio.setHotel(hotel1);
    			servicio.setIdServicios(SS.siguienteId());
    	
    			SS.insertar(servicio);
    			SS.closeEntityManager();
    			SH.closeEntityManager();
        		SCH.closeEntityManager();
    			return true;
    	
		}else
		{
			SCH.closeEntityManager();
			return false;
		}
		}
		SCH.closeEntityManager();
		return false;
		}
	
	public boolean ActualizarServicio (int idHotel, int idCliente, int idServicio, String Descripcion,int costo){
		ServicioCadena_Hotelera SCH = new ServicioCadena_Hotelera();
		Date horario = new Date(20-8-2014);
		ServicioHotel SH = new ServicioHotel();
		Cadena_Hotelera CH = new Cadena_Hotelera(); //Cadena Existente
		SCH.startEntityManager();
		Hotel hotel1 = new Hotel(); // hotel existente
    	SH.startEntityManager();
    	hotel1 = SH.buscar(idHotel);
		CH = hotel1.getCadenaHotelera();
		if(CH!=null)
		{
    	CH.setIdCadena_Hotelera(CH.getIdCadena_Hotelera());
    	CH.setNombre(CH.getNombre());
    	CH.setHotels(CH.getHotels());
    	
    	if(hotel1!=null)
    	{
    	hotel1.setIdHotel(hotel1.getIdHotel());
    	hotel1.setNombre(hotel1.getNombre());
    	hotel1.setUbicacion(hotel1.getUbicacion());
    	hotel1.setCadenaHotelera(CH);
    	hotel1.setHabitaciones(hotel1.getHabitaciones());
    	hotel1.setReservacions(hotel1.getReservacions());
    	hotel1.setServicios(hotel1.getServicios());
    	hotel1.setUsuarios(hotel1.getUsuarios());
    	CH.getHotels().add(hotel1);
    	
    			ServicioServicio SS = new ServicioServicio(); //Instanciacion del Servicio
    			Servicio servicio = new Servicio();
    			SS.startEntityManager();
    			servicio = SS.buscar(idServicio);
    			if(servicio!=null)
    			{
    			servicio.setClientes(servicio.getClientes());
    			servicio.setCosto(costo);
    			servicio.setDescripcion(Descripcion);
    			servicio.setHorario(servicio.getHorario());
    			servicio.setHotel(hotel1);
    			servicio.setIdServicios(servicio.getIdServicios());
    	
    			SS.actualizar(servicio);
    			SS.closeEntityManager();
    			SH.closeEntityManager();
        		SCH.closeEntityManager();
    			return true;
    			}else
    			{
    				SH.closeEntityManager();
    				SS.closeEntityManager();
    				SCH.closeEntityManager();
    				return false;
    			}
		}else
		{
			SH.closeEntityManager();
			SCH.closeEntityManager();
			return false;
		}
		}
		SCH.closeEntityManager();
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
    				SHabita.startEntityManager();
    				habitacion.setIdHabitaciones(SHabita.siguienteId());
    				habitacion.setElementos(new ArrayList<Elemento>());
    				habitacion.setServicioExtras(new ArrayList<ServicioExtra>());
    				SHabita.insertar(habitacion);
    				SHabita.closeEntityManager();
    				hotel1.getHabitaciones().add(habitacion);
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
    				SHabita.startEntityManager();
    				habitacion = SHabita.buscar(idhabitacion);
    				if(habitacion!=null){
    				habitacion.setHotel(hotel1);
    				habitacion.setIdHabitaciones(habitacion.getIdHabitaciones());
    				habitacion.setElementos(habitacion.getElementos());
    				habitacion.setServicioExtras(habitacion.getServicioExtras());
    				SHabita.actualizar(habitacion);
    				SHabita.closeEntityManager();
    				hotel1.getHabitaciones().add(habitacion);
    				SH.closeEntityManager();
    				SCH.closeEntityManager();
    				return true;
    				}else
    				{
    					SHabita.closeEntityManager();
    					SCH.closeEntityManager();
    			    	SH.closeEntityManager();
    			    	return false;
    				}
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
	
	
	public boolean AgregarElemento (int idcadena, int idhotel, int idhabitacion, String descripcion){
		ServicioElemento SEl = new ServicioElemento();
		ServicioCadena_Hotelera SCH = new ServicioCadena_Hotelera();
		ServicioHotel SH = new ServicioHotel();
    	Elemento elemento = new Elemento();
    	ServicioHabitacion SHab = new ServicioHabitacion();
    	Habitacione habitacion = new Habitacione();
    	Cadena_Hotelera CH = new Cadena_Hotelera(); //Cadena Existente
    	SCH.startEntityManager();
    	CH= SCH.buscar(idcadena);
    	if(CH!=null){
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
    	SHab.startEntityManager();
    	habitacion = SHab.buscar(idhabitacion);
    	if(habitacion!= null)
    	{
    	habitacion.setIdHabitaciones(habitacion.getIdHabitaciones());
    	habitacion.setHotel(habitacion.getHotel());
    	habitacion.setElementos(habitacion.getElementos());
    	habitacion.setServicioExtras(habitacion.getServicioExtras());
    	
    	elemento.setIdElemento(2);
    	elemento.setDescripcion_Elemento(descripcion);
    	elemento.setHabitacione(habitacion);
    	
    	habitacion.getElementos().add(elemento);
    	SEl.insertar(elemento);
    	SHab.actualizar(habitacion);
    	SH.closeEntityManager();
    	SCH.closeEntityManager();
    	return true;
    	}else
    	{
    		SHab.closeEntityManager();
    		SH.closeEntityManager();
    		SCH.closeEntityManager();
    		return false;
    	}
    	}else{
    		SH.closeEntityManager();
    		SCH.closeEntityManager();
    		return false;
    	}
    		
    	}
    	else{
    		SCH.closeEntityManager();
    		return false;
    	}
	}
	
	
	public boolean ActualizarElemento (int idcadena, int idhotel, int idhabitacion, int idelemento,String descripcion){
		ServicioElemento SEl = new ServicioElemento();
		ServicioCadena_Hotelera SCH = new ServicioCadena_Hotelera();
		ServicioHotel SH = new ServicioHotel();
    	Elemento elemento = new Elemento();
    	ServicioHabitacion SHab = new ServicioHabitacion();
    	Habitacione habitacion = new Habitacione();
    	Cadena_Hotelera CH = new Cadena_Hotelera(); //Cadena Existente
    	SCH.startEntityManager();
    	CH= SCH.buscar(idcadena);
    	if(CH!=null){
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
    	SHab.startEntityManager();
    	habitacion = SHab.buscar(idhabitacion);
    	if(habitacion!= null)
    	{
    	habitacion.setIdHabitaciones(habitacion.getIdHabitaciones());
    	habitacion.setHotel(habitacion.getHotel());
    	habitacion.setElementos(habitacion.getElementos());
    	habitacion.setServicioExtras(habitacion.getServicioExtras());
    	
    	SEl.startEntityManager();
    	elemento= SEl.buscar(idelemento);
    	if(elemento!=null)
    	{
    	elemento.setIdElemento(elemento.getIdElemento());
    	elemento.setDescripcion_Elemento(descripcion);
    	elemento.setHabitacione(elemento.getHabitacione());
    
    	SEl.actualizar(elemento);
    	SHab.actualizar(habitacion);
    	SH.closeEntityManager();
    	SCH.closeEntityManager();
    	return true;
    	}else
    	{
    		SEl.closeEntityManager();
    		SHab.closeEntityManager();
    		SH.closeEntityManager();
    		SCH.closeEntityManager();
    		return false;	
    	}
    	}else
    	{
    		SHab.closeEntityManager();
    		SH.closeEntityManager();
    		SCH.closeEntityManager();
    		return false;
    	}
    	}else{
    		SH.closeEntityManager();
    		SCH.closeEntityManager();
    		return false;
    	}
    		
    	}
    	else{
    		SCH.closeEntityManager();
    		return false;
    	}
	}
	
	
	public boolean AgregarServicioExtra(int idcadena, int idhotel, int idhabitacion, int idelemento,String descripcion,int costo,Date horario){
		//Inicio
		ServicioCadena_Hotelera SCH = new ServicioCadena_Hotelera();
		ServicioHotel SH = new ServicioHotel();
    	ServicioServicioExtra SSE = new ServicioServicioExtra();
    	ServicioExtra SE = new ServicioExtra();
    	ServicioHabitacion SHab = new ServicioHabitacion();
    	Habitacione habitacion = new Habitacione();
    	Cadena_Hotelera CH = new Cadena_Hotelera(); //Cadena Existente
    	SCH.startEntityManager();
    	CH=SCH.buscar(idcadena);
    	if(CH!=null)
    	{
    	CH.setIdCadena_Hotelera(CH.getIdCadena_Hotelera());
    	CH.setNombre(CH.getNombre());
    	CH.setHotels(CH.getHotels());
    	
    	Hotel hotel1 = new Hotel(); // hotel existente
    	SH.startEntityManager();
    	hotel1 = SH.buscar(idhotel);
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
    	
    	SHab.startEntityManager();
    	habitacion=SHab.buscar(idhabitacion);
    	if(habitacion!=null)
    	{
    	habitacion.setHotel(habitacion.getHotel());
    	habitacion.setIdHabitaciones(habitacion.getIdHabitaciones());
    	habitacion.setElementos(habitacion.getElementos());
    	habitacion.setServicioExtras(habitacion.getServicioExtras());
    	
    	
    	SE.setCosto(costo);
    	SE.setDescripcion(descripcion);
    	SE.setHabitacione(habitacion);
    	SE.setHorario(horario);
    	SE.setIdServicio_Extra(2);
    	
    	habitacion.getServicioExtras().add(SE);
    	
    	SHab.actualizar(habitacion);
    	SSE.insertar(SE);
    	SHab.closeEntityManager();
    	SH.closeEntityManager();
    	SCH.closeEntityManager();
    	return true;
    	}else
    	{
    		SHab.closeEntityManager();
    		SH.closeEntityManager();
    		SCH.closeEntityManager();
    		return false;
    	}
    	}
    	else
    	{
    		SH.closeEntityManager();
    		SCH.closeEntityManager();
    		return false;
    	}
    	}else{
    		SCH.closeEntityManager();
    		return false;
    	}
	}
	
	
	public boolean ActualizarServicioExtra(int idcadena, int idhotel, int idhabitacion, int idelemento,String descripcion,int costo,int idse,Date horario){
		//Inicio
		ServicioCadena_Hotelera SCH = new ServicioCadena_Hotelera();
		ServicioHotel SH = new ServicioHotel();
    	ServicioServicioExtra SSE = new ServicioServicioExtra();
    	ServicioExtra SE = new ServicioExtra();
    	ServicioHabitacion SHab = new ServicioHabitacion();
    	Habitacione habitacion = new Habitacione();
    	Cadena_Hotelera CH = new Cadena_Hotelera(); //Cadena Existente
    	SCH.startEntityManager();
    	CH=SCH.buscar(idcadena);
    	if(CH!=null)
    	{
    	CH.setIdCadena_Hotelera(CH.getIdCadena_Hotelera());
    	CH.setNombre(CH.getNombre());
    	CH.setHotels(CH.getHotels());
    	
    	Hotel hotel1 = new Hotel(); // hotel existente
    	SH.startEntityManager();
    	hotel1 = SH.buscar(idhotel);
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
    	
    	SHab.startEntityManager();
    	habitacion=SHab.buscar(idhabitacion);
    	if(habitacion!=null)
    	{
    	habitacion.setHotel(habitacion.getHotel());
    	habitacion.setIdHabitaciones(habitacion.getIdHabitaciones());
    	habitacion.setElementos(habitacion.getElementos());
    	habitacion.setServicioExtras(habitacion.getServicioExtras());
    	
    	SSE.startEntityManager();
    	SE = SSE.buscar(idse);
    	if(SE!=null)
    	{
    	SE.setCosto(costo);
    	SE.setDescripcion(descripcion);
    	SE.setHabitacione(habitacion);
    	SE.setHorario(horario);
    	SE.setIdServicio_Extra(SE.getIdServicio_Extra());
    	habitacion.getServicioExtras().add(SE);
    	
    	SHab.actualizar(habitacion);
    	SSE.insertar(SE);
    	SSE.closeEntityManager();
    	SHab.closeEntityManager();
    	SH.closeEntityManager();
    	SCH.closeEntityManager();
    	return true;
    	}else
    	{
    		SSE.closeEntityManager();
    		SHab.closeEntityManager();
    		SH.closeEntityManager();
    		SCH.closeEntityManager();	
    		return false;
    	}
    	}else
    	{
    		SHab.closeEntityManager();
    		SH.closeEntityManager();
    		SCH.closeEntityManager();
    		return false;
    	}
    	}
    	else
    	{
    		SH.closeEntityManager();
    		SCH.closeEntityManager();
    		return false;
    	}
    	}else{
    		SCH.closeEntityManager();
    		return false;
    	}
	}
};

