package problem16;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class QueueCopier {

	public static void main(String[] args) throws IOException {
		
		Queue<String> q = new LinkedList<>();
		
		if(args.length < 1){
			
			System.err.println("Pass a file!");
			System.exit(1);
			
		}
		
		Scanner in = new Scanner(new File(args[0]));
		
		while(in.hasNextLine()){
			
			try{
				
				q.add(in.nextLine());
				
			}catch(NumberFormatException e){
				
				System.out.println("NaN found!");
				
			}
			
		}
		
		File out = new File("output16.txt");
		System.out.println("Outputing to " + out.getAbsolutePath());
		System.out.print("Also the copy is " + copy(q) + " and the original is " + q);
		FileWriter fw = new FileWriter(out);
		
		for(String s : copy(q)){
			
			fw.write(s + "\n");
			
		}
		
		in.close();
		fw.close();
		
	}
	
	/**
	 * Copies a queue.
	 * @param q The queue to copy.
	 * @return A copy of {@code q}.
	 */
	public static <E> Queue<E> copy(Queue<E> q){
		
		int size = q.size();
		Queue<E> copy = new LinkedList<E>();
		
		for(int i = 0; i < size; i++){
			
			E element = q.remove();
			copy.add(element);
			q.add(element);
			
		}
		
		return copy;
		
	}

}
