package com.chatUcaldas.chat_ucaldas.service;

import java.util.List;

import com.chatUcaldas.chat_ucaldas.entity.Role;

public interface RoleService {
	
	public Role addRole(Role role);
	
	public Role getRole(Long id);
	
	public List<Role> getAllRoles();

}
