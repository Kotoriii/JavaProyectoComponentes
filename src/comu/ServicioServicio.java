package comu;


import java.io.Serializable;
import java.util.List;
import entidades.Servicio;




public class ServicioServicio extends ServicioEntidad<Servicio> implements Serializable
{
	private static final long serialVersionUID = 1L;
	

	public Servicio buscar(Object pk){
		
		return (Servicio) em.find(Servicio.class, pk);
	}
	

	public List<Servicio> buscarTodos(){
		String qjl = "Select t from " + Servicio.class.getSimpleName() +" t";
		return em.createQuery(qjl, Servicio.class).getResultList();
		
	}
	public void borrar(int i){
		Servicio c = buscar(i);
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
