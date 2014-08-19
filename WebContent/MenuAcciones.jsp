
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
			Cadena Hotelera:<input type="submit" name="IR" value="IRcadena"><br>
			Hotel:<input type="submit" name="IR" value="IRhotel"><br>
			Habitaciones:<input type="submit" name="IR" value="IRhabitacion"><br>
			Servicios:<input type="submit" name="IR" value="IRservicio"><br>
			Servicios Extra:<input type="submit" name="IR" value="IRservicioextra"><br>
			Cliente:<input type="submit" name="IR" value="IRcliente"><br>
			Reservacion:<input type="submit" name="IR" value="IRreservacion"><br>
			Elementos de Habitaciones:<input type="submit" name="IR" value="IRelemento">
			
		</form>
	</div>

			
			
</body>
</html>