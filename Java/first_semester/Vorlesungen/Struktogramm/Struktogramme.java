package oop;

public class Struktogramme {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(Struktogramme.ggt(4, 12));
		System.out.println(ggt(4,12));
		Struktogramme struk = new Struktogramme();
		
		
	}
	
	public static int ggt(int a, int b) {
		if ( a < b) {
			int tmp = a;
			a = b;
			b = tmp;
		}
		int r = a % b;
		while( r > 0) {
			a = b;
			b = r;
			r = a % b;
		}
		return b;
	}

}
