/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entidades.Usuario;
import comu.ServicioUsuario;

/**
 *
 * @author CarlosJB
 */
@WebServlet(name = "ResultadoBusqueda", urlPatterns = {"/ResultadoBusqueda"})
public class ResultadoBusqueda extends HttpServlet {

	private static final long serialVersionUID = 1L;

	/**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        String busqueda = request.getParameter("busqueda");
        String seleccion = request.getParameter("seleccion");
        
        ServicioUsuario su = new ServicioUsuario() {
			private static final long serialVersionUID = 1L;
        };
        
        Usuario resultado;
        List<Usuario> empleados;
        List<Usuario> listkeywords = new ArrayList<Usuario>();

        try {
            if (seleccion.equals("nombre")) {
            	resultado = su.findNombre(busqueda);
            	su.closeEntityManager();
                request.getSession().setAttribute("empleado", resultado);
                response.sendRedirect("administracion.jsp");
            } else if (seleccion.equals("estado")) {
                empleados = su.findEstado(busqueda);
                su.closeEntityManager();
                request.getSession().setAttribute("empleados", empleados);
                response.sendRedirect("administracion.jsp");
            } else if (seleccion.equals("keyword")) {
                for (Usuario e : su.findTodos()) {
                    if (e.comparaKeyword(busqueda)) {
                        listkeywords.add(e);
                    }
                }
                su.closeEntityManager();
                request.getSession().setAttribute("empleados", listkeywords);
                response.sendRedirect("administracion.jsp");
            } else if (seleccion.equals("id")) {
                resultado = su.findPK(new Integer(Integer.parseInt(busqueda)));
                su.closeEntityManager();
                request.getSession().setAttribute("empleado", resultado);
                response.sendRedirect("administracion.jsp");
            } else if (seleccion.equals("todos")) {
                empleados = su.findTodos();
                su.closeEntityManager();
                request.getSession().setAttribute("empleados", empleados);
                response.sendRedirect("administracion.jsp");
            } else if (seleccion.equals("tipobusqueda") || busqueda.equals("")) {
                request.getSession().setAttribute("empleado", null);
                request.getSession().setAttribute("empleados", null);
                response.sendRedirect("administracion.jsp");
            } else {
                request.getSession().setAttribute("empleado", null);
                request.getSession().setAttribute("empleados", null);
                response.sendRedirect("administracion.jsp");
            } 
        } finally {
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
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
