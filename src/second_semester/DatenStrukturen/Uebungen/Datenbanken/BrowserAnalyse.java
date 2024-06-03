package second_semester.DatenStrukturen.Uebungen.Datenbanken;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class BrowserAnalyse {

    public static void main(String[] args) throws SQLException, IOException {

        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e1) {
            e1.printStackTrace();
        }

        Connection connection = DriverManager.getConnection("jdbc:sqlite:/home/woodz/Dev/Daten/places.sqlite");
        Statement statement = connection.createStatement();
        statement.setQueryTimeout(30); // Timeout für Anfrage setzen

        // Tabelle aus der DB auswählen
        ResultSet rs = statement.executeQuery("select * from moz_places");

        // Herausfinden: Anzahl der Spalten, Name der Spalte, Datentyp der Spalte
        // -> Analyse: was ist drin ---
        ResultSetMetaData meta = rs.getMetaData();
        List<String> columnNames = new ArrayList<>();
        for (int m = 1; m <= meta.getColumnCount(); m++) {
            columnNames.add(meta.getColumnName(m));
            System.out.println(meta.getColumnName(m) + " - " + meta.getColumnTypeName(m));
        }
        // in Datenbanken ist der Startindex 1

        // Inhalt anzeigen und in eine ArrayList überführen
        System.out.println("\n Inhalt:");

        List<String[]> data = new ArrayList<>();
        while (rs.next()) {
            System.out.println(rs.getInt("id") + " - " + rs.getString("url"));
            data.add(new String[] { Integer.toString(rs.getInt("id")), rs.getString("url") });
        }

        // CSV-Datei erstellen und schreiben
        try (BufferedWriter bufferedWriter = new BufferedWriter(
                new FileWriter("/home/woodz/Downloads/Test/output.csv"))) {

            // Schreibe die Spaltenüberschriften in die CSV-Datei
            for (int i = 0; i < columnNames.size(); i++) {
                bufferedWriter.write(columnNames.get(i));
                if (i < columnNames.size() - 1) {
                    bufferedWriter.write(',');
                }
            }
            bufferedWriter.write('\n');

            // Schreibe die Datensätze aus der Liste in die CSV-Datei
            for (String[] row : data) {
                for (int i = 0; i < row.length; i++) {
                    bufferedWriter.write(row[i]);
                    if (i < row.length - 1) {
                        bufferedWriter.write(',');
                    }
                }
                bufferedWriter.write('\n');
            }

            System.out.println("CSV-Datei erfolgreich erstellt!");

        } catch (IOException e) {
            e.printStackTrace();
        }

        // Schließe das ResultSet nach dem Abrufen der Daten
        rs.close();
        statement.close();
        connection.close();
    }

}
