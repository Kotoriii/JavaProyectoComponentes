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

import com.Conexion;
import entidades.Usuario;
import comu.ServicioEntidad;

/**
 *
 * @author CarlosJB
 */
@WebServlet(name = "ResultadoBusqueda", urlPatterns = {"/ResultadoBusqueda"})
public class ResultadoBusqueda extends HttpServlet {

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

        List<Usuario> empleados;
        List<Usuario> listkeywords = new ArrayList<Usuario>();

        Conexion con = Conexion.getInstancia();
        
        ServicioEntidad <Usuario> u = new ServicioEntidad<Usuario>() {
			private static final long serialVersionUID = 1L;
        };
        Usuario resultado = new Usuario();

        try {
            if (seleccion.equals("nombre")) {
            	resultado = u.busqueda(resultado, busqueda);
                request.getSession().setAttribute("empleado", resultado);
                response.sendRedirect("administracion.jsp");
            } else if (seleccion.equals("estado")) {
                empleados = u.busEstado(resultado, busqueda);
                request.getSession().setAttribute("empleados", empleados);
                response.sendRedirect("administracion.jsp");
            } else if (seleccion.equals("keyword")) {
                empleados = u.buscarTodos(resultado);
                for (Usuario e : empleados) {
                    if (e.comparaKeyword(busqueda)) {
                        listkeywords.add(e);
                    }
                }
                request.getSession().setAttribute("empleados", listkeywords);
                response.sendRedirect("administracion.jsp");
            } else if (seleccion.equals("id")) {
                resultado = u.buscar(resultado, new Integer(Integer.parseInt(busqueda)));
                request.getSession().setAttribute("empleado", resultado);
                response.sendRedirect("administracion.jsp");
            } else if (seleccion.equals("todos")) {
                empleados = u.buscarTodos(resultado);
                request.getSession().setAttribute("empleados", empleados);
                response.sendRedirect("administracion.jsp");
            } else if (seleccion.equals("tipobusqueda") || busqueda.equals("")) {
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
