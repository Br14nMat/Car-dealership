package model;

public class TechnoMechanical extends Document {

	private double gasEmitted;

	public TechnoMechanical(double price, int year, double gasEmitted) {
		super(price, year);
		this.gasEmitted = gasEmitted;
	}

	public double getGasEmitted() {
		return this.gasEmitted;
	}

	/**
	 * 
	 * @param gasEmitted
	 */
	public void setGasEmitted(double gasEmitted) {
		this.gasEmitted = gasEmitted;
	}

	public void decode() {
		// TODO - implement TechnoMechanical.decode
		throw new UnsupportedOperationException();
	}

}