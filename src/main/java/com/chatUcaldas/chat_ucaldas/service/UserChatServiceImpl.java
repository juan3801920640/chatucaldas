package com.chatUcaldas.chat_ucaldas.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import com.chatUcaldas.chat_ucaldas.entity.UserChat;
import com.chatUcaldas.chat_ucaldas.repository.RepoUserChat;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;

@Service("UserChatServiceImpl")
@Transactional
public class UserChatServiceImpl implements UserChatService{
	
	@Autowired
	@Qualifier("UserChatRepository")
	RepoUserChat repositoryUserChat;

	@Override
	public UserChat addUserChat(UserChat userChat) {
		return repositoryUserChat.save(userChat);
	}

	@Override
	public UserChat getUserChat(Long idUserChat) {
		return repositoryUserChat.findById(idUserChat).get();
	}

	@Override
	public List<UserChat> getAllUserChat() {
		return (List<UserChat>) repositoryUserChat.findAll();
	}

	@Override
	public void deleteUserChat(Long idUserChat) {
		repositoryUserChat.deleteById(idUserChat);
	}

	@Override
	public UserChat updateUserChat(UserChat newUserChat) {
		
		Optional<UserChat> userChatExist = repositoryUserChat.findById(newUserChat.getIdUser());
		
		if (userChatExist.isPresent()) {
			UserChat userChat = userChatExist.get();
			userChat.setUserChat(newUserChat.getUserChat());
			userChat.setPassword(newUserChat.getPassword());
			userChat.setEmail(newUserChat.getEmail());
			userChat.setRole(newUserChat.getRole());
			
			return repositoryUserChat.save(userChat);
		} else {
			throw new EntityNotFoundException("Usuario no encontrado con id " + newUserChat.getIdUser());
		}
		
	}

	@Override
	public UserChat login(String userChat, String password) {
		
		UserChat userChatNew = repositoryUserChat.findByUserChatAndPassword(userChat, password);
		
		if (userChatNew != null) {
			return userChatNew;
		} else {
			throw new EntityNotFoundException("El usuario no se encuentra registrado");
		}
	}

}
