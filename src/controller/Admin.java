package controller;

import java.io.UnsupportedEncodingException;
import java.security.SecureRandom;
import java.util.Arrays;

import model.Trip;

public class Admin {
	private static boolean isLoggedIn = false;
	private static DatabaseRetrival dbR = new DatabaseRetrival();
	private static DatabaseUpdater dbU = new DatabaseUpdater();
	
	public static boolean logIn(String username, String password){
		byte[] adminPw = dbR.queryAdminPw(username);
		byte[] adminSalt = dbR.queryAdminSalt(username);
		//String hashPw = adminCred[0];
		//String hashSalt = adminCred[1];
		
		char[] pwArray = password.toCharArray();
		
		byte hashTest[] = Password.hashPassword(pwArray, adminSalt, 10, 256);
		System.out.println(hashTest[0]);
	
		if(Arrays.equals(hashTest, adminPw)){
			isLoggedIn = true;
			return true;
		}
		else{
			System.out.println("wutwut");
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
		    char[] password2 = password.toCharArray();
		    byte pw[] = Password.hashPassword(password2, salt, 10, 256);
		    String pw2 = pw.toString();
		    String saltString = salt.toString();
		    
			dbU.insertAdmin(username, pw, salt);
			
			/*if(Arrays.equals(saltTest, salt)){
				System.out.println("Eins salt");
			}
			else{
				System.out.println("ekki eins salt");
			}*/
			
			return true;
		}
		else{
			return false;
		}
	}
	public static void main(String[] args){
		isLoggedIn = true;
		addAdmin("smeller", "retta");
	}

}