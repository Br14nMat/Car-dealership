package model;

/**
 * This interface represents the behavior of battery-powered vehicles.
 */

public interface IBattery {

	/**
	 * This method will calculate the battery consumption of the vehicle that implements this interface.
	 * @return the battery consumption.
	 */
	double calculateBatteryConsumption();

}