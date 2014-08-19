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
		<h1>Servicio</h1>
	</div>
		
	<div>
		<form action="AgregarServicio" method="get">
			Id Servicio:<input type="text" name="IdServicio"><br>
			Descripción:<input type="text" name="Descripcion"><br>
			Id Cliente:<input type="text" name="IdCliente"><br>
			Costo:<input type="text" name="Costo"><br>
			Id Hotel:<input type="text" name="IdHotel"><br>
			<input type="submit" name="Agregar" value="Agregar" /><br>
		</form>
	</div>
	
	<div>
		<form action="EliminarServicio" method="get">
			Id Servicio:<input type="text" name="IdServicio"><br>
			Descripción:<input type="text" name="Descripcion"><br>
			Id Cliente:<input type="text" name="IdCliente"><br>
			Costo:<input type="text" name="Costo"><br>
			Id Hotel:<input type="text" name="IdHotel"><br>
			<input type="submit" name="Eliminar" value="Eliminar" /><br>
		</form>
	</div>	
	
	<div>
		<form action="ActualizarServicio" method="get">
			Id Servicio:<input type="text" name="IdServicio"><br>
			Descripción:<input type="text" name="Descripcion"><br>
			Id Cliente:<input type="text" name="Id Cliente"><br>
			Costo:<input type="text" name="Costo"><br>
			Id Hotel:<input type="text" name="IdHotel"><br>
			<input type="submit" name="Actualizar" value="Actualizar" /><br>
		</form>
	</div>		

	
</body>
</html>