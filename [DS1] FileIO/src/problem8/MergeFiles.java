package problem8;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class MergeFiles {

	public static void main(String[] args) throws IOException {
		
		if(args.length < 2 || args[0].length() == 0 || args[1].length() == 0){
			
			System.out.println("Now really? Trying to pass less than 2 arguments? You troll");
			System.exit(1);
						
		}
		
		combineTwoFiles(args[0], args[1]);
		
	}
	
	/**
	 * Combines two lexicographically sorted files into one lexicographically sorted file named {@code output.txt}
	 * and located in {@code filepath1}'s parent directory. It will write over the contents of this file or create
	 * a new file if {@code output.txt} doesn't exist. 
	 * @param filepath1 The path to the first file.
	 * @param filepath2 The path to the second file.
	 * @throws IOException If there is an error reading from the inputs or writing to the output.
	 */
	public static void combineTwoFiles(String filepath1, String filepath2) throws IOException{
		
		File file1 = new File(filepath1);
		File file2 = new File(filepath2);
		
		File output = new File("output.txt");
		
		System.out.println("The output is at " + output.getAbsolutePath());
		
		if(!output.createNewFile()){
			
			System.out.println("The output file at " + output.getAbsolutePath() + " already exsists! Overwriting it.");
			
		}
		
		FileReader reader1 = null;
		FileReader reader2 = null;
		
		try {
			
			reader1 = new FileReader(file1);
			reader2 = new FileReader(file2);
						
		} catch (IOException e) {

			e.printStackTrace();
			System.out.println("Passing invalid file paths? Really? You troll!");
			System.exit(1);
			
		}
		
		BufferedReader bufferedReader1 = new BufferedReader(reader1);
		BufferedReader bufferedReader2 = new BufferedReader(reader2);
		
		PrintWriter outputWriter = new PrintWriter(output);
						
		if(bufferedReader1.ready() && bufferedReader2.ready()){
		
			String line1 = bufferedReader1.readLine();
			String line2 = bufferedReader2.readLine();
			
			while(bufferedReader1.ready() && bufferedReader2.ready()){
				
				if(line1.compareTo(line2) < 0){
					
					outputWriter.write(line1 + "\n");
					
					line1 = bufferedReader1.readLine();
					
				}
				
				else if(line1.compareTo(line2) == 0){
					
					outputWriter.write(line1 + "\n");
					outputWriter.write(line2 + "\n");
					
					line1 = bufferedReader1.readLine();
					line2 = bufferedReader2.readLine();
					
				}
				
				else if(line1.compareTo(line2) > 0){
					
					outputWriter.write(line2 + "\n");
					
					line2 = bufferedReader2.readLine();
					
				}
				
			}
			
			if(!bufferedReader2.ready()){
								
				if(line1.compareTo(line2) >= 1){
					
					outputWriter.write(line2 + "\n");
					outputWriter.write(line1 + "\n");
					
				}
				
				else{
					
					outputWriter.write(line1 + "\n");
					outputWriter.write(line2 + "\n");
					
				}
				
			}
			
			if(!bufferedReader1.ready()){
								
				if(line1.compareTo(line2) >= 1){
					
					outputWriter.write(line2 + "\n");
					outputWriter.write(line1 + "\n");
					
				}
				
				else{
					
					outputWriter.write(line1 + "\n");
					outputWriter.write(line2 + "\n");
					
				}
				
			}
			
		}
		
		while(bufferedReader1.ready()){
			
			outputWriter.write(bufferedReader1.readLine() + " \n");
			
		}
		
		while(bufferedReader2.ready()){
			
			outputWriter.write(bufferedReader2.readLine() + "\n");
			
		}
		
		bufferedReader1.close();
		bufferedReader1.close();
		
		outputWriter.close();
		
	}

}
