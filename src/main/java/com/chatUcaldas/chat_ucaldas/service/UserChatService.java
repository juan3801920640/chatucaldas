package com.chatUcaldas.chat_ucaldas.service;

import java.util.List;

import com.chatUcaldas.chat_ucaldas.entity.UserChat;

public interface UserChatService {
	
	public UserChat addUserChat(UserChat userChat);
	
	public UserChat getUserChat(Long idUserChat);
	
	public List<UserChat> getAllUserChat();
	
	public void deleteUserChat(Long idUserChat);
	
	public UserChat updateUserChat(UserChat newUserChat);
	
	public UserChat login(String userChat, String password);

}
