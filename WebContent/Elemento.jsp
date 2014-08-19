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
		<h1>Datos Elemento</h1>
	</div>
	
	<div>
		<form action="AgregarElemento" method="get">
			Id del Elemento:<input type="text" name="IdElemento"><br>
			Descripción:<input type="text" name="Descripcion"><br>
			Id Habitación asociada:<input type="text" name="IdHabitacion"><br>
			<input type="submit" name="Agregar" value="Agregar" /><br>
		</form>
	</div>	
	
	<div>
		<form action="EliminarElemento" method="get">
			Id del Elemento:<input type="text" name="IdElemento"><br>
			Descripción:<input type="text" name="Descripcion"><br>
			Id Habitación asociada:<input type="text" name="IdHabitacion"><br>
			<input type="submit" name="Eliminar" value="Eliminar" /><br>
		</form>
	</div>	
	
	<div>
		<form action="ActualizarElemento" method="get">
			Id del Elemento:<input type="text" name="IdElemento"><br>
			Descripción:<input type="text" name="Descripcion"><br>
			Id Habitación asociada:<input type="text" name="IdHabitacion"><br>
			<input type="submit" name="Actualizar" value="Actualizar" /><br>
		</form>
	</div>	

	

</body>
</html>