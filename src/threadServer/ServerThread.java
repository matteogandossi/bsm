package threadServer;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import controller.Status;

public class ServerThread extends Thread {
	
	private ServerSocket serverSocket;
	private boolean stop;
	private Status status;
	
	public ServerThread(int port, boolean stop, Status status) throws IOException {
		serverSocket = new ServerSocket(port);
		this.stop = stop;
		this.status = status;
	}
	
	public void run() {
		
		while(!stop) {
			
			try {
				Socket socket = serverSocket.accept();
				ClientHandler ch = new ClientHandler(socket, status);
				ch.start();
			} catch (IOException e) {
				System.out.println("Problem with accept of ServerThread");
				System.exit(0);
			}
		}
	}

}
