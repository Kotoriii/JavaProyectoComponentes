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
			<h2 style="margin-left: 35%; margin-top: 2%; margin-bottom: 2%">Generación
				de Reportes</h2>
			<div class="row" style="margin-left: 40%">
				<select name="repo">
					<option value="Empleados_Estados">Lista de Empleados Activos</option>
					<option value="Empleados_Role">Cantidad de Roles de Empleados</option>
					<option value="Empleados_Salarios">Porcentaje de Gasto en Salarios</option>
					<option value="Hoteles_Cadenas">Lista de Hoteles por Cadena</option>
					<option value="Hoteles_PorPais">Lista de Hoteles por Pais</option>
					
				</select>
				<button type="submit">Aceptar</button>
				
			</div>
		</div>
	</form>
	<script>
		frases.push("such permit");
		frases.push("much vacations");
		frases.push("so procrastinate"); //jaja
	</script>
</body>
</html>
