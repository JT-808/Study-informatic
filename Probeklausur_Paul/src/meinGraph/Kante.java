package meinGraph;

import java.io.Serializable;

public class Kante implements Serializable{

	private static final long serialVersionUID = 1L;
	private int von;
	private int nach;
	
	public Kante(int von, int nach) {
		// TODO Auto-generated constructor stub
		this.nach= nach;
		this.von=von;
		
	}

	public int getVon() {
		return von;
	}

	public int getNach() {
		return nach;
	}
	
	
}
