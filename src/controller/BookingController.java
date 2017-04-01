package controller;

import model.BookingModel;

public class BookingController {
	
	DatabaseRetrival dbRetrival = new DatabaseRetrival();
	DatabaseUpdater dbUpdater = new DatabaseUpdater();

	
	public boolean bookTrip(String[] tripInfo) { // tripInfo er listi af tripId, bookerEmail, numPEople, bookerSSN
		
		boolean bookingComplete = false;
		
		BookingModel booking = new BookingModel(-1, Integer.parseInt(tripInfo[0]), tripInfo[1], Integer.parseInt(tripInfo[2]), Integer.parseInt(tripInfo[3]));
				
		bookingComplete = dbUpdater.insertBooking(booking);
				
		if(bookingComplete) {
			sendVerification(Integer.parseInt(tripInfo[1]));
		}
		
		return bookingComplete;	
	}
	
	public void sendVerification(int tripId) {
			
		BookingModel[] tripBookings = dbRetrival.queryTripBooking(tripId);
		
		for(int i=0; i < tripBookings.length; i++) {
			contact(tripBookings[i].getBookerEmail());
		}
	}
	
	public void contact(String email) {
		
		System.out.println(email);
		
	}
}