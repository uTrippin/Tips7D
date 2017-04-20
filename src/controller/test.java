package controller;

import model.SearchModel;
import model.Trip;

public class test {
	public static void testfall() {
		DatabaseRetrival dbR = new DatabaseRetrival();
		DatabaseUpdater dbU = new DatabaseUpdater();
		/*dbU.sampleQuery();
		String[] searchPm = new String[] {"", "", "", "", ""};
		
		SearchModel searchmodel = new SearchModel(searchPm);
		Trip[] trips = dbR.queryTrip(searchmodel);
		
		for(int i = 0; i < trips.length; i++) {
			System.out.println(trips[i].getTripName() + "\t" + trips[i].getDescription());
		}*/
		dbU.sampleQuery();
	}
	
	public static void main(String[] args) {
		testfall();
		System.out.println("done");
	}
}
