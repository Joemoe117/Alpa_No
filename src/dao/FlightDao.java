package dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import bean.Flight;

public class FlightDao {

	/**
	 * Get a list of all flights
	 * @return
	 * 		a list containing all the existing flights
	 */
	public static List<Flight> getAllFlights(){
		List<Flight> flights = new ArrayList<>();
		EntityManager em = GenericDao.getEntityManager();
		
		Query query = em.createQuery("from Flight as f");
		
		flights = query.getResultList();
		return flights;
	}
}
