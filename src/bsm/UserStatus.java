package bsm;

import com.sun.xml.internal.bind.v2.runtime.RuntimeUtil.ToStringAdapter;

public class UserStatus {
	
	User user;
	private Room r;
	private boolean logged;
	
	UserStatus(User u){
		this.user = u;
		r = null;
		logged = false;
	}
	
	public Room getCurrentRoom() {
		return r;
	}
	
	public boolean isLogged() {
		return logged;
	}
	
	public void login() {
		logged = true;
	}
	
	public void logout() {
		exitRoom();
		logged = false;
	}
	
	public void enterRoom(Room r) {
		this.r = r;
	}
	
	public void exitRoom() {
		r = null;
	}
	
	@Override
	public String toString() {
		
		StringBuilder str = new StringBuilder();
		
		str.append(user.getName() + " is ");
		str.append( (logged)? "" : "not " );
		str.append("logged in");
		if(r!=null)
			str.append(" and he is currently in room " + r.getName());
		str.append(".");
		
		return str.toString();
		
	}

}
