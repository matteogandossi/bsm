package threadServer;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerThread extends Thread {
	
	private ServerSocket serverSocket;
	private boolean stop;
	
	public ServerThread(int port, boolean stop) throws IOException {
		serverSocket = new ServerSocket(port);
		this.stop = stop;
	}
	
	public void run() {
		
		while(!stop) {
			
			try {
				Socket socket = serverSocket.accept();
				ClientHandler ch = new ClientHandler(socket);
				ch.start();
			} catch (IOException e) {
				System.out.println("Problem with accept of ServerThread");
				System.exit(0);
			}
		}
	}

}
