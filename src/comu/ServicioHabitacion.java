package comu;


import java.io.Serializable;
import java.util.List;

import entidades.Habitacione;




public class ServicioHabitacion extends ServicioEntidad<Habitacione> implements Serializable
{
	private static final long serialVersionUID = 1L;
	

	public Habitacione buscar(Object pk){
		
		return (Habitacione) em.find(Habitacione.class, pk);
	}
	

	public List<Habitacione> buscarTodos(){
		String qjl = "Select t from " + Habitacione.class.getSimpleName() +" t";
		return em.createQuery(qjl, Habitacione.class).getResultList();
		
	}
	public void borrar(int i){
		Habitacione c = buscar(i);
		em.remove(c);
		
	}
	
	public int siguienteId()
	{
		int num = 1;
		num = buscarTodos().size() + 1;
		return num;
	}
}
