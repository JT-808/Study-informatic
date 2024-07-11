package second_semester.Z_Probepruefung2;

import java.io.IOException;
import java.io.RandomAccessFile;

public class einlesen {
	public static void main(String[] args) {
		try {
			RandomAccessFile raf = new RandomAccessFile("/home/woodz/Dev/Projects/Study-Java/src/second_semester/DatenStrukturen/Uebungen/text copy.txt","r");
			String line = raf.readLine();
			int fileSize = 0;
			int totalSize = 0;
			while(line != null) {
				System.out.println(line);
				if(!line.contains("DIR")) {
					String[] element = line.split(" ");
					System.out.println(element[2]);
					fileSize = Integer.parseInt(element[2]);
					totalSize += fileSize;
				}
		        	line = raf.readLine(); 
                    // sobald Zeile Leer => Null
				
				
			}
			System.out.println("Total size: "+ (double)totalSize/1000000 + " MB");
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
}