package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import LogicaHotel.Logica;

/**
 * Servlet implementation class ActualizarServicioExtra
 */

public class ActualizarServicioExtra extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Logica logica = new Logica();  
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ActualizarServicioExtra() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out= response.getWriter();
	 	out.println("ServicioExtra Actualizado");
	 	
	 	String descripcion = request.getParameter("Descripcion");	
		int idhotel = Integer.parseInt(request.getParameter("IdHotel"));
		int idhabitacion= Integer.parseInt(request.getParameter("IdHabitacion"));
		int costo= Integer.parseInt(request.getParameter("Costo"));
		int idse= Integer.parseInt(request.getParameter("IdServicioExtra"));
		logica.ActualizarServicioExtra(idhotel, idhabitacion, descripcion, costo, idse);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
