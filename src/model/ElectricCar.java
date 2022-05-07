package model;

public class ElectricCar extends Car implements IBattery {

	private int batteryLife;
	private double batteryConsumption;

	public double getBatteryLife() {
		return this.batteryLife;
	}

	/**
	 * 
	 * @param batteryLife
	 */
	public void setBatteryLife(double batteryLife) {
		this.batteryLife = batteryLife;
	}

	public double getBatteryConsumption() {
		return this.batteryConsumption;
	}

	/**
	 * 
	 * @param batteryConsumption
	 */
	public void setBatteryConsumption(double batteryConsumption) {
		this.batteryConsumption = batteryConsumption;
	}

}