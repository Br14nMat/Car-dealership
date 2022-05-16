package model;

/**
 * This class represents a Motorcycle.
 */
public class Motorcycle extends Vehicle implements IGasoline {

	/**
	 * The type of motorcycle.
	 */
	private MotorcycleType type;

	/**
	 * The gasolince capacity.
	 */
	private double gasolineCapacity;

	/**
	 * The gasoline consumption.
	 */
	private double gasolineConsumption;

	/**
	 * The constructor of the Motorcycle class.<br>
	 * It calls the calculateSellingPrice to calculate the selling price of the Motorcycle.<br>
	 * It calls the calculateGasolineConsumption to calculate the gasoline consumption.<br>
	 */
	public Motorcycle(VehicleType type, double basePrice, String brand, int model, int cylinderCapacity, double mileage, String licensePlate, Document [] documents, MotorcycleType motorcycleType, double gasolineCapacity) {
		super(type, basePrice, brand, model, cylinderCapacity, mileage, licensePlate, documents);
		this.gasolineCapacity = gasolineCapacity;
		this.type = motorcycleType;

		calculateGasolineConsumption();

		calculateSellingPrice();

	}

	/**
	 * Method to calculate and set the gasoline consumption.
	 * @return the gasoline consumption.
	 */
	@Override
	public double calculateGasolineConsumption() {
		
		gasolineConsumption = gasolineCapacity * (super.getCylinderCapacity()/75.0);

		return gasolineConsumption;
	}

	/**
	 * Method to calculate and set the selling price of the Motorcycle. It calls the calculateSellingPrice method of the superclass Vehicle.<br>
	 * Motorcycles cost an additional 4% of their base price.<br>
	 * If the motorcycle is used, there is a 2% discount.<br>
	 */
	@Override
	public double calculateSellingPrice() {
		double sellingPrice = 0;
		sellingPrice = super.calculateSellingPrice();

		sellingPrice += super.getBasePrice() * 0.04;

		if(super.getType() == VehicleType.USED) {
			sellingPrice -= super.getBasePrice() * 0.02;
		}

		super.setSellingPrice(sellingPrice);

		return sellingPrice;

	}
	
	/**
	 * Method to return the information of the motorcycle.
	 * @return the information of the motorcycle.
	 */
	@Override
	public String toString() {

		return super.toString() +
				"Motorcyle type: " + this.type.toString() + "\n" +
				"Gasoline capacity: " + this.gasolineCapacity + "\n" +
				"Gasoline consumption: " + calculateGasolineConsumption() + "\n";

	}

	public double getGasolineCapacity() {
		return gasolineCapacity;
	}

	public void setGasolineCapacity(double gasolineCapacity) {
		this.gasolineCapacity = gasolineCapacity;
	}

	public double getGasolineConsumption() {
		return gasolineConsumption;
	}

	public void setGasolineConsumption(double gasolineConsumption) {
		this.gasolineConsumption = gasolineConsumption;
	}
	

}