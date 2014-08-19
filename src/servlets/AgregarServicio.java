package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import LogicaHotel.Logica;
import comu.ServicioCadena_Hotelera;
import comu.ServicioHotel;
import comu.ServicioServicio;
import entidades.Cadena_Hotelera;
import entidades.Cliente;
import entidades.Hotel;
import entidades.Servicio;

/**
 * Servlet implementation class AgregarServicio
 */

public class AgregarServicio extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Logica logica = new Logica();  
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AgregarServicio() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out= response.getWriter();
	 	out.println("Servicio Agregado");
	 	
	 	String Descripcion = request.getParameter("Descripcion");	
		int idhotel = Integer.parseInt(request.getParameter("IdHotel"));
		int idcliente= Integer.parseInt(request.getParameter("IdCliente"));
		int costo= Integer.parseInt(request.getParameter("Costo"));
		
		logica.CrearServicio(idhotel, idcliente, Descripcion, costo);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
