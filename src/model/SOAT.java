package model;

public class SOAT extends Document {

	private double coverageAmount;

	public SOAT(double price, int year, double coverageAmount) {
		super(price, year);
		this.coverageAmount = coverageAmount;
	}


	public double getCoverageAmount() {
		return this.coverageAmount;
	}

	/**
	 * 
	 * @param coverageAmount
	 */
	public void setCoverageAmount(double coverageAmount) {
		this.coverageAmount = coverageAmount;
	}

	public void decode() {
		// TODO - implement SOAT.decode
		throw new UnsupportedOperationException();
	}

}