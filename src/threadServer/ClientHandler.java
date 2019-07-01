package threadServer;

import java.net.Socket;

import controller.Status;

public class ClientHandler extends Thread{
	
	private Socket socket;
	private Status status;
	
	public ClientHandler(Socket socket, Status status) {
		this.socket = socket;
		this.status = status;
	}
	
	public void run() {
		
	}


}
