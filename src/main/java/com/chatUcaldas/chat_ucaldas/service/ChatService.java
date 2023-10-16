package com.chatUcaldas.chat_ucaldas.service;

import java.util.List;

import com.chatUcaldas.chat_ucaldas.entity.Chat;

public interface ChatService {
	
	public abstract Chat addChat(Chat chat);
	
	public abstract Chat getChat(Long id);
	
	public abstract List<Chat> getAllChats();

}
