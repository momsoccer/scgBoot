package com.scg.model;

public class UserRole {

	private int roleId;
	private String rolename;
	private int uid;

	public UserRole() {
	}

	public UserRole(int uid) {
		this.uid = uid;
	}

	public UserRole(int roleId, String rolename, int uid) {
		this.roleId = roleId;
		this.rolename = rolename;
		this.uid = uid;
	}

	public String getRolename() {
		return rolename;
	}

	public void setRolename(String rolename) {
		this.rolename = rolename;
	}

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}


	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}
}