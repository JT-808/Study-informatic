package second_semester.DatenStrukturen.Uebungen.Datenbanken;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Browseranalyse_Bufferedwriter {

    public static void main(String[] args) {
        String url = "jdbc:sqlite:/home/woodz/Dev/Daten/places.sqlite";
        String outputPath = "/home/woodz/Downloads/Test/output4.csv";

        try (Connection connection = DriverManager.getConnection(url);
                Statement statement = connection.createStatement();
                ResultSet rs = statement.executeQuery("SELECT * from moz_places");
                BufferedWriter writer = new BufferedWriter(new FileWriter(outputPath))) {

            while (rs.next()) {
                String line = rs.getInt("id") + " - " + rs.getString("url") + "\n";
                writer.write(line);
            }

        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
    }
}
