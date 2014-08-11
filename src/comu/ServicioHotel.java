package comu;


import java.io.Serializable;
import java.util.List;

import entidades.Cadena_Hotelera;
import entidades.Hotel;



public class ServicioHotel extends ServicioEntidad<Hotel> implements Serializable
{
	private static final long serialVersionUID = 1L;
	

	public Hotel buscar(Object pk){
		
		return (Hotel) em.find(Hotel.class, pk);
	}
	

	public List<Hotel> buscarTodos(){
		String qjl = "Select t from " + Hotel.class.getSimpleName() +" t";
		return em.createQuery(qjl, Hotel.class).getResultList();
		
	}
	public void borrar(int i){
		Hotel c = buscar(i);
		em.remove(c);
		
	}
	
	public int siguienteId()
	{
		int num = 1;
		num = buscarTodos().size() + 1;
		return num;
	}
}
