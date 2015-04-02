package dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import bean.Flight;
import bean.Hotel;

/**
 * Acces to hotel object
 * @author baptiste
 *
 */
public class HotelDao {

	/**
	 * Get a list of all existing hotels
	 * @return
	 * 		list of all existing hotels
	 */
	public static List<Hotel> getAllHotels(){
		List<Hotel> hotels = new ArrayList<>();
		
		EntityManager em = GenericDao.getEntityManager();		
		Query query = em.createQuery("from Hotel as h");
		
		hotels = query.getResultList();
		
		return hotels;
	}
	
	/**
	 * Add a hotel to the database
	 * @param hotel
	 * 			hotel to add to the database
	 */
	public static void add(Hotel hotel){
		EntityManager em = GenericDao.getEntityManager();
		em.getTransaction().begin();
		
		if (hotel.getId() != 0){
			hotel = em.merge(hotel);
		}
		em.persist(hotel);
		em.getTransaction().commit();
	}
	
	/**
	 * Delete the given hotel
	 * @param hotel
	 * 		the hotel to delete
	 */
	public static void delete(Hotel hotel){
		EntityManager em = GenericDao.getEntityManager();
		em.getTransaction().begin();
		
		// we need to retrieve the flight because we are not in the same session
		Hotel h= em.merge(hotel);
		
		// remove the flight
		em.remove(h);
		em.getTransaction().commit();
	}
}