package model;

import java.util.concurrent.atomic.AtomicInteger;
import java.time.LocalDate;

public abstract class Vehicle implements ISellable {
	
	/**
	 * The previous id to generate the next id.
	 */
	private static AtomicInteger previousID = new AtomicInteger(0);

	/**
	 * The id of the vehicle.
	 */
	private String id;
	
	/**
	 * The base price of the vehicle.
	 */
	private double basePrice;

	/**
	 * The selling price of the vehicle.
	 */
	private double sellingPrice;

	/**
	 * The brand of the vehicle.
	 */
	private String brand;

	/**
	 * The model of the vehicle. The year of the vehicle.
	 */
	private int model;

	/**
	 * The cylinder capacity.
	 */
	private int cylinderCapacity;

	/**
	 * The mileage of the vehicle.
	 */
	private double mileage;

	/**
	 * The license plate of the vehicle.
	 */
	private String licensePlate;

	/**
	 * The documents of the vehicle.
	 */
	private Document [] documents;

	/**
	 * The type of vehicle.
	 */
	private VehicleType type;

	/**
	 * The constructor of the Vehicle class.<br>
	 * It generate the id automatically.
	 */

	public Vehicle(VehicleType type, double basePrice, String brand, int model, int cylinderCapacity, double mileage, String licensePlate, Document [] documents) {
		
		//The id autoincrements.
		this.id = "V" + previousID.incrementAndGet();
		this.basePrice = basePrice;
		this.brand = brand;
		this.model = model;
		this.cylinderCapacity = cylinderCapacity;
		this.mileage = mileage;
		this.licensePlate = licensePlate;
		this.documents = documents;
		this.type = type;
		this.sellingPrice = basePrice;

	}

	/**
	 * Method to calculate the selling price of the vehicle.<br>
	 * If the vehicle's documents are not up to date, the selling price increases by 500,000.<br>
	 * @return The selling price of the vehicle.
	 */
	@Override
	public double calculateSellingPrice() {
		
		if(documents[0] == null || documents[0].getYear() != LocalDate.now().getYear() || documents[1].getYear() != LocalDate.now().getYear())
			this.sellingPrice = basePrice + 500000;
		
		return this.sellingPrice;
	}
	
	/**
	 * Methot to return the information of the vehicle.
	 * @return The information of the vehicle.
	 */
	@Override
	public String toString() {
		
		return "Selling price: $" + this.sellingPrice + "\n" +
				"ID: " + this.id + "\n" +
				"Type: " + this.type.toString() + "\n" +
				"Base price: $" + this.basePrice + "\n" +
				"Brand: " + this.brand + "\n" +
				"Model: " + this.model + "\n" +
				"Cylinder capacity: " + this.cylinderCapacity + "\n" +
				"Mileage: " + this.mileage + "\n" +
				"License plate: " + this.licensePlate + "\n";

	}

	/**
	 * Method to get a document by index.
	 * @param index The index of the document.
	 * @return The document.
	 */
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

	public int getModel() {
		return model;
	}

	public void setModel(int model) {
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