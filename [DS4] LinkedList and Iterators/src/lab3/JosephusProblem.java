package lab3;

import node.ListNode;

public class JosephusProblem<E> {
	
	public static void main(String[] args){
		
		if(args.length < 3){
			
			System.err.println("Must pass 3 arguments!");
			System.exit(1);
			
		}
						
		int numPeople = 0;
		int startingIdx = 0;
		int stride = 0;
		
		try{
			
			numPeople = Integer.parseInt(args[0]);
			
		}catch(NumberFormatException e){
			
			System.err.println("The first argument must be a number!");
			System.exit(1);
			
		}
				
		try{
			
			startingIdx = Integer.parseInt(args[1]);
			
		}catch(NumberFormatException e){
			
			System.err.println("The second argument must be a number!");
			System.exit(1);
			
		}

		try{
			
			stride = Integer.parseInt(args[2]);
			
		}catch(NumberFormatException e){
			
			System.err.println("The third argument must be a number!");
			System.exit(1);
			
		}
		
		if(numPeople <= 0 || startingIdx < 0 || stride <= 0){
			
			System.err.println("Illegal argument!");
			System.exit(1);
			
		}
		
		Integer[] people = new Integer[numPeople];
		
		for(int i = 0; i < numPeople; i++){
			
			people[i] = i;
			
		}
		
		JosephusProblem<Integer> problem = new JosephusProblem<>();
		
		System.out.println(problem.josephus(people, startingIdx, stride));
		
	}
	
	public E josephus(E[] people, int idxToStart, int stride){
		
		CircularLinkedList<E> list = new CircularLinkedList<>(people);
		
		ListNode<E> startingNode = list.getHead();
		
		for(int i = 0; i < (idxToStart - 1) % list.size(); i++){
			
			startingNode = startingNode.getNext();
			
		}
		
		ListNode<E> currentlyOn = startingNode;
		
		while(list.size() != 1){
			
			for(int i = 0; i < stride - 1; i++){
				
				currentlyOn = currentlyOn.getNext();
				
			}
						
			currentlyOn.setNext(currentlyOn.getNext().getNext());
			list.setSize(list.size() - 1);
			
		}
		
		return currentlyOn.getData();
		
	}

}