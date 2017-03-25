package controller;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import model.SearchModel;
import model.Trip;

public class SearchController {

	DatabaseRetrival dbRetrival = new DatabaseRetrival();

	public Trip[] findResults(String[] searchParam) {
		
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
		
		if(searchParam[2] == "") {
			dateEnd = new SimpleDateFormat("dd/MM/yyyy").parse("31/12/3000");  
		} else {
			try {
				dateEnd = new SimpleDateFormat("dd/MM/yyyy").parse(searchParam[2]);  
			} catch(Exception e) {
				dateEnd = new SimpleDateFormat("dd/MM/yyyy").parse("31/12/3000");   
			}
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
		
		SearchModel search = new SearchModel(tripName, dateBegin, dateEnd, location, price);
		
		return search;
	}
}