<%-- 
    Document   : MenuTrabajadores
    Created on : Mar 9, 2014, 1:26:00 PM
    Author     : Andrea

    recibe un parametro que es el id del trabajador y despliega sus datos
--%>
<jsp:include page="template.jsp" />
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Agregar Trabajador</title>
    </head>
    <body>

        <div class='container'>
            <form method="post">

                <table class="table">
                    <tbody>
                        <tr>
                            <td>
                                <h2>
                                    Agregar Trabajador
                                </h2>
                                <table class="table table-striped" style="width: 80%; margin-top: 5%;">
                                    <tbody>
                                        <tr>
                                            <td>
                                                <h4> <span class='glyphicon glyphicon-user'></span> Nombre:</h4>
                                            </td>
                                            <td>
                                                <input type="text" class="form-control" id="nombre" placeholder="Ingrese el Nombre" name="nombre">
                                            </td>
                                        </tr>
                                        <tr>
                                            <td>
                                                <h4> <span class='glyphicon glyphicon-glass'></span> Id:</h4>
                                            </td>
                                            <td>
                                                <input type="text" class="form-control" id="id" placeholder="Ingrese el Id" name="id">
                                            </td>
                                        </tr>
                                        <tr>
                                            <td>
                                                <h4> <span class='glyphicon glyphicon-usd'></span> Precio Por Hora:</h4>
                                            </td>
                                            <td>
                                                <input type="number" class="form-control" id="precioPorHora" placeholder="Ingrese el Precio Por Hora" name="precioPorHora">
                                            </td>
                                        </tr>

                                    </tbody>
                                </table>
                            </td>
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
                        </tr> 

                    </tbody>

                </table>
                 <p>                    
                    Tags del trabajador (Porfavor separarlos con una coma "," )
                    <textarea style="max-width: 100%; min-width: 100%" class="form-control" rows="4" name="tags">"Tags"</textarea>
                </p>
            </form>
            
        </div>
    </body>
</html>
