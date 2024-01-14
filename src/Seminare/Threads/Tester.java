package nebenlaeufigkeit;

public class Tester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Person a = new Person("A");
		Person b = new Person("B");
		
		new Thread(()->a.leihen(b)).start();
		new Thread(()->b.leihen(a)).start();

	}

}
