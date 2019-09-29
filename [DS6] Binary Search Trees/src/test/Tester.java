package test;

public class Tester {
	
	public static void main(String args[]) {
		
	/**System.out.println("Are you a boy or a girl?");
		Scanner input = new Scanner(System.in);
		String gender = input.nextLine();
		
		input.close();

		if (gender == "boy") {
			
			System.out.println("BOY");
			
		} 
		
		else {
			
			System.out.println("GIRL");
			
		}*/
		
		double sum = 0;
		double x = 2;

		for(int i = 0; i < 15; i++){
			
			double toAdd = (Math.pow(x, i)) / factorial(i);
			sum += toAdd;
			
		}
		
		System.out.println(sum);
		System.out.println(Math.pow(Math.E, x));
				
	}
	
	public static int factorial(int n){
		
		if(n == 0){
			
			return 1;
			
		}
		
		int product = 1;
		
		for(int i = 2; i <= n; i++){
			
			product *= i;
			
		}
		
		return product;
		
	}
	
}