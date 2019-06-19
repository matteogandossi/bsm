package message;

public class EnterMessage implements Message {
	
	private String idUser, idRoom;
	
	public EnterMessage(String idUser, String idRoom) {
		this.idUser = idUser;
		this.idRoom = idRoom;
	}

	public String getIdUser() {
		return idUser;
	}

	public String getIdRoom() {
		return idRoom;
	}

}
