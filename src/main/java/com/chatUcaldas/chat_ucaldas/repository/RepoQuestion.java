package com.chatUcaldas.chat_ucaldas.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.chatUcaldas.chat_ucaldas.entity.Question;

@Repository("QuestionRepository")
public interface RepoQuestion extends CrudRepository<Question, Long>{
	
}
