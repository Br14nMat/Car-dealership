package model;

/**
 * This class represents a Techno Mechanical document.
 */
public class TechnoMechanical extends Document {

	/**
	 * The levels of gases emitted by the car.
	 */
	private double gasEmitted;

	/**
	 * The constructor of the Techno Mechanical class.
	 * It generate the image and decodes it.
	 */
	public TechnoMechanical(double price, int year, double gasEmitted) {
		super(price, year);
		this.gasEmitted = gasEmitted;

		super.generateImage();
		//super.showImage();

		this.decode();
		
	}

	/**
	 * Method to decode the image. The image is decoded to obtain and set the document code.<br>
	 * Code: Z-shaped path through the matrix.<br>
	 */
	@Override
	public void decode() {

		String code = "";
		int [][] image = this.getImage();

		for(int i = 0; i < image.length; i++) {

			for(int j = 0; j < image[0].length; j++){
				
				if(i == 0 || i == (image.length - 1)){

					code += image[i][j];

				}else if(i + j == (image.length - 1)){
					code += image[i][j];
				}

			}
		}

		super.setCode(code);

	}

	public double getGasEmitted() {
		return this.gasEmitted;
	}


	public void setGasEmitted(double gasEmitted) {
		this.gasEmitted = gasEmitted;
	}
	
}