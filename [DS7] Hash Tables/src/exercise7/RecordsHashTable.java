package exercise7;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class RecordsHashTable {
	
	private ListNode[] buckets = new ListNode[1000];
	
	public static void main(String[] args){
		
		if(args.length < 0){
			
			System.out.println("Must pass a file!");
			
		}
		
		RecordsHashTable table = new RecordsHashTable();
		args = new String[1];
		args[0] = "src/exercise7/states.txt";
		
		File file = new File(args[0]);
		
		Scanner scan = null;
		
		try {
			
			scan = new Scanner(file);
			
		} catch (FileNotFoundException e) {

			System.out.println("Invalid file passed");
			e.printStackTrace();
			System.exit(1);
			
		}
		
		while(scan.hasNextLine()){
			
			String line = scan.nextLine();
			String[] split = line.split(" ");
			
			String abbr = split[0];
			
			StringBuilder nameBuilder = new StringBuilder();
			
			for(int i = 1; i < split.length; i++){
				
				nameBuilder.append(split[i] + " ");
				
			}
			
			State s = new State(abbr, nameBuilder.toString());
			
			table.add(new Record(s));
			
		}
		
		scan.close();
		
		System.out.println("Type contains to test if something is in the table, lookup to lookup a state given its abbreviation, and quit to quit.");
		
		Scanner inScan = new Scanner(System.in);
		
		while(true){
			
			String input = inScan.nextLine();
			String[] split = input.split(" ");
			
			if(split.length >= 1){
				
				String command = split[0];
				StringBuilder argsBuilder = new StringBuilder();
				
				for(int i = 1; i < split.length; i++){
					
					argsBuilder.append(split[i]);
					
				}

				Record rec = new Record(new State(argsBuilder.toString(), ""));
				
				switch(command){
					
				case "contains":
					System.out.println(table.contains(rec));
					break;
					
				case "lookup":
					System.out.println(table.lookup(rec));
					break;
				
				case "quit":
					System.out.println("Quitting...");
					inScan.close();
					System.exit(0);
					break;
					
				default:
					System.out.println("Invalid input!");
					break;
				
				}
				
			}
			
			else{
				
				System.out.println("Invalid input!");
				
			}
									
		}
				
	}
	
	public void add(Record record){
		
		if(this.contains(record)){
			
			return;
			
		}
		
		int hash = record.hashCode();
				
		if(buckets[hash] == null || buckets[hash].getValue() == null){
			
			buckets[hash] = new ListNode(record);
			
			return;
			
		}
		
		ListNode at = buckets[hash];
		
		while(true){
			
			at = at.getNext();
			
			if(at.getNext() == null){
				
				break;
				
			}
			
		}
		
		at.setNext(new ListNode(record));
				
	}
	
	public void remove(Record record){
		
		int hash = record.hashCode();
		
		if(buckets[hash] != null && buckets[hash].getValue() != null){
			
			ListNode at = buckets[hash];
			
			if(at.getValue().equals(record)){
				
				buckets[hash] = buckets[hash].getNext();
				
				return;
				
			}
			
			while(at != null && at.getNext() != null){
				
				if(at.getValue().equals(record)){
					
					at = at.getNext();
					
					break;
					
				}
				
				at = at.getNext();
				
			}
						
			if(at.getNext().getValue().equals(record)){
				
				at.setNext(null);
				
			}
			
		}
		
	}
	
	public boolean contains(Record record){
		
		int hash = record.hashCode();
				
		if(buckets[hash] != null && buckets[hash].getValue() != null){
			
			ListNode node = buckets[hash];
			
			for( ; node != null; node = node.getNext()){
				
				if(node.getValue().equals(record)){
					
					return true;
					
				}
				
			}
			
		}
		
		return false;
		
	}
	
	public String lookup(Record rec){
		
		if(!contains(rec)){
			
			return "";
			
		}
		
		int hash = rec.hashCode();
		
		ListNode node = buckets[hash];
		
		for( ; node != null; node = node.getNext()){
			
			if(node.getValue().equals(rec)){
				
				return ((State)((Record) node.getValue()).getObject()).getName();
				
			}
			
		}
		
		return "";
		
	}

}
