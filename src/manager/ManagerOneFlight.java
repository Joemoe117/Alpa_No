package manager;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import bean.Flight;
import bean.Panel;
import dao.FlightDao;
import dao.PanelDao;

@ManagedBean
@SessionScoped
public class ManagerOneFlight {

	/**
	 * List of all existing flights
	 */
	public List<Flight> flights;

	public Panel panel;
	
	public Flight flight;
	/**
	 * Default constructor
	 */
	public ManagerOneFlight(){
		loadFlights();
		flight = flights.get(0);
		panel = PanelDao.getPanelByFlight(flight);
	}
	
	public void loadFlights(){
		flights = FlightDao.getAllFlights();
	}

	
	
	public Flight getFlight() {
		return flight;
	}
	
	public List<Flight> getFlights() {
		return flights;
	}

	public Panel getPanel() {
		return panel;
	}

	public void setPanel(Panel panel) {
		this.panel = panel;
	}
}
