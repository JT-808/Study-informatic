package ÜbungRational;

public class Rational2 {

	
	private int zaehler;
	private int nenner;
	
	public Rational2(int z, int n) {
		zaehler = z;
		nenner  = n;
	}
	public Rational2() {
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
	public boolean equals(Rational2 r) {
		return (this.zaehler*r.nenner == this.nenner*r.zaehler);
	}
	public double doubleWert() {
		return ((double)zaehler) / ((double)nenner);
	}
	
	
	
	public Rational2 plus(Rational2 r) {
		return new  Rational2(this.zaehler*r.nenner*r.zaehler+this.nenner*r.zaehler, this.nenner*r.nenner);
	}
}

