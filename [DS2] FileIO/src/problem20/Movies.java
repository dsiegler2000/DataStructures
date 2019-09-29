package problem20;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.TreeSet;

public class Movies {
	
public static void main(String[] args) throws IOException{
		
		FileWriter fwb = new FileWriter(new File("output20B.txt"));
		FileWriter fwc = new FileWriter(new File("output20C.txt"));
		FileWriter fwd = new FileWriter(new File("output20D.txt"));
		
		if(args.length < 1){
			
			System.out.println("Pass movie.txt");
			
		}
		
		ArrayList<Movie> movies = Movie.parseMovies(args[0]);
		Collections.sort(movies);
		
		for(Movie m : movies){
			
			fwb.write(m.toString() + "\n");
			
		}
				
		movies = Movie.parseMovies(args[0]);
		
		Collections.sort(movies, new Comparator<Movie>(){

			@Override
			public int compare(Movie o1, Movie o2) {

				return o1.getDirector().compareTo(o2.getDirector());
				
			}
			
		});
				
		for(Movie m : movies){
			
			fwc.write(m.toString() + "\n");
			
		}
		
		ArrayList<Person> actors = new ArrayList<>();
		
		for(Movie m : movies){
						
			for(Person a : m.getActors()){
				
				actors.add(a);
				
			}
			
		}
		
		Collections.sort(actors);
		TreeSet<Person> actorsSet = new TreeSet<>(actors);
		
		fwd.write(String.valueOf(actorsSet.size()) + "\n");
		
		for(Person p : actorsSet){
			
			fwd.write(p.toString() + "\n");
			
		}
		
		System.out.println("Written to " + new File("output20B.txt").getAbsolutePath() + " for part (b)\n"
				+ "Written to " + new File("output20C.txt").getAbsolutePath() + " for part (c)\n"
						+ "Written to " + new File("output20D.txt").getAbsolutePath() + " for part (d).");
		
		fwb.close();
		fwc.close();
		fwd.close();
				
	}

}
