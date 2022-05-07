package model;

public abstract class Document {

	private String code;
	private double price;
	private int year;
	private int[][] image;

	public Document(double price, int year) {
		this.price = price;
		this.year = year;
	}

	public double getPrice() {
		return this.price;
	}

	/**
	 * 
	 * @param price
	 */
	public void setPrice(double price) {
		this.price = price;
	}

	public int getYear() {
		return this.year;
	}

	/**
	 * 
	 * @param year
	 */
	public void setYear(int year) {
		this.year = year;
	}

	public String getCode() {
		return this.code;
	}

	/**
	 * 
	 * @param code
	 */
	public void setCode(String code) {
		this.code = code;
	}

	public abstract void decode();

	public Document() {
		// TODO - implement Document.Document
		throw new UnsupportedOperationException();
	}

}