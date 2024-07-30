package application;

import java.io.Serializable;


public class SpeicherLinie implements Serializable
{
	private static final long serialVersionUID = 1L;
	private double anfangX;
	private double anfangY;
	private double endeX;
	private double endeY;
	private double malFarbeR;
	private double malFarbeG;
	private double malFarbeB;
	
	public SpeicherLinie(double anfangX, double anfangY,double endeX, double endeY,
			double malFarbeR,double malFarbeG,double malFarbeB )
	{
		this.anfangX=anfangX;
		this.anfangY=anfangY;
		this.endeX=endeX;
		this.endeY=endeY;
		this.malFarbeR=malFarbeR;
		this.malFarbeG=malFarbeG;
		this.malFarbeB=malFarbeB;
	}
	
	public double getAnfangX() {
		return anfangX;
	}

	public double getAnfangY() {
		return anfangY;
	}



	public double getEndeX() {
		return endeX;
	}



	public double getEndeY() {
		return endeY;
	}



	public double getMalFarbeR()
	{
		return malFarbeR;
	}
	public double getMalFarbeG()
	{
		return malFarbeG;
	}
	public double getMalFarbeB()
	{
		return malFarbeB;
	}

	
	
	
}