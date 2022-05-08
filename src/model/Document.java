package model;

public abstract class Document {

	private String code;
	private double price;
	private int year;
	private int[][] image;

	public Document(double price, int year) {
		this.price = price;
		this.year = year;

		generateImage();
	}

	public void generateImage() {

	}

	public abstract void decode();

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	

}