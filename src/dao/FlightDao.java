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
	@SuppressWarnings("unchecked")
	public static List<Flight> getAllFlights(){
		List<Flight> flights = new ArrayList<>();
		EntityManager em = GenericDao.getEntityManager();
		
		Query query = em.createQuery("from Flight as f");
		
		flights = query.getResultList();
		return flights;
	}

	/**
	 * Deleet a flight from the database
	 * @param f
	 * 		the flight to delete
	 */
	public static void delete(Flight f) {
		// TODO Auto-generated method stub
		EntityManager em = GenericDao.getEntityManager();
		em.getTransaction().begin();
		
		// we need to retrieve the flight because we are not in the same session
		Flight flight = em.merge(f);
		
		// remove the flight
		em.remove(flight);
		em.getTransaction().commit();
	}
}
