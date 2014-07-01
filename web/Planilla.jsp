<%-- 
    Document   : Planilla.jsp
    Created on : Mar 15, 2014, 07:53:19 PM
    Author     : Soda de Limon
--%>
<%@page import="com.ControlHorarios"%>
<%@page import="com.Conexion"%>
<%@page import="java.util.List"%>
<%@page import="com.Usuario"%>
<jsp:include page="template.jsp" />
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%
    Usuario usuario = new Usuario();//se usa un constructor vacio para evitar nullPointerException
    if (request.getSession().getAttribute("usuario") == null) {
        response.sendRedirect("index.jsp");
    } else {
        usuario = (Usuario) request.getSession().getAttribute("usuario");
    }
    
    if(!usuario.getRol().equalsIgnoreCase("admin")){
        response.sendRedirect("paginaP.jsp");
    }
    
    Conexion con = Conexion.getInstancia();
    List<Usuario> empleados = con.mostrarEmpleados();
    
    empleados.remove(usuario); // la lista de usaurios menos el usuario actual

    ControlHorarios ch = ControlHorarios.getInstancia();
%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Panilla de Empresa</title>
    </head>
    <body>
        <div class='container'>
            <form method="post">
                <table class="table">
                    <tbody>
                        <tr>
                            <td>
                                <h2>
                                    Planilla
                                </h2>
                                <table class="table table-condensed" style="width: 80%; margin-top: 5%;">
                                    <tbody>
                                    <thead>
                                        <tr>
                                            
                                        </tr>
                                    </thead>
                            
                                    
                                     <tr>
                                       
                                    </tr>
                                                                    
                    </tbody>
                </table>
                </td>

                </tr> 

                </tbody>

                </table>
                <td>
                    <div class="jumbotron " style="width: 100%; margin-top: 25%">
                        <p>
                            <button type="button" class="btn btn-primary btn-lg">Such Confirm</button>
                        </p>
                    </div>

                </td>
            </form>

        </div>
    </body>
</html>