package com.chatUcaldas.chat_ucaldas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.chatUcaldas.chat_ucaldas.entity.Chat;
import com.chatUcaldas.chat_ucaldas.repository.RepoChat;

import jakarta.transaction.Transactional;

@Service("ChatServiceImpl")
@Transactional
public class ChatServiceImpl implements ChatService{
	
	@Autowired
	@Qualifier("ChatRepository")
	RepoChat repositoryChat;

	@Override
	public Chat addChat(Chat chat) {
		return repositoryChat.save(chat);
	}

	@Override
	public Chat getChat(Long id) {
		return repositoryChat.findById(id).get();
	}

	@Override
	public List<Chat> getAllChats() {
		return (List<Chat>) repositoryChat.findAll();
	}
	
	

}
