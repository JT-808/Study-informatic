package prim;

public class Paarung <V,E> {

	private E kante;
	private V knoten;
	
	public Paarung( V knoten,E kante) {
		this.kante = kante;
		this.knoten = knoten;
	}
	
	public E getKante() {
		return kante;
	}
	
	public V getKnoten() {
		return knoten;
	}

	
}
