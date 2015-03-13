package manager;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import bean.Hotel;
import dao.HotelDao;

@ManagedBean
@SessionScoped
public class ManagerHotel {

	/**
	 * List of all existing flights
	 */
	public List<Hotel> hotels;
	
	/**
	 * Default constructor
	 */
	public ManagerHotel(){
		hotels = HotelDao.getAllHotels();
	}

	public List<Hotel> getHotels() {
		return hotels;
	}

	public void setHotels(List<Hotel> hotels) {
		this.hotels = hotels;
	}

	
}
