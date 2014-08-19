package com.webService;


import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import comu.ServicioCadena_Hotelera;
import comu.ServicioHotel;
import entidades.Cadena_Hotelera;
import entidades.Hotel;

@Path("/hoteles")
public class HotelesWebService {

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String Hoteles_Cadena(@QueryParam("id") int ID){
		
		ServicioCadena_Hotelera SCH= new ServicioCadena_Hotelera();
		ServicioHotel SH =new ServicioHotel();
		SCH.startEntityManager();
		SH.startEntityManager();
		Cadena_Hotelera CH = SCH.buscar(ID);
		String hotel="***Hoteles de "+CH.getNombre()+"***";
		for (Hotel H: SH.buscarTodos()) {
			
			hotel = hotel + "\nNombre: " + H.getNombre() +"\nId Hotel"+H.getIdHotel() +"\nUbicación"+ H.getUbicacion()+
					"\nServicios"+ H.getServicios() + "------------------------------";
		}
			
		
		return hotel;
		
	}
	
	
	
	
	
}
