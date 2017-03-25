package controller;

public class testerDB {
	private DatabaseRetrival dbR;
	
	
	public static void main(String args[]){
		DatabaseRetrival dbR = new DatabaseRetrival();
		System.out.print(dbR.simpleQuery());

	}
	
	public void bla(){
		String a = dbR.simpleQuery();
		System.out.println(a);
	}
}
