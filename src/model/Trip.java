package model;

import java.util.Date;

public class Trip {
	
	private String tripName;
	private Date dateBegin;
	private Date dateEnd;
	private String description;
	private int maxPeople;
	private int minPeople;
	private String location;
	private int price;
	private String tripId;
	
	public Trip(String tripName, Date dateBegin, Date dateEnd, String description, int maxPeople, int minPeople, String location, int price, String tripId) {
		this.tripName = tripName;
		this.dateBegin = dateBegin;
		this.dateEnd = dateEnd;
		this.description = description;
		this.maxPeople = maxPeople;
		this.minPeople = minPeople;
		this.location = location;
		this.price = price;
		this.tripId = tripId;
	}
	
	// GET
	
	private String getTripName() {
		return tripName;
	}
	
	private Date getDateBegin() {
		return dateBegin;
	}
	
	private Date getDateEnd() {
		return dateEnd;
	}
	
	private String getDescription() {
		return description;
	}
	
	private int getMaxPeople() {
		return maxPeople;
	}
	
	private int getMinPeople() {
		return minPeople;
	}
	
	private String getLocation() {
		return location;
	}
	
	private int getPrice() {
		return price;
	}
	
	private String getTripId() {
		return tripId;
	}
	
	// SET
	
	private void setTripNme(String tripName) {
		this.tripName = tripName;
	}
	
	private void setDateBegin(Date dateBegin) {
		this.dateBegin = dateBegin;
	}
	
	private void setDateEnd(Date dateEnd) {
		this.dateEnd = dateEnd;
	}
	
	private void setDescription(String description) {
		this.description = description;
	}
	
	private void setMaxPeople(int maxPeople) {
		this.maxPeople = maxPeople;
	}
	
	private void setMinPeople(int minPeople) {
		this.minPeople = minPeople;
	}
	
	private void setLocation(String location) {
		this.location = location;
	}
	
	private void setPrice(int price) {
		this.price = price;
	}
	
	private void setTripId(String tripId) {
		this.tripId = tripId;
	}
}