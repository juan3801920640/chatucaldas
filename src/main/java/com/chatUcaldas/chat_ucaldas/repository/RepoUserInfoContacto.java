package com.chatUcaldas.chat_ucaldas.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.chatUcaldas.chat_ucaldas.entity.UserInfoContacto;

@Repository("UserInfoContactoRepository")
public interface RepoUserInfoContacto extends CrudRepository<UserInfoContacto, Long>{

}
