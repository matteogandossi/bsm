package bsm;

import java.io.Serializable;

public class RoomCount extends Room implements Serializable {
	
	private static final long serialVersionUID = 2718944280352522821L;
	private int currentPeople;
	
	public RoomCount(Room r) {
		super();
		
		setId(r.getId());
		setMaxSize(r.getMaxSize());
		setRoomName(r.getRoomName());
		setRoomPassword(r.getRoomPassword());
	}
	
	public void setCurrentPeople(int n) {
		currentPeople = n;
	}
	
	public int getCurrentPeople() {
		return currentPeople;
	}
	
	public boolean isFull() {
		return currentPeople >= getMaxSize();
	}

}
