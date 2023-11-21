package com.chatUcaldas.chat_ucaldas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.chatUcaldas.chat_ucaldas.entity.Chat;

@Repository("ChatRepository")
public interface RepoChat extends CrudRepository<Chat, Long>{
	
	@Query("SELECT c FROM Chat c WHERE c.userChat.idUser = :idUser")
	List<Chat> findByUserChatId(@Param("idUser") long idUser);

}
