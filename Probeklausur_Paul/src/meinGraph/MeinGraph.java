package meinGraph;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;

public class MeinGraph {
	private ArrayList<Kante> nachbarschaften;
	
	public MeinGraph() {
		// TODO Auto-generated constructor stub
		nachbarschaften= new ArrayList<Kante>();
		
	}
	
	public void addKante(int von, int nach) {
		Kante neueKante = new Kante(von, nach);
		nachbarschaften.add(neueKante);
		
	}
	public int getAnzahl() {
		// TODO Auto-generated method stub
		int anzahl = nachbarschaften.size();
		return anzahl;
	}
	
	public ArrayList<Kante> getNachbarschaften(){
		return nachbarschaften;
	}
	
	public void speichereNachbarschaften(String pfad) {
		
		ObjectOutputStream os = null;
		
		try {
			os = new ObjectOutputStream(new FileOutputStream(pfad));
			os.writeObject(nachbarschaften);
			
		} catch (IOException ioex) {
			ioex.printStackTrace();
		}finally {
			if(os != null) {
				try {
					os.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
	}
	
	public void ladeNachbarschaften(String pfad) {
		
		ObjectInputStream oi = null;
		try {
			oi = new ObjectInputStream(new FileInputStream(pfad));
			
			nachbarschaften = (ArrayList<Kante>) oi.readObject();
			
			
		} catch (IOException ioex) {
			ioex.printStackTrace();
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		finally {
			if(oi != null) {
				try {
					oi.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
	}
	
	public void gibListeAus(String pfad) {

		PrintWriter writer = null;
		
		try {
			writer = new PrintWriter(new FileWriter(pfad));
			
			for(Kante kante : nachbarschaften) {
				writer.println(kante.getVon() + " , " + kante.getNach());
			}
			
			
		} catch (IOException ioex) {
			ioex.printStackTrace();
		}
		finally {
			if(writer != null) {
				writer.close();
			}
		}
		

		
	}

}
