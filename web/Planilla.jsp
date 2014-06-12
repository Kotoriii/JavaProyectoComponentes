<%-- 
    Document   : Planilla.jsp
    Created on : Mar 15, 2014, 07:53:19 PM
    Author     : Deiver Kiel
    Descripcion: Presenta la lista de empleados y los campos para asignar valores de planilla
--%>
<%@page import="com.Conexion"%>
<%@page import="java.util.List"%>
<%@page import="com.Usuario"%>
<jsp:include page="template.jsp" />
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%
    String nombre = (request.getParameter("nombre")) == null ? "" : request.getParameter("nombre");
    String id = (request.getParameter("id")) == null ? "" : request.getParameter("id");

    List<Usuario> empleados = (List<Usuario>) session.getAttribute("empleados");
    Usuario empleado = (Usuario) session.getAttribute("empleado");


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
                                    Datos para Pagos
                                </h2>
                                <table class="table table-condensed" style="width: 80%; margin-top: 5%;">
                                    <tbody>
                                    <thead>
                                        <tr>
                                            <th>#</th>
                                            <th>Nombre</th>
                                            <th>ID</th>
                                            <th>Base</th>                                         
                                            <th>Bono</th> 
                                            <th>Viaticos</th> 
                                            <th>Extras</th>
                                            <th>Ahorro</th> 
                                            <th>CCSS</th> 
                                            <th>Prestamos</th> 
                                            <th>Seguro</th> 
                                        </tr>
                                    </thead>
                                    <% 
    int pos = 0;
                                    for (Usuario u : Conexion.getInstancia().mostrarEmpleados()) {
                                        pos++;
                                    %> 
                                    
                                     <tr>
                                        <td><%= pos %></td>
                                        <td></td>
                                        <td><%= u.getId() %></td>
                                        <td>
                                            <input type="number" class="form-control" id="salarioBase" placeholder="Salario base" value="<%= u.getSalario() %>" name="SalarioBase">
                                        </td>
                                        <td>
                                            <input type="number" class="form-control" id="bono"  placeholder="Bono" name="Bono">
                                        </td>
                                        <td>
                                            <input type="number" class="form-control" id="viaticos"  placeholder="Viaticos" name="Viaticos">
                                        </td>
                                        <td>
                                            <input type="number" class="form-control" id="extras" placeholder="Extras" name="Extras">
                                        </td>
                                        <td>
                                            <input type="number" class="form-control" id="ahorro" placeholder="Ahorro" name="Ahorro">
                                        </td>
                                        <td>
                                            <input type="number" class="form-control" id="ccss" placeholder="CCSS" name="CCSS">
                                        </td>
                                        <td>
                                            <input type="number" class="form-control" id="prestamo" placeholder="Prestamos" name="Prestamos">
                                        </td>
                                        <td>
                                            <input type="number" class="form-control" id="seguro" placeholder="Seguro" name="Seguro">
                                        </td>
                                    </tr>
                                    
                                    <% }
                                    %>

                                   
                    </tbody>
                </table>
                </td>

                </tr> 

                </tbody>

                </table>
                <td>
                    <div class="jumbotron " style="width: 100%; margin-top: 25%">
                        <p>
                            <button type="button" class="btn btn-primary btn-lg">Aceptar</button>
                        </p>
                        <p>
                            <button type="button" class="btn btn-primary btn-lg">Cancelar</button>
                        </p>
                    </div>

                </td>
            </form>

        </div>
    </body>
</html>