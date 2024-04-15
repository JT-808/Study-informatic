package ÜbungRational;

public class Rational {

	
	private int zaehler;
	private int nenner;
	
	public Rational(int z, int n) {
		zaehler = z;
		nenner  = n;
	}
	public Rational() {
		zaehler =0;
		nenner  =1;
	}
	public int getZaehler() {
		return zaehler;
	}
	public int getNenner() {
		return nenner;
	}
	public String toString() {
		return zaehler + "/" + nenner;
	}
	public boolean equals(Rational r) {
		return (this.zaehler*r.nenner == this.nenner*r.zaehler);
	}
	public double doubleWert() {
		return ((double)zaehler) / ((double)nenner);
	}
	
	
	
	public Rational plus(Rational r) {
		return new  Rational(this.zaehler*r.nenner*r.zaehler+this.nenner*r.zaehler, this.nenner*r.nenner);
	}
}

