package einausgabe;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
	
	private Socket socket;
	private PrintWriter out;
	private BufferedReader in;
	
	public void start() {
		try {
			socket = new Socket("127.0.0.1", 12345);
			//127.0.0.1 -> Rechner selbst
			out = new PrintWriter(socket.getOutputStream(),true);
			in = new BufferedReader( 
				new InputStreamReader(socket.getInputStream()));
		}catch(IOException ioex) {
			ioex.printStackTrace();
		}
	}
	
	public void stop() {
		try {
			out.close();
			in.close();
			socket.close();
		}catch(IOException ioex) {
			ioex.printStackTrace();
		}
	}
	
	public void senden(String nachricht) {
		try {
			out.println(nachricht);
			System.out.println(in.readLine());
		}catch(IOException ioex) {
			ioex.printStackTrace();
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Client c = new Client();
		
		c.start();
		c.senden("Wir sind in der Osterwoche.");
		c.senden("Hallo Mittweida.");
		c.senden("ich habe keine Lust mehr");
		c.senden("ende");
		c.stop();

	}

}
