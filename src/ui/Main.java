package ui;

import java.util.Scanner;

import model.Controller;

/**
 * The Main Class.
 */

public class Main {

	/**
	 * Scanner to read user input
	 */
	private Scanner sc;

	/**
	 * controller to communicate with the model
	 */
	private Controller controller;
	
	/**
	 * Constructor initializes the controller and the scanner
	 */
	public Main() {
		
		sc = new Scanner(System.in);
		InitModel initModel = new InitModel();
		controller = new Controller(initModel.initVehicles());

	}

	public static void main(String[] args) {

		Main main = new Main();
		
		System.out.println("\n");
		System.out.println(":'######:::::'###::::'########:::::'########::'########::::'###::::'##:::::::'########:'########:::'######::'##::::'##:'####:'########::");
		System.out.println("'##... ##:::'## ##::: ##.... ##:::: ##.... ##: ##.....::::'## ##::: ##::::::: ##.....:: ##.... ##:'##... ##: ##:::: ##:. ##:: ##.... ##:");
		System.out.println(" ##:::..:::'##:. ##:: ##:::: ##:::: ##:::: ##: ##::::::::'##:. ##:: ##::::::: ##::::::: ##:::: ##: ##:::..:: ##:::: ##:: ##:: ##:::: ##:");
		System.out.println(" ##:::::::'##:::. ##: ########::::: ##:::: ##: ######:::'##:::. ##: ##::::::: ######::: ########::. ######:: #########:: ##:: ########::");
		System.out.println(" ##::::::: #########: ##.. ##:::::: ##:::: ##: ##...:::: #########: ##::::::: ##...:::: ##.. ##::::..... ##: ##.... ##:: ##:: ##.....:::");
		System.out.println(" ##::: ##: ##.... ##: ##::. ##::::: ##:::: ##: ##::::::: ##.... ##: ##::::::: ##::::::: ##::. ##::'##::: ##: ##:::: ##:: ##:: ##::::::::");
		System.out.println(". ######:: ##:::: ##: ##:::. ##:::: ########:: ########: ##:::: ##: ########: ########: ##:::. ##:. ######:: ##:::: ##:'####: ##::::::::");
		System.out.println(":......:::..:::::..::..:::::..:::::........:::........::..:::::..::........::........::..:::::..:::......:::..:::::..::....::..:::::::::");
		System.out.println("\n");

		int option = 0;

		do{
			main.showMenu();
			option = main.readOption();
			main.executeOption(option);

		}while(option != 0);

	}

	
	/**
	 * Method to show the main menu
	 */

	public void showMenu() {
		
		System.out.println("1. Register vehicle\n" + 
							"2. Calculate selling price\n" +
							"3. Generate report\n" +
							"4. Show document status\n" +
							"5. Show parking map\n" +
							"6. Generate parking report\n" +
							"0. Exit");

	}

	/**
	 * Method to read the option chosen by the user
	 * @return the option chosen by the user
	 */

	public int readOption() {
		
		int option = 0;
		option = sc.nextInt();
		sc.nextLine();

		return option;

	}

	/**
	 * Method to execute the option chosen by the user
	 * @param option the option chosen by the user
	 */

	public void executeOption(int option) {
		
		switch(option) {

			case 1:
				registerVehicle();
				break;
			case 2:
				calculateSellingPrice();
				break;
			case 3:
				generateReport();
				break;
			case 4:
				showDocumentStatus();
				break;
			case 5:
				showParkingMap();
				break;
			case 6:
				generateParkingReport();
				break;
			case 0:
				System.out.println("Bye...");
				break;
			default:
				System.out.println("Invalid option");

		}

	}

	/**
	 * Method to register a vehicle. The type of vehicles are motorcycle, gasoline car, electric car and hybrid car.
	 */

