package dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import bean.Flight;
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
		
		return (Panel) query.getResultList().get(0);
	}
}
