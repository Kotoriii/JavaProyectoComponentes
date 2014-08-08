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

	public void startEntityManager() {
		if(emf == null){
		emf = Persistence.createEntityManagerFactory("DogeBarcelo");
		}
		if(em == null){
		em = emf.createEntityManager();
		}
	}

	public EntityManager getEntityManager(){
		return em;
	}
	
	public void closeEntityManager() {
		em.close();
		emf.close();
	}

	public void insertar(E item) {
		if(em == null){
			startEntityManager();
		}
		em.getTransaction().begin();
		em.persist(item);
		em.flush();
		em.getTransaction().commit();
	}

	public void actualizar(E item) {
		if(em == null){
			startEntityManager();
		}
		em.getTransaction().begin();
		em.merge(item);
		em.flush();
		em.getTransaction().commit();
	}	
	
	public E buscar(E item, Object pk){
		if(em == null){
			startEntityManager();
		}
		E pop = (E) em.find(item.getClass(), pk);
		return pop;
	}

	public List<E> buscarTodos(E item){
		if(em == null){
			startEntityManager();
		}
		String qjl = "Select t from " + item.getClass().getSimpleName() +" t";
		List<E> popio = (List<E>) em.createQuery(qjl, item.getClass()).getResultList();
		return popio;
	}
	
}
