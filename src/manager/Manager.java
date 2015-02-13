package manager;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class Manager {

	public String login;
	public String password;
	
	public Manager(){
		
	}
	
	
	public void identifier(){
		if (login.equals("admin")){
			System.out.println("connexion reussie");
		}
		System.out.println("connexion raté");
	}
}
