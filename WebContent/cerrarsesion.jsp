<%-- 
    Document   : cerrarsesion
    Created on : Apr 8, 2014, 3:38:40 PM
    Author     : Andrea
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="template.jsp" />
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cerrar Sesion</title>
    </head>
    <body>
        <div class="jumbotron container"> 
            <h1>Shift Report!</h1> 
            <form method="post" action="Logout">
                <textarea class="form-control" rows="5" placeholder="such report" name="txtReport"></textarea>
                <button type="submit" class="btn btn-primary btn-lg" > Enviar Reporte y cerrar sesion </button>
            </form>
        </div>
    </body>
</html>
