<%@page import="entidades.Usuario"%>
<jsp:include page="template.jsp" />

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head>
        <%--
            Usuario usuario = new Usuario();//se usa un constructor vacio para evitar nullPointerException
            if (request.getSession().getAttribute("usuario") == null) {
                response.sendRedirect("index.jsp");
            } else {
                usuario = (Usuario) request.getSession().getAttribute("usuario");
            }

        --%> 
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Página de Reportes</title>
    </head>
    <body>

        <form action="GeneradorReportes" method="post" class="form-inline">
            <div class='container jumbotron' style="border-radius: 10px">
                <h2 style="margin-left:35%; margin-top:2%; margin-bottom: 2%">Generación de Reportes</h2>
                <div class="row" style="margin-left:40%">
                <input type="submit" name="empleadosactivos" value="Listado de Empleados Activos" style="margin-top:2%" class="btn btn-primary"/></br>
                <input type="submit" name="salarios" value="Reporte de Salarios de Empleados" style="margin-top:2%" class="btn btn-primary"/></br>
                <input type="submit" name="empleadosroles" value="Gráfico de Roles en el Hotel" style="margin-top:2%" class="btn btn-primary"/></br>
                <input type="submit" name="hotelescadena" value="Listado de Hoteles por Cadena" style="margin-top:2%" class="btn btn-primary"/></br>
                <input type="submit" name="hotelespais" value="Gráfico de Hoteles por País" style="margin-top:2%" class="btn btn-primary"/>
                </div>
                </div>
                </form>
        <script>
            frases.push("such permit");
            frases.push("much vacations");
            frases.push("so procrastinate");   //jaja
        </script>
    </body>
</html>