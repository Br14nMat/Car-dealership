package model;

public class HybridCar extends Car implements IGasoline, IBattery {

	private GasolineType gasolineType;
	private ChargerType chargerType;
	private double tankCapacity;
	private double gasolineConsumption;
	private double batteryLife;
	private double batteryConsumption;

	public HybridCar(VehicleType type, double basePrice, String brand, String model, int cylinderCapacity, double mileage, String licensePlate, Document [] documents, CarType caryType, int doorsNumber, boolean hasTintedWindows, GasolineType gasolineType, double tankCapacity, double gasolineConsumption, ChargerType chargerType, double batteryLife, double batteryConsumption){
		super(type, basePrice, brand, model, cylinderCapacity, mileage, licensePlate, documents, caryType, doorsNumber, hasTintedWindows);
		
		this.gasolineType = gasolineType;
		this.chargerType = chargerType;
		this.tankCapacity = tankCapacity;
		this.gasolineConsumption = gasolineConsumption;
		this.batteryLife = batteryLife;
		this.batteryConsumption = batteryConsumption;

		calculateSellingPrice();

		calculateBatteryConsumption();
		calculateBatteryConsumption();

	}

	@Override
	public void calculateBatteryConsumption() {
		
		if(this.chargerType == ChargerType.FAST) {
			this.batteryConsumption = batteryLife * (super.getCylinderCapacity() / 200);
		}else{
			this.batteryConsumption = (batteryLife + 7) * (super.getCylinderCapacity() / 200);
		}
		
	}

	@Override
	public void calculateGasolineConsumption() {
		
		gasolineConsumption = tankCapacity * (super.getCylinderCapacity() / 180);
		
	}

	@Override
	public double calculateSellingPrice() {
		double sellingPrice = 0;
		sellingPrice = super.calculateSellingPrice();

		sellingPrice += super.getBasePrice() * 0.15;
		super.setSellingPrice(sellingPrice);

		return sellingPrice;
		
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


}