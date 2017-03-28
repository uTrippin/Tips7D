package model;

public class BookingModel {
	
	private String bookingId;
	private String tripId;
	private String bookerEmail;
	private int numPeople;
	private int bookerSSN;
	
	public BookingModel (String tripId, String bookerEmail, int numPeople, int bookerSSN) {
		this.tripId = tripId;
		this.bookerEmail = bookerEmail;
		this.numPeople = numPeople;
		this.bookerSSN = bookerSSN;
	}
	
	public String getTripId() {
		return tripId;
	}
	
	public String getBookerEmail() {
		return bookerEmail;
	}
	
	public int getNumPeople() {
		return numPeople;
	}
	
	public int getBookerSSN() {
		return bookerSSN;
	}
}
