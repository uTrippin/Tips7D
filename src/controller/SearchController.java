package controller;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import model.SearchModel;
import model.Trip;

public class SearchController {

	DatabaseRetrival dbRetrival = new DatabaseRetrival();

	public Trip[] findResults(String[] searchParam) throws ParseException {
		
		SearchModel search = createSearchModelObject(searchParam);
	
		Trip[] tripList = dbRetrival.queryTrip(search);
	
		return tripList;
	}
	
	
	public SearchModel createSearchModelObject(String[] searchParam) throws ParseException {
		String tripName;
		Date dateBegin;
		Date dateEnd;
		String location;
		int price;
				
		if(searchParam[0] == "") {
			tripName = ".*";
		} else {
			tripName = searchParam[0];
		}
		
		if(searchParam[1] == "") {
			dateBegin = new SimpleDateFormat("dd/MM/yyyy").parse("01/01/0001");  
		} else {
			try {
				dateBegin = new SimpleDateFormat("dd/MM/yyyy").parse(searchParam[1]);  
			} catch(Exception e) {
				dateBegin = new SimpleDateFormat("dd/MM/yyyy").parse("01/01/0001"); 
			}
		}
		
		dateBegin = Date.valueOf(searchParam[1]);
		dateEnd = Date.valueOf(searchParam[2]);
		
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
		
		SearchModel search = new SearchModel(tripName, dateBegin, dateEnd, location, price);
		
		return search;
	}
	
	
	public static void main(String args[]) {
		DatabaseRetrival dbRetrival = new DatabaseRetrival();
		
		String[] param = {"", "10/01/16", "11/01/16", "", "1500"};
		
		SearchController test = new SearchController();
		
		try {
			 Trip[] trips = test.findResults(param);
			 
			 for(int i=0; i < trips.length; i++) {
				System.out.println(trips[i]);
			}			 
		} catch(Exception e) {
			// do nothing
		}
	}
}