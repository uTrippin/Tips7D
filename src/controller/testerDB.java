package controller;

import java.sql.Date;
import model.Trip;

public class testerDB {
	private DatabaseUpdater dbU;
	
	public static void main(String args[]){
		DatabaseUpdater dbU = new DatabaseUpdater();
		
		//dbU.createTables();
		
		/*Trip tripA = new Trip("The Golden Circle", Date.valueOf("2017-04-09"), Date.valueOf("2017-04-09"), "This is a day trip where you will view the waterfall Gullfoss, see the Eurasion and American continental plates dividing in Þingvellir National Park, witness the erupting of Strokkur geyser, and more.", 50, 0, "Iceland", 10000, -1, 0);
		Trip tripB = new Trip("Mountain calming", Date.valueOf("2017-06-18"), Date.valueOf("2017-06-18"), "Expirience a soothing and balanced walk up Esja. The mountains Esja is just outside of Reykjavik and well suitable for people who like the outdoors and want a great view of the city.", 500, 0, "Esjan", 1000, -1, 0);
		Trip tripC = new Trip("Whale watching", Date.valueOf("2017-05-29"), Date.valueOf("2017-05-29"), "Experience the whales in their natural habitat, do not miss this unique opportunity before you leave. Full refund is guaranteed if you see no whales.", 20, 0, "Húsavík", 5000, -1, 0);

		dbU.insertTrip(tripA);
		dbU.insertTrip(tripB);
		dbU.insertTrip(tripC);*/
	}
}