package problem14;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class HonorsStudents {
	
	public static void main(String[] args) throws IOException{
		
		if(args.length < 2){
			
			System.err.println("Pass 2 arguments!");
			System.exit(1);
			
		}
		
		File studentsF = new File(args[0]);
		Scanner in = new Scanner(studentsF);

		Queue<Student> students = new LinkedList<>();
				
		while(in.hasNextLine()){

			String line = in.nextLine();
			String[] split = line.split(" ");
			String name = split[0];
			double GPA = 0;
			
			try{
				
				GPA = Double.parseDouble(split[1]);
				
			}catch(NumberFormatException e){
				
				System.err.println("NaN found!");
				System.out.println(split[1]);
				System.exit(0);
				
			}
			
			students.add(new Student(name, GPA));
			
		}
		
		FileWriter out = new FileWriter(new File("output14.txt"));
		
		Queue<Student> cut = cutAtGPA(students, Double.parseDouble(args[1]));
		
		for(Student s : cut){
			
			out.write(s.toString() + "\n");
			
		}
		
		System.out.println("Outputed to " + new File("output14.txt").getAbsolutePath());
		
		in.close();
		out.close();
		
	}
	
	
	/**
	 * Empties the {@code student} queue and returns a queue of students with GPA higher than {@code minGPA}.
	 * @param students The queue of students to look through. This queue will be emptied. 
	 * @param minGPA The minimum GPA to be added to the honors queue (inclusive).
	 * @return The queue of students with GPA >= {@code minGPA} from the {@code students} queue.
	 */
	public static Queue<Student> cutAtGPA(Queue<Student> students, double minGPA){
		
		Queue<Student> honors = new LinkedList<Student>();
		
		while(!students.isEmpty()){
			
			Student s = students.remove();
			
			if(s.getGPA() >= minGPA){
				
				honors.add(s);
				
			}
			
		}
		
		return honors;
		
	}

}
