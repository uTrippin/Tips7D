package controller;

import java.security.SecureRandom;
import java.util.Arrays;

import model.Trip;

/*
 * Example account:
 * User: Trips7D
 * Password: 12345
 */

public class Admin {
	private static boolean isLoggedIn = false;
	private static DatabaseRetrival dbR = new DatabaseRetrival();
	private static DatabaseUpdater dbU = new DatabaseUpdater();

	public static boolean logIn(String username, String password){
		byte[] adminPw = dbR.queryAdminPw(username);
		byte[] adminSalt = dbR.queryAdminSalt(username);
		char[] pwArray = password.toCharArray();
		byte hashTest[] = Password.hashPassword(pwArray, adminSalt, 10, 256);

		if(Arrays.equals(hashTest, adminPw)){
			isLoggedIn = true;
			return true;
		}
		else{
			return false;
		}

	}

	public static boolean addTrip(Trip trip){
		if(isLoggedIn){
			dbU.insertTrip(trip);
			return true;
		}
		else{
			return false;
		}
	}

	public static boolean addAdmin(String username, String password){
		if(isLoggedIn) {
			SecureRandom random = new SecureRandom();
			byte bytes[] = new byte[20];
			random.nextBytes(bytes);
			byte salt[] = bytes;
			char[] password2 = password.toCharArray();
			byte pw[] = Password.hashPassword(password2, salt, 10, 256);

			dbU.insertAdmin(username, pw, salt);

			return true;
		}
		else {
			return false;
		}
	}

	public static boolean getIsLoggedIn() {
		return isLoggedIn;
	}

}
