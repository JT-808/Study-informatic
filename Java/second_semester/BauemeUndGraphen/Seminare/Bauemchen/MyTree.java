package second_semester.BauemeUndGraphen.Seminare.Bauemchen;

public class MyTree <E extends Comparable<E>> {

	private Node<E> root;//der Baum kennt nur die Wurzel
	
	public MyTree() {
		root = null;//leerer Baum
	}
	
	public MyTree(E data) {
		root = new Node<E>(data);
		//erzeugt einen BAum der nur aus der Wurzel besteht mit den 
		//Daten als Inhalt
		//Baum besteht in diesen Fall nur aus einen Blatt
	}
	
	public MyTree(Node<E> root) {
		this.root = root;//zum durchlaufen des Baumes
	}
	
	public void insert(E data) {
		if(root == null) {
			//noch kein Baum vorhanden, nur der leere Baum
			//Daten werden die Wurzel
			root = new Node<E>(data);
		}else {
			//in der Wurzel steht etwas
			if(data.equals(root.getData())) {
				//DAten und Daten aus Wurzel sind gleich
				System.out.println("keine doppelten Werte");
			}else {
				//Daten sind nicht die Daten in der Wurzel
				//Daten sind entweder kleiner oder groesser als die
				//Daten in der Wurzel
				
				if(data.compareTo(root.getData()) < 0) {
					//DAten sind kleiner als die Daten in der Wurzel
					//links der Wurzel einfuegen
					
					MyTree<E> left =
							new MyTree<E>(root.getLeftTree());
					left.insert(data);
					root.setLeftTree(left.root);
				}
				
				if(data.compareTo(root.getData()) > 0) {
					//Daten sind groesser als die DAten in der Wurzel
					//rechts der Wurzel einfuegen
					MyTree<E> right =
							new MyTree<E>(root.getRightTree());
					right.insert(data);
					root.setRightTree(right.root);
				}
			}
		}
	}
	
	public Node<E> find(E data){
		if(root == null) {
			return null;
		}else {
			if(root.getData().equals(data)) {
				//Daten sind gleich den DAten in der Wurzel
				// -> Wurzel zurueck
				return root;
			}else {
				//DAten sind nicht das Wurzelelement
				//Daten sind entweder groesser oder kleiner als das
				//Wurzelelement
				
				if(data.compareTo(root.getData()) < 0) {
					//DAten sind kleiner als das Wurzelelement
					//-> im linken Teilbaum weitersuchen
					MyTree<E> left =
							new MyTree<E>(root.getLeftTree());
					return left.find(data);
				}else {
					//Daten sind groesser als das Wurzelelement
					//-> im rechten TEilbaum weitersuchen
					MyTree<E> right=
							new MyTree<E>(root.getRightTree());
					return right.find(data);
				}
			}
		}
	}
	
	public String preOrder() {
		if(root == null) {
			return "";
		}else {
			MyTree<E> left = new MyTree<E>(root.getLeftTree());
			MyTree<E> right = new MyTree<E>(root.getRightTree());
			return root.getData().toString() + left.preOrder()+ right.preOrder();
		}
	}
	
}
