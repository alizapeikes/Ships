package Program10;
import java.time.LocalDate;
import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.println("Pier 22 Cruise and Cargo ship log:\n");
		
		//Creates the lists to hold the cruise and cargo ships.
		ArrayList<CruiseShip> cruiseShips = new ArrayList<>();
		ArrayList<CargoShip> cargoShips = new ArrayList<>();
		
		//Allows the user to enter information about more than one ship.
		char answer;
		do {
			int choice = shipChoice(input);
			switch(choice) {
				case 1:
					cruiseShip(cruiseShips, input);
					break;
				case 2:
					cargoShip(cargoShips, input);
					break;
				}
			System.out.println("Would you like to enter the information for another ship?");
			System.out.println("Please enter y/n:");
			answer = input.nextLine().toLowerCase().charAt(0);
			//Validates that the user enters y/n
			while(answer != 'y' && answer != 'n') {
				System.out.println("Error! Please enter y/n");
				answer = input.nextLine().toLowerCase().charAt(0);
			}
		}
		while(answer == 'y');
		

		display(cruiseShips, cargoShips);
	}
	
	/**
	 * Allows the user to choose what kind of ship to enter information for.
	 * @param input A Scanner object receiving data from the keyboard.
	 * @return Choice of the user.
	 */
	public static int shipChoice(Scanner input) {
		System.out.println("Please choose a type of ship, and enter its corresponding number.");
		System.out.println("1.Cruise ship "
					   + "\n2.Cargo Ship");
		int choice = input.nextInt();
		
		//Validates that the input is only 1 or 2.
		while(choice != 1 && choice != 2) {
			System.out.println("Invalid input! Please enter either 1 or 2!");
			choice = input.nextInt();
		}
		input.nextLine();
		return choice;
	}
	
	/**
	 * Gets the information about a cruise ship.
	 * @param cruiseShips An ArrayList of different cruise ships.
	 * @param input A Scanner object receiving data from the keyboard.
	 */
	public static void cruiseShip(ArrayList<CruiseShip> cruiseShips, Scanner input) {
		System.out.println("What is the name of your ship?");
		String name = input.nextLine();
		
		//Gets the current year.
		int now = LocalDate.now().getYear();
		System.out.println("What year was your ship built in?");
		int year = input.nextInt();
		
		//Validates that the year is greater than or equal to one and less than the current year.
		while(year < 1 || year > now) {
			System.out.println("Year must be greater than one or less than the current year!");
			System.out.println("Please re-enter the year:");
			year = input.nextInt();
		}
		
		System.out.println("What is the maximum amount of passenger allowed on your boat?");
		int maxPassengers = input.nextInt();
		//Validates the the user does not enter a negative number.
		while(maxPassengers < 0) {
			System.out.println("Maximum amount of passengers must be 0 or greater! Please re-enter amount:");
			maxPassengers = input.nextInt();
		}
		
		System.out.println("How many passangers are on your ship?");
		int amount = input.nextInt();
		
		//Validates that the user does not enter a negative amount of passangers or an amount greater than the max.
		while(amount < 0 || amount > maxPassengers) {
			System.out.println("Amount of passengers cannot be less than 0 or more than the max amount of passengers allowed!");
			System.out.println("Please enter a valid number of passegners:");
			amount = input.nextInt();
		}
		
		//Clears the Scanner buffer.
		input.nextLine();
		
		//Creates a ship object.
		CruiseShip ship = new CruiseShip(name, year, maxPassengers);
		getPassengerInfo(input, amount, cruiseShips, ship, now);
		
	}
	
	/**
	 * Gets the passenger information for a cruise ship.
	 * @param input A Scanner object receiving data from the keyboard.
	 * @param amount The amount of passengers on the boat.
	 * @param cruiseShips An ArrayList of all the cruise ships.
	 * @param ship A Ship object.
	 * @param now The current year.
	 */
	public static void getPassengerInfo(Scanner input, int amount, ArrayList<CruiseShip> cruiseShips, CruiseShip ship, int now){
		
		for(int x = 0; x < amount; x++) {
			//Controls the do-while loop
			boolean repeat; 
			do {
				repeat = false;
				try {
					System.out.println("\n*Passenger #" + (x + 1) + "*");
			
					System.out.println("First name: ");
					String fname = input.nextLine();
			
					System.out.println("Last name: ");
					String lname = input.nextLine();
			
					System.out.println("Gender: M/F ");
					String gender = input.nextLine().toUpperCase();
					
					//Validates that the user entered m or f.
					while(!gender.equals("M") && !gender.equals("F")) {
						System.out.println("Invalid entry! Please enter M/N: ");
						gender = input.nextLine().toUpperCase();
					}
			
					System.out.println("Year of birthdate:(Please write the full year)");
					int year = input.nextInt();
					
					//Validates year is not more than 120 years ago and is not greater than the current year.
					while(year < (now - 120) || year > now) {
						System.out.println("Invalid birth year! Please enter a valid year: ");
						year = input.nextInt();
					}
			
					System.out.println("Month of birthdate: Please enter 1=jan 2=feb...");
					int month = input.nextInt();
			
					//Validates if month in range
					while(month < 1 || month > 12) {
						System.out.println("Error! Month must be between 1-12! Please enter a valid month: ");
						month = input.nextInt();
					}
					
					//Creates an array of the amount of days per month.
					int[] daysPerMonth = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
					
					System.out.println("Day of the month of birthdate: ");
					int day = input.nextInt();
			
					//Validates if day in range for month
					while(day <= 0 || (day > daysPerMonth[month] && !(month == 2 && day == 29))) {
						System.out.println("Day is out-of-range for the specified month and year! Please enter a valid day: ");
						day = input.nextInt();
					}

					//Check for leap year if month is 2 and day is 29
					while(month == 2 && day == 29 && !(year % 400 == 0 || (year % 4 == 0 && year % 100 != 0))) {
						System.out.println("Day is out-of-range for the specified month and year. Please enter a valid day: ");
						day = input.nextInt();
					}
					
					//Clears the Scanner buffer
					input.nextLine();
			
					System.out.println("Street:");
					String street = input.nextLine();
			
					System.out.println("City:");
					String city = input.nextLine();
			
					System.out.println("State:");
					String state = input.nextLine();
			
					System.out.println("Zip-code:");
					String zipCode = input.nextLine();
					
					//Validates that the zip code is 5 digits 
					while(zipCode.length() != 5) {
						System.out.println("Zipcode must be exactly 5 digits! Please re-enter zip: ");
						zipCode = input.nextLine();
					}
			
					System.out.println("Passport ID: ");
					String ID = input.nextLine();
			
					System.out.println("Amount of luggage pieces: ");
					int luggage = input.nextInt();
					
					//Validates that the amount of luggage pieces is not a negative number.
					while(luggage < 0) {
						System.out.println("Amount of luggage pieces cannot be less than zero!" + 
								   "\nPlease enter a valid amount of luggage pieces: ");
						luggage = input.nextInt();
					}
					input.nextLine();
			
					//Creates a string with the full birthdate.
					String birthdate = (year + "-" + (month < 10 ? ("0" + month): month) + "-" + (day < 10 ? ("0" + day): day));
					
					//Creates an Address object
					Address address = new Address(street, city, state, zipCode);
					
					//Creates a Passenger object
					Passenger passenger = new Passenger(fname, lname, Gender.valueOf(gender), address, birthdate, ID, luggage);
					
					//Adds the passenger to the list of passengers in the ship object. 
					ship.addPassenger(passenger);
				

				} catch(IllegalArgumentException | PassengerExistsException e){
				System.out.println(e.getMessage());
				System.out.println("Please enter information for a new passenger only!");
				repeat = true;
				}
				
			} while(repeat);
		}
		
		//Adds the ship object to the cruishShip ArrayList.
		cruiseShips.add(ship);
	}
	
	/**
	 * Gets the information for a cargo ship.
	 * @param cargoShips An ArrayList of all the cargo ships.
	 * @param input A Scanner object receiving data from the keyboard.
	 */
	public static void cargoShip(ArrayList<CargoShip> cargoShips, Scanner input) {
		try {
			System.out.println("What is the name of your ship?");
			String name = input.nextLine();
			
			//Gets the current year
			int now = LocalDate.now().getYear();
			
			System.out.println("What year was your ship built in?");
			int year = input.nextInt();
		
			//Validates that the year is not less than one and not greater than the current year.
			while(year < 1 || year > now) {
				System.out.println("Year must be greater than one or less than the current year!");
				System.out.println("Please re-enter the year:");
				year = input.nextInt();
			}
		
			System.out.println("The max capacity for a chargo ship is 25,000 tons.");
			System.out.println("What is the max capacity of your ship?");
			int capacity = input.nextInt();
			
			//Validates that the capacity is not a negative number and not greater than 25000.
			while(capacity < 0 || capacity > 25000) {
				System.out.println("Error! Capacity must be between 0 and 25,000. Please enter a valid number!");
				capacity = input.nextInt();
			}
			
			input.nextLine();
			//Adds the cargo ship to the ArrayList of cargo ships.
			cargoShips.add(new CargoShip(name, year, capacity));
			
		}catch(IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}
	}
	
	/**
	 * Displays the list of cruise and cargo ships with their relevant information
	 * @param cruiseShips An ArrayList of all the cruise ships.
	 * @param cargoShips An ArrayList of all the cargo ships.
	 */
	public static void display(ArrayList<CruiseShip> cruiseShips, ArrayList<CargoShip> cargoShips) {
		
		//Displays the list of cruise ships.
		System.out.println("\nCruise Ships:");
		for(int x = 0; x < cruiseShips.size(); x++) {
			System.out.println(cruiseShips.get(x));
		}
		
		//Displays the list of cargo ships.
		System.out.println("\nCargo Ships:");
		for(int x = 0; x < cargoShips.size(); x++) {
			System.out.println(cargoShips.get(x) + "\n");
		}
	}
}

