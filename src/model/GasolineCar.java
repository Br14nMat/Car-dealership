package model;

/**
 * This class represents a gasoline car.
 */
public class GasolineCar extends Car implements IGasoline {
	
	/**
	 * The type of gasoline.
	 */
	private GasolineType gasolineType;

	/**
	 * The tank capacity.
	 */
	private double tankCapacity;

	/**
	 * The gasoline consumption.
	 */
	private double gasolineConsumption;

	/**
	 * The contructor of the GasolineCar class.<br>
	 * It calls the calculateSellingPrice method of the superclass Car to calculate the selling price of the GasolineCar.<br>
	 * It calls the calculateGasolineConsumption to calculate the gasoline consumption.<br>
	 */
	public GasolineCar(VehicleType type, double basePrice, String brand, int model, int cylinderCapacity, double mileage, String licensePlate, Document [] documents, CarType caryType, int doorsNumber, boolean hasTintedWindows, GasolineType gasolineType, double tankCapacity){

		super(type, basePrice, brand, model, cylinderCapacity, mileage, licensePlate, documents, caryType, doorsNumber, hasTintedWindows);
		this.gasolineType = gasolineType;
		this.tankCapacity = tankCapacity;

		super.calculateSellingPrice();
		calculateGasolineConsumption();

	}

	/**
	 * Method to calculate and set the gasoline consumption.
	 * @return the gasoline consumption.
	 */
	@Override
	public double calculateGasolineConsumption() {
		
		gasolineConsumption = tankCapacity * (super.getCylinderCapacity() / 150.0);
		
		return gasolineConsumption;
	}

	/**
	 * Method to return the information of the GasolineCar. It calls the toString method of the superclass Car.<br>
	 */
	@Override
	public String toString() {
		
		return super.toString() + 
				"Gasoline type: " + this.gasolineType.toString() + "\n" +
				"Tank capacity: " + this.tankCapacity + "\n" +
				"Gasoline consumption: " + calculateGasolineConsumption() + "\n";
				
	}
	

	public double getTankCapacity() {
		return tankCapacity;
	}

	public void setTankCapacity(double tankCapacity) {
		this.tankCapacity = tankCapacity;
	}

	public double getGasolineConsumption() {
		return gasolineConsumption;
	}

	public void setGasolineConsumption(double gasolineConsumption) {
		this.gasolineConsumption = gasolineConsumption;
	}

	public GasolineType getGasolineType() {
		return gasolineType;
	}

	public void setGasolineType(GasolineType gasolineType) {
		this.gasolineType = gasolineType;
	}


}