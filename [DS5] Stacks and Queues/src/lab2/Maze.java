package lab2;

import java.util.EmptyStackException;
import java.util.Random;
import java.util.Scanner;
import java.util.Stack;

public class Maze {

	private char mat[][];
	private Coord currentMove;
	private Stack<Coord> visitStack;

	// Makes a random maze
	// constructor which generates the random maze, random starting location
	// and initializes Maze class values.  If the random value equals 0 the maze
	// store an 'X' otherwise it store an 'O' in the maze.
	public Maze(int seed){
		
		Random random = new Random(seed);
		
		int startRow, startCol;
		mat = new char[12][12];
		
		for (int r = 0; r < 12; r++){
			
			for (int c = 0; c < 12; c++){
				
				if (r == 0 || c == 0 || r == 11 || c == 11){
					
					mat[r][c] = 'X';
					
				}
				
				else{
					
					int rndInt = random.nextInt(2);
					
					if (rndInt == 0){
						
						mat[r][c] = 'X';
						
					}
					
					else{
						
						mat[r][c] = 'O';
						
					}
					
				}
				
			}
			
		}
		
		mat[0][0] = 'O';
		startRow = random.nextInt(12);
		startCol = 11;
		mat[startRow][startCol] = '.';
		visitStack = new Stack<>();
		currentMove = new Coord(startRow,startCol); 
		visitStack.push(currentMove);
		
	}

	public void displayMaze(){
		
		System.out.println("\nRANDOM MAZE DISPLAY\n");
		
		for (int r = 0; r < 12; r++) {
			
			for (int c = 0; c < 12; c++){
				
					System.out.print(mat[r][c] + "  ");
					
				}
			
			System.out.println();
			
		}
		
		System.out.println();
		pause();
		
	}

	// This methods solves the maze with private helper method <getMove>.
	// A loop is needed to repeat getting new moves until either a maze solution
	// is found or it is determined that there is no way out off the maze.
	public void solveMaze(){
		
		System.out.println("\n>>>>>   WORKING  ....  SOLVING MAZE   <<<<<\n");
		
		while(true){
			
			mat[currentMove.getR()][currentMove.getC()] = '.';
			boolean cont = getMove();
						
			if(currentMove.isFree()){
				
				break;
				
			}
			
			if(!cont){
				
				try{
					
					currentMove = visitStack.pop();
					
				}catch(EmptyStackException e){
					
					break;
					
				}
				
			}
			
			else{
				
				visitStack.add(currentMove);
				
			}
									
		}
		
	}

	// Short method to display the result of the maze solution
	public void mazeSolution(){
		
		if (currentMove.isFree()){
			
			mat[0][0] = '.';
			System.out.println("\nTHE MAZE HAS A SOLUTION.\n");
			
		}
		
		else{
			
			System.out.println("\nTHE MAZE HAS NO SOLUTION.\n");
		
		}
		
	}

	// This method determines if a coordinate position is inbounds or not
	private boolean inBounds(int r, int c){

		return r < 12 && c < 12;
		
	}

	// This method checks eight possible positions in a counter-clock wise
	// manner
	// starting with the (-1,0) position. If a position is found the method
	// returns
	// true and the currentMove coordinates are altered to the new position
	private boolean getMove(){
		
		Coord toCheck = new Coord(currentMove.getR() - 1, currentMove.getC());
		
		if(inBounds(toCheck.getR(), toCheck.getC()) && mat[toCheck.getR()][toCheck.getC()] == 'O'){

			currentMove = toCheck;
			return true;
			
		}
		
		toCheck = new Coord(currentMove.getR() - 1, currentMove.getC() - 1);
		
		if(inBounds(toCheck.getR(), toCheck.getC()) && mat[toCheck.getR()][toCheck.getC()] == 'O'){

			currentMove = toCheck;
			return true;
			
		}
		
		toCheck = new Coord(currentMove.getR(), currentMove.getC() - 1);
		
		if(inBounds(toCheck.getR(), toCheck.getC()) && mat[toCheck.getR()][toCheck.getC()] == 'O'){

			currentMove = toCheck;
			return true;
			
		}
		
		toCheck = new Coord(currentMove.getR() + 1, currentMove.getC() - 1);
		
		if(inBounds(toCheck.getR(), toCheck.getC()) && mat[toCheck.getR()][toCheck.getC()] == 'O'){

			currentMove = toCheck;
			return true;
			
		}
		
		toCheck = new Coord(currentMove.getR() + 1, currentMove.getC());
		
		if(inBounds(toCheck.getR(), toCheck.getC()) && mat[toCheck.getR()][toCheck.getC()] == 'O'){

			currentMove = toCheck;
			return true;
			
		}
		
		toCheck = new Coord(currentMove.getR() + 1, currentMove.getC() + 1);
		
		if(inBounds(toCheck.getR(), toCheck.getC()) && mat[toCheck.getR()][toCheck.getC()] == 'O'){

			currentMove = toCheck;
			return true;
			
		}
		
		toCheck = new Coord(currentMove.getR(), currentMove.getC() + 1);
		
		if(inBounds(toCheck.getR(), toCheck.getC()) && mat[toCheck.getR()][toCheck.getC()] == 'O'){

			currentMove = toCheck;
			return true;
			
		}
		
		toCheck = new Coord(currentMove.getR() - 1, currentMove.getC() + 1);
		
		if(inBounds(toCheck.getR(), toCheck.getC()) && mat[toCheck.getR()][toCheck.getC()] == 'O'){

			currentMove = toCheck;
			return true;
			
		}
				
		return false;

	}

	private void pause() {
		
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in); 
		System.out.print("\nPress <Enter> to continue  ===>>  ");		
		input.nextLine();
		
	}
	
}
