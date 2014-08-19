package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import comu.ServicioCliente;
import entidades.Cliente;
import entidades.Reservacion;
import entidades.Servicio;

/**
 * Servlet implementation class AgregarCliente
 */

public class AgregarCliente extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AgregarCliente() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String Nombre = request.getParameter("Nombre");	
		String cedula = request.getParameter("Cedula");
		String telefono = request.getParameter("Telefono");
	 	
		
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

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
