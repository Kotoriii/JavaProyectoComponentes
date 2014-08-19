
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@include file="template.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Menu de acciones del Hotel</title>
</head>
<body>
	
	<div>
		<form action="DirigirPag" method="get">
			<a href="CadenaHotelera.jsp">Cadena Hotelera:<input type="submit" name="IR" value="Cadena"><br>
			<a href="Hotel.jsp">Hotel:<input type="submit" name="IR" value="Hotel"><br>
			<a href="Habitacion.jsp">Habitaciones:<input type="submit" name="IR" value="Habitacion"><br>
			<a href="Servicio.jsp">Servicios:<input type="submit" name="IR" value="Servicio"><br>
			<a href="ServicioExtra.jsp">Servicios Extra:<input type="submit" name="IR" value="Servicioextra"><br>
			<a href="Cliente.jsp">Cliente:<input type="submit" name="IR" value="Cliente"><br>
			<a href="Reservacion.jsp">Reservacion:<input type="submit" name="IR" value="Reservacion"><br>
			<a href="Elemento.jsp">Elementos de Habitaciones:<input type="submit" name="IR" value="Elemento">
			
		</form>
	</div>

			
			
</body>
</html>