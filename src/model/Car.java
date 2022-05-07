package model;

public abstract class Car extends Vehicle {

	private int doorsNumber;
	private boolean hasTintedWindows;

	public int getDoorsNumber() {
		return this.doorsNumber;
	}

	/**
	 * 
	 * @param doorsNumber
	 */
	public void setDoorsNumber(int doorsNumber) {
		this.doorsNumber = doorsNumber;
	}

	public boolean hasTintedWindows() {
		// TODO - implement Car.hasTintedWindows
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param hasTintedWindows
	 */
	public void setTintedWindows(boolean hasTintedWindows) {
		// TODO - implement Car.setTintedWindows
		throw new UnsupportedOperationException();
	}

}