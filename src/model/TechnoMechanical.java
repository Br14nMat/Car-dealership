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


	public void setGasEmitted(double gasEmitted) {
		this.gasEmitted = gasEmitted;
	}

	@Override
	public void decode() {
		// TODO Auto-generated method stub
		
	}

	

}