/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.Conexion;
import com.ControlHorarios;
import com.ObservadorUsuario;
import com.Usuario;

/**
 *
 * @author Andrea
 */
public class LoginB extends HttpServlet {

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
        try {
            String id = request.getParameter("inptId");
            String contra = request.getParameter("inptContra");
            Conexion con = Conexion.getInstancia();

            Usuario usuario = con.buscarXId(id);

            int cnt = 0;
            //se fija que el usuairo no ha iniciado sesion en el dia y
            //se fija que el usuario exista y que la contrasenna
            //sea correcta
            if (usuario == null) {
                cnt = 1;
            } else if (!usuario.getContrasenna().equals(contra)) {
                cnt = 2;
            } else if (ControlHorarios.getInstancia().cerroSesionXelDia(usuario)) {
                cnt = 3;
            } else if (usuario.getEstado().equals("Inactivo")) {
                cnt = 4;
            } 

            if (cnt == 0) {

                request.getSession().setMaxInactiveInterval(0);
                request.getSession().setAttribute("usuario", usuario);
                ControlHorarios.getInstancia().iniciarSesionXelDia(usuario);
                usuario.registerObserver(ObservadorUsuario.getInstancia());
                usuario.notifyObservers();

                response.sendRedirect("paginaP.jsp");

            } else {
                response.sendRedirect("index.jsp?cnt=" + cnt + "");
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
