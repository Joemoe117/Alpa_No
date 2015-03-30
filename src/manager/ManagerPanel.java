package manager;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import bean.Hotel;
import dao.HotelDao;

@ManagedBean
@SessionScoped
public class ManagerPanel {
	
	/**
	 * List of all existing hotels
	 */
	public List<Hotel> hotels;
	
	/**
	 * Selected hotels in form
	 */
	public Integer[] inputHotels;
	
	/**
	 * Default constructor
	 */
	public ManagerPanel(){
		hotels = HotelDao.getAllHotels();
	}

	public List<Hotel> getHotels() {
		return hotels;
	}

	public void setHotels(List<Hotel> hotels) {
		this.hotels = hotels;
	}

	public Integer[] getInputHotels() {
		return inputHotels;
	}

	public void setInputHotels(Integer[] inputHotels) {
		this.inputHotels = inputHotels;
	}
	
	/**
	 * Save the current panel
	 */
	public void save(){
		System.out.println(inputHotels);
	}
	
}
