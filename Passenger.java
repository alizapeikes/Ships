package Program10;

public class Passenger extends Person {
	private String passportID;
	private int luggagePieces;
	
	/**
	 * Creates a constructor that receives 7 parameters
	 * @param f The first name of a person
	 * @param l The last name of a person
	 * @param g The gender of a person
	 * @param addr The address of a person
	 * @param birthdate The birthdate of a person
	 * @param passportID The passport ID of a person
	 * @param luggage The amount of luggage pieces of person
	 */
	public Passenger(String f, String l, Gender g, Address addr, String birthdate, String passportID, int luggage) {
		//Calls the constructor of the super class
		super(f,l,g,addr,birthdate);
		
		//Checks to see if the luggage pieces is a valid positive number, and if not throws an exception.
		if(luggagePieces < 0) {
			throw new IllegalArgumentException("Amount of luggage peices cannot be less than zero!");
		}
		
		//Assigns the parameter values to the fields.
		this.passportID = passportID;
		this.luggagePieces = luggage;
	}
	
	/**
	 * Creates a copy constructor for the Passenger class 
	 * @param p A passanger object
	 */
	public Passenger(Passenger p) {
		this(p.getFirstname(), p.getLastName(), p.getGender(), p.getAddress(), (p.getBirthdate().toString()), p.passportID, p.luggagePieces);
	}
	
	/**
	 * Creates a toString() method for the Passenger class
	 * @return A string indicating the fields of a Person object, the Passport ID, and amount of luggage pieces of the Person
	 */
	@Override
	public String toString() {
		StringBuilder str = new StringBuilder();
		//Calls the toString() method of the parent class-Person class.
		str.append("[" + super.toString());
		str.append("\nPassportID: " + passportID);
		str.append("\nAmount of luggage pieces: " + luggagePieces + "]\n");
		return str.toString();
	}

	/**
	 * Creates an equals() method that works with the Passenger class comparing the passport ID's.
	 * @param The Passenger object being compared with.
	 * @return True if the objects are equal, and false if they are not equal. 
	 */
	@Override 
	public boolean equals(Object o) {
		if(this == o) {
			return true;
		}
		
		if(o == null) {
			return false;
		}
		
		if(this.getClass() != o.getClass()) {
			return false;
		}
		
		Passenger other = (Passenger) o;
		if(passportID == null) {
			if(other.passportID != null) {
				return false;
			}
		}else if(!passportID.equals(other.passportID)) {
			return false;
		}
		
		return true;
	}
}
