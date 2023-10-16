package com.chatUcaldas.chat_ucaldas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.chatUcaldas.chat_ucaldas.entity.Role;
import com.chatUcaldas.chat_ucaldas.repository.RepoRole;

import jakarta.transaction.Transactional;

@Service("RoleServiceImpl")
@Transactional
public class RoleServiceImpl implements RoleService{
	
	@Autowired
	@Qualifier("RoleRepository")
	RepoRole repositoryRole;

	@Override
	public Role addRole(Role role) {
		return repositoryRole.save(role);
	}

	@Override
	public Role getRole(Long id) {
		return repositoryRole.findById(id).get();
	}

	@Override
	public List<Role> getAllRoles() {
		return (List<Role>) repositoryRole.findAll();
	}
	
	

}
