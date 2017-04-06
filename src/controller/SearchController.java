package controller;

import java.text.ParseException;

import model.SearchModel;
import model.Trip;

public class SearchController {

	private static DatabaseRetrival dbRetrival = new DatabaseRetrival();

	public static Trip[] findResults(String[] searchParam) throws ParseException {
		
		SearchModel search = new SearchModel(searchParam);
				
		Trip[] tripList = dbRetrival.queryTrip(search);
	
		return tripList;
	}
}