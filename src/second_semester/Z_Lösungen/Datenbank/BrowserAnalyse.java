import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;

/** 
 *  Diese Klasse greift auf die Browsercache-Datenbank places.sqlite des
 *  Web-Browser Mozilla Firefox ueber JDBC zu.
 *  
 *  Es werden einfache SQL-Anweisungen an die Datenbank gesendet und die
 *  Anfrage-Ergebnisse anschliessend ausgegeben.
 *
 */

public class BrowserAnalyse {

	private static Connection connection;

	public static void connectToDB() {

		try {
			Class.forName("org.sqlite.JDBC");
			// Ersetzen Sie den Pfad an dieser Stelle auf die zu oeffnende
			// Datenbank-Datei
			connection = DriverManager
					.getConnection("jdbc:sqlite:db/places.sqlite");

		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

	/**
	 * Fuegt eine Zeile in die Tabelle MOZ_PLACES ein.
	 */
	public static void insert() {

		Statement st;
		try {
			st = connection.createStatement();
			st.setQueryTimeout(30);
			// einfuegen einer Zeile in die Tabelle MOZ_Places
			st.executeUpdate("insert into moz_places values(42,'www.facebook.com','irgendwas','','','','','','','','')");

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	/**
	 * Fragt alle in der Tabelle moz_places gespeicherten Datensaetze ab und
	 * gibt diese anschliessend an der Konsole aus.
	 */
	public static void select() throws SQLException {

		Statement st = connection.createStatement();
		st.setQueryTimeout(30);
		ResultSet rs = st.executeQuery("select * from moz_places");

		while (rs.next()) {
			System.out.println(rs.getInt("id") + " " + rs.getString("url"));
		}

	}

	public static void writeCSV() throws SQLException, IOException {

		Statement st = connection.createStatement();
		st.setQueryTimeout(30);
		ResultSet rs = st.executeQuery("select * from moz_places");
		FileWriter fw = new FileWriter(
				"ergebnis.csv");

		while (rs.next()) {
			fw.write(rs.getInt("id") + "#" + rs.getString("url") + "#"
					+ rs.getString("rev_host"));

		}

		fw.close();

	}

	public static void main(String[] args) throws ClassNotFoundException,
			SQLException, IOException {

		connectToDB();
		select();
		insert();
		writeCSV();
		connection.close();
	}

}
