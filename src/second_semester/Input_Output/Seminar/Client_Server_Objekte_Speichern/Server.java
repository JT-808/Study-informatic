package einausgabe;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Server().start();
	}
	
	public void start() {
		ServerSocket socket;
		try {
			socket = new ServerSocket(12345);
			while(true) {
				Socket socketClient = socket.accept();
				Runnable thread = () ->{
					try {
						aufgabe(socketClient);
					}catch(Exception ex) {
						ex.printStackTrace();
					}
				};
				new Thread(thread).start();
			}
			
		}catch(IOException ioex) {
			ioex.printStackTrace();
		}
		
	}
	
	private void aufgabe(Socket socketClient) {
		System.out.println("Socket angenommen");
		PrintWriter out = null;
		BufferedReader in = null;
		try {
			
			out = 
			new PrintWriter(socketClient.getOutputStream(),true);
			//true -> autoflush
			in = new BufferedReader(
				new InputStreamReader(
						socketClient.getInputStream()));
			
			String nachricht = null;
			while((nachricht = in.readLine())!= null) {
				System.out.println("Client sendete: "+ nachricht);
				if("ende".equals(nachricht)) {
					out.println("Bye Bye");
					break;
				}
				out.println("Server sendet:" + nachricht);
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
			if(socketClient != null) {
				try {
					socketClient.close();
				}catch(IOException ioex) {
					ioex.printStackTrace();
				}
			}
			if(out != null) {
				out.close();
			}
		}
	}

}
