package bsm;

import controller.Status;
import threadServer.AdminThread;

public class MatteoMain {

	public static void main(String[] args){
		
		boolean stop = false;
		Status status = new Status();
		
		AdminThread admthr = new AdminThread(status, stop);
		admthr.start();
		
		
		

	}

}
