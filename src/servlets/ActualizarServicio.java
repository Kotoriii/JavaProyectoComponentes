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
 * Servlet implementation class ActualizarServicio
 */

public class ActualizarServicio extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Logica logica = new Logica();  
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ActualizarServicio() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out= response.getWriter();
	 	out.println("Servicio Actualizado");
	 	
	 	String Descripcion = request.getParameter("Descripcion");	
	 	int idServicio = Integer.parseInt(request.getParameter("IdServicio"));
		int idHotel = Integer.parseInt(request.getParameter("IdHotel"));
		int idCliente= Integer.parseInt(request.getParameter("IdCliente"));
		int costo= Integer.parseInt(request.getParameter("Costo"));
		
		logica.ActualizarServicio(idHotel, idCliente, idServicio, Descripcion, costo);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
