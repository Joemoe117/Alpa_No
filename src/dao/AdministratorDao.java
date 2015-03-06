package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import bean.Administrator;

/**
 * Dao for administrators
 * @author baptiste
 *
 */
public class AdministratorDao extends GenericDao {

	/**
	 * Connect a user with the given credentials
	 * @param login
	 * 		login of the user
	 * @param password
	 * 		password of the user
	 * @return
	 * 		true if a user exists with the given credentials
	 * 		false otherwise
	 */
	public static boolean connect(String login, String password){
		
		EntityManagerFactory emf = 
				Persistence.createEntityManagerFactory(
						"tphibernate");
		EntityManager em = emf.createEntityManager();
		
		Query query = em.createQuery("from Administrator as admin where admin.name = :login and admin.password = :password");
		query.setParameter("login", login);
		query.setParameter("password", password);
		
		List<Administrator> list = (List<Administrator>) query.getResultList();
		
		if (!list.isEmpty()) {
			return true;
		}
		
		return false;
	}
}
