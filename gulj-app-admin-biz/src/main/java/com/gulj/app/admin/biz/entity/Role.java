package com.gulj.admin.web.entity;

/**
 * 角色表
 * Role
 * 创建人:gulj
 * 时间：2016年4月27日-上午10:52:38 
 * @version 1.0.0
 *
 */
public class Role {
	private int sid;
	private String roleId;
	private String roleName;
	
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getRoleId() {
		return roleId;
	}
	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
}
