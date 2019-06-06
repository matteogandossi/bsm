package controller;

import java.util.ArrayList;

import bsm.PermissionNotFoundException;
import bsm.Room;
import bsm.RoomNotFoundException;
import bsm.User;
import model.Model;

public class Permission{
	private ArrayList<User> permissionList;
	
	public Permission(){
		permissionList = Model.loadPermissions();
	}
	
	private int findPermission(String userId,String roomId) throws PermissionNotFoundException {
		
		for(int i = 0; i < permissionList.size(); i++)
			if(permissionList.get(i).getPermissionUserId().equals(userId) && permissionList.get(i).getChoosenRoom().equals(roomId)) 
				return i;
		
		//if I cannot find it
		throw new PermissionNotFoundException();
				
	}
	

	public User getPermission(String userId,String roomId) throws PermissionNotFoundException {
	
	return permissionList.get(findPermission(userId, roomId));
	}
	
	public boolean addNewPermission(User user) {
		
		try {
			
			findPermission(user.getPermissionUserId(),user.getChoosenRoom());
			
		} catch (PermissionNotFoundException e) {
			//if there is no user with that room permission
			permissionList.add(user);
			return Model.addPermission(user);
		}
		
		return false;
	}
	
	public void removePermission(String userId ,String roomId) throws PermissionNotFoundException {	
		
		permissionList.remove(findPermission(userId, roomId));
		Model.deletePermission(userId, roomId);
		
	}
}