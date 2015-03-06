package manager;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import dao.FlightDao;
import bean.Flight;

@ManagedBean
@SessionScoped
public class ManagerFlight {

	/**
	 * List of all existing flights
	 */
	public List<Flight> flights;
	
	/**
	 * Default constructor
	 */
	public ManagerFlight(){
		flights = FlightDao.getAllFlights();
	}

	public List<Flight> getFlights() {
		return flights;
	}

	public void setFlights(List<Flight> flights) {
		this.flights = flights;
	}
	
	
}
