package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class BrowserTester {

	private Connection conn; // Repraesentiert die Verbindung zur DB

	public void connect() {
		try {
			Class.forName("org.sqlite.JDBC");// siehe Anbieter Datenbank
			conn = DriverManager
					.getConnection("jdbc:sqlite:/home/woodz/Dev/Daten/places.sqlite");
			// siehe Anbieter der Datenbank

		} catch (ClassNotFoundException cnfe) {
			cnfe.printStackTrace();
		} catch (SQLException sql) {
			sql.printStackTrace();
		}
	}

	public void select() {
		try {

			Statement st = conn.createStatement();

			st.setQueryTimeout(30);// (Sekunden)

			ResultSet rs = st.executeQuery("SELECT * FROM moz_places");
			// SELECT <spalten> FROM <tabellen>
			// <spalten> -> Spaltennamen mit Komma getrennt oder
			// * fuer alle Spalten
			// <tabellen> -> Tabellennamen mit Komma getrennt

			ResultSetMetaData meta = rs.getMetaData();
			// z.B. Anzahl der Spalten, Name der Spalte, Datentyp der Spalte
			for (int m = 1; m <= meta.getColumnCount(); m++) {
				System.out.println(meta.getColumnName(m) + " - "
						+ meta.getColumnTypeName(m));
			}
			// in Datenbanken ist der Startindex 1

			// Inhalt:
			System.out.println("Inhalt:");

			while (rs.next()) {
				System.out.println(rs.getInt("id") + " - "
						+ rs.getString("url"));

			}

		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
	}

	public void close() {
		try {
			conn.close();
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BrowserTester bt = new BrowserTester();
		bt.connect();
		bt.select();
		bt.close();

	}

}
