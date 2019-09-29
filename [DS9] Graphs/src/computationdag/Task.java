package computationdag;

public class Task {
	
	private int estimatedExecutionTime;
	private Runnable task;
	private boolean completed;
	
	private String name;
	
	public Task(Runnable task, int estimatedExecutionTime){
		
		this.completed = false;
		this.task = task;
		this.estimatedExecutionTime = estimatedExecutionTime;
		this.name = "";
		
	}
	
	public Task(Runnable task, int estimatedExecutionTime, String name){
		
		this(task, estimatedExecutionTime);
		
		this.name = name;
		
	}

	public int getEstimatedExecutionTime() {
		
		return estimatedExecutionTime;
		
	}

	public void setEstimatedExecutionTime(int estimatedExecutionTime) {
		
		this.estimatedExecutionTime = estimatedExecutionTime;
		
	}

	public Runnable getTask() {
		
		return task;
		
	}

	public void setTask(Runnable task) {
		
		this.task = task;
		
	}

	public boolean isCompleted() {
		
		return completed;
		
	}

	public void setCompleted(boolean completed) {
		
		this.completed = completed;
		
	}
	
	public String getName(){
		
		return name;
		
	}
	
	public void setName(String n){
		
		name = n;
		
	}
	
	@Override
	public String toString(){
		
		String str;
		
		if(name.equals("")){
			
			str = task.toString();
			
		}
		
		else{
			
			str = name;
			
		}
		
		return str;
		
	}

}
