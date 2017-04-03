package controller;

import org.junit.*;
import java.sql.Date;
import java.text.ParseException;
import java.util.Arrays;
import static org.junit.Assert.*;
import model.Trip;

public class SearchControllerTester {
	private Trip[] list1, list2, list3;
	private DatabaseRetrival db;
	private String[] searchPm1, searchPm2, searchPm3, searchPm4, searchPm5;

	@Before
	public void setUp() { 
		searchPm1 = new String[] {"Hallo", "2017-04-01", "2017-05-01", "Reykjavík", "1000"};		
		searchPm2 = new String[] {"Bless", "2017-04-01", "2017-05-01", "Reykjavík", "1000"};	
		searchPm3 = new String[] {"Hallo", "invalid", "invalid", "Reykjavík", "invalid"};		
		searchPm4 = new String[]  {"", "", "", "", ""};
		searchPm5 = new String[] {"", "", "", "Reykjavík", ""};
		
		Trip trip1 = new Trip("Hallo", Date.valueOf("2017-04-01"), Date.valueOf("2017-05-01"), "sweet stuff", 100, 0, "Reykjavík", 1000, -1);
		Trip trip2 = new Trip("Bless", Date.valueOf("2017-04-01"), Date.valueOf("2017-05-01"), "sweet stuff", 100, 0, "Reykjavík", 1000, -1);
		Trip trip3 = new Trip("Walk in Reykjavík", Date.valueOf("2017-04-01"), Date.valueOf("2017-05-01"), "lollað dæmi", 200, 50, "Reykjavík", 2000, -1);
				
		list1 = new Trip[] {trip1};
		list2 = new Trip[] {};
		list3 = new Trip[] {trip1, trip3};
		
		db = new DatabaseRetrival();
	}
	
	@After
	public void tearDown() { 
		searchPm1 = null;
		searchPm2 = null;
		searchPm3 = null;
		searchPm4 = null;
		searchPm5 = null;
		
		list1 = null;
		list2 = null;
		list3 = null;
		db = null;
	}
	
	@Test
	public void testExistingTrip() throws ParseException {
		Trip[] listFromDB = SearchController.findResults(searchPm1);
		assertEquals(list1.length, listFromDB.length);
		
		for(int i=0; i < list1.length; i++) {
			assertEquals(list1[i].getTripName(), listFromDB[i].getTripName());
			assertEquals(list1[i].getDateBegin(), listFromDB[i].getDateBegin());
			assertEquals(list1[i].getDateEnd(), listFromDB[i].getDateEnd());
			assertEquals(list1[i].getDescription(), listFromDB[i].getDescription());
			assertEquals(list1[i].getMaxPeople(), listFromDB[i].getMaxPeople());
			assertEquals(list1[i].getMinPeople(), listFromDB[i].getMinPeople());
			assertEquals(list1[i].getLocation(), listFromDB[i].getLocation());
			assertEquals(list1[i].getPrice(), listFromDB[i].getPrice());
		}		
	}
	
	@Test
	public void testWithValidNoneExistingTrip() throws ParseException {
		Trip[] listFromDB = SearchController.findResults(searchPm2);
		assertEquals(list2.length, listFromDB.length);
		
		for(int i=0; i < list2.length; i++) {
			assertEquals(list2[i].getTripName(), listFromDB[i].getTripName());
			assertEquals(list2[i].getDateBegin(), listFromDB[i].getDateBegin());
			assertEquals(list2[i].getDateEnd(), listFromDB[i].getDateEnd());
			assertEquals(list2[i].getDescription(), listFromDB[i].getDescription());
			assertEquals(list2[i].getMaxPeople(), listFromDB[i].getMaxPeople());
			assertEquals(list2[i].getMinPeople(), listFromDB[i].getMinPeople());
			assertEquals(list2[i].getLocation(), listFromDB[i].getLocation());
			assertEquals(list2[i].getPrice(), listFromDB[i].getPrice());
		}		
	}
	
	@Test
	public void testWithNonvalidParameters() throws ParseException {
		Trip[] listFromDB = SearchController.findResults(searchPm3);
		assertEquals(list1.length, listFromDB.length);
		
		for(int i=0; i < list1.length; i++) {
			assertEquals(list1[i].getTripName(), listFromDB[i].getTripName());
			assertEquals(list1[i].getDateBegin(), listFromDB[i].getDateBegin());
			assertEquals(list1[i].getDateEnd(), listFromDB[i].getDateEnd());
			assertEquals(list1[i].getDescription(), listFromDB[i].getDescription());
			assertEquals(list1[i].getMaxPeople(), listFromDB[i].getMaxPeople());
			assertEquals(list1[i].getMinPeople(), listFromDB[i].getMinPeople());
			assertEquals(list1[i].getLocation(), listFromDB[i].getLocation());
			assertEquals(list1[i].getPrice(), listFromDB[i].getPrice());
		}	
	}
	
	@Test
	public void testWithEmptyParameters() throws ParseException {
		Trip[] listFromDB = SearchController.findResults(searchPm4);
		assertEquals(list3.length, listFromDB.length);
		
		for(int i=0; i < list3.length; i++) {
			assertEquals(list3[i].getTripName(), listFromDB[i].getTripName());
			assertEquals(list3[i].getDateBegin(), listFromDB[i].getDateBegin());
			assertEquals(list3[i].getDateEnd(), listFromDB[i].getDateEnd());
			assertEquals(list3[i].getDescription(), listFromDB[i].getDescription());
			assertEquals(list3[i].getMaxPeople(), listFromDB[i].getMaxPeople());
			assertEquals(list3[i].getMinPeople(), listFromDB[i].getMinPeople());
			assertEquals(list3[i].getLocation(), listFromDB[i].getLocation());
			assertEquals(list3[i].getPrice(), listFromDB[i].getPrice());
		}
	}
	
	@Test
	public void testWithMoreThanOneResult() throws ParseException {
		Trip[] listFromDB = SearchController.findResults(searchPm5);
		assertEquals(list3.length, listFromDB.length);
		
		for(int i=0; i < list3.length; i++) {
			assertEquals(list3[i].getTripName(), listFromDB[i].getTripName());
			assertEquals(list3[i].getDateBegin(), listFromDB[i].getDateBegin());
			assertEquals(list3[i].getDateEnd(), listFromDB[i].getDateEnd());
			assertEquals(list3[i].getDescription(), listFromDB[i].getDescription());
			assertEquals(list3[i].getMaxPeople(), listFromDB[i].getMaxPeople());
			assertEquals(list3[i].getMinPeople(), listFromDB[i].getMinPeople());
			assertEquals(list3[i].getLocation(), listFromDB[i].getLocation());
			assertEquals(list3[i].getPrice(), listFromDB[i].getPrice());
		}
	}
}