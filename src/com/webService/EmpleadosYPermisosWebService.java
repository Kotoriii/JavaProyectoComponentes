package com.webService;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import comu.ServicioPermiso;
import entidades.Permiso;


@Path("/empleados")
public class EmpleadosYPermisosWebService {
 
 @GET
 @Produces(MediaType.TEXT_PLAIN)
 public String permisos() {
  ServicioPermiso sp = new ServicioPermiso();
  String per = "*** Listado Empleados y sus respectivos Permisos de DogeBarcelo ***";
  for (Permiso p : sp.findTodos()){
   per += "\nNombre Empleado: " + p.getUsuario() + "\nID Permiso: " + p.getId()
     + "\nTipo: " + p.getTipo() + "\nFechaDeExpiración: " + p.getHastaFecha()
     + "\n-----------------------------------------";
  }
  return per;
 }

}
