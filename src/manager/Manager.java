package manager;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import bean.Hotel;
import dao.HotelDao;

@ManagedBean
@SessionScoped
public class Manager {

	public String login;
	public String password;
	public String inputHotelName;
	
	public Manager(){
		login = "";
		password ="";
		inputHotelName = "";
	}
	
	
	public void identifier(){
		if (login.equals("admin")){
			System.out.println("connexion reussie");
		}
		System.out.println("connexion raté");
	}
	
	/**
	 * 	Add a hotel to the database
	 */
	public void createHotel(){
		if (inputHotelName != null && !inputHotelName.isEmpty()) {
			Hotel hotel = new Hotel();
			hotel.setName(inputHotelName);
			HotelDao.add(hotel);
			// TODO faire redirection
		} else {
			System.out.println("input vide"); //
			//
		}
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


	public String getInputHotelName() {
		return inputHotelName;
	}


	public void setInputHotelName(String inputHotelName) {
		this.inputHotelName = inputHotelName;
	}
	
	
}
