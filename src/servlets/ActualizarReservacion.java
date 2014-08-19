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
import comu.ServicioCliente;
import comu.ServicioHotel;
import comu.ServicioReservacion;
import entidades.Cadena_Hotelera;
import entidades.Cliente;
import entidades.Factura;
import entidades.Hotel;
import entidades.Reservacion;

/**
 * Servlet implementation class ActualizarReservacion
 */

public class ActualizarReservacion extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Logica logica = new Logica();  
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ActualizarReservacion() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String FechaSalida = request.getParameter("FechaSalida");	
		int idhotel = Integer.parseInt(request.getParameter("IdHotel"));
		int idcliente= Integer.parseInt(request.getParameter("IdCliente"));
		int idReservacion= Integer.parseInt(request.getParameter("IdReservacion"));
		String Fechallegada = request.getParameter("FechaLlegada");	
		
		PrintWriter out= response.getWriter();
	 	out.println("Reservacion Actualizada");
		logica.ActualizarReservacion(idhotel, idcliente, idReservacion, Fechallegada, FechaSalida);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
