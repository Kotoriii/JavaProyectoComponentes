package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import comu.ServicioCliente;

import entidades.Cliente;

/**
 * Servlet implementation class ActualizarCliente
 */

public class ActualizarCliente extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ActualizarCliente() {
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
	 	int idCliente = Integer.parseInt(request.getParameter("IdCliente"));
	 	
		ServicioCliente SC = new ServicioCliente();
    	Cliente clientenuevo = new Cliente();
    	SC.startEntityManager();
    	clientenuevo = SC.buscar(idCliente);
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
    
    	} else{
    		SC.closeEntityManager();
    	}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
