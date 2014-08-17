package com.webService;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import comu.ServicioUsuario;
import entidades.Usuario;

@Path("/empleados")
public class EmpleadosWebService {

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String empleados() {
		return lista();
	}

	@GET
	@Produces(MediaType.TEXT_XML)
	public String sayXMLHello() {
		return "<?xml version=\"1.0\"?>" + "<hello> " + lista() + "</hello>";
	}

	@GET
	@Produces(MediaType.TEXT_HTML)
	public String sayHtmlHello() {
		return "<html> " + "<title>" + "Empleados" + "</title>"
				+ "<body><h1>" + lista() + "</body></h1>" + "</html> ";
	}

	public String lista() {
		ServicioUsuario su = new ServicioUsuario();
		String emp = "*** Empleados de DogeBarcelo ***";
		for (Usuario u : su.findTodos()) {
			emp = emp + "\nNombre: " + u.getNombre() + "\nID empleado: "
					+ u.getId() + "\nPuesto: " + u.getRol() + "\nContacto: "
					+ u.getCorreo() + "\n---------------------------------";
		}
		return emp;
	}
}
