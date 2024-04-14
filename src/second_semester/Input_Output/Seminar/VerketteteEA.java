package einausgabe;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.SequenceInputStream;

public class VerketteteEA {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		leseMehrereDateien();
	}
	
	private static void leseMehrereDateien() {
		InputStream input1 = null;
		InputStream input2 = null;
		SequenceInputStream sis = null;
		try {
			
			input1 = new FileInputStream("C:\\Daten\\seqIFVo.txt");
			input2 = new FileInputStream("C:\\Daten\\gpIFVo.txt");
			sis = new SequenceInputStream(input2, input1);
			//oder Liste von InputStreams
			//Achtung Reihenfolge
			
			int b = sis.read();
			
			while(b != -1) {
				System.out.print((char)b);
				b = sis.read();
			}
			
		}catch(IOException ioex) {
			ioex.printStackTrace();
		}finally {
			if(input1 != null) {
				try {
					input1.close();
				}catch(IOException ioex) {
					ioex.printStackTrace();
				}
			}
			if(input2 != null) {
				try {
					input2.close();
				}catch(IOException ioex) {
					ioex.printStackTrace();
				}
			}
			if(sis != null) {
				try {
					sis.close();
				}catch(IOException ioex) {
					ioex.printStackTrace();
				}
			}
		}
	}

}
