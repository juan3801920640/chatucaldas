package com.chatUcaldas.chat_ucaldas.service;

import java.util.List;

import com.chatUcaldas.chat_ucaldas.entity.Chat;

public interface ChatService {
	
	public Chat addChat(Chat chat);
	
	public Chat getChat(Long id);
	
	public List<Chat> getChatByUserChatId(Long userChatId);
	
	public List<Chat> getAllChats();
	

}
