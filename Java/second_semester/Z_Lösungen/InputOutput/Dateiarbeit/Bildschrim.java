import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class Bildschrim {

	public static void zeigeInhalt(Reader r) throws IOException {
		try (BufferedReader in = new BufferedReader(r)) {
			String zeile;
			while ((zeile = in.readLine()) != null) {
				System.out.println(zeile);
			}
		}
	}

	public static void main(String[] args) throws IOException {
		if(args.length == 1){
			zeigeInhalt(new FileReader(args[0]));
		}
	}
}
