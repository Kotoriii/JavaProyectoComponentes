package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import comu.ServicioCadena_Hotelera;
import comu.ServicioCliente;
import comu.ServicioHotel;
import comu.ServicioReservacion;
import entidades.Cadena_Hotelera;
import entidades.Cliente;
import entidades.Factura;
import entidades.Hotel;
import entidades.Reservacion;

/**
 * Servlet implementation class AgregarReservacion
 */

public class AgregarReservacion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AgregarReservacion() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String FechaSalida = request.getParameter("FechaSalida");	
		String FechaReservacion = request.getParameter("FechaReservacion");
		int costo = Integer.parseInt(request.getParameter("Costo"));
		int idhotel = Integer.parseInt(request.getParameter("IdHotel"));
		int idcliente= Integer.parseInt(request.getParameter("IdCliente"));
		String Fechallegada = request.getParameter("FechaLlegada");	
		
		
		
		ServicioCliente SC = new ServicioCliente();
    	ServicioReservacion SR = new ServicioReservacion();
    	ServicioHotel SH= new ServicioHotel();
    	ServicioCadena_Hotelera SCH = new ServicioCadena_Hotelera(); //Instanciacion del Servicio
    	SH.startEntityManager();
    	Hotel hotel1 = new Hotel(); // hotel existente
    	hotel1=SH.buscar(idhotel);
    	
    	
    	Cadena_Hotelera CH = new Cadena_Hotelera(); //Cadena Existente
    	SCH.startEntityManager();
    	CH=hotel1.getCadenaHotelera();
    	if(CH!=null){
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
   
    			Cliente clientenuevo = new Cliente();//cliente existente
    			SC.startEntityManager();
    			clientenuevo = SC.buscar(idcliente);
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
    	    	reservacionueva.setFecha_Reserva("18/08/2014");
    	    	reservacionueva.setFecha_Llegada(Fechallegada);
    	    	reservacionueva.setFecha_Salida(FechaSalida);
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
    	
    			}else
    			{
    				SC.closeEntityManager();
    				SH.closeEntityManager();
    	    		SCH.closeEntityManager();
    	        
    			}
    		
    	}else
    	{	
    		SH.closeEntityManager();
    		SCH.closeEntityManager();
  
    	}
    	}else{
	    	SCH.closeEntityManager();
    
    	}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
