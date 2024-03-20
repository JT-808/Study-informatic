package observermuster;

import java.util.ArrayList;

public class Nachrichten {
	
	private String name;
	
	private ArrayList<Kanal> kanaele =
			new ArrayList<Kanal>();
	
	
	public void addObserver(Kanal kanal) {
		kanaele.add(kanal);
	}
	
	public void removeObserver(Kanal kanal) {
		kanaele.remove(kanal);
	}
	
	public void sendeNachricht(String name) {
		this.name = name;
		for(Kanal k : kanaele) {
			k.update(name);
		}
	}

}
