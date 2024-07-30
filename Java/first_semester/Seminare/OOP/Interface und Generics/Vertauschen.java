package uebunginterface;

public class Vertauschen<T> {

	private T wertA;
	private T wertB;
	
	public Vertauschen(T wertA, T wertB) {
		this.wertA = wertA;
		this.wertB = wertB;
	}

	/**
	 * @return the wertA
	 */
	public T getWertA() {
		return wertA;
	}

	/**
	 * @return the wertB
	 */
	public T getWertB() {
		return wertB;
	}
	
	public void vertausche() {
		T tmp = wertA;
		wertA = wertB;
		wertB = tmp;
	}
}
