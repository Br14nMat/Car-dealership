package model;

import java.util.concurrent.atomic.AtomicInteger;
import java.time.LocalDate;

public abstract class Vehicle implements ISellable {
	
	private static AtomicInteger count = new AtomicInteger(0); 
	private String id;
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
		
		this.id = "V" + count.incrementAndGet();
		this.basePrice = basePrice;
		this.brand = brand;
		this.model = model;
		this.cylinderCapacity = cylinderCapacity;
		this.mileage = mileage;
		this.licensePlate = licensePlate;
		this.sellingPrice = 0;
		this.documents = documents;

	}

	@Override
	public double calculateSellingPrice() {
		
		if(documents[0] == null || documents[1].getYear() != LocalDate.now().getYear())
			this.sellingPrice = basePrice + 500000;
		
		return this.sellingPrice;
	}
	

	public Document getDocument(int index) {
		return documents[index];
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public VehicleType getType() {
		return type;
	}

	public void setType(VehicleType type) {
		this.type = type;
	}

	public double getBasePrice() {
		return basePrice;
	}

	public void setBasePrice(double basePrice) {
		this.basePrice = basePrice;
	}

	public double getSellingPrice() {
		return sellingPrice;
	}

	public void setSellingPrice(double sellingPrice) {
		this.sellingPrice = sellingPrice;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getCylinderCapacity() {
		return cylinderCapacity;
	}

	public void setCylinderCapacity(int cylinderCapacity) {
		this.cylinderCapacity = cylinderCapacity;
	}

	public double getMileage() {
		return mileage;
	}

	public void setMileage(double mileage) {
		this.mileage = mileage;
	}

	public String getLicensePlate() {
		return licensePlate;
	}

	public void setLicensePlate(String licensePlate) {
		this.licensePlate = licensePlate;
	}

	

}