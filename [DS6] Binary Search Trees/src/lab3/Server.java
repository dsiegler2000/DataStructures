package lab3;

import java.util.TreeMap;
import java.util.TreeSet;

public class Server implements Login{
	
	private TreeMap<String, MsgUser> screenNameToUser;
	private TreeSet<MsgUser> alreadyLoggedIn;
	
	public Server(){
		
		this.screenNameToUser = new TreeMap<>();
		this.alreadyLoggedIn = new TreeSet<>();
		
	}

	@Override
	public int addUser(String name, String password) {
		
		if(name.length() < 4 || name.length() > 10){
			
			return -1;
			
		}
		
		else if(password.length() < 2 || password.length() > 10){
			
			return -2;
			
		}

		else if(screenNameToUser.containsKey(name)){
			
			return -3;
			
		}
		
		screenNameToUser.put(name, new MsgUser(this, name, password));
		
		return 0;
		
	}

	@Override
	public int login(String name, String password) {
		
		if(!screenNameToUser.containsKey(name)){
			
			return -1;
			
		}
		
		else if(!screenNameToUser.get(name).getPassword().equals(password)){
			
			return -2;
			
		}
		
		else if(alreadyLoggedIn.contains(new MsgUser(this, name, password))){
			
			return -3;
			
		}

		MsgUser newUser = new MsgUser(this, name, password);
		newUser.openDialog(alreadyLoggedIn);
		alreadyLoggedIn.add(newUser);
		
		for(MsgUser u : alreadyLoggedIn){
			
			if(!u.equals(newUser)){
				
				u.addBuddy(newUser);
				
			}
					
		}
		
		return 0;
		
	}
	
	public void logout(MsgUser u){
		
		alreadyLoggedIn.remove(u);
		
	}

}
