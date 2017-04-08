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
		
		String s[] = dbR.simpleQuery();
		for(int i= 0; i< 10; i++){
			System.out.println(s[i]);
		}
		
	}
}