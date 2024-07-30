package proxymuster;

public class Proxy implements Bearbeite {

	private static Implementierung imp;
	
	public void machWas() {
		if( imp == null) {
			imp = new Implementierung();
		}
		imp.machWas();
	}
}
