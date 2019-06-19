package message;

public class LoginMessage implements Message {
	
	private String email, password;
	
	public LoginMessage(String email, String password) {
		this.email = email;
		this.password = password;
	}
	
	public String getEmail() {
		return email;
	}
	
	public String getPassword() {
		return password;
	}

}
