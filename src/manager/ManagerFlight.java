package manager;

import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.context.FacesContextFactory;

import bean.Flight;
import bean.Plane;
import dao.FlightDao;
import dao.PlaneDao;

@ManagedBean
@SessionScoped
public class ManagerFlight {

	/**
	 * List of all existing flights
	 */
	public List<Flight> flights;
	
	/**
	 * List of all existing planes
	 */
	public List<Plane> planes;
	
	public int inputIdAvion;
	
	public String inputDescription;
	
	/**
	 * Default constructor
	 */
	public ManagerFlight(){
		loadFlights();
		planes = PlaneDao.getAllPlanes();
	}
	
	/**
	 * Create a flight in the database with the value given in inputs
	 */
	public void createFlight(){
		Flight flight = new Flight();
		// TODO check form input
		
		// get plane by ID
		flight.setPlane(PlaneDao.getById(inputIdAvion));
		
		
		flight.setDescription(inputDescription);
		
		PlaneDao.add(flight);
		
		// need to reload flights
		loadFlights();
	}
	
	/**
	 * Display the details of a flight
	 */
	public void get(Flight f){
		System.out.println("Test ");
		System.out.println(f.toString());
	}
	
	/**
	 * Delete a flight
	 */
	public void delete(Flight f){
		System.out.println("delete a flight");
		FlightDao.delete(f);
		
		loadFlights();
	}
	
	
	public void loadFlights(){
		flights = FlightDao.getAllFlights();
	}

	public List<Flight> getFlights() {
		return flights;
	}

	public void setFlights(List<Flight> flights) {
		this.flights = flights;
	}
	
	public int getInputIdAvion() {
		return inputIdAvion;
	}

	public void setInputIdAvion(int inputIdAvion) {
		this.inputIdAvion = inputIdAvion;
	}

	public String getInputDescription() {
		return inputDescription;
	}

	public void setInputDescription(String inputDescription) {
		this.inputDescription = inputDescription;
	}

	public List<Plane> getPlanes() {
		return planes;
	}

	public void setPlanes(List<Plane> planes) {
		this.planes = planes;
	}
	
	
}
