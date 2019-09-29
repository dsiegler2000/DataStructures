package lab5;

public class Car {
	
	int id;
	
	private int weight;
	
	private int parkingSpotIdx;
	
	public Car(int weight, int id){
		
		this.weight = weight;
		this.id = id;
				
	}
	
	public Car(Car c, int parkingSpotIdx){
		
		this.weight = c.weight;
		this.id = c.id;
		
		this.parkingSpotIdx = parkingSpotIdx;
		
	}
	
	public int getParkingSpotIdx(){
		
		return parkingSpotIdx;
		
	}
	
	public int getWeight(){
		
		return weight;
		
	}
	
	@Override
	public String toString(){
		
		return "ID: " + id + " WEIGHT: " + weight;
		
	}

}
