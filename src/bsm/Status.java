package bsm;

import java.util.ArrayList;

public class Status {
	
	private ArrayList<UserStatus> list;
	
	public Status(){
		list = new ArrayList<UserStatus>();
	}
	
	private int find(String userId) {
		
		int index = - 1;
		
		for(int i = 0; i < list.size(); i++)
			if(list.get(i).user.getId().equals(userId)) {
				index = i;
				break;
			}
		
		return index;
				
	}
	
	public UserStatus get(String userId) {
		
		int index = find(userId);
		
		if(index < 0)
			return null;
		
		return list.get(index);
		
	}
	
	public boolean add(User newUser) {
		
		if(find(newUser.getId()) < 0)
			return list.add(new UserStatus(newUser));
		return false;
		
	}
	
	public int size() {
		return list.size();
	}
	
	public boolean remove(String userId) {
		
		int index = find(userId);
		
		if(index >= 0) {
			list.remove(index);
			return true;
		}
			
		return false;
	}
	
	public void print() {
		
		for(int i = 0; i < size(); i++)
			System.out.println(list.get(i));
		
	}
	
	//function to get status TODO
		
		
}
