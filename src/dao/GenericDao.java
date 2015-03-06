package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

/**
 * Generic Dao
 * @author baptiste
 *
 */
public abstract class GenericDao {

	private static EntityManager em;
	
	/**
	 * get an active session
	 * @return
	 */
    public static EntityManager getEntityManager(){
    	if (em != null){
    		return em;
    	} else {
    		EntityManagerFactory emf = 
    				Persistence.createEntityManagerFactory(
    						"tphibernate");
    		EntityManager em = emf.createEntityManager();
    		return em;
    	}
    	
    }
    
	
}
