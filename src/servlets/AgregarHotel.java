package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import LogicaHotel.Logica;
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
	Logica logica = new Logica();  
       
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
	 	PrintWriter out= response.getWriter();
		out.println("Hotel Agregado");
	 	logica.InsertarHotelACadena(idCadena, nombreHotel, Ubicacion);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
