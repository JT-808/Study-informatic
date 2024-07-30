package second_semester.DatenStrukturen.Uebungen.Datenbanken;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Browseranalyse_charArray {

    public static void main(String[] args) throws SQLException, IOException {

        // einfachere Variante mit Chararays
        // in der Praxis nimmt man eher Stringbuilder

        OutputStream out = null;

        try {

            Class.forName("org.sqlite.JDBC");

            Connection connection = DriverManager.getConnection("jdbc:sqlite:/home/woodz/Dev/Daten/places.sqlite");
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30); // Timeout für Anfrage setzen
            ResultSet rs = statement.executeQuery("SELECT * from moz_places");
            out = new FileOutputStream("/home/woodz/Downloads/Test/output2.csv");
            String text = "";

            while (rs.next()) {

                text += rs.getInt("id") + " - " + rs.getString("url") + "\n";
            }

            char[] zeichen = text.toCharArray();

            for (char c : zeichen) {
                out.write(c);
            }

            out.close();

        } catch (ClassNotFoundException e1) {
            e1.printStackTrace();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            if (out != null) {
                try {
                    out.close();
                } catch (IOException ioex) {
                    ioex.printStackTrace();
                }
            }
        }
    }
}
// um Daten einzufügen
// statement.executeUpdate("INSERT into moz_places (id, url) VALUES (999,
// 'https://chatgpt.com/')");
// rs = statement.executeQuery("SELECT * from moz_places");

// löschen
// statement.executeUpdate("DELETE from moz_places where id = 999");
// rs = statement.executeQuery("SELECT * from moz_places");
