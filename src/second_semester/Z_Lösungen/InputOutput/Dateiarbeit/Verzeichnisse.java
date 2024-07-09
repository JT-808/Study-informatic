import java.io.File;
import java.io.IOException;

public class Verzeichnisse {

	public static void main(String[] args) throws IOException {
		String pfad = "PFAD";
		File f = new File(pfad);

		if (!f.isDirectory()) {
			System.out.println(pfad + " ist kein Verzeichnis");
			System.exit(1);
		}

		System.out.println(f.getCanonicalPath());
		showVerzeichnis(f);
	}

	public static void showVerzeichnis(File verzeichnis) throws IOException {
		File[] liste = verzeichnis.listFiles();
		if(liste != null){
			for (File f : liste) {
				System.out.println(f.getCanonicalPath());
				if (f.isDirectory()) {
					showVerzeichnis(f);
				}
			}
		}
	}

}
