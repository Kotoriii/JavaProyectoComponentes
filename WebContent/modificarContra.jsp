<%-- 
    Document   : modificarContra
    Created on : Apr 22, 2014, 10:54:10 AM
    Author     : Andrea
--%>
<jsp:include page="template.jsp"></jsp:include>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cambiar Contraseña</title>
    </head>
    <body>
        <%
            if (request.getSession().getAttribute("usuario") == null) {
                response.sendRedirect("index.jsp");
            }
            String mens = "";
            if (request.getParameter("mens") != null) {
                String mes = request.getParameter("mens");

                if ("inco1".equals(mes)) {
                    mens = "La vieja contraseña no es correcta";
                } else if ("inco2".equals(mes)) {
                    mens = "Las contraseñas no son iguales";
                } else if ("inco3".equals(mes)) {
                    mens = "Hubo un problema al cambiar la contraseña \n por favor reintentarlo más tarde";
                }
            }
        %>
        <form action="modificarContra">
            <div class="container jumbotron" style="border-radius: 10px;">
                <h2><%= mens %></h2>
                <h4> Vieja Contraseña</h4>
                <input type="password" class="form-control" name="contraV" style="width:50%" />
                <br />
                <h4> Nueva Contraseña </h4>
                <input type="password" class="form-control" name="contraN1" style="width:50%" />
                <br/> 
                <h4> Repetir Nueva Contraseña </h4>
                <input type="password" class="form-control" name="contraN2" style="width:50%" />
                <button type="submit" class="btn btn-success btn-lg" >Cambiar contraseña</button>
            </div>
        </form>        
        <a href="index.jsp" class="btn btn-primary btn-lg">Cancelar</a>

    </body>
</html>
