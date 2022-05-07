package ui;

import model.Controller;
import java.util.Scanner;

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
		controller = new Controller();

	}

	public void main(String[] args) {

		Main main = new Main();

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
							"0. Exit\n");

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
		
		int vehicleType = 0;

		double basePrice = 0, mileage = 0;
		String brand = "", model = "", licensePlate = "";
		int cylinderCapacity = 0;

		System.out.println("Type of vehicle: ");
		System.out.println("1. New\n" + "2. Used\n");
		vehicleType = sc.nextInt();
		sc.nextLine();

		System.out.println("Base price: ");
		basePrice = sc.nextDouble();
		sc.nextLine();

		System.out.println("Brand: ");
		brand = sc.nextLine();

		System.out.println("Model: ");
		model = sc.nextLine();

		System.out.println("Cylinder capacity: ");
		cylinderCapacity = sc.nextInt();
		sc.nextLine();

		System.out.println("Mileage: ");
		mileage = (vehicleType == 1) ? 0 : sc.nextDouble();
		sc.nextLine();

		System.out.println("License plate: ");
		licensePlate = (vehicleType == 1) ? null : sc.nextLine();


		//Documents
		Double tmPrice = null, soatPrice = null,coverageAmount = null, gasEmitted = null;
		Integer tmYear = null, soatYear = null;

		if(vehicleType == 2) {

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

			System.out.println("Vehicle has SOAT?");
			System.out.println("1)Yes  2)No");
			int hasSOAT = sc.nextInt();
			sc.nextLine();

			if(hasSOAT == 1) {

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

		}

		int option = 0;

		System.out.println("1) Car\n" + "2) Motorcycle\n");
		option = sc.nextInt();
		sc.nextLine();

		if(option == 2) {

			double gasolineCapacity = 0, gasolineConsumption = 0;
			int motorcycleType = 0;

			System.out.println("Motorcycle type: ");
			System.out.println("1)Standar\n" +
								"2)Sport \n" +
								"3)Scooter\n" +
								"4)Cross\n");
			motorcycleType = sc.nextInt();

			System.out.println("Gasoline capacity: ");
			gasolineCapacity = sc.nextDouble();
			sc.nextLine();

			System.out.println("Gasoline consumption: ");
			gasolineConsumption = (motorcycleType == 1) ? 0 : sc.nextDouble();
			sc.nextLine();

			controller.registerVehicle(vehicleType, basePrice, brand, model, cylinderCapacity, mileage, licensePlate, tmPrice, tmYear, gasEmitted, soatPrice, soatYear, coverageAmount, motorcycleType, gasolineCapacity, gasolineConsumption);

		}else {
			int doorsNumber = 0, hasTintedWindows = 0, carType = 0, carType2 = 0;

			System.out.println("Car info:");
			
			System.out.println("Car type: ");
			System.out.println("1)Sedan\n" + 
								"2)SUV\n");
			carType = sc.nextInt();

			System.out.println("1)Gasoline car\n" + 
								"2)Electric car\n" +
								"3)Hybrid car\n");

			carType2 = sc.nextInt();
			

			System.out.println("Doors number: ");
			doorsNumber = sc.nextInt();
			sc.nextLine();

			System.out.println("Has tinted windows? ");
			System.out.println("1)Yes\n" + "2)No\n");
			hasTintedWindows = sc.nextInt();
			sc.nextLine();


			if(carType2 == 1) {
				double tankCapacity = 0, gasolineConsumption = 0;
				int gasolineType = 0;

				System.out.println("Gasoline type: ");
				System.out.println("1)Extra\n" + 
									"2)Diesel\n" + 
									"3)Regular\n");

				gasolineType = sc.nextInt();

				System.out.println("Tank capacity: ");
				tankCapacity = sc.nextDouble();
				sc.nextLine();

				System.out.println("Gasoline consumption: ");
				gasolineConsumption = (vehicleType == 1) ? 0 : sc.nextDouble();
				sc.nextLine();

				controller.registerVehicle(vehicleType,basePrice, brand, model, cylinderCapacity, mileage, licensePlate, tmPrice, tmYear, gasEmitted, soatPrice, soatYear, coverageAmount, carType, doorsNumber, hasTintedWindows, gasolineType, tankCapacity, gasolineConsumption);
			}

			if(carType2 == 2) {

				double batteryConsumption = 0;
				int batteryLife = 0, chargerType = 0;

				System.out.println("Charger type: ");
				System.out.println("1)Fast\n" +
									"2)Normal\n");
				chargerType = sc.nextInt();

				System.out.println("Battery life: ");
				batteryLife = sc.nextInt();
				sc.nextLine();

				System.out.println("Battery consumption: ");
				batteryConsumption = sc.nextDouble();
				sc.nextLine();

				controller.registerVehicle(vehicleType, basePrice, brand, model, cylinderCapacity, mileage, licensePlate, tmPrice, tmYear, gasEmitted, soatPrice, soatYear, coverageAmount, carType, doorsNumber, hasTintedWindows, chargerType, batteryLife, batteryConsumption);
			}

			if(carType2 == 3) {
				double tankCapacity = 0, gasolineConsumption = 0;
				int gasolineType = 0;

				double batteryConsumption = 0;
				int batteryLife = 0, chargerType = 0;

				System.out.println("Gasoline type: ");
				System.out.println("1)Extra\n" + 
									"2)Diesel\n" + 
									"3)Regular\n");

				gasolineType = sc.nextInt();

				System.out.println("Tank capacity: ");
				tankCapacity = sc.nextDouble();
				sc.nextLine();

				System.out.println("Gasoline consumption: ");
				gasolineConsumption = sc.nextDouble();
				sc.nextLine();

				System.out.println("Charger type: ");
				System.out.println("1)Fast\n" +
									"2)Normal\n");
				chargerType = sc.nextInt();

				System.out.println("Battery life: ");
				batteryLife = sc.nextInt();
				sc.nextLine();

				System.out.println("Battery consumption: ");
				batteryConsumption = sc.nextDouble();
				sc.nextLine();

				controller.registerVehicle(vehicleType, basePrice, brand, model, cylinderCapacity, mileage, licensePlate, tmPrice, tmYear, gasEmitted, soatPrice, soatYear, coverageAmount, carType, doorsNumber, hasTintedWindows, gasolineType, tankCapacity, gasolineConsumption, chargerType, batteryLife, batteryConsumption);
				
			}

		}
	}

	public void calculateSellingPrice() {
	

	}

	public void generateReport() {
		

	}

}