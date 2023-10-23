package com.chatUcaldas.chat_ucaldas.service;

import java.util.List;

import com.chatUcaldas.chat_ucaldas.entity.UserChat;

public interface UserChatService {
	
	public abstract UserChat addUserChat(UserChat userChat);
	
	public abstract UserChat getUserChat(Long idUserChat);
	
	public abstract List<UserChat> getAllUserChat();
	
	public abstract void deleteUserChat(Long idUserChat);
	
	public abstract UserChat updateUserChat(UserChat newUserChat);
	
	public abstract UserChat login(String userChat, String password);

}
