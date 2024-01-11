package singleton;

public class Singleton {
	
	private static final Singleton OBJ = new Singleton();
	
	private Singleton() {
		System.out.println("Hallo Mittweida");
	}
	
	public static Singleton getInstance() {
		return OBJ;
	}

}