	public void registerVehicle() {

		boolean registered = false;

		//basic vehicle information
		int vehicleType = 0, model = 0;
		double basePrice = 0, mileage = 0;
		String brand = "", licensePlate = "";
		int cylinderCapacity = 0;

		System.out.println("Type of vehicle: ");
		System.out.println("1. New\n" + "2. Used");
		vehicleType = sc.nextInt();
		sc.nextLine();

		System.out.println("Base price: ");
		basePrice = sc.nextDouble();
		sc.nextLine();

		System.out.println("Brand: ");
		brand = sc.nextLine();

		System.out.println("Model: ");
		model = sc.nextInt();
		sc.nextLine();

		System.out.println("Cylinder capacity: ");
		cylinderCapacity = sc.nextInt();
		sc.nextLine();

		System.out.println("Mileage: ");
		mileage = (vehicleType == 1) ? 0 : sc.nextDouble();
		sc.nextLine();

		System.out.println("License plate: ");
		licensePlate = (vehicleType == 1) ? null : sc.nextLine();


		//Documents information
		Double tmPrice = null, soatPrice = null, pcPrice = null, coverageAmount = null, gasEmitted = null;
		Integer tmYear = null, soatYear = null, pcYear = null;

		//If the vehicle is used, the user must enter the documents information
		if(vehicleType == 2) {

			System.out.println("Property card info: ");
			System.out.println("Price: ");
			pcPrice = sc.nextDouble();
			sc.nextLine();

			System.out.println("Year: ");
			pcYear = sc.nextInt();
			sc.nextLine();

			System.out.println("Techno mechanical info:");

			System.out.println("Price: ");
			tmPrice = sc.nextDouble();
			sc.nextLine();

			System.out.println("Year: ");
			tmYear = sc.nextInt();
			sc.nextLine();

			System.out.println("Gas emitted: ");
			gasEmitted = sc.nextDouble();
			sc.nextLine();

			System.out.println("SOAT info:");

			System.out.println("Price: ");
			soatPrice = sc.nextDouble();
			sc.nextLine();

			System.out.println("Year: ");
			soatYear = sc.nextInt();
			sc.nextLine();

			System.out.println("Coverage amount: ");
			coverageAmount = sc.nextDouble();
			sc.nextLine();

		}

		int option = 0;

		System.out.println("Type of vehicle:");
		System.out.println("1) Car\n" + "2) Motorcycle");
		option = sc.nextInt();
		sc.nextLine();

		//Register motorcycle
		if(option == 2) {

			double gasolineCapacity = 0;
			int motorcycleType = 0;

			System.out.println("Motorcycle type: ");
			System.out.println("1)Standar\n" +
								"2)Sport \n" +
								"3)Scooter\n" +
								"4)Cross");
			motorcycleType = sc.nextInt();

			System.out.println("Gasoline capacity: ");
			gasolineCapacity = sc.nextDouble();
			sc.nextLine();

			registered = controller.registerVehicle(vehicleType, basePrice, brand, model, cylinderCapacity, mileage, licensePlate, pcPrice, pcYear, tmPrice, tmYear, gasEmitted, soatPrice, soatYear, coverageAmount, motorcycleType, gasolineCapacity);


		}else {
			//Register car
			int doorsNumber = 0, hasTintedWindows = 0, carType = 0, carType2 = 0;

			System.out.println("Car info:");
			
			System.out.println("Car type: ");
			System.out.println("1)Sedan\n" + 
								"2)SUV");
			carType = sc.nextInt();

			System.out.println("1)Gasoline car\n" + 
								"2)Electric car\n" +
								"3)Hybrid car");

			carType2 = sc.nextInt();
			

			System.out.println("Doors number: ");
			doorsNumber = sc.nextInt();
			sc.nextLine();

			System.out.println("Has tinted windows? ");
			System.out.println("1)Yes\n" + "2)No");
			hasTintedWindows = sc.nextInt();
			sc.nextLine();

			//Register gasoline car
			if(carType2 == 1) {
				double tankCapacity = 0;
				int gasolineType = 0;

				System.out.println("Gasoline type: ");
				System.out.println("1)Extra\n" + 
									"2)Diesel\n" + 
									"3)Regular");

				gasolineType = sc.nextInt();
				sc.nextLine();

				System.out.println("Tank capacity: ");
				tankCapacity = sc.nextDouble();
				sc.nextLine();

				registered = controller.registerVehicle(vehicleType,basePrice, brand, model, cylinderCapacity, mileage, licensePlate, pcPrice, pcYear, tmPrice, tmYear, gasEmitted, soatPrice, soatYear, coverageAmount, carType, doorsNumber, hasTintedWindows, gasolineType, tankCapacity);
			}

			//Register electric car
			if(carType2 == 2) {

				int batteryLife = 0, chargerType = 0;

				System.out.println("Charger type: ");
				System.out.println("1)Fast\n" +
									"2)Normal");
				chargerType = sc.nextInt();
				sc.nextLine();

				System.out.println("Battery life: ");
				batteryLife = sc.nextInt();
				sc.nextLine();

				registered = controller.registerVehicle(vehicleType, basePrice, brand, model, cylinderCapacity, mileage, licensePlate, pcPrice, pcYear, tmPrice, tmYear, gasEmitted, soatPrice, soatYear, coverageAmount, carType, doorsNumber, hasTintedWindows, chargerType, batteryLife);
			}

			//Register hybrid car
			if(carType2 == 3) {
				double tankCapacity = 0;
				int gasolineType = 0;

				int batteryLife = 0, chargerType = 0;

				System.out.println("Gasoline type: ");
				System.out.println("1)Extra\n" + 
									"2)Diesel\n" + 
									"3)Regular\n");

				gasolineType = sc.nextInt();

				System.out.println("Tank capacity: ");
				tankCapacity = sc.nextDouble();
				sc.nextLine();

				System.out.println("Charger type: ");
				System.out.println("1)Fast\n" +
									"2)Normal\n");
				chargerType = sc.nextInt();

				System.out.println("Battery life: ");
				batteryLife = sc.nextInt();
				sc.nextLine();


				registered = controller.registerVehicle(vehicleType, basePrice, brand, model, cylinderCapacity, mileage, licensePlate, pcPrice, pcYear, tmPrice, tmYear, gasEmitted, soatPrice, soatYear, coverageAmount, carType, doorsNumber, hasTintedWindows, gasolineType, tankCapacity, chargerType, batteryLife);
				
			}

		}

		if(registered) {
			System.out.println("Vehicle registered successfully");
		}else {
			System.out.println("Vehicle not registered");
		}

	}

