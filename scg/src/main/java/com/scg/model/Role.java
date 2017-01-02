package com.scg.model;

public class Role {

	private int roleid;
	private int uid;
	private String rolename;

	public Role(){}

	public Role(int roleid, int uid, String rolename) {
		this.roleid = roleid;
		this.uid = uid;
		this.rolename = rolename;
	}

	public int getRoleid() {
		return roleid;
	}

	public void setRoleid(int roleid) {
		this.roleid = roleid;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public String getRolename() {
		return rolename;
	}

	public void setRolename(String rolename) {
		this.rolename = rolename;
	}

	@Override
	public String toString() {
		return "Role{" +
				"roleid=" + roleid +
				", uid=" + uid +
				", rolename='" + rolename + '\'' +
				'}';
	}
}