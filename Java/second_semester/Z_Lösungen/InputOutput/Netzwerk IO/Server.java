
import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import csFertig.Message;

public class Server {
	private int port = 50000;
	private ArrayList<ObjectOutputStream> connections;
	private ArrayList<String> users;

	public static void main(String[] args) {
		new Server().startServer();
	}

	public void startServer() {
		connections = new ArrayList<ObjectOutputStream>();
		users = new ArrayList<String>();
		ServerSocket serverSocket = null;
		try {
			serverSocket = new ServerSocket(port);
			System.out.println("Server gestartet ...");
			while (true) {
				Socket socket = serverSocket.accept();
				Runnable r = () -> {
					boolean joined = false;
					String user = null;
					ObjectOutputStream oos = null;
					try {
						oos = new ObjectOutputStream(socket.getOutputStream());
						ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
						while (ois != null) {
							Message message = (Message) ois.readObject();
							switch (message.getAction()) {
								case LOGIN:
									user = message.getUser();
									if (users.contains(message.getUser())) {
										Message messageNew = new Message(Message.Action.JOIN_ERROR, message.getUser(),
												"");
										oos.writeObject(messageNew);
										oos.flush();
										joined = false;
									} else {
										connections.add(oos);
										users.add(user);
										Message messageNew = new Message(Message.Action.JOIN, user, "");
										broadcast(messageNew);
										joined = true;
									}
									break;
								case SAY:
									Message messageNew = new Message(Message.Action.SAY, user, message.getText());
									broadcast(messageNew);
									break;
								default:
									break;
							}
						}
					} catch (EOFException eofe) {
						eofe.printStackTrace();
					} catch (IOException ioe) {
						ioe.printStackTrace();
					} catch (ClassNotFoundException cnfe) {
						cnfe.printStackTrace();
					} finally {
						if (joined) {
							connections.remove(oos);
							users.remove(user);
							Message message = new Message(Message.Action.LEAVE, user, "");
							broadcast(message);
						}
					}
				};
				new Thread(r).start();
			}
		} catch (IOException e) {
			System.err.println(e.getMessage());
		}
	}

	private void broadcast(Message message) {

		for (ObjectOutputStream oos : connections) {
			try {
				oos.writeObject(message);
				oos.flush();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
