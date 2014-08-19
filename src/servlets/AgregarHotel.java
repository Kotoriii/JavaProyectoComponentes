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
import entidades.Habitacione;
import entidades.Hotel;
import entidades.Reservacion;
import entidades.Servicio;
import entidades.Usuario;

/**
 * Servlet implementation class AgregarHotel
 */

public class AgregarHotel extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AgregarHotel() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nombreHotel = request.getParameter("Nombre");	
		String Ubicacion = request.getParameter("Ubicacion");	
	 	int idCadena = Integer.parseInt(request.getParameter("IdCadenaHotelera"));
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
    	hotel1.setNombre(nombreHotel);
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

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
