package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import comu.ServicioCadena_Hotelera;
import comu.ServicioHotel;
import entidades.Cadena_Hotelera;
import entidades.Hotel;

/**
 * Servlet implementation class ActualizarHotel
 */

public class ActualizarHotel extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ActualizarHotel() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServicioCadena_Hotelera SCH = new ServicioCadena_Hotelera(); //Instanciacion del Servicio
    	ServicioHotel SH = new ServicioHotel();
    	String nombreHotel = request.getParameter("Nombre");	
		String Ubicacion = request.getParameter("Ubicacion");	
	 	int idCadena = Integer.parseInt(request.getParameter("IdCadenaHotelera"));
	 	int idhotel = Integer.parseInt(request.getParameter("IdHotel"));
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
    	hotel1.setNombre(nombreHotel);
    	hotel1.setUbicacion(Ubicacion);
    	hotel1.setCadenaHotelera(CH);
    	hotel1.setHabitaciones(hotel1.getHabitaciones());
    	hotel1.setReservacions(hotel1.getReservacions());
    	hotel1.setServicios(hotel1.getServicios());
    	hotel1.setUsuarios(hotel1.getUsuarios());
    	CH.getHotels().add(hotel1);
    	SCH.actualizar(CH);
    	SH.closeEntityManager();
   
    	}else
    	{
    		SCH.closeEntityManager();
			SH.closeEntityManager();
		
    	}
    	}else {
    			SCH.closeEntityManager();
    			SH.closeEntityManager();
    		
    	}	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
