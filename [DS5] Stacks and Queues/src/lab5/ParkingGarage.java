package lab5;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class ParkingGarage {
	
	private Queue<Car> waitingLine;
	
	private PriorityQueue<ParkingSpot> nextOpenSpot;
	
	private ParkingSpot[] parkingSpots;
	
	private int numSpots;
	
	public int profit;
	
	public ParkingGarage(int[] prices){
		
		if(prices.length < numSpots){
			
			throw new IllegalArgumentException("prices.length: " + prices.length + " numSpots: " + numSpots);
			
		}
		
		this.waitingLine = new LinkedList<>();
		this.nextOpenSpot = new PriorityQueue<>();
		
		this.profit = 0;
		
		this.numSpots = prices.length;
		
		this.parkingSpots = new ParkingSpot[this.numSpots];
				
		for(int i = 0; i < this.numSpots; i++){
			
			parkingSpots[i] = new ParkingSpot(prices[i], i + 1);
			nextOpenSpot.add(parkingSpots[i]);
			
		}
		
	}
	
	public Car addCar(Car c){
		
		if(nextOpenSpot.isEmpty()){
			
			waitingLine.add(c);
															
			return new Car(c, -1);
			
		}
		
		else{
			
			int idxOfClosestOpenSpot = nextOpenSpot.remove().idx;
			parkingSpots[idxOfClosestOpenSpot - 1].fillSpot(c);
						
			return new Car(c, idxOfClosestOpenSpot);
			
		}
		
	}
	
	public void removeCar(Car c, Car[] cars){
						
		nextOpenSpot.add(parkingSpots[c.getParkingSpotIdx() - 1]);
						
		profit += c.getWeight() * parkingSpots[c.getParkingSpotIdx() - 1].getPrice();
		
		parkingSpots[c.getParkingSpotIdx() - 1].carLeaves();
						
		if(!waitingLine.isEmpty()){
					
			Car queuedCar = waitingLine.remove();
			int idx = queuedCar.id - 1;
			cars[idx] = addCar(queuedCar);
			
		}
						
	}
	
	public boolean isWaitingLineEmpty(){
		
		return waitingLine.isEmpty();
		
	}
	
	@Override
	public String toString(){
		
		StringBuilder str = new StringBuilder();
		
		for(int i = 0; i < parkingSpots.length; i++){
			
			str.append(parkingSpots[i] + (i == parkingSpots.length - 1 ? "" : "\n"));
			
		}
				
		return str.toString();
		
	}

}
