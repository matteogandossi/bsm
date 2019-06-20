package threadServer;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerSinchThread extends Thread{
	
	private ServerSocket serverSocket;
	private boolean stop;
	
	public ServerSinchThread(int port) throws IOException {
		serverSocket = new ServerSocket(port);
	}
	
	public void run() {
		
		while(!stop) {
			
			try {
				Socket socket = serverSocket.accept();
			} catch (IOException e) {
				System.out.println("Problem with accept of ServerSinchThread");
				System.exit(0);
			}
		}
	}
	
	
	

}
