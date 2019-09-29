package exercise7;

public class Record {
	
	private Object obj;
	
	public Record(Object obj){
		
		this.obj = obj;
		
	}
	
	public Object getObject(){
		
		return obj;
		
	}
	
	@Override
	public boolean equals(Object other){
		
		return (other instanceof Record) && (other.hashCode() == this.hashCode());
		
	}
	
	@Override
	public int hashCode(){
		
		int hash = ((State) obj).hashCode();
		
		return (hash < 0 ? -hash % 999 : hash % 999);
		
	}

}
