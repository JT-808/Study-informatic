package second_semester.Z_Probepruefung;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class kopieren {


    public static void main(String[] args) throws IOException {
        String source = "/home/woodz/Downloads/Test";
        String target = "/home/woodz/Downloads/Test2";

        copyVerzeichnis(source, target);
    }

    

    public static void copyVerzeichnis(String source, String target) throws IOException {
        Path quelle = Paths.get(source);
        Path ziel = Paths.get(target);
        int count = copyVerzeichnisRekursiv(quelle, ziel);

        System.out.println("Kopiervorgang wurde abgeschlossen.");
        System.out.println("Es wurden " + count + " Dateien kopiert.");
    }

    private static int copyVerzeichnisRekursiv(Path quelle, Path ziel) throws IOException {
        int count = 0;

        if (Files.isDirectory(quelle)) {
            if (Files.notExists(ziel)) {
                Files.createDirectories(ziel);
            }
            for (File file : quelle.toFile().listFiles()) {
                Path targetPath = ziel.resolve(file.getName());
                if (file.isDirectory()) {
                    count += copyVerzeichnisRekursiv(file.toPath(), targetPath);
                } else {
                    Files.copy(file.toPath(), targetPath, StandardCopyOption.REPLACE_EXISTING);
                    count++;
                }
            }
        } else {
            Files.copy(quelle, ziel, StandardCopyOption.REPLACE_EXISTING);
            count++;
        }

        return count;
    }

}
