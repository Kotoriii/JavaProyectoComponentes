package comu;


import java.io.Serializable;
import java.util.List;

import entidades.Cadena_Hotelera;



public class ServicioCadena_Hotelera extends ServicioEntidad<Cadena_Hotelera> implements Serializable
{
	private static final long serialVersionUID = 1L;
	

	public Cadena_Hotelera buscar(Object pk){
		
		return (Cadena_Hotelera) em.find(Cadena_Hotelera.class, pk);
	}
	

	public List<Cadena_Hotelera> buscarTodos(){
		String qjl = "Select t from " + Cadena_Hotelera.class.getSimpleName() +" t";
		return em.createQuery(qjl, Cadena_Hotelera.class).getResultList();
		
	}
	public void borrar(int i){
		Cadena_Hotelera c = buscar(i);
		em.remove(c);
		
	}
}
