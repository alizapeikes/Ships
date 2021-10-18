package Program10;

public class PassengerExistsException extends RuntimeException {
	public PassengerExistsException() {
		super("Passenger already exists!");
	}
	
	public PassengerExistsException(String message) {
		super(message);
	}
}
