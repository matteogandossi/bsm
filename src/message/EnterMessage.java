package message;

public class EnterMessage implements Message {
	
	private String idUser, idRoom, password;
	
	public EnterMessage(String idUser, String idRoom, String password) {
		this.idUser = idUser;
		this.idRoom = idRoom;
		this.password = password;
	}

	public String getIdUser() {
		return idUser;
	}

	public String getIdRoom() {
		return idRoom;
	}
	
	public String getPassword() {
		return password;
	}

}
