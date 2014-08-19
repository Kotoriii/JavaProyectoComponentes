<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@include file="template.jsp"%>
  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Insert title here</title>
</head>
<body>

	<div>
		<h1>Reservación</h1>
	</div>
	<div>
		<form action="AgregarReservacion" method="get">
		
			Id de la Reservación:<input type="text" name="IdReservacion"><br>
			Id Hotel:<input type="text" name="IdHotel"><br>
			Id Cliente:<input type="text" name="IdCliente"><br>
			Fecha de llegada:<input type="text" name="FechaLlegada"><br>
			Fecha de salida:<input type="text" name="FechaSalida"><br>
			Fecha Reservación:<input type="text" name="FechaReservacion"><br>
			Costo:<input type="text" name="Costo"><br>
			<input type="submit" name="Agregar" value="Agregar" /><br>
			
		</form>
	</div>	
	
	<div>
		<form action="EliminarReservacion" method="get">
		
			Id de la Reservación:<input type="text" name="IdReservacion"><br>
			Id Hotel:<input type="text" name="IdHotel"><br>
			Id Cliente:<input type="text" name="IdCliente"><br>
			Fecha de llegada:<input type="text" name="FechaLlegada"><br>
			Fecha de salida:<input type="text" name="FechaSalida"><br>
			Fecha Reservación:<input type="text" name="FechaReservacion"><br>
			Costo:<input type="text" name="Costo"><br>
			<input type="submit" name="Eliminar" value="Eliminar" /><br>
			
		</form>
	</div>	
	
	<div>
		<form action="ActualizarReservacion" method="get">
		
			Id de la Reservación:<input type="text" name="IdReservacion"><br>
			Id Hotel:<input type="text" name="IdHotel"><br>
			Id Cliente:<input type="text" name="IdCliente"><br>
			Fecha de llegada:<input type="text" name="FechaLlegada"><br>
			Fecha de salida:<input type="text" name="FechaSalida"><br>
			Fecha Reservación:<input type="text" name="FechaReservacion"><br>
			Costo:<input type="text" name="Costo"><br>
			<input type="submit" name="Actualizar" value="Actualizar" /><br>
			
		</form>
	</div>	
		
	
	
	
</body>
</html>