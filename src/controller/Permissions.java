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
}