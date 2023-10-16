package com.chatUcaldas.chat_ucaldas.service;

import java.util.List;

import com.chatUcaldas.chat_ucaldas.entity.Role;

public interface RoleService {
	
	public abstract Role addRole(Role role);
	
	public abstract Role getRole(Long id);
	
	public abstract List<Role> getAllRoles();

}
