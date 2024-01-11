package zahlen;

import java.math.BigDecimal;
import java.math.BigInteger;

public class Zahlen {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		berechne();
		fakultaet();
	}
	
	public static void fakultaet() {
		BigInteger produkt = new BigInteger("1");
		for( int m = 1; m < 10000; m++) {
			produkt = produkt.multiply(new BigInteger(m+""));
		}
		System.out.println(produkt);
	}
	
	public static void berechne() {
		double a = 0.02;
		double b = 0.03;
		double c = b - a;
		System.out.println(c);
		
		BigDecimal aNeu = new BigDecimal("0.02");
		BigDecimal bNeu = new BigDecimal("0.03");
		BigDecimal cNeu = bNeu.subtract(aNeu);
		
		System.out.println(cNeu);
		
		BigDecimal geld = new BigDecimal("10.00");
		for(BigDecimal preis = new BigDecimal(".10");
				geld.compareTo(preis) >= 0 ;
				preis = preis.add(new BigDecimal("0.10"))) {
			geld = geld.subtract(preis);
		}
		System.out.println(geld);
	}

}
