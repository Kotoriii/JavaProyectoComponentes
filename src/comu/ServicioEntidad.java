package comu;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public abstract class ServicioEntidad<E> implements Serializable {

	private static final long serialVersionUID = 1L;
	protected EntityManagerFactory emf;
	protected EntityManager em;
	
	public ServicioEntidad() {
		super();
	}

	public void startEntityManager(String unidadPersistencia) {
		emf = Persistence.createEntityManagerFactory(unidadPersistencia);
		em = emf.createEntityManager();
	}

	public void closeEntityManager() {
		em.close();
		emf.close();
	}

	public void insertar(E item) {
		em.getTransaction().begin();
		em.persist(item);
		em.flush();
		em.getTransaction().commit();
	}

	public void actualizar(E item) {
		em.getTransaction().begin();
		em.merge(item);
		em.flush();
		em.getTransaction().commit();
	}	
	
	public E buscar(E item, Object pk){
		return (E) em.find(item.getClass(), pk);
	}
	
	public List<E> buscarTodos(E item){
		String qjl = "Select t from " + item.getClass().getSimpleName() +" t";
		return (List<E>) em.createQuery(qjl, item.getClass()).getResultList();
		
	}

}
