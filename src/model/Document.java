package model;

/**
 * This class represents a Document.
 */

public abstract class Document {
	
	/**
	 * The code of the document.
	 */
	private String code;

	/**
	 * The price of the document.
	 */
	private double price;

	/**
	 * The year of the document.
	 */
	private int year;

	/**
	 * The image of the document. It is a matrix of integers.
	 */
	private int[][] image;

	/**
	 * The contructor of the Document class.
	 */
	public Document(double price, int year) {
		this.price = price;
		this.year = year;

		image = new int[4][4];

	}

	/**
	 * Method to generate the image of the document. It fills the image matrix with random numbers between 1 and 99.
	 */
	public void generateImage() {

		for(int i = 0; i < image.length; i++) {
			for(int j = 0; j < image[0].length; j++) {
				image[i][j] = (int) (Math.random() * (99) + 1);
			}
		}

	}

	/**
	 * Method to return the image of the document.
	 * @return the image of the document.
	 */
	public String showImage() {

		String img = "";

		for (int i = 0; i < image.length; i++) {
			
			for (int j = 0; j < image.length; j++) {
				
				img += image[i][j] + " ";
				
			}
			
			img += "\n";
		}

		return img;
	}	

	/**
	 * Method to return the information of the document.
	 */
	public String toString(){

		return "Code: " + code + "\n" +
				"Price: " + price + "\n" +
				"Year: " + year + "\n" +
				"Image: \n" + showImage();

	}

	public abstract void decode();

	public int [][] getImage() {
		return image;
	}

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