package manager;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class Manager {

	public String login;
	public String password;
	
	public Manager(){
		login = "";
		password ="";
	}
	
	
	public void identifier(){
		if (login.equals("admin")){
			System.out.println("connexion reussie");
		}
		System.out.println("connexion rat�");
	}


	public String getLogin() {
		return login;
	}


	public void setLogin(String login) {
		this.login = login;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
