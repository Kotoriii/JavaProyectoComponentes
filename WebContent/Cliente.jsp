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
		<h1>Datos Cliente</h1>
	</div>
	<div>
		<form action="AgregarCliente" method="get">
		
			Id del cliente:<input type="text" name="IdCliente"><br>
			Nombre cliente:<input type="text" name="Nombre"><br>
			Cédula cliente:<input type="text" name="Cedula"><br>
			Teléfono cliente:<input type="text" name="Telefono"><br>
			<input type="submit" name="Agregar" value="Agregar" /><br>
			
		</form>
	</div>
	
	<div>
		<form action="EliminarCliente" method="get">
		
			Id del cliente:<input type="text" name="IdCliente"><br>
			Nombre cliente:<input type="text" name="Nombre"><br>
			Cédula cliente:<input type="text" name="Cedula"><br>
			Teléfono cliente:<input type="text" name="Telefono"><br>
			<input type="submit" name="Eliminar" value="Eliminar" /><br>
			
		</form>
	</div>
	
	<div>
		<form action="ActualizarCliente" method="get">
		
			Id del cliente:<input type="text" name="IdCliente"><br>
			Nombre cliente:<input type="text" name="Nombre"><br>
			Cédula cliente:<input type="text" name="Cedula"><br>
			Teléfono cliente:<input type="text" name="Telefono"><br>
			<input type="submit" name="Actualizar" value="Actualizar" /><br>
			
		</form>
	</div>
		

		
	
</body>
</html>