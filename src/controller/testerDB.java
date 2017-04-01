package controller;

import java.sql.Date;

import model.BookingModel;
import model.SearchModel;
import model.Trip;

public class testerDB {
	private DatabaseRetrival dbR;
	private DatabaseUpdater dbU;
	
	public static void main(String args[]){
		DatabaseUpdater dbU = new DatabaseUpdater();
		DatabaseRetrival dbR = new DatabaseRetrival();
		
		System.out.println(dbR.simpleQuery(".*"));
		
		/*Date dateBegin = new Date(0);
		Date dateEnd = new Date(200000);
		
		
		SearchModel B = new SearchModel("Cool Walk", dateBegin, dateEnd, "Iceland", 100000);
		Trip[] C = dbR.queryTrip(B);
		
		System.out.println(C[0].getDescription());*/
		
		/*BookingModel D = new BookingModel(-1,1, "karisucks@yeeebitch.com", 1, 69696969);
		dbU.insertBooking(D);
		BookingModel[] E = dbR.queryTripBooking(1);
		for(int i=0; i < E.length; i++) {
			System.out.println(E[i].getBookerEmail());
		}*/

	}
}