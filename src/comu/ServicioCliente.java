package comu;


import java.io.Serializable;
import java.util.List;

import entidades.Cliente;




public class ServicioCliente extends ServicioEntidad<Cliente> implements Serializable
{
	private static final long serialVersionUID = 1L;
	

	public Cliente buscar(Object pk){
		
		return (Cliente) em.find(Cliente.class, pk);
	}
	

	public List<Cliente> buscarTodos(){
		String qjl = "Select t from " + Cliente.class.getSimpleName() +" t";
		return em.createQuery(qjl, Cliente.class).getResultList();
		
	}
	public void borrar(int i){
		Cliente c = buscar(i);
		em.remove(c);
		
	}
	
	public int siguienteId()
	{
		int num = 1;
		num = buscarTodos().size() + 1;
		return num;
	}
}