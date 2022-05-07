package model;

public class Motorcycle extends Vehicle implements IGasoline {

	private double gasolineCapacity;
	private double gasolineConsumption;

	public Motorcycle(VehicleType type, double basePrice, String brand, String model, int cylinderCapacity, double mileage, String licensePlate, Document [] documents, double gasolineCapacity, double gasolineConsumption) {
		super(type, basePrice, brand, model, cylinderCapacity, mileage, licensePlate, documents);
		this.gasolineCapacity = gasolineCapacity;
		this.gasolineConsumption = gasolineConsumption;
	}

	@Override
	public void calculateGasolineConsumption() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void calculateSellingPrice() {
		// TODO Auto-generated method stub
		
	}

}