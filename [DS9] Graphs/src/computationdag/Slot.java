package computationdag;

public class Slot {
	
	private Task task;
	
	public Slot(Task t){
		
		task = t;
		
	}
	
	public Task getTask(){
		
		return task;
		
	}
	
	public void setTask(Task t){
		
		task = t;
		
	}
	
	@Override
	public String toString(){
		
		return task.toString();
		
	}

}
