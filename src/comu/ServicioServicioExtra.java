package comu;


import java.io.Serializable;
import java.util.List;
import entidades.ServicioExtra;




public class ServicioServicioExtra extends ServicioEntidad<ServicioExtra> implements Serializable
{
	private static final long serialVersionUID = 1L;
	

	public ServicioExtra buscar(Object pk){
		
		return (ServicioExtra) em.find(ServicioExtra.class, pk);
	}
	

	public List<ServicioExtra> buscarTodos(){
		String qjl = "Select t from " + ServicioExtra.class.getSimpleName() +" t";
		return em.createQuery(qjl, ServicioExtra.class).getResultList();
		
	}
	public void borrar(int i){
		ServicioExtra c = buscar(i);
		em.remove(c);
		
	}
	
	public int siguienteId()
	{
		int num = 1;
		num = buscarTodos().size() + 1;
		return num;
	}
}
