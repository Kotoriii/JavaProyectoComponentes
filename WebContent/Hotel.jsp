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
		<h1>Datos Hotel</h1>
	</div>
	<div>
		<form action="AgregarHotel" method="get">
			Id Hotel:<input type="text" name="IdHotel"><br>
			Nombre:<input type="text" name="Nombre"><br>
			Ubicación:<input type="text" name="Ubicacion"><br>
			Id Cadena Hotelera:<input type="text" name="IdCadenaHotelera"><br>
			<input type="submit" name="Agregar" value="Agregar" /><br>
		</form>
	
	</div>
	
		<div>
		<form action="EliminarHotel" method="get">
			Id Hotel:<input type="text" name="IdHotel"><br>
			Nombre:<input type="text" name="Nombre"><br>
			Ubicación:<input type="text" name="Ubicacion"><br>
			Id Cadena Hotelera:<input type="text" name="IdCadenaHotelera"><br>
			<input type="submit" name="Eliminar" value="Eliminar" /><br>
		</form>
	
	</div>
	
		<div>
		<form action="ActualizarHotel" method="get">
			Id Hotel:<input type="text" name="IdHotel"><br>
			Nombre:<input type="text" name="Nombre"><br>
			Ubicación:<input type="text" name="Ubicacion"><br>
			Id Cadena Hotelera:<input type="text" name="IdCadenaHotelera"><br>
			<input type="submit" name="Actualizar" value="Actualizar" /><br>
		</form>
	
	</div>

	
</body>
</html>