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
		<h1>Servicio Extra</h1>
	</div>
	<div>
		<form action="AgregarServicioExtra" method="get">
		
			Id Servicio Extra:<input type="text" name="IdServicioExtra"><br>
			Descripción:<input type="text" name="Descripcion"><br>
			Costo:<input type="text" name="Costo"><br>
			Horario:<input type="text" name="Horario"><br>
			Id Habitación:<input type="text" name="IdHabitacion"><br>
			<input type="submit" name="Agregar" value="Agregar" /><br>
			
		</form>
	</div>
	
		<div>
		<form action="EliminarServicioExtra" method="get">
		
			Id Servicio Extra:<input type="text" name="IdServicioExtra"><br>
			Descripción:<input type="text" name="Descripcion"><br>
			Costo:<input type="text" name="Costo"><br>
			Horario:<input type="text" name="Horario"><br>
			Id Habitación:<input type="text" name="IdHabitacion"><br>
			<input type="submit" name="Eliminar" value="Eliminar" /><br>
			
		</form>
	</div>
	
		<div>
		<form action="ActualizarServicioExtra" method="get">
		
			Id Servicio Extra:<input type="text" name="IdServicioExtra"><br>
			Descripción:<input type="text" name="Descripcion"><br>
			Costo:<input type="text" name="Costo"><br>
			Horario:<input type="text" name="Horario"><br>
			Id Habitación:<input type="text" name="IdHabitacion"><br>
			<input type="submit" name="Actualizar" value="Actualizar" /><br>
			
		</form>
	</div>

	
</body>
</html>