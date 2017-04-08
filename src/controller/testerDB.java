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
		
		//BookingModel bookz = dbR.queryPersonBooking("stellarut95@gmail.com")[0];
		//Trip trip1 = new Trip("Walk in Reykjavík", Date.valueOf("2017-04-01"), Date.valueOf("2017-05-01"), "lollað dæmi", 200, 50, "Reykjavík", 2000, -1);
		//BookingModel booking = new BookingModel(-1, -1, "stellarut95@gmail.com", 1, 1234567890);
		//dbU.insertBooking(booking);
		//System.out.println(dbR.simpleQuery(".*"));
		
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
		System.out.println(dbR.simpleQuery("ksk12@hi.is"));

	}
}