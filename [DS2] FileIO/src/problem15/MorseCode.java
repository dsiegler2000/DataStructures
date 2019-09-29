package problem15;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

public class MorseCode {
	
	public static void main(String[] args) throws IOException{
		
		if(args.length < 1){
			
			System.err.println("Pass a file!");
			System.exit(1);
			
		}
		
		Queue<String> morseCode = new LinkedList<>();
		
		Scanner in = new Scanner(new File(args[0]));
		
		while(in.hasNextLine()){
			
			morseCode.add(in.nextLine());
			
		}
		
		FileWriter out = new FileWriter(new File("output15.txt"));
		
		HashMap<String, String> morseToStr = new HashMap<>();
		
		morseToStr.put(".-", "A");
		morseToStr.put("-...", "B");
		morseToStr.put("-.-.", "C");
		morseToStr.put("-..", "D");
		morseToStr.put(".", "E");
		morseToStr.put("..-.", "F");
		morseToStr.put("--.", "G");
		morseToStr.put("....", "H");
		morseToStr.put("..", "I");
		morseToStr.put(".---", "J");
		morseToStr.put("-.-", "K");
		morseToStr.put(".-..", "L");
		morseToStr.put("--", "M");
		morseToStr.put("-.", "N");
		morseToStr.put("---", "O");
		morseToStr.put(".--.", "P");
		morseToStr.put("--.-", "Q");
		morseToStr.put(".-.", "R");
		morseToStr.put("...", "S");
		morseToStr.put("-", "T");
		morseToStr.put("..-", "U");
		morseToStr.put("...-", "V");
		morseToStr.put(".--", "W");
		morseToStr.put("-..-", "X");
		morseToStr.put("-.--", "Y");
		morseToStr.put("--..", "Z");
		morseToStr.put("-----", "0");
		morseToStr.put(".----", "1");
		morseToStr.put("..---", "2");
		morseToStr.put("...--", "3");
		morseToStr.put("....-", "4");
		morseToStr.put("....", "5");
		morseToStr.put("-....", "6");
		morseToStr.put("--...", "7");
		morseToStr.put("---..", "8");
		morseToStr.put("----.", "9");
		morseToStr.put(".-.-.-", ".");
		morseToStr.put("--..--", ",");
		morseToStr.put("---...", ":");
		morseToStr.put("..--..", "?");
		morseToStr.put(".----.", "'");
		morseToStr.put("-....-", "-");
		morseToStr.put("-..-.", "/");
		morseToStr.put("-.--.-", "(");
		morseToStr.put(".-..-.", "\"");
		morseToStr.put(".--.-.", "@");
		morseToStr.put("-...-", "=");
		
		morseToStr.put("/", " ");
		morseToStr.put("|", " ");
		
		replace(morseCode);
		
		out.write(translateWordToWord(morseCode, morseToStr));

		System.out.println("Written to " + new File("output15.txt").getAbsolutePath());
		
		in.close();
		out.close();

				
	}
	
	/**
	 * Replaces all instances of "..--.." with ".-.-.-"
	 * @param morseCode The queue to search.
	 */
	public static void replace(Queue<String> morseCode){
		
		Iterator<String> iter = morseCode.iterator();
		HashSet<Integer> hits = new HashSet<>();
		int idx = 0;
		
		while(iter.hasNext()){
			
			String code = iter.next();
			
			if(code.equals("..--..")){
				
				hits.add(idx);
				
			}
			
			idx++;
			
		}
		
		for(int i = 0; i < idx; i++){
			
			if(hits.contains(i)){
				
				morseCode.add(".-.-.-");
				morseCode.remove();
				
			}
			
			else{
				
				morseCode.add(morseCode.remove());
				
			}
						
		}
		
	}
	
	/**
	 * Translates a queue word to word given a dictionary.
	 * @param words A queue of words to translate.
	 * @param dictionary The dictionary of word to word pairs. 
	 * @return A string of the translate {@code words} given {@code dictionary}.
	 */
	public static String translateWordToWord(Queue<String> words, Map<String, String> dictionary){
		
		StringBuilder translated = new StringBuilder();
		
		while(!words.isEmpty()){
			
			String next = words.remove();
			
			if(dictionary.containsKey(next)){
				
				translated.append(dictionary.get(next));
				
			}
			
			else{
				
				translated.append(next);
				
			}
			
		}
			
		
		return translated.toString();
		
	}

}
