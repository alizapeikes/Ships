package Program10;
import java.util.*;

public class CruiseShip extends Ship{
	private int maxPassengers;
	private ArrayList<Passenger> passengers;
	
	/**
	 * Creates a constructor with 2 fields of the super class and one of it's own class.
	 * @param name The name of the ship
	 * @param year The year the ship was built in
	 * @param maxPassengers The maximum amount of passengers allowed on the ship
	 */
	public CruiseShip(String name, int year, int maxPassengers) {
		//Calls the super class's constructor of the parent class- the Ship class.
		super(name,year);
		
		//Checks to see that the max amount of passengers is not a negative number,
		//and throws an exception if the number is negative.
		if(maxPassengers < 0) {
			throw new IllegalArgumentException("Number of passengers must be 0 or greater!");
		}
		
		//Assigns the parameter to the field
		this.maxPassengers = maxPassengers;
		passengers = new ArrayList<>();
	}
	
	/**
	 * Creates a constructor with 2 parameters
	 * @param ship An object of the Ship class.
	 * @param maxPassengers The maximum amount of passengers allowed on the ship
	 */
	public CruiseShip(Ship ship, int maxPassengers) {
		this(ship.getName(), ship.getYear(),  maxPassengers);
	}
	
	/**
	 * Creates a copy constructor for the CruiseShip class.
	 * @param cruiseShip A CruiseShip object.
	 */
	public CruiseShip(CruiseShip cruiseShip) {
		this(cruiseShip.getName(), cruiseShip.getYear(), cruiseShip.maxPassengers);
	}
	
	/**
	 * Sets the maxPssengers field
	 * @param maxPassengers The maximum amount of passengers allowed on the ship
	 */
	public void setMaxPassengers(int maxPassengers) {
		//Checks to see that the max amount of passengers is not a negative number,
		//and throws an exception if the number is negative.
		if(maxPassengers < 0) {
			throw new IllegalArgumentException("Maximum amount of passengers must be 0 or greater!");
		}
		
		this.maxPassengers = maxPassengers;
	}
	
	/**
	 * Allows the user access to the maxPassengers class.
	 * @return The maximum amount of passengers allowed on the ship
	 */
	public int getMaxPassengers() {
		 return maxPassengers;
	}
	 
	/**
	 * Returns a deep copy of the list of passengers on the boat.
	 * @return The list of passengers on the boat.
	 */
	public ArrayList<Passenger> getListPassengers() {
		 ArrayList<Passenger> copy = new ArrayList<>();
		 for(int x = 1; x < passengers.size(); x ++) {
			 copy.add(passengers.get(x));
		 }
		 return copy;
	}
	
	/**
	 * Allows the user add a passenger to the ArrayList only if it is not already in the list.
	 * @param passenger A passenger object
	 */
	public void addPassenger(Passenger passenger) {
		if(!passengers.contains(passenger)) {
			passengers.add(passenger);
		} else {
			throw new PassengerExistsException("Passenger is already in the list!");
		}
	}
	
	/**
	 * Creates a toString() that works with the CruiseShip class.
	 * @return A string indicating the ship's name, year it was built, max amount of passengers, and list of passengers
	 */
	@Override
	public String toString() {
		 StringBuilder str = new StringBuilder();
		 str.append(super.toString());
		 str.append("\nMax amount of passengers: " + maxPassengers);
		 str.append("\nPassenger/s: \n");
		 for(int x = 0; x < passengers.size(); x++) {
			 str.append(passengers.get(x));
		 }
		 return str.toString();
	}
}
