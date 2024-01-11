
public class Kontrollstrukturen {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("byte:");
		System.out.println(Byte.MIN_VALUE);
		System.out.println(Byte.MAX_VALUE);
		System.out.println(Byte.SIZE);
		
		boolean a1 = 9 > 7;
		System.out.println(a1);
		
		boolean a2 = 9 > 7 && 9 == 9;
		
		System.out.println(a2);
		
		boolean a3 = 9 > 7 && (9 < 23 || 17 >= 10);
		
		System.out.println(a3);
		
		int m = 0;
		
		System.out.println( m++ );
		
		m = 0;
		
		System.out.println( ++m );
		
		m = 0;
		
		System.out.println( m++ + ++m );
	}

}
