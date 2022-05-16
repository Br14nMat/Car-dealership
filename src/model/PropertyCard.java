package model;

/**
 * This class represents a property card.
 */
public class PropertyCard extends Document {

	/**
	 * The constructor of the PropertyCard class.
	 * It generate the image and decodes it.
	 */
	public PropertyCard(double price, int year) {
		super(price, year);

		super.generateImage();
		//super.showImage();

		this.decode();

	}

	/**
	 * Method to decode the image. The image is decoded to obtain and set the document code.<br>
	 * Code: Traverse the matrix from bottom to top and from right to left. Then, obtain the numbers whose sum of their positions [i][j] is equal to an even number.
	 */
	@Override
	public void decode() {

		String code = "";
		int[][] image = getImage();

		for (int i = (image.length - 1); i >= 0; i--) {

			for (int j = (image[0].length - 1); j >= 0; j--) {

				if((i + j) % 2 == 0) {
					code += image[i][j];
				}
			}
		}

		super.setCode(code);

	}

}