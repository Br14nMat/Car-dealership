package model;

public class HybridCar extends Car implements IGasoline, IBattery {

	private double tankCapacity;
	private double gasolineConsumption;
	private double batteryLife;
	private double batteryConsumption;

	public double getTankCapacity() {
		return this.tankCapacity;
	}

	/**
	 * 
	 * @param tankCapacity
	 */
	public void setTankCapacity(double tankCapacity) {
		this.tankCapacity = tankCapacity;
	}

	public double getGasolineConsumption() {
		return this.gasolineConsumption;
	}

	/**
	 * 
	 * @param gasolineConsumption
	 */
	public void setGasolineConsumption(double gasolineConsumption) {
		this.gasolineConsumption = gasolineConsumption;
	}

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