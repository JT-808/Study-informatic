
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/*
 * Bei der Arbeit mit Dateien ist eine Fehlerbehandlung 
 * unerlässlich, um das Programm gegen verschiedene mögliche 
 * Fehler abzusichern und um sicherzustellen, dass es robust 
 * und stabil bleibt. Dateien sind externe Ressourcen, und der 
 * Zugriff auf sie kann aus verschiedenen Gründen fehlschlagen. Hier sind einige konkrete Gründe, warum Fehlerbehandlung notwendig ist, sowie ein Beispiel:

	Nicht vorhandene Datei: 
	Die Datei, auf die zugegriffen werden soll, existiert 
	möglicherweise nicht.
	
	Berechtigungsprobleme: 
	Das Programm hat möglicherweise nicht die notwendigen 
	Rechte, um auf die Datei zuzugreifen oder sie zu verändern.
	
	Volles Dateisystem: 
	Es ist möglicherweise nicht genügend Speicherplatz auf dem 
	Laufwerk verfügbar, um die Datei zu erstellen oder zu schreiben.
	
	Dateien in Gebrauch: 
	Die Datei wird möglicherweise von einem anderen Programm 
	verwendet, was den Zugriff einschränkt.
	
	Hardwareprobleme: 
	Probleme mit dem Speichermedium (z.B. defekte Festplatte) 
	können den Zugriff auf Dateien beeinträchtigen.
 */



public class Fehlerbehandlung {
    public static void main(String[] args) {
        String dateiName = "/systemverzeichnis/neue_datei.txt";
        String inhalt = "Dies ist eine neu erstellte Datei.";

        try {
            File datei = new File(dateiName);

            // Versuch, die Datei zu erstellen oder zu überschreiben
            FileWriter fileWriter = new FileWriter(datei, false);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            
            bufferedWriter.write(inhalt);
            
            // Datei sicher schließen
            bufferedWriter.close();
            System.out.println("Datei wurde erfolgreich erstellt und beschrieben.");
        } catch (IOException e) {
            // Fehlerbehandlung
            System.err.println("Ein Fehler ist aufgetreten: " + e.getMessage());

            // Spezifische Behandlung von Berechtigungsproblemen
            if (e.getMessage().contains("Permission denied")) {
                System.err.println("Fehler: Keine Berechtigung zum Schreiben in das Verzeichnis.");
            }
        }
    }
}

