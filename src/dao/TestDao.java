package dao;

import java.util.List;

import bean.Flight;
import bean.LinkPanelHotel;
import bean.Panel;

public class TestDao {

	public static void main(String [] args) {
		/*
		boolean exists = AdministratorDao.connect("admin", "password");
		System.out.println(exists);
		*/
		
		/*
		List<Plane> planes = PlaneDao.getAllPlanes();
		
		for (Plane plane : planes) {
			System.out.println(plane.getName());
			for (Flight flight : plane.getFlights()) {
				System.out.println(flight.getDescription());
			}

		}
		*/
		
		// Liste des vols
		
		List<Flight> flights = FlightDao.getAllFlights();
		for (Flight flight : flights) {
			System.out.println(flight.getDescription());
		}
		
		
		// Liste des panels
		Panel panel = PanelDao.getPanelByFlight(flights.get(0));
		for (LinkPanelHotel link : panel.getPanels()) {
			System.out.println(link.getHotel().getName());
		}
		
	}
}
