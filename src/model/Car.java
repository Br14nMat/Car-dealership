package model;

public abstract class Car extends Vehicle {

	private CarType type;
	private int doorsNumber;
	private boolean hasTintedWindows;

	public Car(VehicleType type, double basePrice, String brand, String model, int cylinderCapacity, double mileage, String licensePlate, Document [] documents, CarType carType, int doorsNumber, boolean hasTintedWindows){
		super(type, basePrice, brand, model, cylinderCapacity, mileage, licensePlate, documents);

		this.type = carType;
		this.doorsNumber = doorsNumber;
		this.hasTintedWindows = hasTintedWindows;

	}

	@Override
	public double calculateSellingPrice() {
		double sellingPrice = 0;
		sellingPrice = super.calculateSellingPrice();

		if(super.getType() == VehicleType.USED)
			sellingPrice -= super.getBasePrice() * 0.1;
		
		super.setSellingPrice(sellingPrice);

		return sellingPrice;

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