package exercise7;

public class State {
	
	private String abbreviation;
	
	private String name;
	
	public State(String abbreviation, String name){
		
		this.abbreviation = abbreviation;
		
		this.name = name;
				
	}
	
	public String getName(){
		
		return name;
		
	}
	
	@Override
	public int hashCode(){
						
		int firstPlace = (((int) abbreviation.charAt(0)) - 65) * 26;
		int secondPlace = ((int) abbreviation.charAt(1) - 65);
						
		return firstPlace + secondPlace;
		
	}

}
