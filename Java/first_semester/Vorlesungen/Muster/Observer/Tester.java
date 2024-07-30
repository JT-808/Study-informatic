package observermuster;

public class Tester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Nachrichten nachrichten = new Nachrichten();
		Sportkanal sk1 = new Sportkanal();
		
		nachrichten.addObserver(sk1);
		
		
		nachrichten.sendeNachricht("HAllo Mittweida");
		
		System.out.println(sk1);
	}

}
