package lab2;

import java.util.Scanner;

public class MazeSolver {
	
	public static void main(String[] args){
		
		System.out.println("Lab 29a");
		Scanner input = new Scanner(System.in);
		System.out.println("Enter a random seed");
		
		int seed = 0;
		
		try{
			
			seed = input.nextInt();
			
		}catch(NumberFormatException e){
			
			System.out.println("You must input a number!");
			System.exit(1);
			
		}
				
		Maze maze = new Maze(seed);
		maze.displayMaze();
		maze.solveMaze();
		maze.displayMaze();
		maze.mazeSolution(); 
		
		input.close();
		
	}

}
