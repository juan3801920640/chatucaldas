package com.chatUcaldas.chat_ucaldas.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.chatUcaldas.chat_ucaldas.entity.UserChat;

@Repository("UserChatRepository")
public interface RepoUserChat extends CrudRepository<UserChat, Long> {
	

}
