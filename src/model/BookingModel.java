package model;

public class BookingModel {
	
	private int bookingId;
	private int tripId;
	private String bookerEmail;
	private int numPeople;
	private int bookerSSN;
	
	public BookingModel(int bookingId, int tripId, String bookerEmail, int numPeople, int bookerSSN) {
		this.tripId = tripId;
		this.bookerEmail = bookerEmail;
		this.numPeople = numPeople;
		this.bookerSSN = bookerSSN;
	}
	
	public int getBookingId() {
		return bookingId;
	}
	
	public int getTripId() {
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
