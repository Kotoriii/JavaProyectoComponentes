<%-- 
    Document   : paginaP
    Created on : Apr 6, 2014, 7:46:14 PM
    Author     : Andrea
--%>

<%@page import="com.ControlHorarios"%>
<%@page import="java.sql.Time"%>
<%@page import="com.Usuario"%>
<%
    Usuario usuario = new Usuario();//se usa un constructor vacio para evitar nullPointerException
    if (request.getSession().getAttribute("usuario") == null) {
        response.sendRedirect("index.jsp");
    } else {
        usuario = (Usuario) request.getSession().getAttribute("usuario");
    }

%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<jsp:include page="template.jsp" />
<html>
    <head>
        <link href="style/main.css" rel="stylesheet" type="text/css">
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Bienvenido <%= usuario.getNombre()%></title>
    </head>
    <body>
        <div class="row">
            <div class="col-md-6">
                <%
                int tiempoConHoy = ControlHorarios.getInstancia().tiempoConectadoHoyMinutos(usuario);
                int horas = tiempoConHoy / 60;
                int minutos =  tiempoConHoy - (horas * 60);
                %>                
                <div class=" jumbotron" style="margin-top: 23%; border-radius: 10px;">
                    <h4>Usted lleva <%= horas %> horas y <%= minutos %> minutos de estar conectado</h3>
                        <h1>Bienvenido <%= usuario.getNombre()%>!</h1>    
                        <%                if (usuario.getRol().equals("admin")) {
                                out.println("<p><a href=\"administracion.jsp\"><button class=\"btn btn-primary btn-lg\">Administracion</button></a></p>");
                                 out.println("<p><a href=\"Planilla.jsp\"><button class=\"btn btn-primary btn-lg\">Planillas</button></a></p>");
                                
                            }%>
                            <p><a href="SolicitudPermisos.jsp"><button class="btn btn-success btn-lg">Pedir Permisos</button></a></p>
                            <p><a href="modificarContra.jsp"><button class="btn btn-success btn-lg">Cambiar Contraseña</button></a></p>
                                
                </div>
            </div>
            <div class="col-md-6">
                <div class="container" style="margin-top: 5%; width: 100%; margin-right: 100px">
                    <div class="heading">
                        <h1 class="title"><%= usuario.getNombre() %></h1>
                        <div class="scores-container" >
                            <div class="score-container" style="height: 5%">0</div>
                            <div class="best-container" style="height: 5%">0</div>
                        </div>
                    </div>

                    <div class="above-game">
                        <a class="restart-button">Empezar de Nuevo</a>
                    </div>

                    <div class="game-container">
                        <div class="game-message">
                            <p></p>
                            <div class="lower">
                                <a class="keep-playing-button">Seguir</a>
                                <a class="retry-button">Volver a Empezar</a>
                            </div>
                        </div>

                        <div class="grid-container">
                            <div class="grid-row">
                                <div class="grid-cell"></div>
                                <div class="grid-cell"></div>
                                <div class="grid-cell"></div>
                                <div class="grid-cell"></div>
                            </div>
                            <div class="grid-row">
                                <div class="grid-cell"></div>
                                <div class="grid-cell"></div>
                                <div class="grid-cell"></div>
                                <div class="grid-cell"></div>
                            </div>
                            <div class="grid-row">
                                <div class="grid-cell"></div>
                                <div class="grid-cell"></div>
                                <div class="grid-cell"></div>
                                <div class="grid-cell"></div>
                            </div>
                            <div class="grid-row">
                                <div class="grid-cell"></div>
                                <div class="grid-cell"></div>
                                <div class="grid-cell"></div>
                                <div class="grid-cell"></div>
                            </div>
                        </div>

                        <div class="tile-container">

                        </div>
                    </div>


                </div>
            </div>
        </div>
        <script src="js/bind_polyfill.js"></script>
        <script src="js/classlist_polyfill.js"></script>
        <script src="js/animframe_polyfill.js"></script>
        <script src="js/keyboard_input_manager.js"></script>
        <script src="js/html_actuator.js"></script>
        <script src="js/grid.js"></script>
        <script src="js/tile.js"></script>
        <script src="js/local_storage_manager.js"></script>
        <script src="js/game_manager.js"></script>
        <script src="js/application.js"></script>
         
        <script> 
            frases.push('Much game');      
            frases.push('Such points');      
        </script>
    </body>
</html>
