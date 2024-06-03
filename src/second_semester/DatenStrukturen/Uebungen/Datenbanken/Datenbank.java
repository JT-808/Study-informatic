package second_semester.DatenStrukturen.Uebungen.Datenbanken;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Iterator;



public class Datenbank {
    public static void main(String[] args) throws SQLException {

        String url = "jdbc:sqlite:/home/woodz/Dev/Daten/Musik.db";
        String zeigeAlleTabellen = "SELECT name FROM sqlite_master WHERE type = 'table'";
        String zeigeInhaltDerTabelle = "SELECT * FROM artist";
        //String MeisteRechnung = "SELECT COUNT(invoiceId), BillingCountry FROM invoice";
        String MeisteRechnung = "SELECT TOP 10 billingcountry, invoiceiD FROM invoice ORDER BY COUNT(invoiceId)";


      
        //ResultSet rs= Select(zeigeInhaltDerTabelle, url)
        //ResultSet rs=  Select(zeigeInhaltDerTabelle, url);
        ResultSet rs= Select(MeisteRechnung, url);
        ZeigeInhalt(rs);
      
}

public static ResultSet Select(String abfrage, String url) throws SQLException{

    Connection connection = DriverManager.getConnection(url);
    Statement statement = connection.createStatement();
    ResultSet rs = statement.executeQuery(abfrage);

    return rs;
}
            
                    //DAS WICHTIGSTE!
// damit kann man JEDE Datenbank auslesen, egal wieviel Spalten und art der Variablen

public static void ZeigeInhalt(ResultSet rs) throws SQLException{

// hole Metadaten aus dem Resultset (Anzahl spalten ist wichtig)
    ResultSetMetaData meta = rs.getMetaData();
    //Inhalt in ein Hashset überführen und dann ausgeben

    HashSet<String> hs = new HashSet<String>();
    String text="";
    while (rs.next()) {

        //  Spaltenweise auslesen ohne variable/Typ zu brauchen
            for (int i = 1; i <= meta.getColumnCount(); i++) {
            text += rs.getString(i);
            text += "-"; 
            }
            text += "\n";
            hs.add(text);
        
    }
    Iterator<String> i = hs.iterator(); 
    while (i.hasNext()) {
        System.out.println(i.next());

     }
    
}

//Statt String wäre auch Stringbuilder möglich

}

