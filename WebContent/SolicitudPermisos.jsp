<%-- 
    Document   : SolicitudPermisos
    Created on : Apr 13, 2014, 3:33:53 PM
    Author     : Christian
--%>

<%@page import="entidades.Usuario"%>
<jsp:include page="template.jsp" />

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
<head>
<%
	
	 Usuario usuario = new Usuario();//se usa un constructor vacio para evitar nullPointerException
	 if (request.getSession().getAttribute("usuario") == null) {
	 response.sendRedirect("index.jsp");
	 } else {
	 usuario = (Usuario) request.getSession().getAttribute("usuario");
	 }
	 
	String solicitud = (String) request.getSession().getAttribute(
			"permiso");
	if (solicitud == null)
		solicitud = "";
	else
		solicitud = "Su solicitud ha sido enviada, pronto sera aprobada.";
%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Solicitud de Permisos</title>
</head>
<body>

	<div class='container jumbotron'>

		<form action="SolicitarPermiso" method="post">

			<div class="row">

				<div class="col-md-8">
					<ul class="list-group">

						<ul class="list-group-item">
							<h3>Solicitud de Permiso</h3>
						</ul>

						<ul class="list-group-item">
							<div class="row">
								<div class="col-md-4">
									<h4>
										<span class='glyphicon glyphicon-glass'></span> ID:
									</h4>
								</div>
								<div class="col-md-8">
									<input type="text" class="form-control" id="id"
										placeholder="Ingrese el ID del solicitante" name="id" value="" />
								</div>
							</div>
						</ul>

						<ul class="list-group-item">
							<div class="row">
								<div class="col-md-4">
									<h4>
										<span class='glyphicon glyphicon-flag'></span> Motivo:
									</h4>
								</div>
								<div class="col-md-8">
									<input type="text" class="form-control" id="motivo"
										placeholder="Ingrese el motivo del permiso" name="motivo"
										value="" />
								</div>
							</div>
						</ul>

						<ul class="list-group-item">
							<div class="row">
								<div class="col-md-4">
									<h4>
										<span class='glyphicon glyphicon-calendar'></span> Fecha
										Inicio:
									</h4>
								</div>
								<div class="col-md-8">
									<input type="text" class="form-control" id="fechainicio"
										placeholder="Ingrese la Fecha de Inicio en el formato YYYY-MM-DD"
										name="fechainicio" value="" />
								</div>
							</div>
						</ul>

						<ul class="list-group-item">
							<div class="row">
								<div class="col-md-4">
									<h4>
										<span class='glyphicon glyphicon-calendar'></span> Fecha
										Final:
									</h4>
								</div>
								<div class="col-md-8">
									<input type="text" class="form-control" id="fechafinal"
										placeholder="Ingrese la Fecha de Finalizacion en el formato YYYY-MM-DD"
										name="fechafinal" value="" />
								</div>
							</div>
						</ul>

						<ul class="list-group-item">
							<h4><%=solicitud%></h4>
						</ul>

					</ul>
				</div>

				<div class="col-md-4">
					<ul class="list-gorup">

						<ul class="list-group-item">
							<div class="jumbotron "
								style="width: 100%; margin-top: 5%; margin-bottom: 5%">
								<input type="submit" name="enviar" id="enviar"
									value="Enviar Solicitud" class="btn btn-primary btn-lg" />
							</div>
						</ul>

						<ul class="list-group-item">
							<div class="jumbotron "
								style="width: 100%; margin-top: 5%; margin-bottom: 5%">
								<a href="paginaP.jsp" style="width: 100%"
									class="btn btn-primary btn-lg">Cancelar</a>
							</div>
						</ul>

					</ul>
				</div>

			</div>
		</form>

	</div>

	<script>
		frases.push("such permit");
		frases.push("much vacations");
		frases.push("so procrastinate");
	</script>
</body>
</html>

