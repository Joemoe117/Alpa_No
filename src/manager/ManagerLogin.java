package manager;


import java.io.IOException;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletResponse;

import utils.HttpUtils;
import utils.SessionUtils;
import dao.AdministratorDao;

/**
 * Manager for login/logout
 * @author baptiste
 *
 */
@ManagedBean
@SessionScoped
public class ManagerLogin {

	/**
	 * input for login
	 */
	private String inputLogin;
	
	/**
	 * input for password
	 */
	private String inputPassword;

	public ManagerLogin(){
		
	}
	
	/**
	 * Connect a user
	 * @return
	 * 		redirect the user to list of flight if success
	 * 		stay on the same page on error
	 */
	public void login(){
		boolean isConnected = AdministratorDao.connect(inputLogin, inputPassword);
		
		if ( isConnected ){
			SessionUtils.getSession().setAttribute(SessionUtils.CONNECTED, true);
			HttpUtils.redirect("listFlights");
		}
	}

	public String getInputLogin() {
		return inputLogin;
	}

	public void setInputLogin(String inputLogin) {
		this.inputLogin = inputLogin;
	}

	public String getInputPassword() {
		return inputPassword;
	}

	public void setInputPassword(String inputPassword) {
		this.inputPassword = inputPassword;
	}
	
	
}
