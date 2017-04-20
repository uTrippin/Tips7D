package model;

import java.sql.Date;

public class SearchModel {

	private String tripName;
	private Date dateBegin;
	private Date dateEnd;
	private String location;
	private int price;

	public SearchModel(String[] searchParam) {
		String tripName;
		Date dateBegin;
		Date dateEnd;
		String location;
		int price;

		if("".equals(searchParam[0])) {
			tripName = ".*";
		} else {
			tripName = searchParam[0];
		}

		try {
			dateBegin = Date.valueOf(searchParam[1]);
		} catch(Exception e) {
			dateBegin = Date.valueOf("2017-01-01"); // Format: "yyyy-mm-dd"
		}

		try {
			dateEnd = Date.valueOf(searchParam[2]);
		} catch(Exception e) {
			dateEnd = Date.valueOf("2030-12-24");
		}

		if(searchParam[3] == "") {
			location = ".*";
		} else {
			location = searchParam[3];
		}

		if(searchParam[4] == "") {
			price = Integer.MAX_VALUE;
		} else {
			try {
				price = Integer.parseInt(searchParam[4]);
			} catch(Exception e) {
				price = Integer.MAX_VALUE;
			}
		}

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
