package com.scg.persistence;

import com.scg.model.Role;
import com.scg.model.UserRole;

import java.util.List;

public interface UserRoleMapper {

	public List<UserRole> getUserRoleList(UserRole userRole);

	public void saveUserRole(Role role);
}