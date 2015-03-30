package manager;

import java.sql.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import bean.Hotel;
import dao.HotelDao;
import dao.PanelDao;

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
	 * input begin date
	 */
	public Date beginDate;
	
	/**
	 * input end date
	 */
	public Date endDate;
	
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
	
		// check if all selected hotels exist in database
		// ie, user does not modify manually the html
		boolean isOk = true;
		for (int i = 0; i < inputHotels.length; i++) {
			Integer hotelId = inputHotels[i];
			isOk &= PanelDao.hotelWithIdExist(hotelId);
		}
		
		if (isOk){
			
		}
	}

	public Date getBeginDate() {
		return beginDate;
	}

	public void setBeginDate(Date beginDate) {
		this.beginDate = beginDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	
}
