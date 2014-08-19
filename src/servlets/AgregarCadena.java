package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import comu.ServicioCadena_Hotelera;
import entidades.Cadena_Hotelera;
import entidades.Hotel;
import LogicaHotel.Logica;
/**
 * Servlet implementation class AgregarHotel
 */

public class AgregarCadena extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ServicioCadena_Hotelera SCH = new ServicioCadena_Hotelera();
	Logica logica = new Logica(); 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AgregarCadena() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out= response.getWriter();
		out.println("Hola agregar hotel");
		String nombreCadena = request.getParameter("Nombre");	
	 	int idCadena = Integer.parseInt(request.getParameter("IdCadena"));
	 	
		ServicioCadena_Hotelera SCH = new ServicioCadena_Hotelera(); //Instanciacion del Servicio
		SCH.startEntityManager();
		Cadena_Hotelera CH = new Cadena_Hotelera();//asignacion de un nuevo espacio en memoria
    	CH.setIdCadena_Hotelera(SCH.siguienteId());
    	CH.setNombre(nombreCadena);
    	CH.setHotels(new ArrayList<Hotel>());
    	SCH.insertar(CH);	
    	SCH.closeEntityManager();
	}

	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
