package dao;

import java.util.List;

import bean.Hotel;

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
		/*
		List<Flight> flights = FlightDao.getAllFlights();
		for (Flight flight : flights) {
			System.out.println(flight.getDescription());
		}
		*/
		/*
		List<Hotel> hotels = HotelDao.getAllHotels();
		for (Hotel hotel : hotels) {
			System.out.println(hotel.getName());
		}
		*/
		
		// Add hotel
		/*
		Hotel hotel = new Hotel();
		hotel.setName("Hotel Wonderland");
		HotelDao.add(hotel);
		*/
	}
}
