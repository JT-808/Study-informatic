package second_semester.Input_Output.Uebungen;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class NIO {

    public static void main(String[] args) {
        try {
            Path path_dir = Paths.get("/home/woodz/Downloads/Test/kopien"); // String in Pfad umwandeln
            if (!Files.exists(path_dir)) { // Wenn Verzeichnis nicht vorhanden, dann:
                Files.createDirectory(path_dir); // Verzeichnis erstellen
                System.out.println("Ordner erstellt");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        copyFile("test", "testkopie");

        moveFile("test", "test1");

        try {
            copyURL("https://www.staff.hs-mittweida.de/~altrogge/Beispiel_NIO.txt",
                    "/home/woodz/Downloads/Test/kopien/nio.txt");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

    }

    public static void copyFile(String source, String target) {

        Path quelle = Paths.get("/home/woodz/Downloads/Test/" + source);
        Path ziel = Paths.get("/home/woodz/Downloads/Test/" + target);

        try {

            Files.copy(quelle, ziel, StandardCopyOption.REPLACE_EXISTING);
            System.out.println("erfolgreich kopiert");

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void moveFile(String source, String target) {

        Path quelle2 = Paths.get("/home/woodz/Downloads/Test/" + source);
        Path ziel2 = Paths.get("/home/woodz/Downloads/Test/kopien/" + target);

        try {

            Files.move(quelle2, ziel2);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void copyURL(String source, String target) throws MalformedURLException {

        // erst Uri-objekt erstellen -> dies umwandeln in URL

        URI uri = URI.create(source);
        URL url = uri.toURL();
        Path ziel3 = Paths.get(target);

        // inputstream damit befüllen
        try {
            InputStream in = url.openStream();
            Files.copy(in, ziel3);
            System.out.println("erfolgreich kopiert");
            in.close();

        } catch (IOException e) {
            e.printStackTrace();

        }

    }
}
