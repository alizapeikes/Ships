package Program10;
import java.time.LocalDate;

public class Person {
	private String firstName;
	private String lastName;
	private Gender gender;
	private Address address;
	private LocalDate birthdate;
	
	/**
	 * Creates a constructor that receives 5 parameters.
	 * @param f The first name of the person.
	 * @param l The last name of the person.
	 * @param g The gender of the person.
	 * @param add The address of the person in a Address object.
	 * @param birthdate The birth date of the person.
	 */
	public Person(String f, String l, Gender g, Address add, String birthdate) {
		this(f,l,g,add, LocalDate.parse(birthdate));
	}
	
	/**
	 * Creates a constructor that receives 8 parameters
	 * @param f The first name of the person.
	 * @param l The last name of the person.
	 * @param g The gender of the person
	 * @param s The street of the person's address 
	 * @param c The city of the person's address
	 * @param state The state of the person's address 
	 * @param zip The zip-code of the person's address
	 * @param birthdate The birth date of the person.
	 */
	public Person(String f, String l, Gender g, String s, String c, String state, String zip, String birthdate) {
		this(f,l,g, new Address(s,c,state,zip), LocalDate.parse(birthdate));
	}
	
	/**
	 * Creates a constructor that receives 5 parameters.
	 * @param f The first name of the person.
	 * @param l The last name of the person.
	 * @param g The gender of the person.
	 * @param add The address of the person in a Address object.
	 * @param birthdate The birth date of the person in Date object.
	 */
	public Person(String f, String l, Gender g, Address add, LocalDate birthdate) {
		//Assigns the parameter values to the fields.
		this.firstName = f;
		this.lastName = l;
		this.gender =  g;
		this.address = add;
		this.birthdate = birthdate;
	}
	
	/**
	 * Creates a copy constructor for the Person class
	 * @param p A person object. 
	 */
	public Person(Person p) {
		this(p.firstName, p.lastName, p.gender, p.address, p.birthdate);
	}
	
	/**
	 * Allow the user to access the firstName field
	 * @return The first name of the person
	 */
	public String getFirstname() {
		return firstName;
	}
	
	/**
	 * Allows the user to access the lastName field.
	 * @return The last name of the user
	 */
	public String getLastName() {
		return lastName;
	}
	
	/**
	 * Allows the user access to the gender field.
	 * @return The gender of the person
	 */
	public Gender getGender() {
		return gender;
	}
	
	/**
	 * Allows the user to access the birthdate field.
	 * @return  The birthdate of the person
	 */
	public LocalDate getBirthdate() {
		return birthdate;
	}
	
	/**
	 * Allows the user access to the address field.
	 * @return The address of the person
	 */
	public Address getAddress() {
		return address;
	}
	
	/**
	 * Sets the last name field to the last name passed by the user.
	 * @param last The last name of the person
	 */
	public void setLastName(String last) {
		lastName = last;
	}
	
	/**
	 * Sets the address field to the address passed by the user.
	 * @param addr
	 */
	public void setAddress(Address addr) {
		address = addr;
	}
	
	/**
	 * Creates a toString() method for the Person class.
	 * @return String that indicating a persons first name, last name, gender, address, and birthdate.
	 */
	@Override 
	public String toString() {
		StringBuilder str = new StringBuilder();
		str.append(firstName + " " + lastName);
		str.append("\nGender: " + gender);
		str.append("\nAddress: " + address);
		str.append("\nBirthdate: " + birthdate);
		return str.toString();
	}
	
	/**
	 * Creates an equals method that makes it possible to compare 2 
	 * Person objects based on first name, last name, and birthdate.
	 * @param The Person object being compared with.
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
		
		if(!(o instanceof Person)) {
			return false;
		}
		
		Person sample = (Person) o;
		if(firstName == null) {
			if(sample.firstName != null) {
				return false;
			}
		} else if(!firstName.equals(sample.firstName)) {
			return false; 
		}
		
		if(lastName == null) {
			if(sample.lastName != null) {
				return false;
			}
		} else if(!lastName.equals(sample.lastName)) {
			return false;
		}
		
		if(birthdate == null) {
			if(sample.birthdate != null);
			return false;
		} else if(!birthdate.equals(sample.birthdate)) {
			return false;
		}
		
		return true;
	}
}
