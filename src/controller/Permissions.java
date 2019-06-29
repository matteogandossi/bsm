package controller;

import java.util.ArrayList;

import bsm.Permission;
import bsm.PermissionNotFoundException;
import model.Model;

public class Permissions{
	private ArrayList<Permission> permissionList;
	
	public Permissions(){
		permissionList = Model.loadPermissions();
	}
	
	public ArrayList<Permission> getList(){
		return permissionList;
	}
	
	private int findPermission(String idUser, String idRoom) throws PermissionNotFoundException {
		
		if(idUser == null || idRoom == null)
			throw new PermissionNotFoundException();
		
		for(int i = 0; i < permissionList.size(); i++)
			if(permissionList.get(i).getIdUser().equals(idUser) && permissionList.get(i).getIdRoom().equals(idRoom)) 
				return i;
		
		//if I cannot find it
		throw new PermissionNotFoundException();
				
	}	

	public Permission getPermission(String idUser, String idRoom) throws PermissionNotFoundException {
	
		return permissionList.get(findPermission(idUser, idRoom));
	}
	
	public ArrayList<Permission> findUserPermission(String idUser)
	{
		ArrayList<Permission> list = new ArrayList<Permission>();
		
		for(int i = 0; i < permissionList.size(); i++)
			if(permissionList.get(i).getIdUser().equals(idUser)) 
				list.add(permissionList.get(i));
		
		return list;
	}

	
	public boolean addNewPermission(Permission permission) {
		
		try {
			
			findPermission(permission.getIdUser(), permission.getIdRoom());
			
		} catch (PermissionNotFoundException e) {
			//if there is no user with that room permission
			permissionList.add(permission);
			return Model.insertPermission(permission);
		}
		
		return false;
	}
	
	public void removePermission(String userId ,String roomId) throws PermissionNotFoundException {	
		
		permissionList.remove(findPermission(userId, roomId));
		Model.deletePermission(userId, roomId);
		
	}


	
	

}