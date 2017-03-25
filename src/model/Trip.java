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
	
	public String getTripName() {
		return tripName;
	}
	
	public Date getDateBegin() {
		return dateBegin;
	}
	
	public Date getDateEnd() {
		return dateEnd;
	}
	
	public String getDescription() {
		return description;
	}
	
	public int getMaxPeople() {
		return maxPeople;
	}
	
	public int getMinPeople() {
		return minPeople;
	}
	
	public String getLocation() {
		return location;
	}
	
	public int getPrice() {
		return price;
	}
	
	public String getTripId() {
		return tripId;
	}
	
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