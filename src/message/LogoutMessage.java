package message;

public class LogoutMessage implements Message {
	
	private String idUser;
	
	public LogoutMessage(String idUser) {
		this.idUser = idUser;
	}
	
	public String getIdUser() {
		return idUser;
	}

}
