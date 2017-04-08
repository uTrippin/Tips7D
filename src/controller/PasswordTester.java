package controller;
import java.security.SecureRandom;
import java.util.Arrays;

public class PasswordTester {
	private static byte salt[];
	
	public static void main(String args[]){
	    char[] pw = { 'a', 'r', 't', 'i', 's', 't' };
	    char[] pw2 = { 'a', 'r', 't', 'i', 's', 'm' };
	    byte pword[] = makePW(pw);
	    byte pword2[] = Password.hashPassword(pw, salt, 10, 256);
	    byte pword3[] = makePW(pw);
	    System.out.println(testPW(pword, pword2));
	    System.out.println(testPW(pword,pword3));
	
	}
	
	public static byte[] makePW(char[] pw){
		SecureRandom random = new SecureRandom();
	    byte bytes[] = new byte[20];
	    random.nextBytes(bytes);
	    salt = bytes;
		byte pw1[] = Password.hashPassword(pw, bytes, 10, 256);
		return pw1;
	}
	
	public static boolean testPW(byte[] tester, byte[] realPw){
		return(Arrays.equals(tester, realPw));
		
	}

}
