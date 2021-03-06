/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import comu.ServicioPermiso;
import entidades.Permiso;
import entidades.PermisoPK;
import entidades.Usuario;

/**
 * 
 * @author laboratorio
 */
@WebServlet(name = "SolicitarPermiso", urlPatterns = { "/SolicitarPermiso" })
public class SolicitarPermiso extends HttpServlet {

	/**
	 * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
	 * methods.
	 * 
	 * @param request
	 *            servlet request
	 * @param response
	 *            servlet response
	 * @throws ServletException
	 *             if a servlet-specific error occurs
	 * @throws IOException
	 *             if an I/O error occurs
	 */
	protected void processRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();

		if(request.getSession().getAttribute("usuario").equals(null)){
			response.sendRedirect("paginaP.jsp");
		}
		Usuario usuario = (Usuario)request.getSession().getAttribute("usuario");
		int id = usuario.getId();
		String permiso = request.getParameter("motivo");
		String fechainicio = request.getParameter("fechainicio");
		String fechafinal = request.getParameter("fechafinal");

		try {
			ServicioPermiso sp = new ServicioPermiso();
			PermisoPK perPK = new PermisoPK();
			perPK.setIdUsuario(id);
			perPK.setDesdeFecha(fechainicio);
			Permiso per = new Permiso();
			per.setHastaFecha(fechafinal);
			per.setEstado((byte) 0);
			per.setTipo(permiso);
			per.setId(perPK);
			sp.insertar(per);
			sp.closeEntityManager();
			request.getSession().setAttribute("permiso", "yes");
			response.sendRedirect("SolicitudPermisos.jsp");
		} finally {
			out.close();
		}
	}

	// <editor-fold defaultstate="collapsed"
	// desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
	/**
	 * Handles the HTTP <code>GET</code> method.
	 * 
	 * @param request
	 *            servlet request
	 * @param response
	 *            servlet response
	 * @throws ServletException
	 *             if a servlet-specific error occurs
	 * @throws IOException
	 *             if an I/O error occurs
	 */
	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	/**
	 * Handles the HTTP <code>POST</code> method.
	 * 
	 * @param request
	 *            servlet request
	 * @param response
	 *            servlet response
	 * @throws ServletException
	 *             if a servlet-specific error occurs
	 * @throws IOException
	 *             if an I/O error occurs
	 */
	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	/**
	 * Returns a short description of the servlet.
	 * 
	 * @return a String containing servlet description
	 */
	@Override
	public String getServletInfo() {
		return "Short description";
	}// </editor-fold>
}
