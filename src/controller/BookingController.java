package controller;

import model.BookingModel;

public class BookingController {
	
	DatabaseRetrival dbRetrival = new DatabaseRetrival();
	DatabaseUpdater dbUpdater = new DatabaseUpdater();

	
	public boolean bookTrip(String[] tripInfo) { // tripInfo er listi af tripId, bookerEmail, numPEople, bookerSSN
		
		boolean bookingComplete = false;
		
		// missing
		// �tf�ra fall � db updater til a� b�ta vi� b�kun, 
		// 
		
		
				
		
		if(bookingComplete) {
			sendVerification(tripInfo[1]);
		}
		
		return bookingComplete;	
	}
	
	public void sendVerification(String tripId) {
			
		BookingModel[] tripBookings = dbRetrival.queryTripBooking(tripId);
		
		for(int i=0; i < tripBookings.length; i++) {
			contact(tripBookings[i].getBookerEmail());
		}
	}
	
	public void contact(String email) {
		
		System.out.println(email);
		
	}
}