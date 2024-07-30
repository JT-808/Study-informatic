package einausgabe;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class DeSi {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Person p = new Person("Klaus", 50);
		p.bestimmeEinkommen();
		
		serialisieren(p);
		
		Person neuP = deserialisieren();
		System.out.println(neuP);
	}
	
	private static Person deserialisieren() {
		Person erg = null;
		ObjectInputStream ois = null;
		try {
			ois =
			new ObjectInputStream(
				new BufferedInputStream(
					new FileInputStream(
						new File(
						"C:\\Daten\\objIFGruppe3.data"))));
			erg = (Person)ois.readObject();
			
		}catch(IOException ioex) {
			ioex.printStackTrace();
		}catch(ClassNotFoundException cnfe) {
			cnfe.printStackTrace();
		}catch(Exception ex) {
			ex.printStackTrace();
			//Elternfehlermeldungen ans Ende
		}finally {
			if(ois != null) {
				try {
					ois.close();
				}catch(IOException ioex) {
					ioex.printStackTrace();
				}
			}
		}
		return erg;
	}
	
	private static void serialisieren(Person p) {
		ObjectOutputStream oos = null;
		try {
			oos = 
			new ObjectOutputStream(
				new BufferedOutputStream(
					new FileOutputStream(
						"C:\\Daten\\objIFGruppe3.data")));
			oos.writeObject(p);
			oos.flush();
			
		}catch(IOException ioex) {
			ioex.printStackTrace();
		}finally {
			if(oos != null) {
				try {
					oos.close();
				}catch(IOException ioex) {
					ioex.printStackTrace();
				}
			}
		}
	}

}
