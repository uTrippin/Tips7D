package controller;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;

public class DatabaseRetrival {
	public static void main(String[] argv) {

		System.out.println("-------- PostgreSQL "
				+ "JDBC Connection Testing ------------");

		try {

			Class.forName("org.postgresql.Driver");

		} catch (ClassNotFoundException e) {

			System.out.println("Where is your PostgreSQL JDBC Driver? "
					+ "Include in your library path!");
			e.printStackTrace();
			return;

		}

		System.out.println("PostgreSQL JDBC Driver Registered!");

		Connection connection = null;
		
		String URL = "jdbc:postgresql://kuldbinstance.czsqr6wtrtap.us-west-2.rds.amazonaws.com:5432/kuldb";
		String USER = "kuluser";
		String PASS = "kulpassword";
		
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

}
