package message;

public class RecoveryMessage {
	
	private String email, petName, birthPlace, newPassword;
	
	public RecoveryMessage(String email, String petName, String birthPlace, String newPassword) {
		this.email = email;
		this.petName = petName;
		this.birthPlace = birthPlace;
		this.newPassword = newPassword;
	}

	public String getPetName() {
		return petName;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public String getBirthPlace() {
		return birthPlace;
	}

	public String getEmail() {
		return email;
	}

}
