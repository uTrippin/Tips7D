package model;

import java.sql.Date;

public class SearchModel {
	
	private String tripName;
	private Date dateBegin;
	private Date dateEnd;
	private String location;
	private int price;
	
	public SearchModel(String tripName, Date dateBegin, Date dateEnd, String location, int price) {
		this.tripName = tripName;
		this.dateBegin = dateBegin;
		this.dateEnd = dateEnd;
		this.location = location;
		this.price = price;		
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
	
	public String getLocation() {
		return location;
	}
	
	public int getPrice() {
		return price;
	}	
}
