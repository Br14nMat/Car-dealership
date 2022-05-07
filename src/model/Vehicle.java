package model;

public abstract class Vehicle implements ISellable {

	private double basePrice;
	private double sellingPrice;
	private String brand;
	private String model;
	private int cylinderCapacity;
	private double mileage;
	private String licensePlate;
	private Document [] documents;
	private VehicleType type;

	public Vehicle(VehicleType type, double basePrice, String brand, String model, int cylinderCapacity, double mileage, String licensePlate, Document [] documents) {
		
		this.basePrice = basePrice;
		this.brand = brand;
		this.model = model;
		this.cylinderCapacity = cylinderCapacity;
		this.mileage = mileage;
		this.licensePlate = licensePlate;

		this.documents = documents;

	}

	public abstract void calculateSellingPrice();

}