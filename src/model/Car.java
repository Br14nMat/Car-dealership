package model;

/**
 * This class represents a car
 */

public abstract class Car extends Vehicle {

	/**
	 * Type of the car. Can be "Sedan" or "SUV".
	 */
	private CarType type;

	/**
	 * The doors number of the car.
	 */
	private int doorsNumber;

	/**
	 * Whether the cas has tinted windows or not.
	 */
	private boolean hasTintedWindows;

	/**
	 * The contructor of the Car class.
	 */
	public Car(VehicleType type, double basePrice, String brand, int model, int cylinderCapacity, double mileage, String licensePlate, Document [] documents, CarType carType, int doorsNumber, boolean hasTintedWindows){
		super(type, basePrice, brand, model, cylinderCapacity, mileage, licensePlate, documents);

		this.type = carType;
		this.doorsNumber = doorsNumber;
		this.hasTintedWindows = hasTintedWindows;

	}
	/**
	 * Method to calculate and set the selling price of the car. It calls the method of the superclass Vehicle.<br>
	 * If the car is used, there is a 10% discount.<br>
	 * @return the selling price of the car. 
	 */
	@Override
	public double calculateSellingPrice() {
		double sellingPrice = 0;
		sellingPrice = super.calculateSellingPrice();

		if(super.getType() == VehicleType.USED)
			sellingPrice -= super.getBasePrice() * 0.1;
			
		super.setSellingPrice(sellingPrice);

		return sellingPrice;

	}
	
	/**
	 * Method to return the information of the car. It calls the toString method of the superclass Vehicle.
	 * @return the information of the car.
	 */
	@Override
	public String toString() {
		
		return super.toString() +
				"Car type: " + this.type.toString() + "\n" +
				"Doors number: " + this.doorsNumber + "\n" +
				"Has tinted windows: " + this.hasTintedWindows + "\n";
	}

	public int getDoorsNumber() {
		return doorsNumber;
	}

	public void setDoorsNumber(int doorsNumber) {
		this.doorsNumber = doorsNumber;
	}

	public boolean hasTintedWindows() {
		return hasTintedWindows;
	}

	public void setTintedWindows(boolean hasTintedWindows) {
		this.hasTintedWindows = hasTintedWindows;
	}

}