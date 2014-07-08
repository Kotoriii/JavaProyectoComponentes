<%-- 
    Document   : administracion
    Created on : Apr 11, 2014, 10:38:13 AM
    Author     : CarlosJB
--%>
<%@page import="java.util.List"%>
<%@page import="com.Usuario"%>
<jsp:include page="template.jsp" />
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%
    String nombre = (request.getParameter("nombre")) == null ? "" : request.getParameter("nombre");
    String id = (request.getParameter("id")) == null ? "" : request.getParameter("id");
    String puesto = (request.getParameter("puesto")) == null ? "" : request.getParameter("puesto");
    String salario = (request.getParameter("salario")) == null ? "" : request.getParameter("salario");
    String pagoHora = (request.getParameter("pagoHora")) == null ? "" : request.getParameter("pagoHora");
    String horaEntrada = (request.getParameter("horaEntrada")) == null ? "" : request.getParameter("horaEntrada");
    String horaSalida = (request.getParameter("horaSalida")) == null ? "" : request.getParameter("horaSalida");
    String email = (request.getParameter("email")) == null ? "" : request.getParameter("email");
    String keywords = (request.getParameter("keywords")) == null ? "" : request.getParameter("keywords");
    String estado = (request.getParameter("estado")) == null ? "" : request.getParameter("estado");
    
    List<Usuario> empleados = (List<Usuario>) session.getAttribute("empleados");
    Usuario empleado = (Usuario) session.getAttribute("empleado");
    String busqueda = "";
    if (empleados == null & empleado == null){
        busqueda = "<tr>" + "<td><h4>" + "Busqueda..." + "</h4></td>" + "<tr>";
    } else if (empleados != null){
        for (Usuario e : empleados){
            busqueda += e.toString();
        }
    } else if (empleado != null){
        busqueda = empleado.toString();
    }
