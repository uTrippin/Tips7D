package controller;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;

import model.SearchModel;
import model.Trip;

public class DatabaseRetrival {
	
	private static Connection connection = null; //Database connection
	
	public static void main(String[] argv) {
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
		
		//query();
		
	}
	
	//Function for querying the database
	public static Trip[] queryTrip(SearchModel search){
		
		Trip [] tripList;
		//tripName
		//dateBegin
		//dateEnd
		//location
		//price
		
		String selectSQL = "SELECT * FROM TRIP WHERE tripName = ? AND dateBegin = ? AND dateEnd = ? AND location = ?"
				+ "AND price = ?";
		PreparedStatement preparedStatement;
		try {
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setString(1, search.getTripName());
			preparedStatement.setDate(2, (Date) search.getDateBegin());
			preparedStatement.setDate(3, (Date) search.getDateEnd());
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
	
	private static Trip[] createTriplist(ResultSet rs){
		//Get the length of the results set
		boolean b = rs.last();
		int n = 0;
		if(b){
		    n = rs.getRow();
		}
		
		//Create a list of Trip objects
		Trip[] tripList = new Trip[n];
		
		int i = 0;
		while (rs.next()) {
			String tripName = rs.getString("tripName");
			Date dateBegins = rs.getDate("dateBegin");
			Date dateEnds = rs.getDate("dateEnd");
			String location = rs.getString("location");
			int price = rs.getInt("price");
			tripList[i] = new Trip(tripName, dateBegins, dateEnds, location, price);
			
		}
		
		return tripList;
	}
	
	public static void queryBooking(SearchModel search){
		
	}
	
	public static void queryAdmin(SearchModel search){
		
	}

}
