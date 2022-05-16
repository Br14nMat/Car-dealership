package model;

/**
 * This interface represents the behavior of vehicles using gasoline.<br>
 */
public interface IGasoline {

	/**
	 * This method will calculate the gasoline consumption of the vehicle that implements this interface.
	 * @return the gasoline consumption.
	 */
	double calculateGasolineConsumption();

}