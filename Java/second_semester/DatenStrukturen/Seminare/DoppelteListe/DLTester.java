package DoppelteListe;

public class DLTester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		DLMyList<String> meineListe = new DLMyList<String>();
		System.out.println(meineListe);

		meineListe.addStart("Heute");
		System.out.println(meineListe);

		meineListe.addStart("Hallo");
		System.out.println(meineListe);

		meineListe.addEnde("Dienstag");
		System.out.println(meineListe);

		meineListe.addEnde("April");
		System.out.println(meineListe);

		System.out.println(meineListe.size());

		System.out.println(meineListe.removeStart());
		System.out.println(meineListe.removeStart());
		System.out.println(meineListe.removeEnde());
		System.out.println(meineListe.removeStart());

		System.out.println(meineListe.size());

		System.out.println(meineListe.removeEnde());

	}

}
