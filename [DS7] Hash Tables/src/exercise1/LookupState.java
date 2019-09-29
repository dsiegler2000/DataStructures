package exercise1;

import java.util.Scanner;

public class LookupState {
	
	private static String[] stateNames = new String[676];
	
	public static void main(String[] args){
		
		populateTable();
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Input a state abbreviation:");
		
		String in = scanner.nextLine();
		
		System.out.println("This corresponds to the state " + find(in));
		
		scanner.close();
		
	}
	
	public static void populateTable(){
		
		add("AL", "Alabama");
		add("AK", "Alaska");
		add("AZ", "Arizona");
		add("AR", "Arkansas");
		add("CA", "California");
		add("CO", "Colorado");
		add("CT", "Connecticut");
		add("DE", "Delaware");
		add("FL", "Florida");
		add("GA", "Georgia");
		add("HI", "Hawaii");
		add("ID", "Idaho");
		add("IL", "Illinois");
		add("IN", "Indiana");
		add("IA", "Iowa");
		add("KS", "Kansas");
		add("KY", "Kentucky");
		add("LA", "Louisiana");
		add("ME", "Maine");
		add("MD", "Maryland");
		add("MA", "Massachusetts");
		add("MI", "Michigan");
		add("MN", "Minnesota");
		add("MS", "Mississippi");
		add("MO", "Missouri");
		add("MT", "Montana");
		add("NE", "Nebraska");
		add("NV", "Nevada");
		add("NH", "New Hampshire");
		add("NJ", "New Jersey");
		add("NM", "New Mexico");
		add("NY", "New York");
		add("NC", "North Carolina");
		add("ND", "North Dakota");
		add("OH", "Ohio");
		add("OK", "Oklahoma");
		add("OR", "Oregon");
		add("PA", "Pennsylvania");
		add("RI", "Rhode Island");
		add("SC", "South Carolina");
		add("SD", "South Dakota");
		add("TN", "Tennessee");
		add("TX", "Texas");
		add("UT", "Utah");
		add("VT", "Vermont");
		add("VA", "Virginia");
		add("WA", "Washington");
		add("WV", "West Virginia");
		add("WI", "Wisconsin");
		add("WY", "Wyoming");
		
	}
	
	public static void add(String abbr, String name){
		
		stateNames[lookupIndex(abbr)] = name;
		
	}
	
	public static String find(String abbr){
		
		return stateNames[lookupIndex(abbr)];
		
	}
	
	private static int lookupIndex(String abbr){
		
		abbr = abbr.toUpperCase();
				
		int firstPlace = (((int) abbr.charAt(0)) - 65) * 26;
		int secondPlace = ((int) abbr.charAt(1) - 65);
				
		return firstPlace + secondPlace;
		
	}

}
