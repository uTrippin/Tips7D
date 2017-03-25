package controller;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseUpdater {
	private Connection connection = null;
	private String URL = "jdbc:postgresql://kuldbinstance.czsqr6wtrtap.us-west-2.rds.amazonaws.com:5432/kuldb";
	private String USER = "kuluser";
	private String PASS = "kulpassword";
	
	public DatabaseUpdater(){
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
	
	public static void main(String[] argv) {
		
		
		/*String insertTableSQL = "INSERT INTO TEST"
				+ "(id, tester) VALUES"
				+ "(?,?)";
		PreparedStatement preparedStatement;
		try {
			preparedStatement = connection.prepareStatement(insertTableSQL);
			preparedStatement.setInt(1, 100);
			preparedStatement.setString(2, "KariKul");
			// execute insert SQL stetement
			preparedStatement .executeUpdate();
			System.out.print("Awwww yeeeeaaaaaaaah");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/

		
	}
	
	private void createTables(){
		Statement stmt = null;
		try{
			stmt = connection.createStatement();
		      
		      String sql1 = "CREATE TABLE TRIP " +
		                   "(tripId VARCHAR(256) NOT NULL, " +
		                   " tripName VARCHAR(256) NOT NUll, " +
		                   " dateBegin DATE NOT NULL, " +
		                   " dateEnd DATE NOT NULL, " +
		                   " description VARCHAR(2000), " +
		                   " maxPeople INT NOT NULL UNSIGNED, " +
		                   " minPeople INT NOT NULL UNSIGNED, " +
		                   " location VARCHAR(256) NOT NULL, " +
		                   " price INT NOT NULL)";
		                   

		      stmt.executeUpdate(sql1);
		      System.out.println("Created table in given database...");
		   }catch(SQLException se){
		      //Handle errors for JDBC
		      se.printStackTrace();
		}
	}
}
