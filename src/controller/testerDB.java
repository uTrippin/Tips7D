package controller;

import java.sql.Date;

import model.SearchModel;
import model.Trip;

public class testerDB {
	private DatabaseRetrival dbR;
	private DatabaseUpdater dbU;
	
	public static void main(String args[]){
		DatabaseUpdater dbU = new DatabaseUpdater();
		DatabaseRetrival dbR = new DatabaseRetrival();
		Date dateBegin = new Date(0);
		Date dateEnd = new Date(200000);
		Trip A = new Trip("Cool Walk", dateBegin, dateEnd, "An awesome walk along the lake of fire", 0, 10, "Iceland", 100000, "trip1");
		
		dbU.insertTrip(A);
		
		SearchModel B = new SearchModel("Cool Walk", dateBegin, dateEnd, "Iceland", 100000);
		Trip[] C = dbR.queryTrip(B);
		
		System.out.println(C[0].getDescription());
		//System.out.println(dbR.simpleQuery());
		
	}
}
