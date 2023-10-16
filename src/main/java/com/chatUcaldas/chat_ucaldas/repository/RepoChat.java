package com.chatUcaldas.chat_ucaldas.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.chatUcaldas.chat_ucaldas.entity.Chat;

@Repository("ChatRepository")
public interface RepoChat extends CrudRepository<Chat, Long>{

}
