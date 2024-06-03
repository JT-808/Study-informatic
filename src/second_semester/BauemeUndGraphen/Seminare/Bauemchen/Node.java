package second_semester.BauemeUndGraphen.Seminare.Bauemchen;

public class Node <E extends Comparable<E>> {

	private E data;//zur Speicherung der DAten
	//Achtung bei der Umsetzung von binaeren Suchbaeumen
	// ggf.-> Unterstuetzung von compareTo
	
	private Node<E> leftTree;//linker TEilbaum
	private Node<E> rightTree;//rechter Teilbaum
	
	public Node(E data) {
		this.data = data;
		leftTree = null;
		rightTree = null;
		//nur ein Blatt
	}
	
	public E getData() {
		return data;
	}
	
	public Node<E> getLeftTree(){
		return leftTree;
	}
	
	public Node<E> getRightTree(){
		return rightTree;
	}
	
	public void setData(E data) {
		this.data = data;
	}
	
	public void setLeftTree(Node<E> leftTree) {
		this.leftTree = leftTree;
	}
	
	public void setRightTree(Node<E> rightTree) {
		this.rightTree = rightTree;
	}
}
