package problem20;

import java.io.File;
import java.io.FileNotFoundException;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Movie implements Comparable<Movie>{
	
	private int releaseYear;
	private String title;
	private List<Person> actors;
	private Person director;
	
	/**
	 * Constructs a movie with the given releaseYear, title, actors, and director.
	 * @param releaseYear The release year of the movie.
	 * @param title The title of the movie.
	 * @param actors The actors in the movie. 
	 * @param director The movie's director.
	 */
	public Movie(int releaseYear, String title, List<Person> actors, Person director){
		
		this.releaseYear = releaseYear;
		this.title = title;
		this.actors = actors;
		this.director = director;
		
	}
	
	public Person getDirector(){
		
		return director;
		
	}
	
	public List<Person> getActors(){
		
		return actors;
		
	}
	
	/**
	 * Parses movies.txt.
	 * @param movieFilepath The path to movies.txt.
	 * @return An {@code ArrayList<Movie>} of all of the movies in the movies.txt.
	 * @throws FileNotFoundException If the filepath doesn't exist. 
	 */
	public static ArrayList<Movie> parseMovies(String movieFilepath) throws FileNotFoundException{
		
		ArrayList<Movie> movies = new ArrayList<>();
		
		File moviesF = new File(movieFilepath);
		Scanner in = new Scanner(moviesF);
		
		while(in.hasNextLine()){
			
			String line = in.nextLine();
			
			int releaseYear = 0;
			
			try{
				
				releaseYear = Integer.parseInt(line.split(" ")[0]);
				
			}catch(NumberFormatException e){
				
				System.out.println("Found an NaN");
				
			}
			
			String[] split = line.split("  ");
			String[] titleArr = split[0].split(" ");
			StringBuilder titleBuilder = new StringBuilder();
						
			for(int i = 1; i < titleArr.length; i++){
				
				titleBuilder.append(titleArr[i] + ((i == titleArr.length - 1) ? "" : " "));
				
			}

			String title = titleBuilder.toString();
			
			String[] actorsStr = line.substring(38, 84).split(", | ");
			
			ArrayList<String> temp = new ArrayList<>();
			ArrayList<Person> actors = new ArrayList<>();
			
			for(int i = 0; i < actorsStr.length; i++){
												
				if(actorsStr[i].equals("")){
					
					break;
					
				}
				
				temp.add(actorsStr[i]);
				
			}
						
			for(int i = 0; i < temp.size() - 1; i += 2){
				
				actors.add(new Person(temp.get(i), temp.get(i + 1)));
				
			}
			
			String directorStr = line.substring(89);
			Person director = new Person(directorStr.split(" ")[0], directorStr.split(" ")[1]);
			
			movies.add(new Movie(releaseYear, title, actors, director));
			
		}
		
		in.close();
		
		return movies;
		
	}

	/**
	 * Compares by title.
	 */
	@Override
	public int compareTo(Movie o) {

		return title.compareTo(o.title);
		
	}
	
	@Override
	public String toString(){
		
		StringBuilder strBuilder = new StringBuilder();
		
		strBuilder.append(releaseYear + " ");
		
		strBuilder.append(title);
		
		for(int i = 0; i < 34 - title.length(); i++){
			
			strBuilder.append(" ");
			
		}
		
		int actorLengths = 0;
		int idx = 0;
		
		for(Person s : actors){
						
			if(idx == actors.size() - 1){
								
				strBuilder.append(s.firstLastToString());
				actorLengths += (s.firstLastToString()).length();
				
			}
			
			else{
				
				strBuilder.append(s.firstLastToString() + ", ");
				actorLengths += (s.firstLastToString() + ", ").length();
				
			}
			
			idx++;
			
		}
		
		for(int i = 0; i < 46 - actorLengths; i++){
			
			strBuilder.append(" ");
			
		}
		
		strBuilder.append("Dir: " + director.firstLastToString());
				
		return strBuilder.toString();
		
	}

}
