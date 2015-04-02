package manager;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import utils.HttpUtils;
import bean.Hotel;
import dao.HotelDao;

/**
 * Manager for hotel
 * @author baptiste
 *
 */
@ManagedBean
@SessionScoped
public class ManagerHotel {
	
	/**
	 * name for a new hotel in form
	 */
	public String inputHotelName;

	/**
	 * current updated hotel
	 */
	public Hotel currentHotel;
	
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

	/**
	 * Redirect to the form to create a new hotel
	 * @return
	 */
	public String add(){
		return "addHotel";
	}
	

	/**
	 * 	Add a hotel to the database
	 */
	public void createHotel(){
		Hotel hotel = new Hotel();
		
		// check if it is an update or a create 
		if (currentHotel != null){
			 hotel = currentHotel;
		}
		
		// form checking
		if (inputHotelName != null && !inputHotelName.isEmpty()) {
			hotel.setName(inputHotelName);
			HotelDao.add(hotel);
			hotels = HotelDao.getAllHotels();
			currentHotel = null;
			HttpUtils.redirect("listHotels");
		} else {
			System.out.println("input vide"); //
		}
	}
	
	/**
	 * Delete the given hotel
	 * @param hotel
	 * 		the hotel to delete
	 */
	public void delete(Hotel h){
		HotelDao.delete(h);
		hotels = HotelDao.getAllHotels();
	}
	
	/**
	 * Open a form to edit the current hotel
	 * @param hotel
	 * 		the hotel to update
	 */
	public void edit(Hotel hotel){
		currentHotel = hotel;
		inputHotelName = hotel.getName();
		HttpUtils.redirect("addHotel");
	}

	public String getInputHotelName() {
		return inputHotelName;
	}

	public void setInputHotelName(String inputHotelName) {
		this.inputHotelName = inputHotelName;
	}
	
	
}
