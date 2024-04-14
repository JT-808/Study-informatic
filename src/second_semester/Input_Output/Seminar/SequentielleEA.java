package einausgabe;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class SequentielleEA {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String text = "Wir sind in der Osterwoche.";
		
		schreibeText(text);
		
		String erg = liesText();
		System.out.println(erg);

	}
	
	private static String liesText() {
		String erg = null;
		InputStream in = null;
		try {
			
			in = Files.newInputStream(
					Paths.get("C:\\Daten\\seqIFVo.txt"), 
					StandardOpenOption.READ);
			
			erg = "";
			
			int b = in.read();//gibt das Byte zurueck
			//oder -1 beim Dateiende
			
			while(b != -1) {
				erg = erg + (char)b;
				b = in.read();
			}
			
		}catch(IOException ioex) {
			ioex.printStackTrace();
		}finally {
			if(in != null) {
				try {
					in.close();
				}catch(IOException ioex) {
					ioex.printStackTrace();
				}
			}
		}
		return erg;
	}
	
	private static void schreibeText(String text) {
		OutputStream out = null;
		try {
			
			out = new FileOutputStream("C:\\Daten\\seqIFVo.txt");
			
			char[] zeichen = text.toCharArray();
			
			for(int m = 0; m < zeichen.length; m++) {
				out.write(zeichen[m]);
			}
			
		}catch(IOException ioex) {
			ioex.printStackTrace();
		}finally {
			if( out != null) {
				try {
					out.close();
				}catch(IOException ioex) {
					ioex.printStackTrace();
				}
			}
		}
	}

}
