
public class Main {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Umwandlung umwandlung = new Umwandlung();
		umwandlung.leseFilmeEin("res\\filme.txt");
		umwandlung.wandleFilmeUm("res\\filme.xml");
		System.out.println("Umwandlung abgeschlossen");
	}

}
