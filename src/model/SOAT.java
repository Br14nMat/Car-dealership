package model;

/**
 * This class represents a SOAT document.
 */

public class SOAT extends Document {

	/**
	 * The coverage amount of the SOAT.
	 */
	private double coverageAmount;

	/**
	 * The constructor of the SOAT class.
	 * It generate the image and decodes it.
	 */
	public SOAT(double price, int year, double coverageAmount) {
		super(price, year);
		this.coverageAmount = coverageAmount;

		super.generateImage();
		//super.showImage();

		this.decode();

	}

	/**
	 * Method to decode the image. The image is decoded to obtain and set the document code.<br>
	 * Code: L-shaped path through the matrix.<br>
	 */
	@Override
	public void decode() {
		
		String code = "";
		int [][] image = super.getImage();

		for(int i = 0; i < image.length; i++) {

			code += super.getImage()[i][0];

			for(int j = 1; i == (image.length - 1) && j < image[0].length; j++) {
				code += super.getImage()[i][j];
			}

		}

		super.setCode(code);

	}

	public double getCoverageAmount() {
		return this.coverageAmount;
	}

	public void setCoverageAmount(double coverageAmount) {
		this.coverageAmount = coverageAmount;
	}

}