package manager;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import utils.HttpUtils;
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
	 * Current modified panel
	 */
	public Panel currentPanel;
	
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
	 * @throws ParseException 
	 */
	public void save(){
		
		// check if all selected hotels exist in database
		// ie, user does not modify manually the html
		boolean isOk = true;
		Set<Hotel> hotels = new HashSet<Hotel>();
		for (int i = 0; i < inputHotels.length; i++) {
			Integer hotelId = inputHotels[i];
			hotels.add(PanelDao.hotelWithIdExist(hotelId));
		}
		
		String pattern = "yyyy-MM-dd HH:mm:ss";
		SimpleDateFormat sdf = new SimpleDateFormat(pattern, Locale.FRANCE);
		Date checkInDate = null;
		Date checkOutDate = null;
		
		try {
			checkInDate = sdf.parse(beginDate);
			checkOutDate = sdf.parse(endDate);
		} catch (ParseException e) {
			isOk = false;
		}
		
		if(checkOutDate.before(checkInDate)) isOk = false;

		if (isOk){
			Panel panel = new Panel();
			
			if (currentPanel != null) {
				panel = currentPanel;
			}
			
			panel.setDateBegin(new Timestamp(checkInDate.getTime()));
			panel.setDateEnd(new Timestamp(checkOutDate.getTime()));
			panel.setHotels(hotels);
			
			PanelDao.save(panel);
		}
	}

	/**
	 * Update an existing panel
	 * @param flight
	 * 		the flight linked to this panel
	 * @return
	 * 		form to update the panel
	 */
	public void edit(Flight flight){
		currentFlight = flight;
		currentPanel = checkExistingPanel();
		HttpUtils.redirect("editPanel");
	}
	
	/**
	 * Check if the actual flight already has a panel
	 * @return
	 */
	private Panel checkExistingPanel(){
		
		if (currentFlight == null){
			HttpUtils.redirect("listFlights");
		}
		
		Panel panel = PanelDao.getPanelByFlight(currentFlight);
	
		// update existing panel
		if (panel != null){
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm");
			beginDate = sdf.format(panel.getDateBegin());
			endDate = sdf.format(panel.getDateEnd());
			
			List<Integer> selectedHotels = new ArrayList<Integer>();
			for (Hotel hotel : panel.getHotels()) {
				selectedHotels.add(hotel.getId());	
			}
			inputHotels = ( selectedHotels.toArray(new Integer[selectedHotels.size()]));
		
		// it is a new panel
		} else {
			panel = new Panel();
			inputHotels = new Integer[hotels.size()];
			beginDate = "";
			endDate = "";
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

	public Panel getCurrentPanel() {
		return currentPanel;
	}

	public void setCurrentPanel(Panel currentPanel) {
		this.currentPanel = currentPanel;
	}
	
	
}
