package model;

/**
 * This class represents a ElectricCar.
 */
public class ElectricCar extends Car implements IBattery {

	/**
	 * The type of charger.
	 */
	private ChargerType chargerType;

	/**
	 * The battery life.
	 */
	private int batteryLife;

	/**
	 * The battery consumption.
	 */
	private double batteryConsumption;

	/**
	 * The contructor of the ElectricCar class.<br>
	 * It calls the calculateSellingPrice to calculate the selling price of the ElectricCar.<br>
	 * It calls the calculateBatteryConsumption to calculate the battery consumption.<br>
	 */

	public ElectricCar(VehicleType type, double basePrice, String brand, int model, int cylinderCapacity, double mileage, String licensePlate, Document [] documents, CarType caryType, int doorsNumber, boolean hasTintedWindows, ChargerType chargerType, int batteryLife){

		super(type, basePrice, brand, model, cylinderCapacity, mileage, licensePlate, documents, caryType, doorsNumber, hasTintedWindows);
		
		this.chargerType = chargerType;
		this.batteryLife = batteryLife;

		calculateSellingPrice();
		calculateBatteryConsumption();

	}

	/**
	 * Method to calculate and set the battery consumption.
	 * @return the battery consumption.
	 */
	@Override
	public double calculateBatteryConsumption() {
		
		if(this.chargerType == ChargerType.FAST) {
			this.batteryConsumption = ((double)batteryLife + 13) * (super.getCylinderCapacity() / 100.0);
		}else{
			this.batteryConsumption = ((double)batteryLife + 18) * (super.getCylinderCapacity() / 100.0);
		}

		return this.batteryConsumption;
		
	}

	/**
	 * Method to calculate and set the selling price of the ElectricCar. It calls the calculateSellingPrice method of the superclass Car.<br>
	 * Electric cars cost an additional 20% of their base price.
	 */
	@Override
	public double calculateSellingPrice() {
		
		double sellingPrice = 0;
		sellingPrice = super.calculateSellingPrice();

		sellingPrice += super.getBasePrice() * 0.2;
		super.setSellingPrice(sellingPrice);

		return sellingPrice;
		
	}
	
	/**
	 * Method to return the information of the ElectricCar. It calls the toString method of the superclass Car.
	 */
	@Override
	public String toString() {
		
		return super.toString() +
				"Charger type: " + this.chargerType.toString() + "\n" +
				"Battery life: " + this.batteryLife + "\n" +
				"Battery consumption: " + calculateBatteryConsumption() + "\n";

	}

	public int getBatteryLife() {
		return batteryLife;
	}

	public void setBatteryLife(int batteryLife) {
		this.batteryLife = batteryLife;
	}

	public double getBatteryConsumption() {
		return batteryConsumption;
	}

	public void setBatteryConsumption(double batteryConsumption) {
		this.batteryConsumption = batteryConsumption;
	}

}