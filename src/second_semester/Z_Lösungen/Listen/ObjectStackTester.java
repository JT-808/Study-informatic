/**
 * 
 * Zum testen des Stacks
 * 
 * @author Knut Altroggen
 *
 */
public class ObjectStackTester {

	/**
	 * 
	 * Unsere Lieblingsmethode
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		ObjectStack stack = new ObjectStack();//Objekt anlegen
		System.out.println(stack);//Stack ausgeben
		for( int i = 0; i<10;i++) {
			stack.push(new Integer(i));//Element i einfuegen
			System.out.println(stack);//Stack ausgeben
		}
		System.out.println("--------------------");
		for( int i = 0; i<10;i++) {
			stack.pop();//Element von Stack holen
			System.out.println(stack);//Stack ausgeben
		}
		System.out.println("----Fehler----");
		stack.pop();//Fehlermeldung erzeugen
	}

}
