package theorie;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

	/*
	 *Verwenden des richtigen Modus: Um eine Datei neu zu erstellen oder 
	 *eine bestehende Datei zu überschreiben, muss der richtige Dateimodus verwendet werden. 
	 *In Java gibt es spezielle Klassen und Konstruktorparameter, dafür:

		FileWriter mit false als zweitem Parameter: 
		Dieser Konstruktorparameter gibt an, 
		dass die Datei im Schreibmodus geöffnet wird. 
		Wenn die Datei bereits existiert, wird sie überschrieben. 
		Wenn die Datei nicht existiert, wird sie neu erstellt.
		
		FileWriter mit true als zweitem Parameter: 
		Dieser Konstruktorparameter gibt an, 
		dass die Datei im Anhängemodus geöffnet wird. 
		Wenn die Datei nicht existiert, wird sie neu erstellt. 
		Der Unterschied besteht darin, dass der Inhalt der Datei nicht gelöscht wird, 
		sondern neue Daten am Ende der Datei angefügt werden.
		
		Fehlerbehandlung:

		Dateirechte: 
		Sicherstellen, dass das Programm die erforderlichen 
		Berechtigungen hat, um die Datei im gewünschten 
		Verzeichnis zu erstellen oder zu überschreiben.
		
		Existierende Dateien: 
		Je nach Modus muss sichergestellt werden, 
		dass der Umgang mit bereits existierenden Dateien 
		korrekt gehandhabt wird 
		
		Pfadüberprüfung: 
		Bevor eine Datei erstellt wird, sollte geprüft werden, 
		ob der angegebene Pfad existiert und gültig ist. 
		Falls der Pfad nicht existiert, muss er möglicherweise
		zuerst erstellt werden.

	 */

public class Wahlfreier_Zugriff {
    public static void main(String[] args) {
        String dateiName = "neue_datei.txt";
        String inhalt = "Dies ist eine neu erstellte Datei.";
        
        try {
            File datei = new File(dateiName);

            // FileWriter im Modus 'false' überschreibt die Datei, falls sie existiert.
            // Falls die Datei nicht existiert, wird sie neu erstellt.
            FileWriter fileWriter = new FileWriter(datei, false);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            
            bufferedWriter.write(inhalt);
            
            // Datei sicher schließen
            bufferedWriter.close();
            System.out.println("Datei wurde erfolgreich erstellt und beschrieben.");
        } catch (IOException e) {
            System.err.println("Ein Fehler ist aufgetreten: " + e.getMessage());
        }
    }
}

