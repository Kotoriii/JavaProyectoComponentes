package com.webService;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.ControlHorarios;

import comu.ServicioUsuario;
import entidades.Usuario;

@Path("/cerrarSesion")
public class CerrarSesionWebS {
	/**
	 * Es para cuando a un usuario se le olvida cerrar sesion. cada metodo
	 * acepta 2 parametros, El id y la contrase_a. Si el usuario no ha iniciado
	 * sesion entonces o si no tiene la contrase_a correcta entonces no se
	 * permite que inicie sesion * Si todo esta bien entonces se sierra la
	 * sesion x el dia
	 */

	// This method is called if TEXT_PLAIN is request
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String cerrarSesionTextPlain(@QueryParam("nombre") String name,
			@QueryParam("contra") String contra) {

		return Cerrar_Sesion_validate(name, contra);
	}

	// This method is called if XML is request
	@GET
	@Produces(MediaType.TEXT_XML)
	public String cerrarSesionXML(@QueryParam("nombre") String name,
			@QueryParam("contra") String contra) {
		return "<?xml version=\"1.0\"?>" + "<mensaje> "+ Cerrar_Sesion_validate(name, contra)+ "</mensaje>";
	}

	// This method is called if HTML is request
	@GET
	@Produces(MediaType.TEXT_HTML)
	public String cerrarSesionHTML(@QueryParam("nombre") String name,
			@QueryParam("contra") String contra) {
		return "<html> " + "<title>" + "Estado" + "</title>"
				+ "<body><h1>" + Cerrar_Sesion_validate(name, contra) + "</body></h1>" + "</html> ";
	}

	public String Cerrar_Sesion_validate(String nombre, String contra) {
		String str = "";
		ServicioUsuario servUsuario = new ServicioUsuario();
		Usuario usuario = null;

		try {
			usuario = servUsuario.findNombre(nombre);
			ControlHorarios controlHorarios = ControlHorarios.getInstancia();

			if (!usuario.getContrasenna().equals(contra)) {
				str = "El usuario o la contrase_a no son correctos";
			} else if (controlHorarios.cerroSesionXelDia(usuario)) {
				str = "El usuario ya cerro sesion en el dia";
			} else {
				controlHorarios.cerrarSesion(usuario);// cierra sesion
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			str = "PARAMETROS OBLIGATORIOS: nombre, contrase_a";
		}

		return str;
	}

}
