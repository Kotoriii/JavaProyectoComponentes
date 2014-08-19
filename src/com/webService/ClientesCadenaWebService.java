package com.webService;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import comu.ServicioHotel;
import comu.ServicioUsuario;
import entidades.Hotel;
import entidades.Reservacion;
import entidades.Usuario;

@Path("/Clientes")
public class ClientesCadenaWebService {
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String clientes() {
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
		return "<html> " + "<title>" + "Clientes" + "</title>" + "<body><h1>"
				+ lista() + "</body></h1>" + "</html> ";
	}

	public String lista() {
		ServicioHotel SH = new ServicioHotel();
		String CAD = "*** Empleados de DogeBarcelo ***";
		SH.startEntityManager();
		for (Hotel h : SH.buscarTodos()) {
			CAD = CAD + "\nHotel: " + h.getNombre() + "\nClientes: ";
			for (Reservacion r : h.getReservacions()) {
				CAD = CAD + "\n Nombre: " + r.getCliente().getNombre()
						+ "  Telefono: "
						+ r.getCliente().getTelefono()
						+ " " + "\n-----------------------------------------";
			}
		}
		return CAD;
	}

}
