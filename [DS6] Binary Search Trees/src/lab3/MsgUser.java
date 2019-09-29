package lab3;

import java.util.Set;

public class MsgUser implements Comparable<MsgUser>{
	
	private String name;
	private String password;
	
	private Server server;
	
	private MsgWindow window;
	
	public MsgUser(Server server, String name, String password){
		
		this.server = server;
		this.name = name;
		this.password = password;
						
	}
	
	public void addBuddy(MsgUser u){
		
		if(window != null){
			
			window.addBuddy(u);
			
		}
		
	}
	
	public void quit(){
		
		server.logout(this);
		
	}
	
	public void receiveMessage(String text){
		
		if(window != null){
			
			window.showMessage(text);
			
		}
		
	}
	
	public void removeBuddy(MsgUser u){
		
		if(window != null){
			
			window.removeBuddy(u);
			
		}
		
	}
	
	public void openDialog(Set<MsgUser> buddies){
		
		window = new MsgWindow(this, buddies);
		
	}
	
	public String getName(){
		
		return name;
		
	}
	
	public String getPassword(){
		
		return password;
		
	}
	
	@Override
	public boolean equals(Object o){
		
		if(o instanceof MsgUser){
			
			return this.name.equalsIgnoreCase(((MsgUser) o).name);
			
		}
		
		return false;
				
	}
	
	@Override
	public String toString(){
		
		return this.name;
		
	}
	
	@Override
	public int compareTo(MsgUser o){
		
		return this.name.compareToIgnoreCase(o.name);
		
	}

}
