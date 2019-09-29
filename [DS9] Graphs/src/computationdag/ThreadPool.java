package computationdag;

public class ThreadPool {
	
	private Thread[] threads;
	
	public ThreadPool(int numThreads){
		
		threads = new Thread[numThreads];
		
	}
	
	public void execute(Thread t){
		
		for(int i = 0; i < threads.length; i++){
			
			if(threads[i] != null && !threads[i].isAlive()){
				
				threads[i] = null;
				
			}
			
			if(threads[i] == null){
				
				threads[i] = t;
				threads[i].start();
				
			}
			
		}
		
	}
	
	public void execute(Runnable r){
		
		execute(new Thread(r));
		
	}
	
}
