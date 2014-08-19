package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import comu.ServicioCadena_Hotelera;
import entidades.Cadena_Hotelera;

/**
 * Servlet implementation class ActualizarCadena
 */

public class ActualizarCadena extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ActualizarCadena() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nombreCadena = request.getParameter("Nombre");	
	 	int idCadena = Integer.parseInt(request.getParameter("IdCadena"));
		ServicioCadena_Hotelera SCH = new ServicioCadena_Hotelera(); //Instanciacion del Servicio
		SCH.startEntityManager();
		Cadena_Hotelera CH = new Cadena_Hotelera();//asignacion de un nuevo espacio en memoria
		CH = SCH.buscar(idCadena);
    	if(CH!= null)
    	{
    	CH.setIdCadena_Hotelera(idCadena);
    	CH.setNombre(nombreCadena);
    	CH.setHotels(CH.getHotels());
    	SCH.actualizar(CH);	
    	SCH.closeEntityManager();
    	}else
    	{
    		System.out.print("Cadena no existe");
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
