package manager;


import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
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
	
	/**
	 * Output result
	 */
	public String resultString = "";

	public ManagerLogin(){
		resultString = "";
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
			resultString = "";
			HttpUtils.redirect("accueil");
		}
		else {
			resultString = "Identifiant ou mot de passe incorrect";
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
	
	public String getResultString(){
		return resultString;
	}
	
	public void setResultString(String resultString){
		this.resultString = resultString;
	}

	public void setInputPassword(String inputPassword) {
		this.inputPassword = inputPassword;
	}
	
	
}
