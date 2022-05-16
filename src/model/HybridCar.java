package model;

/**
 * This class represents a HybridCar.
 */
public class HybridCar extends Car implements IGasoline, IBattery {

	/**
	 * The type of gasoline.
	 */
	private GasolineType gasolineType;

	/**
	 * The type of charger.
	 */
	private ChargerType chargerType;

	/**
	 * The tank capacity.
	 */
	private double tankCapacity;

	/**
	 * The gasoline consumption.
	 */
	private double gasolineConsumption;

	/**
	 * The battery life.
	 */
	private double batteryLife;

	/**
	 * The battery consumption.
	 */
	private double batteryConsumption;

	/**
	 * The contructor of the HybridCar class.<br>
	 * It calls the calculateSellingPrice to calculate the selling price of the HybridCar.<br>
	 * It calls the calculateGasolineConsumption to calculate the gasoline consumption.<br>
	 * It calls the calculateBatteryConsumption to calculate the battery consumption.<br>
	 */
	public HybridCar(VehicleType type, double basePrice, String brand, int model, int cylinderCapacity, double mileage, String licensePlate, Document [] documents, CarType caryType, int doorsNumber, boolean hasTintedWindows, GasolineType gasolineType, double tankCapacity, ChargerType chargerType, double batteryLife){
		super(type, basePrice, brand, model, cylinderCapacity, mileage, licensePlate, documents, caryType, doorsNumber, hasTintedWindows);
		
		this.gasolineType = gasolineType;
		this.chargerType = chargerType;
		this.tankCapacity = tankCapacity;
		this.batteryLife = batteryLife;

		calculateSellingPrice();

		calculateBatteryConsumption();
		calculateGasolineConsumption();
	}

	/**
	 * Method to calculate and set the battery consumption.
	 * @return the battery consumption.
	 */
	@Override
	public double calculateBatteryConsumption() {
		
		if(this.chargerType == ChargerType.FAST) {
			this.batteryConsumption = ((double)batteryLife) * (super.getCylinderCapacity() / 200.0);
		}else{
			this.batteryConsumption = ((double)batteryLife + 7) * (super.getCylinderCapacity() / 200.0);
		}

		return batteryConsumption;
		
	}
	
	/**
	 * Method to calculate and set the gasoline consumption.
	 * @return the gasoline consumption.
	 */
	@Override
	public double calculateGasolineConsumption() {
		
		gasolineConsumption = tankCapacity * (super.getCylinderCapacity() / 180.0);
		
		return gasolineConsumption;
	}

	/**
	 * Method to calculate and set the selling price of the HybridCar. It calls the calculateSellingPrice method of the superclass Car.<br>
	 * Hybrid cars cost an additional 15% of their base price.
	 * @return the selling price of the HybridCar.
	 */

	@Override
	public double calculateSellingPrice() {
		double sellingPrice = 0;
		sellingPrice = super.calculateSellingPrice();
		
		sellingPrice += super.getBasePrice() * 0.15;
		super.setSellingPrice(sellingPrice);

		return sellingPrice;
		
	}

	/**
	 * Method to return the information of the HybridCar. It calls the toString method of the superclass Car.
	 */
	@Override
	public String toString() {
		
		return super.toString() +
				"Gasoline type: " + this.gasolineType.toString() + "\n" +
				"Tank capacity: " + this.tankCapacity + "\n" +
				"Gasoline consumption: " + calculateGasolineConsumption() + "\n" +
				"Charger type: " + this.chargerType.toString() + "\n" +
				"Battery life: " + this.batteryLife + "\n" +
				"Battery consumption: " + calculateBatteryConsumption() + "\n";
	
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

	public double getBatteryLife() {
		return batteryLife;
	}

	public void setBatteryLife(double batteryLife) {
		this.batteryLife = batteryLife;
	}

	public double getBatteryConsumption() {
		return batteryConsumption;
	}

	public void setBatteryConsumption(double batteryConsumption) {
		this.batteryConsumption = batteryConsumption;
	}

	

	public GasolineType getGasolineType() {
		return gasolineType;
	}

	public void setGasolineType(GasolineType gasolineType) {
		this.gasolineType = gasolineType;
	}

	public ChargerType getChargerType() {
		return chargerType;
	}

	public void setChargerType(ChargerType chargerType) {
		this.chargerType = chargerType;
	}

}