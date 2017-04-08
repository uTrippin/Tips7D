package controller;

import java.security.SecureRandom;
import java.util.Arrays;

import model.Trip;

public class Admin {
	private static boolean isLoggedIn = false;
	private static DatabaseRetrival dbR = new DatabaseRetrival();
	private static DatabaseUpdater dbU = new DatabaseUpdater();
	
	public static boolean logIn(String username, String password){
		String[] adminCred = dbR.queryAdmin(username);
		String hashPw = (String) adminCred[0];
		String hashSalt = (String) adminCred[1];
		
		byte[] hashPwB = hashPw.getBytes();
		byte[] hashPwS = hashSalt.getBytes();
		
		char[] pwArray = password.toCharArray();
		
		byte hashTest[] = Password.hashPassword(pwArray, hashPwS, 10, 256);
		
		if(Arrays.equals(hashTest, hashPwB)){
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
		if(isLoggedIn){
			SecureRandom random = new SecureRandom();
		    byte bytes[] = new byte[20];
		    random.nextBytes(bytes);
		    byte salt[] = bytes;
		    String saltString = salt.toString();
			dbU.insertAdmin(username, password, saltString);
			return true;
		}
		else{
			return false;
		}
	}

}
