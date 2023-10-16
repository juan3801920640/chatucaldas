package com.chatUcaldas.chat_ucaldas.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.chatUcaldas.chat_ucaldas.entity.Role;

@Repository("RoleRepository")
public interface RepoRole extends CrudRepository<Role, Long>{
	
}
