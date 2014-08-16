package comu;


import java.io.Serializable;
import java.util.List;

import entidades.Elemento;




public class ServicioElemento extends ServicioEntidad<Elemento> implements Serializable
{
	private static final long serialVersionUID = 1L;
	

	public Elemento buscar(Object pk){
		
		return (Elemento) em.find(Elemento.class, pk);
	}
	

	public List<Elemento> buscarTodos(){
		String qjl = "Select t from " + Elemento.class.getSimpleName() +" t";
		return em.createQuery(qjl, Elemento.class).getResultList();
		
	}
	public void borrar(int i){
		Elemento c = buscar(i);
		em.remove(c);
		
	}
	
	public int siguienteId()
	{
		int num = 1;
		num = buscarTodos().size() + 1;
		return num;
	}
}