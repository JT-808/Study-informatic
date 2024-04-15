

import java.net.URL;
import java.nio.file.*;
import java.io.IOException;
import java.io.InputStream;

public class SimpleFileCopy
{
    public static void main(String[] args)
    {
		try
		{
		   copyFile("SimpleFileCopy.java" , "Kopie_SimpleFileCopy.txt");
		   
		   String dir = "Kopien";
		   
		   if(!Files.exists(Paths.get(dir)))
			{
			Files.createDirectory(Paths.get(dir));
			}
		   
		   moveFile("Kopie_SimpleFileCopy.txt", dir +  "/" + "Kopie_SimpleFileCopy.txt" );
		   
		   copyURL("http://www.staff.hs-mittweida.de/~altrogge/Beispiel_NIO.txt", dir + "/"+ "Kopie_Beispiel_NIO.txt" );
		   
		}
		catch(IOException e)
		{
			System.err.println(e.getMessage());
		}
    }

    public static void copyFile(String source, String target) throws IOException
    {
	    Path sourcePath = Paths.get(source);
	    Path targetPath = Paths.get( target );
	    
	    Files.copy(sourcePath, targetPath, StandardCopyOption.REPLACE_EXISTING );
	    
	    // Ueberpuefung und Ausgabe des Ergebnisses
	    if(Files.exists(targetPath))
	    {
		System.out.println("Die Datei "+ sourcePath.getFileName() + " wurde in die Datei " + targetPath.getFileName() +" kopiert!");
	    }
	    
	    
	   
    }
    
    public static void moveFile(String source, String target) throws IOException
    {
	   	   
	    
	    
	    Path sourcePath = Paths.get( source );
	    Path targetPath = Paths.get( target );
	    Files.move( sourcePath, targetPath, StandardCopyOption.REPLACE_EXISTING); 
	    
	    // Ueberpuefung und Ausgabe des Ergebnisses
	    if(Files.exists(targetPath))
	    {
		System.out.println("Die Datei "+ sourcePath.getFileName() + " wurde in das Verzeichnis " + targetPath.toAbsolutePath() +" verschoben!");
	    }
	   
		
	
    }
    
    public static void copyURL(String source, String target) throws IOException
    {
	   
	    
	    URL url = new URL(source);
	    InputStream is =  url.openStream();
	    Path targetPath = Paths.get(target);
	   
	    Files.copy(is, targetPath, StandardCopyOption.REPLACE_EXISTING);
	    
	    if ( is != null )   
		 is.close(); 
	    
	    // Ueberpuefung und Ausgabe des Ergebnisses
	    if(Files.exists(targetPath))
	    {
		System.out.println("Die URL "+ source + " wurde in das Verzeichnis " + targetPath.getParent() + " unter dem Namen " + targetPath.getFileName() +" kopiert!");
	    }
	   
	    
	  
    }
    
}
