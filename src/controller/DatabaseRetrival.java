package controller;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;

import model.BookingModel;
import model.SearchModel;
import model.Trip;

public class DatabaseRetrival {
	private Connection connection = null; //Database connection
	
	//Constructor for the DatabaseRetrival
	public DatabaseRetrival(){
		//Connect to the postgresql driver
		try {

			Class.forName("org.postgresql.Driver");

		} catch (ClassNotFoundException e) {

			System.out.println("Where is your PostgreSQL JDBC Driver? "
					+ "Include in your library path!");
			e.printStackTrace();
			return;
		}
		
		//Setting the database parameters
		String URL = "jdbc:postgresql://kuldbinstance.czsqr6wtrtap.us-west-2.rds.amazonaws.com:5432/kuldb";
		String USER = "kuluser";
		String PASS = "kulpassword";
		
		//Connecting to the AWS database
		try {
			connection = DriverManager.getConnection(URL, USER, PASS);
		} catch (SQLException e) {
			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();
			return;
		}

		if (connection != null) {
			System.out.println("You made it, take control your database now!");
		} else {
			System.out.println("Failed to make connection!");
		}
	}
	
	//Querying the TRIP table
	public Trip[] queryTrip(SearchModel search){
		Trip [] tripList;
		
		try{		
			String selectSQL = "SELECT * FROM TRIP WHERE tripName = ? AND dateBegin = ? AND dateEnd = ? AND location = ?"
					+ "AND price <= ?";
			PreparedStatement preparedStatement;

			preparedStatement = connection.prepareStatement(selectSQL, ResultSet.TYPE_SCROLL_SENSITIVE, 
                    ResultSet.CONCUR_UPDATABLE);
			preparedStatement.setString(1, search.getTripName());
			preparedStatement.setDate(2, search.getDateBegin());
			preparedStatement.setDate(3, search.getDateEnd());
			preparedStatement.setString(4, search.getLocation());
			preparedStatement.setInt(5, search.getPrice());
			ResultSet rs = preparedStatement.executeQuery();
			tripList = createTriplist(rs);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			tripList = new Trip[0];
		}
		
		return tripList;	
	}
	
	//Creates a list of Trip objects
	private Trip[] createTriplist(ResultSet rs){
		int n = 0;
		try{
			//Get the length of the results set
			boolean b = rs.last();
			if(b){
			    n = rs.getRow();
			}
			rs.beforeFirst();
		} catch(SQLException e){
			e.printStackTrace();
		}	
		//Create a list of Trip objects of the correct size
		Trip[] tripList = new Trip[n];
		
		try{
			int i = 0;
			while (rs.next()) {
				String tripName = rs.getString("tripName");
				Date dateBegins = rs.getDate("dateBegin");
				Date dateEnds = rs.getDate("dateEnd");
				String desc = rs.getString("description");
				int maxPeople = rs.getInt("maxPeople");
				int minPeople = rs.getInt("minPeople");
				String location = rs.getString("location");
				int price = rs.getInt("price");
				int tripId = rs.getInt("tripId");
				
				tripList[i] = new Trip(tripName, dateBegins, dateEnds, desc, maxPeople, minPeople, location, price, tripId);
				i++;
			}
		} catch(SQLException e){
			e.printStackTrace();
		}
		
		return tripList;
	}
	
	//Queries BOOKING table to get info about a person
	public BookingModel[] queryPersonBooking(String email){
		BookingModel [] bookingList;
		
		String selectSQL = "SELECT * FROM BOOKING WHERE bookerEmail = ?";
		PreparedStatement preparedStatement;
		try {
			preparedStatement = connection.prepareStatement(selectSQL, ResultSet.TYPE_SCROLL_SENSITIVE, 
                    ResultSet.CONCUR_UPDATABLE);
			preparedStatement.setString(1, email);
			ResultSet rs = preparedStatement.executeQuery();
			bookingList = createBookinglist(rs);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			bookingList = new BookingModel[0];
		}
		
		return bookingList;
	}
	
	//Queries the BOOKING table to get info about a trip
	public BookingModel[] queryTripBooking(int tripId){
		BookingModel [] bookingList;
		
		String selectSQL = "SELECT * FROM BOOKING WHERE tripId = ?";
		PreparedStatement preparedStatement;
		try {
			preparedStatement = connection.prepareStatement(selectSQL, ResultSet.TYPE_SCROLL_SENSITIVE, 
                    ResultSet.CONCUR_UPDATABLE);
			preparedStatement.setInt(1, tripId);
			ResultSet rs = preparedStatement.executeQuery();
			bookingList = createBookinglist(rs);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			bookingList = new BookingModel[0];
		}
		
		return bookingList;
	}
	
	//Creates a list of BookingModel objects 
	private BookingModel[] createBookinglist(ResultSet rs){
		BookingModel[] bookingList;
		//Get the length of the results set
		int n = 0;
		try{
			boolean b = rs.last();
			if(b){
			    n = rs.getRow();
			}
			rs.beforeFirst();
		} catch(SQLException e){
			e.printStackTrace();
		}
		
		
		try{
			//Create a list of Trip objects
			bookingList = new BookingModel[n];
			
			int i = 0;
			while (rs.next()) {
				int bookingId = rs.getInt("bookingId");
				int tripId = rs.getInt("tripId");
				String bookerEmail = rs.getString("bookerEmail");
				int numPeople = rs.getInt("numPeople");
				int bookerSSN = rs.getInt("bookerSSN");
				bookingList[i] = new BookingModel(bookingId, tripId, bookerEmail, numPeople, bookerSSN);
				i++;
			}
			
			return bookingList;
		} catch (SQLException e){
			bookingList = new BookingModel[0];
			return bookingList;
		}
	}
	
	//Queries ADMIN table to get info about admin
	public String queryAdmin(String adminId){
		String pw = "";
		String selectSQL = "SELECT * FROM ADMIN WHERE adminId = ?";
		PreparedStatement preparedStatement;
		try {
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setString(1, adminId);
			ResultSet rs = preparedStatement.executeQuery();
			
			while (rs.next()) {
				pw = rs.getString("adminPassword");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return pw;
	}
	
	//test function
	public String simpleQuery(){
		try{		
			String selectSQL = "SELECT * FROM BOOKING";
			PreparedStatement preparedStatement;

			preparedStatement = connection.prepareStatement(selectSQL);
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next()){
				return rs.getString("bookerEmail");
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String a = "blabla";
		return a;
		
			
	}

}
