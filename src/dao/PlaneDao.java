package dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import bean.Flight;
import bean.Plane;

/**
 * Acces to plane objects
 * @author baptiste
 *
 */
public class PlaneDao {

	/**
	 * get all planes in DB
	 * @return
	 * 		the list of all planes in database
	 */
	public static List<Plane> getAllPlanes(){
		List<Plane> list = new ArrayList<Plane>(); 
		EntityManager em = GenericDao.getEntityManager();
		
		Query query = em.createQuery("from Plane as p");
		
		list = query.getResultList();
		return list;
	}

	/**
	 * Add a flight to the database
	 * @param flight
	 */
	public static void add(Flight flight) {
		EntityManager em = GenericDao.getEntityManager();
		em.getTransaction().begin();
		
		if (flight.getId() != 0){
			flight = em.merge(flight);
		}
		em.persist(flight);
		em.getTransaction().commit();
	}

	/**
	 * Get one plane by his id
	 * @return
	 * 		the plane with the given ID
	 * 		false if the plane does not exist
	 */
	public static Plane getById(int id) {
		EntityManager em = GenericDao.getEntityManager();
		Query query = em.createQuery("from Plane as p where p.id = :id ");
		query.setParameter("id", id);
		
		List<Plane> planes = query.getResultList();
		
		if (!planes.isEmpty()){
			return planes.get(0);
		}
		return null;
	}
	
}
