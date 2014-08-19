package comu;


import java.io.Serializable;
import java.util.List;

import entidades.Cadena_Hotelera;
import entidades.Hotel;
import entidades.Reservacion;



public class ServicioReservacion extends ServicioEntidad<Reservacion> implements Serializable
{
	private static final long serialVersionUID = 1L;
	

	public Reservacion buscar(Object pk){
		
		return (Reservacion) em.find(Reservacion.class, pk);
	}
	

	public List<Reservacion> buscarTodos(){
		String qjl = "Select t from " + Reservacion.class.getSimpleName() +" t";
		return em.createQuery(qjl, Reservacion.class).getResultList();
		
	}
	public void borrar(int i){
		Reservacion c = buscar(i);
		em.remove(c);
		
	}
	
	public int siguienteId()
	{
		int i = 1;
		boolean bandera = false;
		while(bandera == false){
		if(buscar(i)==null)
		{
			bandera = true;
		}else
			i= i+1;//dato que se asignara al id del nuevo registro
		}
		return i;
		
	}
}
