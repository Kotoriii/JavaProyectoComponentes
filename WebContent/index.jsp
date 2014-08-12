<%-- 
    Document   : newjsp
    Created on : Mar 9, 2014, 1:02:45 PM
    Author     : Andrea
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@include file="template.jsp"%>
<!DOCTYPE html>
<html>
<head>

<%

	if (request.getSession().getAttribute("usuario") != null) {
		response.sendRedirect("paginaP.jsp");
	}
	String mens = "";
	if (request.getSession().getAttribute("errr") != null) {
		switch ((Integer)request.getSession().getAttribute("errr")) {
			case 1 : {
				mens = "El usuario no existe";
				break;
			}
			case 2 : {
				mens = "La contraseña es incorrecta";
				break;
			}
			case 3 : {
				mens = "El usuario ya ha cerrado sesion el dia de hoy";
				break;
			}
			case 4 : {
				response.sendRedirect("despedido");
				break;
			}
			default : {
				mens = "";
			}
		}
		request.getSession().setAttribute("errr", null);
	}
%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Inicio</title>
</head>
<body>

	<div class="jumbotron"
		style="width: 50%; margin-left: auto; margin-right: auto; opacity: 0.96; border-radius: 10px">

		<div style="color: red">
			<html:errors />
			<ul><%= mens %></ul>
		</div>
		<html:form action="/Login">
			<p>ID De Usuario</p>
			<html:text name="LoginForm" property="userName" />
			<br>
			<p>Contraseña</p>
			<html:password name="LoginForm" property="password" />
			<br>
			<html:submit value="Login" />
		</html:form>

	</div>


	<!-- para eliminar todos los contenidos de "controldehorarios",
        horas y shiftreports -->
	<div
		style="width: 200px; border-style: solid; border-bottom-color: #000; padding: 20px; position: absolute; top: 300px; right: 100px">
		<form method='post' action="FlushDB">
			<p>Solo por el momento, para no tener que estar borrando cosas
				directamente desde la base de datos o simulando un cierre forzado de
				sesion</p>
			<button type='submit'>flush DB</button>
		</form>
		<form method="post" action="EliminarSesion">
			<button type='submit'>Eliminar Sesion</button>
		</form>
	</div>

	<iframe tabindex="-1"
		style="width: 1px; height: 1px; position: absolute; top: -100px;"
		src="https://accounts.google.com/o/oauth2/postmessageRelay?parent=http%3A%2F%2Fwww.coinwarz.com#rpctoken=463841963&amp;forcesecure=1"
		id="oauth2relay2052587594" name="oauth2relay2052587594"> </iframe>
	<div style="position: fixed; bottom: 0px; left: 0px; z-index: -10;">
		<img src="student.jpg">
	</div>
</body>

<script type='text/javascript'>
	frases.push("such autentication");
	frases.push("much security");
</script>

</html>
