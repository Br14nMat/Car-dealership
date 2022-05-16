package model;

/**
 * This interface represents the behavior of vehicles that can be sold.
 */
public interface ISellable {

	/**
	 * This method will calculate the selling price of the vehicle.
	 * @return the selling price.
	 */
	double calculateSellingPrice();

}