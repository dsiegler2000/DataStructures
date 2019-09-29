package exercise7;

public class Message {
	
	private int priority;
	
	private int timeArrived;
	
	private String message;
	
	public Message(String message, int priority, int timeArrived){
		
		this.priority = priority;
		
		this.timeArrived = timeArrived;
		
		this.message = message;
		
	}
	
	public int getPriority(){
		
		return priority;
		
	}
	
	public int getTimeArrived(){
		
		return timeArrived;
		
	}
	
	public String getMessage(){
		
		return message;
		
	}
	
	@Override
	public String toString(){
		
		return message + " with priority " + new Integer(priority).toString();
		
	}

}
