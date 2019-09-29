package problem20;

public class Person implements Comparable<Person>{
	
	private String firstName;
	private String lastName;
	
	/**
	 * Constructs a person given the first and last name.
	 * @param firstName The person's first name.
	 * @param lastName The person's last name.
	 */
	public Person(String firstName, String lastName){
		
		this.firstName = firstName;
		this.lastName = lastName;
		
	}
	
	/**
	 * Compares by last then first name.
	 */
	@Override
	public int compareTo(Person o) {

		if(lastName.compareTo(o.lastName) >= 1){
			
			return 1;
			
		}
		
		else if(lastName.compareTo(o.lastName) <= -1){
			
			return -1;
			
		}
		
		else if(lastName.compareTo(o.lastName) == 0){
			
			if(firstName.compareTo(o.firstName) >= 1){
				
				return 1;
				
			}
			
			else if(firstName.compareTo(o.firstName) <= -1){
				
				return -1;
				
			}

		}
		
		return 0;
		
	}
	
	@Override
	public String toString(){
		
		return lastName + ", " + firstName;
		
	}
	
	public String firstLastToString(){
		
		return firstName + " " + lastName;
		
	}

}
