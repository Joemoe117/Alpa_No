package manager;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import dao.AdministratorDao;

/**
 * Manager for login/logout
 * @author baptiste
 *
 */
@ManagedBean
@SessionScoped
public class ManagerAdministrator {

	/**
	 * Input for login
	 */
	public String inputLogin;
	
	/**
	 * Input for password
	 */
	public String inputPassword;
	
	/**
	 * 
	 */
	public boolean login(){
		
		boolean isConnected = AdministratorDao.connect(inputLogin, inputPassword);
		
		if (isConnected){
			
		} else {
			// TODO Error message for login
		}
		
		return false;
	}
}