%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Administracion</title>
    </head>
    <body>
        <div class='container'>

            <div class="panel-group" id="accordion">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <h4 class="panel-title">
                            <a data-toggle="collapse" data-parent="#accordion" href="#collapseOne">
                                Ingresar Nuevo Empleado / Modificar Empleado
                            </a>
                        </h4>
                    </div>
                    <div id="collapseOne" class="panel-collapse collapse in">
                        <div class="panel-body">
                            <form action="NuevoEmpleado" method="post">

                                <div class="row">

                                    <div class="col-md-8">
                                        <ul class="list-group">

                                            <ul class="list-group-item">
                                                <div class="row">
                                                    <div class="col-md-4">
                                                        <h4> <span class='glyphicon glyphicon-user'></span> Nombre:</h4>
                                                    </div>
                                                    <div class="col-md-8">
                                                        <input type="text" class="form-control" id="nombre" placeholder="Ingrese el Nombre" name="nombre" value="<%= nombre%>"/>
                                                    </div>
                                                </div>
                                            </ul>

                                            <ul class="list-group-item">
                                                <div class="row">
                                                    <div class="col-md-4">
                                                        <h4> <span class='glyphicon glyphicon-glass'></span> ID:</h4>
                                                    </div>
                                                    <div class="col-md-8">
                                                        <input type="text" class="form-control" id="id" placeholder="Ingrese el ID" name="id" value="<%= id%>"/>
                                                    </div>
                                                </div>
                                            </ul>

                                            <ul class="list-group-item">
                                                <div class="row">
                                                    <div class="col-md-4">
                                                        <h4> <span class='glyphicon glyphicon-bullhorn'></span> Puesto:</h4>
                                                    </div>
                                                    <div class="col-md-8">
                                                        <input type="text" class="form-control" id="puesto" placeholder="Ingrese el Puesto" name="puesto" value="<%= puesto%>"/>
                                                    </div>
                                                </div>
                                            </ul>

                                            <ul class="list-group-item">
                                                <div class="row">
                                                    <div class="col-md-4">
                                                        <h4> <span class='glyphicon glyphicon-usd'></span> Salario Mensual:</h4>
                                                    </div>
                                                    <div class="col-md-8">
                                                        <input type="text" class="form-control" id="salario" placeholder="Ingrese el Salario" name="salario" value="<%= salario%>"/>
                                                    </div>
                                                </div>
                                            </ul>

                                            <ul class="list-group-item">
                                                <div class="row">
                                                    <div class="col-md-4">
                                                        <h4> <span class='glyphicon glyphicon-usd'></span> Pago Por Hora:</h4>
                                                    </div>
                                                    <div class="col-md-8">
                                                        <input type="text" class="form-control" id="pagoHora" placeholder="Ingrese el Monto por Hora" name="pagoHora" value="<%= pagoHora%>"/>
                                                    </div>
                                                </div>
                                            </ul>

                                            <ul class="list-group-item">
                                                <div class="row">
                                                    <div class="col-md-4">
                                                        <h4> <span class='glyphicon glyphicon-time'></span> Hora Entrada:</h4>
                                                    </div>
                                                    <div class="col-md-8">
                                                        <input type="text" class="form-control" id="horaEntrada" placeholder="Ingrese la hora con el formato HH:MM:SS" name="horaEntrada" value="<%= horaEntrada%>"/>
                                                    </div>
                                                </div>
                                            </ul>

                                            <ul class="list-group-item">
                                                <div class="row">
                                                    <div class="col-md-4">
                                                        <h4> <span class='glyphicon glyphicon-time'></span> Hora Salida:</h4>
                                                    </div>
                                                    <div class="col-md-8">
                                                        <input type="text" class="form-control" id="horaSalida" placeholder="Ingrese la hora con el formato HH:MM:SS" name="horaSalida" value="<%= horaSalida%>"/>
                                                    </div>
                                                </div>
                                            </ul>

                                            <ul class="list-group-item">
                                                <div class="row">
                                                    <div class="col-md-4">
                                                        <h4> <span class='glyphicon glyphicon-envelope'></span> Email:</h4>
                                                    </div>
                                                    <div class="col-md-8">
                                                        <input type="text" class="form-control" id="email" placeholder="Ingrese el email" name="email" value="<%= email%>"/>
                                                    </div>
                                                </div>
                                            </ul>

                                            <ul class="list-group-item">
                                                <div class="row">
                                                    <div class="col-md-4">
                                                        <h4> <span class='glyphicon glyphicon-text-width'></span> Keywords:</h4>
                                                    </div>
                                                    <div class="col-md-8">
                                                        <input type="text" class="form-control" id="keywords" placeholder="Ingrese keyworks separandolas por medio de una coma ',' " name="keywords" value="<%= keywords%>"/>
                                                    </div>
                                                </div>
                                            </ul>

                                            <ul class="list-group-item">
                                                <div class="row">
                                                    <div class="col-md-4">
                                                        <h4> <span class='glyphicon glyphicon-eye-close'></span> Estado:</h4>
                                                    </div>
                                                    <div class="col-md-8">
                                                        <input type="text" class="form-control" id="estado" placeholder="Estado del empleado" name="estado" value="<%= estado%>"/>
                                                    </div>
                                                </div>
                                            </ul>

                                        </ul>
                                    </div>

                                    <div class="col-md-4">
                                        <div class="list-group">
                                            <ul class="list-group-item">
                                                <div class="jumbotron " style="width: 100%; margin-top: 5%; margin-bottom: 5%">
                                                    <input type="submit" name="annadir" id="annadir" value="Ingresar Empleado" class="btn btn-primary btn-lg"/>
                                                </div>
                                            </ul>

                                            <ul class="list-group-item">
                                                <div class="jumbotron " style="width: 100%; margin-top: 5%; margin-bottom: 5%">
                                                    <input type="submit" name="modificar" id="modificar" value="Modificar Empleado" class="btn btn-primary btn-lg"/>
                                                </div>
                                            </ul>

                                            <ul class="list-group-item">
                                                <div class="jumbotron " style="width: 100%; margin-top: 5%; margin-bottom: 5%">
                                                    <input type="submit" name="cambiarEstado" id="cambiarEstado" value="Cambiar Estado" class="btn btn-primary btn-lg"/>
                                                </div>
                                            </ul>
                                        </div>
                                    </div>

                                </div>

                            </form>
                        </div>
                    </div>
                </div>

                <div class="panel panel-default">
                    <div class="panel-heading">
                        <h4 class="panel-title">
                            <a data-toggle="collapse" data-parent="#accordion" href="#collapseThree">
                                Ver Empleados
                            </a>
                        </h4>
                    </div>
                    <div id="collapseThree" class="panel-collapse collapse in">
                        <div class="panel-body">
                            <form action="ResultadoBusqueda" method="post">

                                <div class="row">

                                    <div class="col-md-8">
                                        <div class="list-group">
                                            <ul class="list-group-item">
                                                <div class="row">
                                                    <div class="col-md-7">
                                                        <input type="text" class="form-control" id="busqueda" placeholder="Busqueda" name="busqueda" value=""/>
                                                    </div>
                                                    <div class="col-md-5">
                                                        <select class="form-control" name="seleccion">
                                                            <option value="tipobusqueda">Tipo Busqueda</option>
                                                            <option value="todos">Ver Todos</option>
                                                            <option value="nombre">Nombre</option>
                                                            <option value="id">ID</option>
                                                            <option value="keyword">Keyword</option>
                                                            <option value="estado">Estado</option>
                                                        </select>
                                                    </div>
                                                </div>
                                            </ul>
                                        </div>
                                    </div>

                                    <div class="col-md-4">
                                        <div class="list-group">
                                            <ul class="list-group-item">
                                                <div class="jumbotron " style="width: 100%; margin-top: 5%; margin-bottom: 5%">
                                                    <input type="submit" name="buscar" id="buscar" value="Ejecutar Busqueda" class="btn btn-primary btn-lg"/>
                                                </div>
                                            </ul>
                                        </div>
                                    </div>

                                </div>

                            </form>
                        </div>
                    </div>
                </div>

            </div>

            <table class="table table-striped">

                <tr>
                    <td><h4> <span class='glyphicon glyphicon-glass'></span> ID</h4></td>
                    <td><h4> <span class='glyphicon glyphicon-user'></span> Empleado</h4></td>
                    <td><h4> <span class='glyphicon glyphicon-bullhorn'></span> Puesto</h4></td>
                    <td><h4> <span class='glyphicon glyphicon-usd'></span> Salario</h4></td>
                    <td><h4> <span class='glyphicon glyphicon-eye-close'></span> Estado</h4></td>
                    <td><h4> <span class='glyphicon glyphicon-pencil'></span> Modificar</h4></td>
                </tr>
                <%= busqueda %>

            </table>

        </div>
                <div style="position: fixed; top: 95%;left: 0%">
                    <a href="paginaP.jsp" class="btn btn-primary btn-lg">Volver a la pagina principal</a>                    
                </div>

    </body>
</html>
