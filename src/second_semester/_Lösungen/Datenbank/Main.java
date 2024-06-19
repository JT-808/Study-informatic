package db;
	
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;


public class Main {

	
	public static void main(String[] args) throws Exception {

		alleInfos();
		
		detailAbfragen();
		
	}
	
	private static void detailAbfragen() {
		try {
			Datenbank db = new Datenbank(); // Datenbankobjekt anlegen


			String select = "";
			
			/*
			 * Rechnungen pro Land:
			 * SELECT BILLINGCOUNTRY, COUNT(INVOICEID) FROM INVOICE
			 * Besten Kunden:
			 * SELECT BILLINGCITY,SUM(TOTAL)  FROM INVOICE
			 * 
			 * Nicht USA Kunden:
			 * select customerid, firstname, lastname, country
			 * from customer
			 * where not country = 'USA'
			 * 
			 * select *, count(trackid) as 'Anzahl der Tracks'
			 * from playlisttrack, playlist
			 * on playlisttrack.playlistid = playlist.playlistid
			 * group by playlist.playlistid
			 * 			
			*/
			
			ResultSet rs = db.select(select);
			ResultSetMetaData metaData = rs.getMetaData();
			
			int anzahlSpalten = metaData.getColumnCount();
			
			for(int i = 1; i <= anzahlSpalten; i++ ) {
				System.out.print(metaData.getColumnName(i)+"\t");
			}
			System.out.println();
			while (rs.next()) {
				for(int i = 1; i <= anzahlSpalten; i++ ) {
					System.out.print(rs.getString(i)+"\t");
				}
				System.out.println();
			}
			db.close();
		}catch (Exception e) {
			e.printStackTrace();
			System.err.println("Fehler bei der Abfrage");
		}
			
	}
	
	private static void alleInfos() {
		try {
			Datenbank db = new Datenbank(); // Datenbankobjekt anlegen


			String select = "SELECT name FROM sqlite_master WHERE type = 'table'";
			// Select um alle Tabellen anzuzeigen
			
			ResultSet rs = db.select(select);

			Set<String> tabellen = new TreeSet<String>();
			
			while (rs.next()) {
				tabellen.add(rs.getString(1));
			}
			System.out.println("Vorhandene Tabellen:");
			System.out.println(tabellen);
			
			Iterator<String> iterator = tabellen.iterator();
			
			while(iterator.hasNext()) {
				String tabellenname = iterator.next();
				
				select = "SELECT * FROM "+ tabellenname;
				rs = db.select(select);
				
				ResultSetMetaData metaData = rs.getMetaData();
				
				int anzahlSpalten = metaData.getColumnCount();
				
				for(int i = 1; i <= anzahlSpalten; i++ ) {
					System.out.print(metaData.getColumnName(i)+"\t");
				}
				System.out.println();
				while (rs.next()) {
					for(int i = 1; i <= anzahlSpalten; i++ ) {
						System.out.print(rs.getString(i)+"\t");
					}
					System.out.println();
				}
				System.out.println("-----");
			}
			db.close();
		}catch (Exception e) {
			System.err.println("Fehler bei der Abfrage");
		}
	}
	
}
