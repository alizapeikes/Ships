package Program10;
import java.time.LocalDate;
import java.util.*;

public class Ship {
	private String name;
	private int year;
	
	/**
	 * Creates a constructor receives the ship name.
	 * @param name The name of the ship
	 */
	public Ship(String name) {
		this(name, 0);
	}
	
	/**
	 * Creates a constructor that receives the year the ship was built.
	 * @param year The year the ship was built
	 */
	public Ship(int year) {
		this("unkown", 0);
	}
	
	/**
	 * Creates a constructor that receives the name of the boat and the year it was built.
	 * @param name The name of the boat
	 * @param year The year the ship was built
	 */
	public Ship(String name, int year) {
		int now = LocalDate.now().getYear();
		if(year < 1 || year > now) {
			throw new IllegalArgumentException("Year must be at least 1!");
		}
		
		//Assigns the parameter values to the fields
		this.name = name;
		this.year = year;
	}
	
	/**
	 * Creates a copy constructor which allows the the new object being created to access the fields of object passed.
	 * @param sample A Ship object already created named "sample"
	 */
	public Ship(Ship sample) {
		this(sample.name, sample.year);
	}
	
	/**
	 * Sets the name field. 
	 * @param name The name of the boat
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Sets the year field. 
	 * @param year The year the ship was built
	 */
	public void setYear(int year) {
		this.year = year;
	}
	
	/**
	 * Allows the user to access the name field.
	 * @return The name of the boat
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Allows the user to access the year field.
	 * @return
	 */
	public int getYear() {
		return year;
	}
	
	/**
	 * Creates a toString() method for the Ship class.
	 * @return A string indicating the Ships name and year it was built in
	 */
	@Override
	public String toString() {
		StringBuilder str = new StringBuilder();
		str.append("Name: " + name);
		str.append("\nBuilt-in: " + year);
		
		return str.toString();
	}
}