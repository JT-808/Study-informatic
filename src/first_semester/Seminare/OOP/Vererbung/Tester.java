package vererbung;

public class Tester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		KlasseA kA = new KlasseA("Heute");
		System.out.println(kA.toString());
		System.out.println("--------------");
		KlasseB kB = new KlasseB();
		System.out.println(kB.toString());
		System.out.println("--------------");
		KlasseC kC = new KlasseC();
		System.out.println(kC.toString());
		System.out.println(kC.toStringEltern());
	}

}
