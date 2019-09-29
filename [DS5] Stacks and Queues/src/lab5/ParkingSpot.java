package lab5;

public class ParkingSpot implements Comparable<ParkingSpot>{
	
	int idx;
		
	private Car filledCar;
	
	private int pricePerKg;
	
	public ParkingSpot(int price, int idx){
		
		this.pricePerKg = price;
		this.idx = idx;
				
		this.filledCar = null;
		
	}
	
	public void fillSpot(Car c){
		
		filledCar = c;
		
	}
	
	public Car carLeaves(){
		
		Car toReturn = filledCar;
		filledCar = null;
		
		return toReturn;
		
	}
	
	public int getPrice(){
		
		return pricePerKg;
		
	}
	
	@Override
	public String toString(){
		
		return "IDX: " + idx + " PRICE: " + pricePerKg;
		
	}

	@Override
	public int compareTo(ParkingSpot o) {

		if(this.idx < o.idx){
			
			return -1;
			
		}
		
		else if(this.idx == o.idx){
			
			return 0;
			
		}
		
		else{
			
			return 1;
			
		}
			
	}

}
