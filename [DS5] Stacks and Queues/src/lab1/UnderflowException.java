package lab1;

@SuppressWarnings("serial")
public class UnderflowException extends RuntimeException {

	/**
	 * Constructs an UnderflowException for use when attempting to remove from an
	 * empty data structure.
	 * @param message The message to display. 
	 */
	public UnderflowException(String message){
		
		super(message);
		
	}
	
}
