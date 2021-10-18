package Program10;

public class CargoShip extends Ship {
	private int cargoCapacity;
	
	/**
	 * Creates a constructor has3 the ship
	 * @param year The year the ship was built in
	 * @param cargoCapacity The cargo capacity in tonnage
	 */
	public CargoShip(String name, int year, int cargoCapacity) {
		//Calls the constructor of the super class-the Ship class.
		super(name,year);
		
		//Checks to see that the cargo capacity is 0 or greater, 
		//and throws an exception if the number is less than 0.
		if(cargoCapacity < 0) {
			throw new IllegalArgumentException("Capacity must be 0 or greater!");
		}
		
		//Assigns the parameter to the field.
		this.cargoCapacity = cargoCapacity;
	}
	 
	/**
	 * Creates a constructor that has 2 parameters.
	 * @param ship A Ship object
	 * @param cargoCapacity The cargo capacity of the ship
	 */
	public CargoShip(Ship ship, int cargoCapacity) {
		this(ship.getName(),ship.getYear(), cargoCapacity);
	}
	
	/**
	 * Creates a copy constructor for the cargoShip class
	 * @param cargoShip A CargoShip object
	 */
	public CargoShip(CargoShip cargoShip) {
		this(cargoShip.getName(), cargoShip.getYear(), cargoShip.getCargoCapacity());
	}
	
	/**
	 * Sets the cargoCapacity field.
	 * @param cargoCapacity The cargo capacity of the ship
	 */
	public void setCargoCapacity(int cargoCapacity) {
		//Checks to see that the cargo capacity is 0 or greater, 
		//and throws an exception if the number is less than 0.
		if(cargoCapacity < 0) {
			throw new IllegalArgumentException("Capacity must be greater than 0!");
		}
		
		this.cargoCapacity = cargoCapacity;
	}
	
	/**
	 * Allows the user access to the cargoCapacity field
	 * @return The cargo capacity of the ship
	 */
	public int getCargoCapacity() {
		return cargoCapacity;
	}
	
	/**
	 * Creates a toString() method that works with the CargoShip class.
	 * @return A string indicating the ship's name and cargo capacity.
	 */
	@Override 
	public String toString() {
		StringBuilder str = new StringBuilder();
		str.append("Name: " + getName());
		str.append("\nCargo Capacity: " + cargoCapacity);
		return str.toString();
	}
}
