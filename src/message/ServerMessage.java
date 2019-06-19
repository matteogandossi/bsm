package message;

import controller.UserStatus;

public class ServerMessage implements Message {
	
	public static final short ACCEPT = 1;
	public static final short REJECT = 0;
	public static final short LOGIN = 2;
	
	private short type;
	private String message;
	private UserStatus userStatus;
	
	private ServerMessage(short type, String message, UserStatus userStatus) {
		this.type = type;
		this.message = message;
		this.userStatus = userStatus;
	}
	
	public ServerMessage createAcceptMessage() {
		return new ServerMessage(ACCEPT, null, null);
	}
	
	public ServerMessage createRejectMessage(String message) {
		return new ServerMessage(REJECT, message, null);
	}
	
	public ServerMessage createLoginMessage(UserStatus userStatus) {
		return new ServerMessage(LOGIN, null, userStatus);
	}

	public short getType() {
		return type;
	}

	public String getMessage() {
		return message;
	}

	public UserStatus getUserStatus() {
		return userStatus;
	}

}
