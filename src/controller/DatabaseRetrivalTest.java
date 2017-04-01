package controller;

import org.junit.*;

import model.SearchModel;
import model.Trip;
import java.sql.Date;
import java.text.ParseException;
import java.util.Arrays;

import static org.junit.Assert.*;

public class DatabaseRetrivalTest {
	private SearchModel search1, search2, search3, search4;
	private Trip[] list1, list2, list3, list4;
	private DatabaseRetrival db;
	private String[] searchPm1, searchPm2, searchPm3, searchPm4;

	
	//private String email;
	//private int tripId;
	//private String adminId;
		
	@Before
	public void setUp() { 
		searchPm1 = new String[] {"Hallo", "2017-04-01", "2017-05-01", "Reykjavík", "1000"};
		search1  = new SearchModel(searchPm1);
		
		searchPm2 = new String[] {"Bless", "2017-04-01", "2017-05-01", "Reykjavík", "1000"};
		search2 = new SearchModel(searchPm2);
		
		searchPm3 = new String[] {"Hallo", "ehvbull", "meirabull", "Ísland", "ehvbull"};
		search3 = new SearchModel(searchPm3);
		
		searchPm4 = new String[]  {"", "", "", "", ""};
		search4 = new SearchModel(searchPm4);
		
		Date dateb = Date.valueOf("2017-04-01");
		Date datee = Date.valueOf("2017-05-01");
		Trip trip1 = new Trip("Hallo", dateb, datee, "sweet stuff", 100, 0, "Reykjavík", 1000, -1);
		Trip trip2 = new Trip("Bless", dateb, datee, "sweet stuff", 100, 0, "Reykjavík", 1000, -1);

		list1 = new Trip[] {trip1};
		list2 = new Trip[] {};
		
		db = new DatabaseRetrival();
	}
	
	@After
	public void tearDown() { 
		// For testing queryTrip
		search1 = null;
		search2 = null;
		search3 = null;
		search4 = null;
		
		list1 = null;
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
}