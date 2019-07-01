package bsm;

import controller.Status;
import threadServer.AdminThread;

public class Server {
	
	public final static String ADDRESS = "localhost";
	public final static int PORT = 5000;
	public final static int SYNCH_PORT = 4000;

	public static void main(String[] args){
		
		boolean stop = false;
		Status status = new Status();
		
		AdminThread admthr = new AdminThread(status, stop);
		admthr.start();
		
		
		

	}

}
