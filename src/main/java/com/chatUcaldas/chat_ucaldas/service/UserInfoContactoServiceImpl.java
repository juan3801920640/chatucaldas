package com.chatUcaldas.chat_ucaldas.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.chatUcaldas.chat_ucaldas.entity.UserInfoContacto;
import com.chatUcaldas.chat_ucaldas.repository.RepoUserInfoContacto;

import jakarta.transaction.Transactional;

@Service("UserInfoContactoServiceImpl")
@Transactional
public class UserInfoContactoServiceImpl implements UserInfoContactoService{
	
	@Autowired
	@Qualifier("UserInfoContactoRepository")
	RepoUserInfoContacto repositoryUserInfoCont;

	@Override
	public UserInfoContacto addUserInfoContacto(UserInfoContacto userInfoContacto) {
		return repositoryUserInfoCont.save(userInfoContacto);
	}

}
