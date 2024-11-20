package XML.PR5;

import java.util.ArrayList;

public class Addresses {

	private ArrayList<Address> adresses = new ArrayList<Address>();

	public ArrayList<Address> getAdresses() {

		return this.adresses;
		
	}

	public Object getValue(int index, String key) {

		return this.adresses.get(index).getValue(key);
		
	}

}
