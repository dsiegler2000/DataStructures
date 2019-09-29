package problem14;

public class Student {
	
	private String name;
	private double GPA;

	/**
	 * Gets this student's name
	 * @return This student's name.
	 */
	public String getName() {
		
		return name;
		
	}


	/**
	 * Sets this student's name
	 */
	public void setName(String name) {
		
		this.name = name;
		
	}


	/**
	 * Gets this student's GPA
	 * @return This student's GPA.
	 */
	public double getGPA() {
		
		return GPA;
		
	}


	/**
	 * Sets this student's GPA
	 */
	public void setGPA(double gPA) {
		
		GPA = gPA;
		
	}
	
	/**
	 * Constructs a student with the given name and GOA.
	 * @param name The name for this student.
	 * @param GPA This stuent's GPA.
	 */
	public Student(String name, double GPA){
		
		this.name = name;
		this.GPA = GPA;
		
	}
	
	
	
	@Override
	public String toString(){
		
		return this.name + " " + this.GPA;
		
	}

}