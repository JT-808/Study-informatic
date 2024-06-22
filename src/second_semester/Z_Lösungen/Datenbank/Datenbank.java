package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Datenbank {

	private Connection connection;

	/**
	 * Stellt eine Verbindung zur Datenbank her
	 */
	public Datenbank() {
		try {
			Class.forName("org.sqlite.JDBC");
			// Ersetzen Sie den Pfad an dieser Stelle auf die zu oeffnende
			// Datenbank-Datei
			connection = DriverManager
					.getConnection("jdbc:sqlite:Musik.db");

		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}
	
	/**
	 * 
	 * Fuehrt den uebergebenen SELECT aus
	 * 
	 * @param select SELECT der ausgefuehrt wird
	 * @return ResultSet 
	 * @throws SQLException
	 */
	public  ResultSet select(String select) throws SQLException {

		Statement st = connection.createStatement();
		st.setQueryTimeout(30);
		ResultSet rs = st.executeQuery(select);
		return rs;

	}
 
	/**
	 * Schliesst die Verbindung zur Datenbank
	 * 
	 * @throws SQLException
	 */
	public void close() throws SQLException {
		connection.close();
	}
	
	
}