	/**
	 * Method to calculate the selling price of a vehicle. It prints the selling price of the vehicle or a message if the vehicle is not registered.
	 */

	public void calculateSellingPrice() {

		System.out.println("Enter the id of the vehicle to calculate the selling price: ");
		String id = sc.nextLine();

		System.out.println((controller.calculateSellingPrice(id) != -1)
							? "Selling price: " + controller.calculateSellingPrice(id)
							: "Vehicle not found");
		
	}

	/**
	 * Method to generate reports of the vehicles. The report can be by type, fuel type or use.
	 */

	public void generateReport() {

		int option = 0;
		
		System.out.println("Generate report by: ");
		System.out.println("1)Type\n" +
							"2)Fuel type\n" +
							"3)Usage");
		option = sc.nextInt();
		sc.nextLine();

		System.out.println(controller.generateReport(option));

	}

	/**
	 * Method to show the document status of a vehicle.
	 */
	public void showDocumentStatus(){

		String id = "";
		System.out.println("Enter the vehicle ID: ");
		id = sc.nextLine();

		System.out.println(controller.showDocumentStatus(id));

	}

	/**
	 * Method to show the parking map. The map shows the empty and occupied spaces.
	 */

	public void showParkingMap(){

		System.out.println(controller.showParkingMap());

	}

	/**
	 * Method to generate reports of the parking. The report can be by range of years, newest/oldest vehicle or occupancy percentage.
	 */

	public void generateParkingReport(){

		System.out.println("Generate parking report by: ");
		System.out.println("1)Range of years \n" +
							"2)Oldest/Newest vehicle \n" +
							"3)Occupancy percentage \n");
		int option = sc.nextInt();

		switch (option) {
			case 1:
				int firstYear = 0, lastYear = 0;
				do {//The range includes the first and last year [firstYear, lastYear].
					//(option - 1) corresponds to the index of the parking column with the vehicles of this year.
					//Ex: option 1) 2014 corresponds to the index 0 of the parking column. This column contains the 2014 cars.
					System.out.println("Enter the first year: ");
					System.out.println("1) 2014\n" +
										"2) 2013\n" +
										"3) 2012\n" +
										"4) 2011\n" +
										"5) <2011\n");
					firstYear = sc.nextInt();
					sc.nextLine();

					System.out.println("Enter the last year: ");
					System.out.println("1) 2014\n" +
										"2) 2013\n" +
										"3) 2012\n" +
										"4) 2011\n" +
										"5) <2011\n");
					lastYear = sc.nextInt();
					sc.nextLine();

				} while ((firstYear < lastYear)||(firstYear < 1 || firstYear > 5) || (lastYear < 1 || lastYear > 5));
				System.out.println(controller.oldCarsInRange(firstYear, lastYear));
				break;
			case 2:
				System.out.println("The oldest vehicle is: \n");
				System.out.println(controller.oldestVehicle());
				System.out.println("The newest vehicle is: \n");
				System.out.println(controller.newestVehicle());
				break;
			case 3:
				System.out.println("Occupancy percentage: ");
				System.out.println(controller.parkingOccupancyPercentage() + "%");
				break;
			
		}

	}

}