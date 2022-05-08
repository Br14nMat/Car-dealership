package model;

public class ElectricCar extends Car implements IBattery {

	private ChargerType chargerType;
	private int batteryLife;
	private double batteryConsumption;

	public ElectricCar(VehicleType type, double basePrice, String brand, String model, int cylinderCapacity, double mileage, String licensePlate, Document [] documents, CarType caryType, int doorsNumber, boolean hasTintedWindows, ChargerType chargerType, int batteryLife, double batteryConsumption){

		super(type, basePrice, brand, model, cylinderCapacity, mileage, licensePlate, documents, caryType, doorsNumber, hasTintedWindows);
		
		this.chargerType = chargerType;
		this.batteryLife = batteryLife;
		this.batteryConsumption = batteryConsumption;

		System.out.println(calculateSellingPrice());
		calculateBatteryConsumption();

	}

	@Override
	public void calculateBatteryConsumption() {
		
		if(this.chargerType == ChargerType.FAST) {
			this.batteryConsumption = (batteryLife + 13) * (super.getCylinderCapacity() / 100);
		}else{
			this.batteryConsumption = (batteryLife + 18) * (super.getCylinderCapacity() / 100);
		}
		
	}

	@Override
	public double calculateSellingPrice() {
		
		double sellingPrice = 0;
		sellingPrice = super.calculateSellingPrice();

		sellingPrice += super.getBasePrice() * 0.2;
		super.setSellingPrice(sellingPrice);

		return sellingPrice;
		
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