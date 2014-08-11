/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
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

import entidades.Usuario;
import comu.ServicioUsuario;

/**
 *
 * @author CarlosJB
 */
@WebServlet(name = "NuevoEmpleado", urlPatterns = {"/NuevoEmpleado"})
public class NuevoOModificarEmpleado extends HttpServlet {

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
        
        String nombre = request.getParameter("nombre");
        String id = request.getParameter("id");
        String puesto = request.getParameter("puesto");
        String salario = request.getParameter("salario");
        String pagoHora = request.getParameter("pagoHora");
        String horaEntrada = request.getParameter("horaEntrada");
        String horaSalida = request.getParameter("horaSalida");
        String email = request.getParameter("email");
        String keywords = request.getParameter("keywords");
        String estado = request.getParameter("estado");
        
        String annadir = request.getParameter("annadir");
        String modificar = request.getParameter("modificar");
        String cambiarEstado = request.getParameter("cambiarEstado");
        
        ServicioUsuario su = new ServicioUsuario() {
			private static final long serialVersionUID = 1L;
        };
        
        Usuario emp = new Usuario();
        emp.setNombre(nombre);
        emp.setContrasenna(nombre);
        emp.setId(Integer.parseInt(id));
        emp.setIdHotel(1);
        emp.setRol(puesto);
        emp.setSalario(Integer.parseInt(salario));
        emp.setPrecioPorHora(Integer.parseInt(pagoHora));
        emp.setHoraEntrada(horaEntrada);
        emp.setHoraSalida(horaSalida);
        emp.setCorreo(email);
        emp.setKeywords(keywords);
        emp.setEstado(estado);
                
        try {
            if ("Modificar Empleado".equals(modificar)){
            	su.actualizar(emp);
            	su.closeEntityManager();
                request.getSession().setAttribute("empleado", null);
                request.getSession().setAttribute("empleados", null);
                response.sendRedirect("administracion.jsp");
            } else if ("Estado Empleado".equals(cambiarEstado)) {
            	Usuario usuario = su.findPK(new Integer(Integer.parseInt(id)));
                usuario.cambiarEstado(estado);
                su.actualizar(usuario);
                su.closeEntityManager();
                request.getSession().setAttribute("empleado", null);
                request.getSession().setAttribute("empleados", null);
                response.sendRedirect("administracion.jsp");
            } else if ("Ingresar Empleado".equals(annadir)) {
            	su.insertar(emp);
            	su.closeEntityManager();
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
