package Program10;

public class Address {
	private String street;
	private String city;
	private String state;
	private String zipcode;
	
	/**
	 * Creates a constructor that receives the street, city, state, and zip-code
	 * @param street The street of the address
	 * @param city The city of the address 
	 * @param state The state of the address
	 * @param zip The zip-code of the address 
	 */
	public Address(String street, String city, String state, String zip) {
		//Checks to make sure the zip-code has a length of 5, and if not, throws an exception
		if(zip.length() != 5) {
			throw new IllegalArgumentException("All zipcodes must have 5 digits!");
		}
		
		//Assigns the parameter values to the fields.
		this.street = street;
		this.city = city;
		this.state = state;
		this.zipcode = zip;
	}
	
	/**
	 * Allows the user access to the street field.
	 * @return The street of the address
	 */
	public String getStreet() {
		return street;
	}
		
	/**
	 * Allows the user access to the city field.
	 * @return The city of the address
	 */
	public String getCity() {
		return city;
	}
	
	/**
	 * Allows the user access to the state field.
	 * @return The state of the address
	 */
	public String getState() {
		return state;
	}
	
	/**
	 * Allows the user access to the zip-code of the address.
	 * @return The zip-code of the address
	 */
	public String getZipcode() {
		return zipcode;
	}
	
	/**
	 * Creates a toString() method for the Address class.
	 * @return A string with the address's street, city, state, and zip-code
	 */
	@Override 
	public String toString() {
		StringBuilder str = new StringBuilder();
		str.append(street + " " + city + ", " + state + " " + zipcode);
		return str.toString();
	}
}
