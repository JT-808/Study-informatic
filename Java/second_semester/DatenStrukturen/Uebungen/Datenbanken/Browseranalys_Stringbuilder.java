package second_semester.DatenStrukturen.Uebungen.Datenbanken;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Browseranalys_Stringbuilder {

    public static void main(String[] args) {
        String url = "jdbc:sqlite:/home/woodz/Dev/Daten/places.sqlite";
        String outputPath = "/home/woodz/Downloads/Test/output3.csv";

        try (Connection connection = DriverManager.getConnection(url);
                Statement statement = connection.createStatement();
                ResultSet rs = statement.executeQuery("SELECT * from moz_places");
                OutputStream out = new FileOutputStream(outputPath)) {

            StringBuilder text = new StringBuilder();

            while (rs.next()) {
                text.append(rs.getInt("id"))
                        .append(" - ")
                        .append(rs.getString("url"))
                        .append("\n");
            }

            byte[] bytes = text.toString().getBytes();
            out.write(bytes);

        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
    }
}
