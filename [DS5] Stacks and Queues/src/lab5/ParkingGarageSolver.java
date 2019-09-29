package lab5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class ParkingGarageSolver {
	
	public static void main(String[] args) throws FileNotFoundException{
				
		Scanner input = new Scanner(new File(args[0]));
		
		int numParkingSpaces = input.nextInt();
		int numCars = input.nextInt();
			
		int[] pricesOfParkingSpaces = new int[numParkingSpaces];
		
		Car[] cars = new Car[numCars];
		
		Queue<Integer> arrivalsAndDepartures = new LinkedList<>();
				
		for(int i = 0; i < numParkingSpaces; i++){
			
			pricesOfParkingSpaces[i] = input.nextInt();
			
		}
		
		ParkingGarage garage = new ParkingGarage(pricesOfParkingSpaces);
		
		for(int i = 0; i < numCars; i++){
			
			int weight = input.nextInt();
			cars[i] = new Car(weight, i + 1);
			
		}
		
		for(int i = 0; i < 2 * numCars; i++){
			
			arrivalsAndDepartures.add(input.nextInt());
			
		}
				
		input.close();
		
		while(!arrivalsAndDepartures.isEmpty()){
			
			int event = arrivalsAndDepartures.remove();
						
			if(event > 0){
								
				cars[event - 1] = garage.addCar(cars[event - 1]);
				
			}
			
			else{
				
				garage.removeCar(cars[-event - 1], cars);	
								
			}
			
		}
		
		System.out.println(garage.profit);
				
	}

}
