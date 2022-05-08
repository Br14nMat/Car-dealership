package model;

import java.time.LocalDate;

public class Motorcycle extends Vehicle implements IGasoline {

	private MotorcycleType type;
	private double gasolineCapacity;
	private double gasolineConsumption;

	public Motorcycle(VehicleType type, double basePrice, String brand, String model, int cylinderCapacity, double mileage, String licensePlate, Document [] documents, MotorcycleType motorcycleType, double gasolineCapacity, double gasolineConsumption) {
		super(type, basePrice, brand, model, cylinderCapacity, mileage, licensePlate, documents);
		this.gasolineCapacity = gasolineCapacity;
		this.gasolineConsumption = gasolineConsumption;
		this.type = motorcycleType;

		calculateGasolineConsumption();
		calculateSellingPrice();

	}

	@Override
	public void calculateGasolineConsumption() {
	
		gasolineConsumption = gasolineCapacity * (super.getCylinderCapacity()/75);
		
	}

	@Override
	public double calculateSellingPrice() {
		double sellingPrice = 0;
		sellingPrice = super.calculateSellingPrice();

		if(super.getType() == VehicleType.USED)
			sellingPrice -= super.getBasePrice() * 0.02;

		sellingPrice += super.getBasePrice() * 0.04;

		super.setSellingPrice(sellingPrice);

		return sellingPrice;

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