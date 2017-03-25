package controller;

import model.BookingModel;

public class BookingController {

	
	public boolean bookTrip(String[] tripInfo) { // tripInfo er listi af tripId, bookerEmail, numPEople, bookerSSN
		
		boolean bookingComplete = false;
		
		
		if(bookingComplete) {
			sendVerification(tripInfo[1]);
		}
		
		return bookingComplete;	
	}
	
	public boolean sendVerification(String tripId) {
		
		boolean verificationSent;
		
		BookingModel[] tripBookings = DatabaseRetrival.queryTripBooking(tripId)
				
		for(int i=0; i < tripBookings.length; i++) {
			contact(tripBookings[i].getBookerEmail());
		}
		
		return verificationSent;
	}
	
	public void contact(String email) {
		
		System.out.println(email);
		
	}
}