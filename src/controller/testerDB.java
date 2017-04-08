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
		
		//dbU.createTables();
		
		/*String s[] = dbR.simpleQuery();
		for(int i= 0; i< 10; i++){
			System.out.println(s[i]);
		}*/
		
		/*Trip trip1 = new Trip("Hallo", Date.valueOf("2017-04-01"), Date.valueOf("2017-05-01"), "sweet stuff", 100, 0, "Reykjavík", 1000, -1, 0);
		Trip trip2 = new Trip("Walk in Reykjavík", Date.valueOf("2017-04-01"), Date.valueOf("2017-05-01"), "lollað dæmi", 200, 50, "Reykjavík", 2000, -1, 0);
		
		dbU.insertTrip(trip1);
		dbU.insertTrip(trip2);*/
		
		dbR.simpleQuery();
		
	}
}