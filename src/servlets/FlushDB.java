/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Conexion;

import comu.ServicioEntidad;
import comu.Servicio_ControlHorario;
import comu.Servicio_Hora;
import comu.Servicio_ShiftReport;
import entidades.Controlhorario;
import entidades.Hora;
import entidades.Shiftreport;

/**
 * 
 * @author Andrea
 */
public class FlushDB extends HttpServlet {

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
		try {

			Servicio_ControlHorario swer = new Servicio_ControlHorario();
			List<Controlhorario> listCH = swer.buscarTodosCH();

			Servicio_Hora svh = new Servicio_Hora();
			List<Hora> listH = svh.buscarTodos(new Hora());

			Servicio_ShiftReport sshr = new Servicio_ShiftReport();
			List<Shiftreport> listSHR = sshr.buscarTodos(new Shiftreport());

			for (Controlhorario ch : listCH) {
				if (ch.equals(null)) {
					swer.eliminar(ch);
				}
			}
			swer.closeEntityManager();
			for (Hora h : listH) {
				if (h.equals(null)) {
					svh.eliminar(h);
				}
			}
			svh.closeEntityManager();
			for (Shiftreport sr : listSHR) {
				if (sr.equals(null)) {
					sshr.eliminar(sr);
				}
			}
			sshr.closeEntityManager();

			response.sendRedirect("index.jsp");

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
