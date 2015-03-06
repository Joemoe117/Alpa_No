package dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

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
	
}
