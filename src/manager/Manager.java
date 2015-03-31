package manager;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import bean.Hotel;
import dao.HotelDao;

@ManagedBean
@SessionScoped
public class Manager {


	public String inputHotelName;
	
	public Manager(){
		inputHotelName = "";
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

	public String getInputHotelName() {
		return inputHotelName;
	}


	public void setInputHotelName(String inputHotelName) {
		this.inputHotelName = inputHotelName;
	}
	
	
}
