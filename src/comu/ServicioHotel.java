package comu;

import java.io.Serializable;
import java.util.List;

import javax.persistence.TypedQuery;

import entidades.Cadena_Hotelera;
import entidades.Hotel;
import entidades.Usuario;



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
	public List<Hotel> findTodos() {
		if (em == null) {
			startEntityManager();
		}
		TypedQuery<Hotel> query = em.createNamedQuery("Hotel.findAll", Hotel.class);
		return query.getResultList();
	}

}
