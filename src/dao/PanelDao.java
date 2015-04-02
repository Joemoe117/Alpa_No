package dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import bean.Flight;
import bean.Hotel;
import bean.Panel;

public class PanelDao {

	/**
	 * Return a list of all the panels
	 * @return
	 * 		a list containing all the existing panels
	 */
	public static Panel getPanelByFlight(Flight flight){
		List<Panel> panels = new ArrayList<Panel>();
		EntityManager em = GenericDao.getEntityManager();
		
		Query query = em.createQuery("from Panel as pa where pa.flight = :flight");
		query.setParameter("flight", flight);
		
		if (query.getResultList() != null && !query.getResultList().isEmpty()) {
			return (Panel) query.getResultList().get(0);
		} else {
			return null;
		}		
	}
	
	/**
	 * Check if the hotel with the given id exists in database
	 * @param id
	 * 		id of the hotel to check
	 * @return
	 * 		the hotel if this hotel exists
	 * 		null otherwise
	 */
	public static Hotel hotelWithIdExist(Integer id){
		
		EntityManager em = GenericDao.getEntityManager();
		
		Query query = em.createQuery("from Hotel as h where h.id = :id");
		query.setParameter("id", id);
		
		return (Hotel) query.getResultList().get(0);
	}
	
	/**
	 * Save the given panel
	 * @param panel
	 * 		panel to save
	 */
	public static void save(Panel panel){
		EntityManager em = GenericDao.getEntityManager();
		em.getTransaction().begin();
		
		if (panel.getId() != 0){
			panel = em.merge(panel);
		}
		em.persist(panel);
		em.getTransaction().commit();
	}
}
