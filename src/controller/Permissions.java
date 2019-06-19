<<<<<<< HEAD:src/controller/Permission.java
package controller;

import java.util.ArrayList;

import bsm.PermissionNotFoundException;
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
=======
package controller;

import java.util.ArrayList;

import bsm.Permission;
import bsm.PermissionNotFoundException;
import bsm.Room;
import bsm.RoomNotFoundException;
import bsm.User;
import model.Model;

public class Permissions{
	private ArrayList<Permission> permissionList;
	
	public Permissions(){
		permissionList = Model.loadPermissions();
	}
	
	private int findPermission(String idUser,String idRoom) throws PermissionNotFoundException {
		
		for(int i = 0; i < permissionList.size(); i++)
			if(permissionList.get(i).getIdUser().equals(idUser) && permissionList.get(i).getIdRoom().equals(idRoom)) 
				return i;
		
		//if I cannot find it
		throw new PermissionNotFoundException();
				
	}
	

	public Permission getPermission(String idUser,String idRoom) throws PermissionNotFoundException {
	
	return permissionList.get(findPermission(idUser, idRoom));
	}
	
	public boolean addNewPermission(Permission permission) {
		
		try {
			
			findPermission(permission.getIdUser(),permission.getIdRoom());
			
		} catch (PermissionNotFoundException e) {
			//if there is no user with that room permission
			permissionList.add(permission);
			return Model.addPermission(permission);
		}
		
		return false;
	}
	
	public void removePermission(String userId ,String roomId) throws PermissionNotFoundException {	
		
		permissionList.remove(findPermission(userId, roomId));
		Model.deletePermission(userId, roomId);
		
	}
>>>>>>> ec89724df7b7630f1b6f670edb90576a8abb75f9:src/controller/Permissions.java
}