<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@include file="template.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Cadena Hotelera</title>
</head>
<body>
	<div>
		<h1>Datos Cadena Hotelera</h1>
	</div>
<div id="Agregar">
	<form action="AgregarCadena" method="get">
	
				Id de la Cadena Hotelera:<input type="text" name="IdCadena"><br>
		
				Nombre Cadena Hotelera:<input type="text" name="Nombre"><br>
				
				<input type="submit" name="Agregar" value="Agregar" /><br>
		
	
	</form>
</div>

<div id="Eliminar">
						
	<form action="EliminarCadena" method="get">
				
				Id de la Cadena Hotelera:<input type="text" name="IdCadena"><br>
		
				Nombre Cadena Hotelera:<input type="text" name="Nombre"><br>
				
				<input type="submit" name="Eliminar" value="Eliminar" />
	</form>
</div>	

	
<div id="Actualizar">
	<form action="ActualizarCadena" method="get">
				
				Id de la Cadena Hotelera:<input type="text" name="IdCadena"><br>
		
				Nombre Cadena Hotelera:<input type="text" name="Nombre"><br>
				
				<input type="submit" name="Eliminar" value="Eliminar" />
	</form>
	
</div>	

</body>
</html>