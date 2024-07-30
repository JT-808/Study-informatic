package second_semester.Input_Output.Seminar;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class DemoIO {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		Path quelle = Paths.get("C:\\Daten\\blindtext.txt");
		Path ziel = Paths.get("C:\\Daten\\blindtextKopie.txt");
		Files.copy(quelle, ziel, StandardCopyOption.REPLACE_EXISTING);

	}

}
