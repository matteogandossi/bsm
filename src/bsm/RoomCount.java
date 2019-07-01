package bsm;

public class RoomCount extends Room {
	
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
