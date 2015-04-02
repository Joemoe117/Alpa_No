package manager;

import java.lang.reflect.Array;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import bean.Flight;
import bean.Hotel;
import bean.LinkPanelHotel;
import bean.Panel;
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
	public String beginDate;
	
	/**
	 * input end date
	 */
	public String endDate;
	
	/**
	 * Flight associated to this panel
	 */
	public Flight currentFlight;
	
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
		
		// check if all selected hotels exist in database
		// ie, user does not modify manually the html
		boolean isOk = true;
		for (int i = 0; i < inputHotels.length; i++) {
			Integer hotelId = inputHotels[i];
			isOk &= PanelDao.hotelWithIdExist(hotelId);
		}
		
		// TODO Julien
		// recupere les dates qui sont en format string
		// les transformer en objet date
		
		if (isOk){
			
		}
	}

	/**
	 * Update an existing panel
	 * @param flight
	 * 		the flight linked to this panel
	 * @return
	 * 		form to update the panel
	 */
	public String edit(Flight flight){
		currentFlight = flight;
		Panel p = checkExistingPanel();
		
		return "editPanel";
	}
	
	/**
	 * Check if the actual flight already has a panel
	 * @return
	 */
	private Panel checkExistingPanel(){
		Panel panel = PanelDao.getPanelByFlight(currentFlight);
	
		// update existing panel
		if (panel != null){
			beginDate = panel.getDateBegin().toString();
			endDate = panel.getDateEnd().toString();
			
			List<LinkPanelHotel> panels = (List<LinkPanelHotel>) panel.getPanels();
			List<Integer> selectedHotels = new ArrayList<Integer>();
			for (LinkPanelHotel linkPanelHotel : panels) {
				selectedHotels.add(linkPanelHotel.getHotel().getId());	
			}
			inputHotels = ( selectedHotels.toArray(new Integer[selectedHotels.size()]));
		
		// it is a new panel
		} else {
			panel = new Panel();
		}
		
		return panel;
	}

	public String getBeginDate() {
		return beginDate;
	}

	public void setBeginDate(String beginDate) {
		this.beginDate = beginDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public Flight getCurrentFlight() {
		return currentFlight;
	}

	public void setCurrentFlight(Flight currentFlight) {
		this.currentFlight = currentFlight;
	}
	
	
}
