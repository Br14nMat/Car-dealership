package model;

public class GasolineCar extends Car implements IGasoline {
	
	private GasolineType gasolineType;
	private double tankCapacity;
	private double gasolineConsumption;

	public GasolineCar(VehicleType type, double basePrice, String brand, String model, int cylinderCapacity, double mileage, String licensePlate, Document [] documents, CarType caryType, int doorsNumber, boolean hasTintedWindows, GasolineType gasolineType, double tankCapacity, double gasolineConsumption){

		super(type, basePrice, brand, model, cylinderCapacity, mileage, licensePlate, documents, caryType, doorsNumber, hasTintedWindows);
		this.gasolineType = gasolineType;
		this.tankCapacity = tankCapacity;
		this.gasolineConsumption = gasolineConsumption;

		super.calculateSellingPrice();
		calculateGasolineConsumption();

	}

	@Override
	public void calculateGasolineConsumption() {
		
		gasolineConsumption = tankCapacity * (super.getCylinderCapacity() / 150);
		
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

	

}