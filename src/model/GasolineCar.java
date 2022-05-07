package model;

public class GasolineCar extends Car implements IGasoline {

	private double tankCapacity;
	private double gasolineConsumption;

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

}